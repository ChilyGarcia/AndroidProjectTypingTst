package com.example.dedosrapidos_pruebadeescriturarpida.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dedosrapidos_pruebadeescriturarpida.R;
import com.example.dedosrapidos_pruebadeescriturarpida.entidad.ResultadosPruebas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListaContactosAdapter extends RecyclerView.Adapter<ListaContactosAdapter.ContactoViewHolder> {

    ArrayList<ResultadosPruebas> listaContactos;


    public ListaContactosAdapter(ArrayList<ResultadosPruebas> listaContactos) {
        this.listaContactos = listaContactos;

    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_resultados, null, false);
        return new ContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        holder.tvCorrectas.setText(listaContactos.get(position).getCorrectos());
        holder.tvIncorrectas.setText(listaContactos.get(position).getIncorrectos());

    }


    @Override
    public int getItemCount() {
        return listaContactos.size();
    }

    public class ContactoViewHolder extends RecyclerView.ViewHolder {

        TextView tvCorrectas, tvIncorrectas;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);

            tvCorrectas = itemView.findViewById(R.id.tvCorrectas);
            tvIncorrectas = itemView.findViewById(R.id.tvIncorrectas);



        }
    }
}
