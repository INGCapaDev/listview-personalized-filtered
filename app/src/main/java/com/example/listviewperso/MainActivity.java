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
    private int posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.alumno = new Alumno();
        this.posicion = -1;
        this.app = (Aplicacion) getApplication();
        layoutManager = new LinearLayoutManager(this);
        recyclerView = (RecyclerView) findViewById(R.id.recId);
        recyclerView.setAdapter(app.getAdaptador());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        fbtnAgregar = findViewById(R.id.agregarAlumno);

        fbtnAgregar.setOnClickListener(v -> {
            alumno = null;
            Bundle bundle = new Bundle();
            bundle.putSerializable("alumno", alumno);
            bundle.putInt("posicion", posicion);
            Intent intent = new Intent(MainActivity.this, AlumnoAltaActivity.class);
            intent.putExtras(bundle);

            startActivityForResult(intent, 0);
        });

        app.getAdaptador().setOnClickListener(v -> {
            posicion = recyclerView.getChildAdapterPosition(v);
            alumno = app.getAlumnos().get(posicion);
            Bundle bundle = new Bundle();
            bundle.putSerializable("alumno", alumno);
            bundle.putInt("posicion", posicion);

            Intent intent = new Intent(MainActivity.this, AlumnoAltaActivity.class);
            intent.putExtras(bundle);

            startActivityForResult(intent, 0);

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        recyclerView.getAdapter().notifyDataSetChanged();
        this.posicion = -1;
        this.alumno = null;
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
                app.getAdaptador().getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}