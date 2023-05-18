/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import models.Alumno;
import models.Conexion;
import models.Materia;

public class Metodos extends Conexion {

    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection conn;
    SqlAlumno sqlAlumno = new SqlAlumno();
    SqlMateria sqlMateria = new SqlMateria();
    Alumno alumno = new Alumno();
    Materia materia = new Materia();

    public void inscribirAlumnoMateria(int dni) {
        try {
            String sql = "SELECT alumno.id_alumno FROM alumno WHERE alumno.dni= ?";
            conn = getConexion();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, dni);
            rs = ps.executeQuery();
            conn.close();
            //SELECT alumno.id_alumno FROM alumno WHERE alumno.dni= ? // TRAE EL ID DEL ALUMNO CUYO DNI ES EL QUELLEGA PR PARAMETRO
            //alumno.getDNI();
        } catch (Exception e) {
        }
    }
}
