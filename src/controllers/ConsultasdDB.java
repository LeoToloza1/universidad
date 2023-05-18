/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import models.Alumno;
import models.Materia;
import models.Conexion;

public class ConsultasdDB extends Conexion {

    PreparedStatement ps = null;
    Connection conn;
    ResultSet rs;

    /**
     * * consultas MATERIAS **
     */
    public boolean InsertMateriaAlumno(Materia materia) {
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

    public void SelectMaterias() {
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

    /**
     * * consultas ALUMNO **
     */
    public boolean InsertAlumno(Alumno alumno) throws SQLException {
        //sentencia preparada en java con valores posicionales
        String sql = "INSERT INTO alumno (dni,apellido,nombre,fecha_nacimiento,estado) VALUES (?,?,?,?,?)";
        try {
            conn = getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFecha_nacimiento())); //parsear un LocalDate a Date de SQL
            ps.setBoolean(5, alumno.isEstado());
            ps.executeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null, "SE AGREGÓ CON EXITO AL USUARIO");
            return true;
        } catch (IOException | SQLException e) {
            System.out.println("ERROR DE REGISTRO: " + e.getMessage());
            if (conn != null) {
                conn.close();
            }
            return false;
        }
    }

    public boolean SelectAlumnos() throws SQLException {
        try {
            conn = getConexion();
            String Sql = "SELECT * FROM alumno";
            ps = conn.prepareStatement(Sql);
            rs = ps.executeQuery();
            conn.close();
            return true;
        } catch (IOException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
            if (conn != null) {
                conn.close();
            }

        }
        return false;
    }

    public boolean SelectAlumnoId(int id) throws SQLException {
        try {
            conn = getConexion();
            String Sql = "SELECT * FROM alumno WHERE 'id' = ?";

            ps = conn.prepareStatement(Sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            conn.close();
            return true;
        } catch (IOException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }

    public boolean SelectAlumnoDni(String dni) throws SQLException {
        try {
            conn = getConexion();
            String Sql = "SELECT * FROM alumno WHERE 'dni' = ?";

            ps = conn.prepareStatement(Sql);
            ps.setString(1, dni);
            rs = ps.executeQuery();
            conn.close();
            return true;
        } catch (IOException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }

    /**
     * * consultas INSCRIPCIONES **
     */
}
