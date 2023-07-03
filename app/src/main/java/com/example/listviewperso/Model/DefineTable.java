package com.example.listviewperso.Model;

public class DefineTable {

    public DefineTable(){}

    public static abstract class Alumnos {
        public static final String TABLE_NAME = "alumnos";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_MATRICULA = "matricula";
        public static final String COLUMN_NAME_NOMBRE = "nombre";
        public static final String COLUMN_NAME_CARRERA = "carrera";
        public static final String COLUMN_NAME_FOTO = "foto";

        public static String[] REGISTRO = new String[]{
                Alumnos.COLUMN_NAME_ID,
                Alumnos.COLUMN_NAME_MATRICULA,
                Alumnos.COLUMN_NAME_NOMBRE,
                Alumnos.COLUMN_NAME_CARRERA,
                Alumnos.COLUMN_NAME_FOTO
        };
    }
}
