package com.example.listviewperso;

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

public class AdapterAlumno extends RecyclerView.Adapter<AdapterAlumno.ViewHolder> implements View.OnClickListener {

  protected ArrayList<Alumno> listaAlumnos;
  private View.OnClickListener listener;
  private Context context;
  private LayoutInflater inflater;

  public AdapterAlumno(ArrayList<Alumno> listaAlumnos, Context context){
      this.listaAlumnos = listaAlumnos;
      this.context = context;
      this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }

    @NonNull
    @Override
    public AdapterAlumno.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.alumno_items, null);
        view.setOnClickListener(this);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAlumno.ViewHolder holder, int position) {
        Alumno alumno = listaAlumnos.get(position);
        holder.txtMatricula.setText(alumno.getMatricula());
        holder.txtNombre.setText(alumno.getNombre());
        holder.idImagen.setImageResource(alumno.getImg());
    }

    @Override
    public int getItemCount() {
        return listaAlumnos.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {this.listener = listener;}
    @Override
    public void onClick(View v) {
        if(listener != null) listener.onClick(v);
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

