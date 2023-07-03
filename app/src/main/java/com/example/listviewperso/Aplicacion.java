package com.example.listviewperso;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;

public class Aplicacion extends Application {
    public static ArrayList<Alumno> alumnos;
    public static AdapterAlumno adaptador;

    public ArrayList<Alumno> getAlumnos(){return alumnos;}
    public AdapterAlumno getAdaptador(){return adaptador;}

    @Override
    public void onCreate() {
        super.onCreate();
        alumnos = Alumno.llenarAlumnos();
        adaptador = new AdapterAlumno(alumnos, this);
        Log.d("", "onCreate: tamaño array list " + alumnos.size());
    }
}
