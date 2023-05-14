/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Materia;
import modelo.Conexion;

public class SqlMateria extends Conexion {

    PreparedStatement ps = null;
    Connection conn;
    ResultSet rs;

    public boolean AgregarAlumno(Materia materia) {
        //sentencia preparada en java con valores posicionales
        String sql = "INSERT INTO materia (nombre,año,estado) VALUES (?,?,?)";
        try {
            conn = getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAno());
            ps.setBoolean(3, materia.isEstado());
            ps.executeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null, "SE AGREGÓ CON EXITO UNA NUEVA MATERIA");
            return true;
        } catch (IOException | SQLException e) {
            System.out.println("ERROR DE REGISTRO: " + e.getMessage());
            return false;
        }
    }

    public void verMataerias() {
        try {
            conn = getConexion();
            String Sql = "SELECT * FROM materia";
            ps = conn.prepareStatement(Sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_materia");
                String nombre = rs.getString("nombre");
                int ano = rs.getInt("Año");
                boolean estado = rs.getBoolean("Estado");
                System.out.println("********************************");
                System.out.println("ID: " + id);
                System.out.println("Nombre: " + nombre);
                System.out.println("Año: " + ano);
                System.out.println("Estado: " + estado);
                System.out.println("********************************");
            }
            conn.close();
        } catch (IOException | SQLException e) {
            System.out.println("Error: " + e);
        }

    }

}
