/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package segundo.parcial.entidades.maida.cristian;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author crist
 */
public class Estante implements Manipulable<Producto>, Iterable<Producto> {
    public List<Producto> productos;

    public Estante(){
        this.productos  = new ArrayList<>();
    }
    @Override
    public boolean agregar(Producto p) throws ProductoNuloException {
        if (p == null || p.categoria == null || p.codigoBarra == null || p.nombre == null) {
            throw new ProductoNuloException("No se puede agregar un producto nulo o incompleto.");
        }
        return productos.add(p);

    }
    @Override
    public boolean eliminar(Producto p) throws ProductoNoEncontradoException {
        if (!productos.contains(p)) {
            throw new ProductoNoEncontradoException("El producto no existe en el estante.");
        }
        return productos.remove(p);
    }
    @Override
    public List<Producto> obtenerTodos() throws EstanteVacioException {
        if (this.productos.isEmpty()) {
            throw new EstanteVacioException("El estante está vacío.");
        }
        return new ArrayList<>(this.productos);
    }
    @Override
    public List<Producto> filtrar(Predicate<Producto> criterio) {
        return this.productos.stream()
                        .filter(criterio)
                        .collect(Collectors.toList());
    }

    public void ordenarPorNombre() { this.productos.sort(null); }
    public void ordenarPorCodigo() { this.productos.sort(new ComparadorCodigoBarraProducto()); }
    public void ordenarPorPrecio() { this.productos.sort(new ComparadorPrecioProducto()); }
    public void ordenarPorCategoria() { this.productos.sort(new ComparadorCategoriaProducto()); }

    public Iterator<Producto> iterator() {
        return productos.iterator();
    }
}
