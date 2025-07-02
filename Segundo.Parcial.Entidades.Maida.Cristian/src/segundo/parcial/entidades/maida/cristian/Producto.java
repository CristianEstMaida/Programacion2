/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package segundo.parcial.entidades.maida.cristian;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author crist
 */
public class Producto implements Comparable<Producto>, Serializable {

    public Producto() {
    }

    public Producto(String nombre, String codigoBarra, Categoria categoria, double precio) {
        if (nombre == null || codigoBarra == null || categoria == null) {
            throw new IllegalArgumentException("Producto mal definido");
        }
        this.nombre = nombre;
        this.codigoBarra = codigoBarra;
        this.categoria = categoria;
        this.precio = precio;
    }

    public String nombre, codigoBarra;
    public Categoria categoria;
    public double precio;

    @Override
    public int compareTo(Producto otro) {
        return this.nombre.compareToIgnoreCase(otro.nombre);
    }

    @Override
    public String toString() {
        return nombre + " | " + codigoBarra + " | " + categoria + " | $" + precio;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Producto p = (Producto) obj;
        return Objects.equals(this.codigoBarra, p.codigoBarra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoBarra);
    }

}

