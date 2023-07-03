package com.example.listviewperso;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;

import com.example.listviewperso.Model.AlumnosDb;

public class Aplicacion extends Application {
    public static ArrayList<Alumno> alumnos;
    public static AdapterAlumno adaptador;

    private AlumnosDb alumnosDb;

    public ArrayList<Alumno> getAlumnos(){return alumnos;}
    public AdapterAlumno getAdaptador(){return adaptador;}

    @Override
    public void onCreate() {
        super.onCreate();
        alumnosDb = new AlumnosDb(getApplicationContext());
        alumnos = alumnosDb.allAlumnos();
        adaptador = new AdapterAlumno(alumnos, this);
        Log.d("", "onCreate: tamaño array list " + alumnos.size());

        alumnos = Alumno.llenarAlumnos();
        //alumnosDb.openDataBase();
    }
}
