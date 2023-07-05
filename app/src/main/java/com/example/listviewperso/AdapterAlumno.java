package com.example.listviewperso;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterAlumno extends RecyclerView.Adapter<AdapterAlumno.ViewHolder> implements View.OnClickListener, Filterable {

    protected ArrayList<Alumno> listaAlumnos;
    private ArrayList<Alumno> listaFinal;
    private View.OnClickListener listener;
    private Application context;
    private LayoutInflater inflater;

    public AdapterAlumno(ArrayList<Alumno> listaAlumnos, Application context) {
        this.listaAlumnos = new ArrayList<>();
        this.listaAlumnos.addAll(listaAlumnos);
        this.listaFinal = listaAlumnos;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.alumno_items, null);
        view.setOnClickListener(this);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAlumno.ViewHolder holder, int position) {
        Alumno alumno = this.listaFinal.get(position);
        holder.txtMatricula.setText(alumno.getMatricula());
        holder.txtNombre.setText(alumno.getNombre());
        holder.txtCarrera.setText(alumno.getCarrera());
        //holder.idImagen.setImageResource(R.drawable.avatar);

        if(alumno.getImg() == 0) holder.idImagen.setImageResource(R.drawable.avatar);
        else holder.idImagen.setImageResource(alumno.getImg());

    }

    @Override
    public int getItemCount() {
        return listaFinal.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener != null) listener.onClick(v);
    }

    @Override
    public Filter getFilter() {

        return new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                ArrayList<Alumno> listaFiltrada = new ArrayList<>();

                if(constraint == null || constraint.length() == 0){
                    listaFiltrada.addAll(listaAlumnos);
                    filterResults.values = listaFiltrada;
                    filterResults.count = listaFiltrada.size();
                } else {
                    String searchStr = constraint.toString().toLowerCase().trim();

                    for (Alumno alumno: listaAlumnos){
                        String nombre = alumno.getNombre().toLowerCase().trim();
                        String matricula = alumno.getMatricula().toLowerCase().trim();

                        if (nombre.contains(searchStr) || matricula.contains(searchStr)){
                            listaFiltrada.add(alumno);
                        }
                    }

                    filterResults.values = listaFiltrada;
                    filterResults.count = listaFiltrada.size();
                }
                 return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                listaFinal.clear();
                listaFinal.addAll((ArrayList<Alumno>) results.values);
                notifyDataSetChanged();
            }
        };
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private LayoutInflater inflater;
        private TextView txtNombre;
        private TextView txtMatricula;
        private TextView txtCarrera;
        private ImageView idImagen;

        public ViewHolder(@NonNull View view) {
            super(view);
            txtNombre = (TextView) view.findViewById(R.id.txtAlumnoNombre);
            txtMatricula = (TextView) view.findViewById(R.id.txtMatricula);
            txtCarrera = (TextView) view.findViewById(R.id.txtCarrera);
            idImagen = (ImageView) view.findViewById(R.id.foto);

        }
    }
}

