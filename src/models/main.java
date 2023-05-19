/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.IOException;
import java.sql.SQLException;
import controllers.SqlAlumno;
import controllers.SqlMateria;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import models.File;

/**
 *
 * @author leo_t
 */
public class main {

    public static void main(String[] args) throws IOException, SQLException {
        /* test insanciam,os alumno */
//        File test = new File();
//        test.leerArchivo();
//        String dni = "4369898546";
//        String nombre = "Juan";
//        String apellido = "Perez";
//        LocalDate nacimiento = LocalDate.of(1985, 5, 17);// formato yyyy-mm-dd
//        boolean estado = true;
//        Alumno alu1 = new Alumno(dni, apellido, nombre, nacimiento, estado);

        /* vamos a INSERTAR UN ALUMNO EN DB */
//        System.out.println("Usuario: " + test.getUsuario());
//        System.out.println("Url: " + test.getUrl());
//        System.out.println("Pass: " + test.getPass());
        //       SqlAlumno sqlalum = new SqlAlumno();
        //       sqlalum.InsertAlumno(alu1);
//        if (alu1.SelectAlumnos()) {       }
        // System.out.println(alum.SelectAlumnos());
        /*  Vamos a insertar una materia */
//isntanciamos
//        String nombre = "Laboratorio II";
//        int ano = 2;
//        boolean estado = true;
//
//        Materia mat1 = new Materia(nombre, ano, estado);
//        SqlMateria mate1 = new SqlMateria();
//        mate1.InsertMateria(mat1);
// vamso a soft delette alumno
//       SqlAlumno alu1 = new SqlAlumno();
        //       alu1.DeletteAlumnoDni("42290462");
        /* vanmos con soft delette materia */
        //     SqlMateria mat1 = new SqlMateria();
        //     mat1.DeletteMateriaNombre("Laboratorio II");
        //       alu1.DeletteAlumnoDni("42290462");
        //materia.SelectMaterias();
        /*vamos a modificar alumno */
        SqlAlumno alu = new SqlAlumno();
        alu.SelectAlumnoDni("42290462");
        ResultSet rs = alu.getRs();
        Alumno alu1 = new Alumno();
        String[] array = new String[4];
        rs.next();
        System.out.println("probando doble while");
        System.out.println(rs.getString("fecha_nacimiento"));
        rs.beforeFirst();

        while (rs.next()) {
            System.out.println(rs.getString("fecha_nacimiento"));
            alu1.setApellido(rs.getString("apellido"));
            alu1.setNombre(rs.getString("nombre"));
            alu1.setDni(rs.getString("dni"));
            //   alu1.setFecha_nacimiento(Date.valueOf(rs.getDate("fecha_nacimiento")));
            alu1.setFecha_nacimiento(LocalDate.parse(rs.getString("fecha_nacimiento")));
            alu1.setEstado(rs.getBoolean("estado"));
        }
        //  array[0]=alu1.getApellido();
        array[0] = "Gonzales";
        array[1] = alu1.getNombre();
        array[2] = alu1.getFecha_nacimiento().toString();
        if (alu1.isEstado()) {
            array[3] = "1";
        } else {
            array[3] = "0";
        }
        alu.UpdateAlumnoDni2("42290462", array);

        //  System.out.println(alu.toString());
//        System.out.println(alu.getRs().getString(1));
//        ResultSet rst = alu.getRs();
//        Object nombreObjeto = rst.getObject("nombre");
//        String nombre = (String) nombreObjeto;
//        System.out.println(nombre);
// Convierte el objeto al tipo adecuado, en este caso String
        //String nombre = (String) nombreObjeto;
        //  String nombre1 = rst.getString("nombre");
        //   System.out.println(nombre1);
//        while (rst.next()) {
//            System.out.println("linea 68");
//            //  int id = rst.getInt("id_alumno");
//            //  String nombre = rst.getString("nombre");
//            System.out.println(nombre);
//        }
        //        Alumno alu1 = new Alumno(dni, apellido, nombre, nacimiento, estado);
        /**
         * Chicos, llegué hasta acá, hice un par de cosas, pero faltan. - La clase metodos deberia tener un metodo para insciribir a un alumno en una materia - Falta un metodo para consultarlo y mostrarlo por pantalla - Falta todo lo que es vistas e Interfaz Grafica y quedaria conectar todo para que funcione -------------------------------------------------------------------------------------- Yo despues me voy a encargar de hacer un .jar ejecutable y lo voy a meter en un instalador haria la ultima prueba de que todo funcione correctamente y lo podriamos entregar. Esto ultimo es opcional, pero seria un programa "más real".
         */
    }

}
/*while (rs.next()) { int id = rs.getInt("id_alumno"); String nombre = rs.getString("nombre"); String apellido = rs.getString("apellido"); int dni = rs.getInt("dni"); Date fecha = rs.getDate("Fecha_nacimiento"); boolean estado = rs.getBoolean("Estado"); System.out.println("********************************"); System.out.println("ID: " + id); System.out.println("DNI: " + dni); System.out.println("Apellido: " + apellido); System.out.println("Nombre: " + nombre); System.out.println("FECHA de Nacimiento: " + fecha); System.out.println("Estado: " + estado); System.out.println("********************************"); }*/
