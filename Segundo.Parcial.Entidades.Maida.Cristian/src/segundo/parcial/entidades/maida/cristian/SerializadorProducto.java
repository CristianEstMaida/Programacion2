/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package segundo.parcial.entidades.maida.cristian;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author crist
 */
public class SerializadorProducto implements Serializadora<Producto> {
    @Override
    public void serializarBinario(List<Producto> lista, String archivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(lista);
        }
    }
    @Override
    public List<Producto> deserializarBinario(String archivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                return (List<Producto>) obj;
            } else {
                throw new IOException("El archivo no contiene una lista válida de productos.");
            }
        }
    }

}

