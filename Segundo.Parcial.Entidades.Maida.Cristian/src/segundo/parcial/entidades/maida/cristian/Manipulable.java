/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package segundo.parcial.entidades.maida.cristian;

import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author crist
 */
public interface Manipulable<T> {
    public boolean agregar(T elemento) throws ProductoNuloException;
    public boolean eliminar(T elemento) throws ProductoNoEncontradoException;
    public List<T> obtenerTodos() throws EstanteVacioException;
    public List<T> filtrar(Predicate<T> criterio);
}
