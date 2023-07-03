package com.example.listviewperso;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton fbtnAgregar;
    private Aplicacion app;
    private Alumno alumno;
    private int posicion = -1;
    private AdapterAlumno adaptadorAlumnos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Aplicacion app = (Aplicacion) getApplication();
        recyclerView = (RecyclerView) findViewById(R.id.recId);
        adaptadorAlumnos = app.getAdaptador();
        recyclerView.setAdapter(adaptadorAlumnos);
        recyclerView.setHasFixedSize(true);
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
        posicion = -1;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.searchview, menu);

        MenuItem menuItem = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Escribe para buscar");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adaptadorAlumnos.getFilter().filter(newText);


                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}