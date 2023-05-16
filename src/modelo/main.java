/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.IOException;
import logica.SqlAlumno;
import logica.SqlMateria;

/**
 *
 * @author leo_t
 */
public class main {

    public static void main(String[] args) throws IOException {
        File test = new File();
        test.leerArchivo();
//        System.out.println("Usuario: " + test.getUsuario());
//        System.out.println("Url: " + test.getUrl());
//        System.out.println("Pass: " + test.getPass());
        SqlAlumno alum = new SqlAlumno();
        alum.ver();
        SqlMateria materia = new SqlMateria();

        //materia.verMataerias();
        /**
         * Chicos, llegué hasta acá, hice un par de cosas, pero faltan. - La clase metodos deberia tener un metodo para insciribir a un alumno en una materia - Falta un metodo para consultarlo y mostrarlo por pantalla - Falta todo lo que es vistas e Interfaz Grafica y quedaria conectar todo para que funcione -------------------------------------------------------------------------------------- Yo despues me voy a encargar de hacer un .jar ejecutable y lo voy a meter en un instalador haria la ultima prueba de que todo funcione correctamente y lo podriamos entregar. Esto ultimo es opcional, pero seria un programa "más real".
         */
    }

}
