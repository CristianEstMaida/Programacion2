/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package segundo.parcial.entidades.maida.cristian;

import java.util.Comparator;

/**
 *
 * @author crist
 */
public class ComparadorPrecioProducto implements Comparator<Producto>{
    public int compare(Producto producto1, Producto producto2) {
        return Double.compare(producto1.precio,producto2.precio);
    }
}
