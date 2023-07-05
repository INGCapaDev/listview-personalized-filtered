package com.example.listviewperso;

import java.io.Serializable;

public class Alumno implements Serializable {
    public String img;
    public String nombre;
    public String matricula;
    public String carrera;
    public int id;


    public Alumno() {
        this.carrera = "";
        this.matricula = "";
        this.nombre = "";
        this.img = "";
    }

    public Alumno(int id, String img, String nombre, String matricula, String carrera) {
        this.id = id;
        this.img = img;
        this.nombre = nombre;
        this.matricula = matricula;
        this.carrera = carrera;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
