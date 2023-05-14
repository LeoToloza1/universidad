/*
 * clase para leer un archivo con datos desde un config.txt
   para acceder a una base de datos en remoto
 */
package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author leo_t
 */
public class File {

    private String usuario;
    private String pass;
    private String url;
    FileReader archivo;
    BufferedReader lector;

    public String getUsuario() {
        return usuario;
    }

    public String getPass() {
        return pass;
    }

    public String getUrl() {
        return url;
    }

    public void leerArchivo() throws IOException {
        String cadena;
        ArrayList<String> palabras = new ArrayList();
        try {
            archivo = new FileReader("src/config/config.txt");

            if (archivo.ready()) {
                lector = new BufferedReader(archivo);

                while ((cadena = lector.readLine()) != null) {
                    palabras.add(cadena);
                }
                usuario = palabras.get(0);
                pass = palabras.get(1);
                url = palabras.get(2);

            } else {
                System.out.println("No se puede leer el archivo");
            }
        } catch (FileNotFoundException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}
