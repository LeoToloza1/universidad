/*--------- PROYECTO UNIVERSIDAD PARA LA ULP ----------------------------------
 Conexion a base de datos
 */
package models;

import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private Connection conectar;
    public File datos = new File();
    private String usuario;
    private String url;
    private String pass;
    //--------------CONEXION REMOTO---------------//
//    private String usuario;// = "rafalopez_tuds";
//    private String pass;// = "MalditaEDA";
//    //private String base = "rafalopez_tuds";
//    private String url;// = "jdbc:mysql://mysql-rafalopez.alwaysdata.net/" + base;
    //--------------CONEXION LOCAL---------------//
//    private final String base = "universidad";
//    private final String usuario = "root";
//    private final String pass = "";
//    private final String url = "jdbc:mysql://localhost:3306/" + base;

    public Connection getConexion() throws IOException {
        //------Conexion extrayendo datos de un archivo config.txt--------//
        datos.leerArchivo();
        usuario = datos.getUsuario();
        url = datos.getUrl();
        pass = datos.getPass();
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conectar = DriverManager.getConnection(url, usuario, pass);
            System.out.println("Conectado exitosamente!");
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return conectar;

    }

}
