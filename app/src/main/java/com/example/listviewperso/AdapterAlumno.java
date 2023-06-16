package com.example.listviewperso;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterAlumno extends BaseAdapter implements Filterable {

    Context context;
    List<Alumno> lst;
    List<Alumno> alumnos;
    Filter CustomFilter;

    public AdapterAlumno(Context context, List<Alumno> lst) {
        this.context = context;
        this.lst = lst;
    }

    @Override
    public int getCount() {
        return lst.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView ImageViewContacto;
        TextView TextViewNombre;
        TextView TextViewDes;
        ImageView ImageViewFlecha;

        Alumno c = lst.get(position);

        if (convertView == null){
          convertView =  LayoutInflater.from(context).inflate(R.layout.alumno_item, null);
        }

        ImageViewContacto = convertView.findViewById(R.id.imageViewContacto);
        TextViewNombre = convertView.findViewById(R.id.textViewNombre);
        TextViewDes = convertView.findViewById(R.id.textViewDes);
        ImageViewFlecha = convertView.findViewById(R.id.imageViewFlecha);

        ImageViewContacto.setImageResource(c.imagen);
        TextViewNombre.setText(c.nombre);
        TextViewDes.setText(c.des);
        ImageViewFlecha.setImageResource(c.flecha);

        return convertView;
    }


    @Override
    public Filter getFilter() {
        if (CustomFilter == null) {
            CustomFilter = new CustomFilter();
        }
        return CustomFilter;
    }
    private class CustomFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if (alumnos == null) {
                alumnos = new ArrayList<>(lst);
            }

            if (constraint == null || constraint.length() == 0) {
                results.count = alumnos.size();
                results.values = alumnos;
            } else {
                List<Alumno> filteredList = new ArrayList<>();

                for (Alumno alumno : alumnos) {
                    if (alumno.getNombre().toLowerCase().contains(constraint.toString().toLowerCase()) || alumno.getDes().toLowerCase().contains(constraint.toString().toLowerCase())) {
                        filteredList.add(alumno);
                    }
                }

                results.count = filteredList.size();
                results.values = filteredList;
            }

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            lst = (List<Alumno>) results.values;

            notifyDataSetChanged();
        }
    }
}

