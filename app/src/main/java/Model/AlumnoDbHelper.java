package Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AlumnoDbHelper extends SQLiteOpenHelper {

    private static final String TEXT_TYPE = "TEXT";
    private static final String INTEGER_TYPE = "INTEGER";
    private static final String COMMA_SEP = " ,";

    private static final String SQL_CREATE_ALUMNO = "CREATE TABLE " +
            DefineTable.Alumnos.TABLE_NAME + " (" +
            DefineTable.Alumnos.COLUMN_NAME_ID + " INTEGER PRIMARY KEY, " +
            DefineTable.Alumnos.COLUMN_NAME_MATRICULA + TEXT_TYPE +
            DefineTable.Alumnos.COLUMN_NAME_NOMBRE + TEXT_TYPE + COMMA_SEP +
            DefineTable.Alumnos.COLUMN_NAME_CARRERA + TEXT_TYPE + COMMA_SEP +
            DefineTable.Alumnos.COLUMN_NAME_FOTO + INTEGER_TYPE + ")";

    private static final String SQL_DELETE_ALUMNO = "DROP TABLE IF EXISTS " +
            DefineTable.Alumnos.TABLE_NAME;

    private static final  String DATABASE_NAME = "sistema.db";
    private static final int DATABASE_VERSION = 1;

    public AlumnoDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ALUMNO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(SQL_DELETE_ALUMNO);
        onCreate(sqLiteDatabase);
    }
}
