package com.example.listviewperso;

import java.io.Serializable;

public class Alumno implements Serializable {
    public int id;
    public int imagen;
    public String nombre;
    public String des;
    public String carrera;
    public int flecha;

    public Alumno(int id, int imagen, String nombre, String des, int flecha) {
        this.id = id;
        this.imagen = imagen;
        this.nombre = nombre;
        this.des = des;
        this.carrera = carrera;
        this.flecha = flecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

}
