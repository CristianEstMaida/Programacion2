/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package segundo.parcial.entidades.maida.cristian;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author crist
 */

public interface Serializadora<T> {
    public void serializarBinario(List<T> lista, String archivo) throws IOException;
    public List<T> deserializarBinario(String archivo) throws IOException, ClassNotFoundException;
}
