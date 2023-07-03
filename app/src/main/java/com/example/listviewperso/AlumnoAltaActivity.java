package com.example.listviewperso;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AlumnoAltaActivity extends AppCompatActivity {
    private Button btnGuardar, btnRegresar;
    private Alumno alumno;
    private EditText txtNombre, txtMatricula, txtGrado;
    private ImageView imgAlumno;
    private TextView lblImagen;
    private String carrera = "Ing. Tec. Informacion";
    private int posicion;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno_alta);
        btnGuardar = (Button) findViewById(R.id.btnSalir);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);
        txtMatricula = (EditText) findViewById(R.id.txtMatricula);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtGrado = (EditText) findViewById(R.id.txtGrado);
        imgAlumno = (ImageView) findViewById(R.id.imgAlumno);

        Bundle bundle = getIntent().getExtras();
        alumno = (Alumno) bundle.getSerializable("alumno");
        posicion = bundle.getInt("posicion", posicion);

        if (posicion >= 0) {
            txtMatricula.setText(alumno.getMatricula());
            txtNombre.setText(alumno.getNombre());
            txtGrado.setText(alumno.getCarrera());
            imgAlumno.setImageResource(alumno.getImg());
        }

        btnGuardar.setOnClickListener(v -> {
            if (alumno == null) {
                alumno = new Alumno();
                alumno.setCarrera(carrera);
                alumno.setMatricula(txtMatricula.getText().toString());
                alumno.setNombre(txtNombre.getText().toString());
                alumno.setImg(R.drawable.avatar);

                if (validar()) {
                    Aplicacion.alumnos.add(alumno);
                    Aplicacion.adaptador.notifyDataSetChanged();
                    setResult(Activity.RESULT_OK);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Falto Capturar datos", Toast.LENGTH_SHORT).show();
                    txtMatricula.requestFocus();
                }

            }
            if (posicion >= 0) {
                alumno.setMatricula(txtMatricula.getText().toString());
                alumno.setNombre(txtNombre.getText().toString());
                alumno.setCarrera(txtGrado.getText().toString());

                Aplicacion.alumnos.get(posicion).setMatricula(alumno.getMatricula());
                Aplicacion.alumnos.get(posicion).setNombre(alumno.getNombre());
                Aplicacion.alumnos.get(posicion).setCarrera(alumno.getCarrera());


                Toast.makeText(getApplicationContext(), "Se modifico con exito ", Toast.LENGTH_SHORT).show();
                setResult(Activity.RESULT_OK);
                finish();
            }
        });

        btnRegresar.setOnClickListener(v -> {
        setResult(Activity.RESULT_CANCELED);
        finish();
        });

    }

    private boolean validar(){
        boolean exito = true;
        Log.d("nombre", "validar: " + txtNombre.getText());
        if (txtNombre.getText().toString().equals("")) exito = false;
        if (txtGrado.getText().toString().equals("")) exito = false;
        if (txtMatricula.getText().toString().equals("")) exito = false;

        return exito;
    }
}
