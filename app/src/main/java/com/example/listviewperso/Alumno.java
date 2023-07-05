package com.example.listviewperso;

import java.io.Serializable;

import java.util.ArrayList;

public class Alumno implements Serializable {
    public Integer img;
    public String nombre;
    public String matricula;
    public String carrera;
    public int id;


    public Alumno() {
        this.carrera = "";
        this.matricula = "";
        this.nombre = "";
        this.img = 0;
    }

    public Alumno(int id, int img, String nombre, String matricula, String carrera) {
        this.id = id;
        this.img = img;
        this.nombre = nombre;
        this.matricula = matricula;
        this.carrera = carrera;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
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
    public static ArrayList<Alumno> llenarAlumnos() {
        ArrayList<Alumno> lst = new ArrayList<>();
        lst.add(new Alumno(1, R.drawable.a2019030344, "MORUA ZAMUDIO ESTEFANO", "2019030344", "Ing. Tec. Informacion"));
        lst.add(new Alumno(2, R.drawable.a2020030174, "CARRANZA JAUREGUI CARLOS ALBERTO", "2020030174", "Ing. Tec. Informacion"));
        lst.add(new Alumno(3, R.drawable.a2020030176, "CASTRO LOPEZ MARCO ANTONIO ALARID", "2020030176", "Ing. Tec. Informacion"));
        lst.add(new Alumno(4, R.drawable.a2020030181, "DURAN VALDEZ JOSHUA DANIEL", "2020030181", "Ing. Tec. Informacion"));
        lst.add(new Alumno(5, R.drawable.a2020030184, "GALINDO HERNANDEZ ERNESTO DAVID", "2020030184", "Ing. Tec. Informacion"));
        lst.add(new Alumno(6, R.drawable.a2020030189, "CONTRERAS CEPEDA MAXIMILIANO", "2020030189", "Ing. Tec. Informacion"));
        lst.add(new Alumno(7,R.drawable.a2020030199, "GOMEZ RUELAS IVÁN ENRIQUE", "2020030199", "Ing. Tec. Informacion"));
        lst.add(new Alumno(8, R.drawable.a2020030212, "CRUZ QUINTERO JESUS EDUARDO", "2020030212", "Ing. Tec. Informacion"));
        lst.add(new Alumno(9, R.drawable.a2020030241, "VELARDE OVALLE DAVID ANTONIO", "2020030241", "Ing. Tec. Informacion"));
        lst.add(new Alumno(10, R.drawable.a2020030243, "LAMAS ARMENTA GUSTAVO ADOLFO", "2020030243", "Ing. Tec. Informacion"));
        lst.add(new Alumno(11, R.drawable.a2020030249, "RIVAS LUGO JUAN CARLOS", "2020030249", "Ing. Tec. Informacion"));
        lst.add(new Alumno(12, R.drawable.a2020030264, "SALAS MENDOZA ALEJO", "2020030264", "Ing. Tec. Informacion"));
        lst.add(new Alumno(13, R.drawable.a2020030268, "SERRANO TORRES CARLOS JAIR", "2020030268", "Ing. Tec. Informacion"));
        lst.add(new Alumno( 14,R.drawable.a2020030292, "TIRADO ROMERO JESUS TADEO", "2020030292", "Ing. Tec. Informacion"));
        lst.add(new Alumno( 15,R.drawable.a2020030304, "CARRILLO GARCIA JAIR", "2020030304", "Ing. Tec. Informacion"));
        lst.add(new Alumno( 16,R.drawable.a2020030306, "ARIAS ZATARAIN DIEGO", "2020030306","Ing. Tec. Informacion" ));
        lst.add(new Alumno( 17,R.drawable.a2020030313, "VALDEZ MARTINEZ PAOLA EMIRET", "2020030313","Ing. Tec. Informacion" ));
        lst.add(new Alumno( 18,R.drawable.a2020030315, "IBARRA FLORES SALMA YARETH", "2020030315","Ing. Tec. Informacion" ));
        lst.add(new Alumno (19,R.drawable.a2020030322, "LIZARRAGA MALDONADO JUAN ANTONIO", "2020030322","Ing. Tec. Informacion" ));
        lst.add(new Alumno(20, R.drawable.a2020030325, "VIERA ROMERO ANGEL ZINEDINE ANASTACIO", "2020030325","Ing. Tec. Informacion" ));
        lst.add(new Alumno(21, R.drawable.a2020030327, "TEJEDA PEINADO BLAS ALBERTO", "2020030327","Ing. Tec. Informacion" ));
        lst.add(new Alumno(22, R.drawable.a2020030329, "VIERA ROMERO ANGEL RONALDO ANASTACIO", "2020030329", "Ing. Tec. Informacion"));
        lst.add(new Alumno(23, R.drawable.a2020030332, "ELIZALDE VARGAS XIOMARA YAMILETH", "2020030332", "Ing. Tec. Informacion"));
        lst.add(new Alumno(24, R.drawable.a2020030333, "SALCIDO SARABIA JESUS ANTONIO", "2020030333", "Ing. Tec. Informacion"));
        lst.add(new Alumno(25, R.drawable.a2020030389, "RODRIGUEZ SANCHEZ YENNIFER CAROLINA", "2020030389", "Ing. Tec. Informacion"));
        lst.add(new Alumno(26, R.drawable.a2020030766, "FLORES PRADO MANUEL ALEXIS", "2020030766","Ing. Tec. Informacion"));
        lst.add(new Alumno(27, R.drawable.a2020030771, "AGUIRRE TOSTADO VICTOR MOISES", "2020030771", "Ing. Tec. Informacion"));
        lst.add(new Alumno( 28,R.drawable.a2020030777, "DOMINGUEZ SARABIA HALACH UINIC", "2020030777", "Ing. Tec. Informacion"));
        lst.add(new Alumno( 29,R.drawable.a2020030799, "MACIEL NUÑEZ ENZO ALEJANDRO", "2020030799","Ing. Tec. Informacion"));
        lst.add(new Alumno( 30,R.drawable.a2020030808, "BARRON VARGAS JOSE ALBERTO", "2020030808", "Ing. Tec. Informacion"));
        lst.add(new Alumno( 31,R.drawable.a2020030819, "MARTIN IBARRA GIANCARLO", "2020030819", "Ing. Tec. Informacion"));
        lst.add(new Alumno(32, R.drawable.a2020030865, "SANCHEZ OCEGUEDA LUIS ANGEL", "2020030865","Ing. Tec. Informacion"));
        return lst;
    }
}
