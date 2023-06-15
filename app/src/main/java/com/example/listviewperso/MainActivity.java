package com.example.listviewperso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView ListViewContacto;
    List<Alumno> lst;
    AdapterAlumno adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListViewContacto = findViewById(R.id.ListViewContacto);

        adapter = new AdapterAlumno(this, GetData());
        ListViewContacto.setAdapter(adapter);

        ListViewContacto.setOnItemClickListener((parent, view, position, id) -> {
            Alumno c = lst.get(position);
            Toast.makeText(getBaseContext(), c.nombre, Toast.LENGTH_SHORT).show();
        });
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
                MainActivity.this.adapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private List<Alumno> GetData() {
        lst = new ArrayList<>();
        lst.add(new Alumno(1, R.drawable.a2019030344, "MORUA ZAMUDIO ESTEFANO", "2019030344", R.drawable.arrow));
        lst.add(new Alumno(2, R.drawable.a2020030174, "CARRANZA JAUREGUI CARLOS ALBERTO", "2020030174", R.drawable.arrow));
        lst.add(new Alumno(3, R.drawable.a2020030176, "CASTRO LOPEZ MARCO ANTONIO ALARID", "2020030176", R.drawable.arrow));
        lst.add(new Alumno(4, R.drawable.a2020030181, "DURAN VALDEZ JOSHUA DANIEL", "2020030181", R.drawable.arrow));
        lst.add(new Alumno(5, R.drawable.a2020030184, "GALINDO HERNANDEZ ERNESTO DAVID", "2020030184", R.drawable.arrow));
        lst.add(new Alumno(6, R.drawable.a2020030189, "CONTRERAS CEPEDA MAXIMILIANO", "2020030189", R.drawable.arrow));
        lst.add(new Alumno(7, R.drawable.a2020030199, "GOMEZ RUELAS IVÁN ENRIQUE", "2020030199", R.drawable.arrow));
        lst.add(new Alumno(8, R.drawable.a2020030212, "CRUZ QUINTERO JESUS EDUARDO", "2020030212", R.drawable.arrow));
        lst.add(new Alumno(9, R.drawable.a2020030241, "VELARDE OVALLE DAVID ANTONIO", "2020030241", R.drawable.arrow));
        lst.add(new Alumno(10, R.drawable.a2020030243, "LAMAS ARMENTA GUSTAVO ADOLFO", "2020030243", R.drawable.arrow));
        lst.add(new Alumno(11, R.drawable.a2020030249, "RIVAS LUGO JUAN CARLOS", "2020030249", R.drawable.arrow));
        lst.add(new Alumno(12, R.drawable.a2020030264, "SALAS MENDOZA ALEJO", "2020030264", R.drawable.arrow));
        lst.add(new Alumno(13, R.drawable.a2020030268, "SERRANO TORRES CARLOS JAIR", "2020030268", R.drawable.arrow));
        lst.add(new Alumno(14, R.drawable.a2020030292, "TIRADO ROMERO JESUS TADEO", "2020030292", R.drawable.arrow));
        lst.add(new Alumno(15, R.drawable.a2020030304, "CARRILLO GARCIA JAIR", "2020030304", R.drawable.arrow));
        lst.add(new Alumno(16, R.drawable.a2020030306, "ARIAS ZATARAIN DIEGO", "2020030306", R.drawable.arrow));
        lst.add(new Alumno(17, R.drawable.a2020030313, "VALDEZ MARTINEZ PAOLA EMIRET", "2020030313", R.drawable.arrow));
        lst.add(new Alumno(18, R.drawable.a2020030315, "IBARRA FLORES SALMA YARETH", "2020030315", R.drawable.arrow));
        lst.add(new Alumno(19, R.drawable.a2020030322, "LIZARRAGA MALDONADO JUAN ANTONIO", "2020030322", R.drawable.arrow));
        lst.add(new Alumno(20, R.drawable.a2020030325, "VIERA ROMERO ANGEL ZINEDINE ANASTACIO", "2020030325", R.drawable.arrow));
        lst.add(new Alumno(21, R.drawable.a2020030327, "TEJEDA PEINADO BLAS ALBERTO", "2020030327", R.drawable.arrow));
        lst.add(new Alumno(22, R.drawable.a2020030329, "VIERA ROMERO ANGEL RONALDO ANASTACIO", "2020030329", R.drawable.arrow));
        lst.add(new Alumno(23, R.drawable.a2020030332, "ELIZALDE VARGAS XIOMARA YAMILETH", "2020030332", R.drawable.arrow));
        lst.add(new Alumno(24, R.drawable.a2020030333, "SALCIDO SARABIA JESUS ANTONIO", "2020030333", R.drawable.arrow));
        lst.add(new Alumno(25, R.drawable.a2020030389, "RODRIGUEZ SANCHEZ YENNIFER CAROLINA", "2020030389", R.drawable.arrow));
        lst.add(new Alumno(26, R.drawable.a2020030766, "FLORES PRADO MANUEL ALEXIS", "2020030766", R.drawable.arrow));
        lst.add(new Alumno(27, R.drawable.a2020030771, "AGUIRRE TOSTADO VICTOR MOISES", "2020030771", R.drawable.arrow));
        lst.add(new Alumno(28, R.drawable.a2020030777, "DOMINGUEZ SARABIA HALACH UINIC", "2020030777", R.drawable.arrow));
        lst.add(new Alumno(29, R.drawable.a2020030799, "MACIEL NUÑEZ ENZO ALEJANDRO", "2020030799", R.drawable.arrow));
        lst.add(new Alumno(30, R.drawable.a2020030808, "BARRON VARGAS JOSE ALBERTO", "2020030808", R.drawable.arrow));
        lst.add(new Alumno(31, R.drawable.a2020030819, "MARTIN IBARRA GIANCARLO", "2020030819", R.drawable.arrow));
        lst.add(new Alumno(32, R.drawable.a2020030865, "SANCHEZ OCEGUEDA LUIS ANGEL", "2020030865", R.drawable.arrow));
        return lst;
    }
}