package com.example.listviewperso.Model;

import com.example.listviewperso.Alumno;

public interface Persistencia {

    public void openDataBase();
    public void closeDataBase();
    public long insertAlumno(Alumno alumno);
    public long updateAlumno(Alumno alumno);
    public void deleteAlumno(int id);

}
