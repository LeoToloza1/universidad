/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author leo_t
 */
public class Materia {

    private String nombre;
    private int ano; // a que año de cursada correspone,ej: 1, 2 o 3
    private boolean estado;

    public Materia() {
    }

    public Materia(String nombre, int ano, boolean estado) {
        this.nombre = nombre;
        this.ano = ano;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
