package com.example.listviewperso;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton fbtnAgregar;
    private Aplicacion app;
    private Alumno alumno;
    private int posicion = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Aplicacion app = (Aplicacion) getApplication();
        recyclerView = (RecyclerView) findViewById(R.id.recId);
        recyclerView.setAdapter(app.getAdaptador());

        fbtnAgregar = (FloatingActionButton) findViewById(R.id.agregarAlumno);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        fbtnAgregar.setOnClickListener(v -> {
            alumno = null;
            Intent intent = new Intent(MainActivity.this, AlumnoAltaActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("posicion", posicion);
            intent.putExtras(bundle);

            startActivityForResult(intent, 0);
        });

        app.getAdaptador().setOnClickListener(v -> {
            posicion = recyclerView.getChildAdapterPosition(v);
            // String dato = app.getAlumnos().get(posicion).getNombre();
            // Toast.makeText(MainActivity.this, "Se hizo click en " + dato, Toast.LENGTH_SHORT).show();
            alumno = app.getAlumnos().get(posicion);
            Intent intent = new Intent(MainActivity.this, AlumnoAltaActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("alumno", alumno);
            intent.putExtra("posicion", posicion);
            intent.putExtras(bundle);
            startActivityForResult(intent, 1);

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        recyclerView.getAdapter().notifyDataSetChanged();
        posicion = -1;
    }
}