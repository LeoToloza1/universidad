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
import models.Conexion;

public class SqlAlumno extends Conexion {

    private PreparedStatement ps = null;
    private Connection conn = null;
    private ResultSet rs;

    public ResultSet getRs() {
        return this.rs;
    }

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
            boolean result = ps.execute();
            // TODO falta evaluar rs para ver si inserto
            if (!result) {
                //if(ps.)
                JOptionPane.showMessageDialog(null, "SE AGREGÓ CON EXITO AL USUARIO");
            }
            return true;
        } catch (IOException | SQLException e) {
            System.out.println("ERROR DE REGISTRO: " + e.getMessage());
        } finally {
            ps.close();
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

    public ResultSet SelectAlumnoId(int id) throws SQLException {
        try {
            conn = getConexion();
            String Sql = "SELECT * FROM alumno WHERE 'id' = ?";

            ps = conn.prepareStatement(Sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            conn.close();
            return rs;
        } catch (IOException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
            if (conn != null) {
                conn.close();
            }
        } finally {
            ps.close();
            if (conn != null) {
                conn.close();
            }
            return rs;
        }
    }

    public void SelectAlumnoDni(String dni) throws SQLException {
        try {
            conn = getConexion();
            String Sql = "SELECT * FROM alumno where dni= ?";
            ps = conn.prepareStatement(Sql);
            ps.setString(1, dni);
            rs = ps.executeQuery();
        } catch (IOException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
            if (conn != null) {
                conn.close();
            }
        }
    }

    public boolean DeletteAlumnoDni(String dni) throws SQLException {
        try {
            conn = getConexion();
            //UPDATE `materia` SET `id_materia`='[value-1]',`nombre`='[value-2]',`año`='[value-3]',`estado`='[value-4]' WHERE 1
            String Sql = "UPDATE alumno SET estado = false WHERE dni = ?";
            ps = conn.prepareStatement(Sql);
            ps.setString(1, dni);
            ps.executeQuery();
            JOptionPane.showMessageDialog(null, "SE booro CON EXITO AL USUARIO");
            return true;
        } catch (IOException | SQLException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            ps.close();
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }

    public boolean UpdateAlumnoDni(String dni) throws SQLException {
        try {
            conn = getConexion();
            //UPDATE `materia` SET `id_materia`='[value-1]',`nombre`='[value-2]',`año`='[value-3]',`estado`='[value-4]' WHERE 1
            String Sql = "UPDATE alumno SET estado = false WHERE dni = ?";
            ps = conn.prepareStatement(Sql);
            ps.setString(1, dni);
            ps.executeQuery();
            JOptionPane.showMessageDialog(null, "SE booro CON EXITO AL USUARIO");
            return true;
        } catch (IOException | SQLException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            ps.close();
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }

    public boolean UpdateAlumnoDni2(String dni, String[] alumno) throws SQLException {
        try {
            conn = getConexion();
//            "UPDATE alumno SET apellido= ?,nombre=?,fecha_nacimiento=?,estado=?";"
            String Sql = "UPDATE alumno SET apellido= ?,nombre=?,fecha_nacimiento=?,estado=? WHERE dni =?";
            ps = conn.prepareStatement(Sql);
            ps.setString(1, alumno[0]);
            ps.setString(2, alumno[1]);
            ps.setString(3, alumno[2]);
            ps.setString(4, alumno[3]);
            ps.setString(5, dni);

            ps.executeQuery();
            JOptionPane.showMessageDialog(null, "SE booro CON EXITO AL USUARIO");
            return true;
        } catch (IOException | SQLException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            ps.close();
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }
}

/**
 * while (rs.next()) { int id = rs.getInt("id_alumno"); String nombre = rs.getString("nombre"); String apellido = rs.getString("apellido"); int dni = rs.getInt("dni"); Date fecha = rs.getDate("Fecha_nacimiento"); boolean estado = rs.getBoolean("Estado"); System.out.println("********************************"); System.out.println("ID: " + id); System.out.println("DNI: " + dni); System.out.println("Apellido: " + apellido); System.out.println("Nombre: " + nombre); System.out.println("FECHA de Nacimiento: " + fecha); System.out.println("Estado: " + estado); System.out.println("********************************"); }
 */
