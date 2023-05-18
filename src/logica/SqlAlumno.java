/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Alumno;
import modelo.Conexion;

public class SqlAlumno extends Conexion {

    private PreparedStatement ps = null;
    private Connection conn;
    private ResultSet rs;

    public boolean AgregarAlumno(Alumno alumno) {
        //sentencia preparada en java con valores posicionales
        String sql = "INSERT INTO alumno (dni,apellido,nombre,fecha_nacimiento,estado) VALUES (?,?,?,?,?)";
        try {
            conn = getConexion();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, alumno.getDNI());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, (alumno.getFecha_nacimiento()));
            ps.setDate(4, Date.valueOf(alumno.getFecha_nacimiento())); //parsear un LocalDate a Date de SQL
            ps.executeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null, "SE AGREGÓ CON EXITO AL USUARIO");
            return true;
        } catch (IOException | SQLException e) {
            System.out.println("ERROR DE REGISTRO: " + e.getMessage());
            return false;
        }
    }

    public void ver() {
        try {
            conn = getConexion();
            String Sql = "SELECT * FROM alumno";
            ps = conn.prepareStatement(Sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_alumno");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int dni = rs.getInt("dni");
                Date fecha = rs.getDate("Fecha_nacimiento");
                boolean estado = rs.getBoolean("Estado");
                System.out.println("********************************");
                System.out.println("ID: " + id);
                System.out.println("DNI: " + dni);
                System.out.println("Apellido: " + apellido);
                System.out.println("Nombre: " + nombre);
                System.out.println("FECHA de Nacimiento: " + fecha);
                System.out.println("Estado: " + estado);
                System.out.println("********************************");
            }
            conn.close();
        } catch (IOException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
