/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package segundo.parcial.maida.cristian;

import java.io.IOException;
import java.util.List;
import segundo.parcial.entidades.maida.cristian.*;
/**
 *
 * @author crist
 */
public class SegundoParcialMaidaCristian {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ProductoNuloException, ProductoNoEncontradoException, IOException {
        // TODO code application logic here
        Estante estante = new Estante();

        try {
            estante.agregar(new Producto("Celular", "1111", Categoria.ELECTRONICA, 250000));
            estante.agregar(new Producto("Sofá", "2222", Categoria.HOGAR, 180000));
            estante.agregar(new Producto("Zapatillas", "3333", Categoria.MODA, 90000));
            estante.agregar(new Producto("Perfume", "4444", Categoria.BELLEZA, 70000));
            estante.agregar(new Producto("Notebook", "5555", Categoria.ELECTRONICA, 350000));

            try {
                estante.agregar(null);
            } catch (ProductoNuloException e) {
                System.out.println("❗Error: " + e.getMessage());
            }

            System.out.println("\n Estante original:");
            for (Producto p : estante) System.out.println(p);

            estante.ordenarPorNombre();
            System.out.println("\n Ordenado por nombre:");
            estante.obtenerTodos().forEach(System.out::println);

            estante.ordenarPorCodigo();
            System.out.println("\n Ordenado por código de barra:");
            estante.obtenerTodos().forEach(System.out::println);

            estante.ordenarPorPrecio();
            System.out.println("\n💲 Ordenado por precio:");
            estante.obtenerTodos().forEach(System.out::println);

            estante.ordenarPorCategoria();
            System.out.println("\n️ Ordenado por categoría:");
            estante.obtenerTodos().forEach(System.out::println);

            System.out.println("\n Filtrado por ELECTRONICA y HOGAR:");
            List<Producto> filtrados = estante.filtrar(p -> 
                p.categoria == Categoria.ELECTRONICA || 
                p.categoria == Categoria.HOGAR
            );
            filtrados.forEach(System.out::println);

            try {
                estante.eliminar(new Producto("Televisor", "9999", Categoria.ELECTRONICA, 200000));
            } catch (ProductoNoEncontradoException e) {
                System.out.println("Error al eliminar: " + e.getMessage());
            }

            try {
                estante.eliminar(new Producto("Zapatillas", "3333", Categoria.MODA, 90000));
                System.out.println("\n️ Después de eliminar 'Zapatillas':");
                estante.obtenerTodos().forEach(System.out::println);
            } catch (ProductoNoEncontradoException e) {
                System.out.println(" Error al eliminar: " + e.getMessage());
            }

            SerializadorProducto serializador = new SerializadorProducto();
            String archivo = "productos.dat";
            serializador.serializarBinario(estante.obtenerTodos(), archivo);
            System.out.println("\n Productos serializados en " + archivo);

            List<Producto> productosDeserializados = serializador.deserializarBinario(archivo);
            System.out.println("\n Productos deserializados:");
            productosDeserializados.forEach(System.out::println);

        } catch (EstanteVacioException | IOException | ClassNotFoundException e) {
            System.out.println("️ Excepción general: " + e.getMessage());
        }
    }
    
}
