package com.example.dedosrapidos_pruebadeescriturarpida;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dedosrapidos_pruebadeescriturarpida.entidad.ResultadosPruebas;

import java.util.ArrayList;

public class ListaContactosAdapter extends RecyclerView.Adapter<ListaContactosAdapter.ContactoViewHolder>{

    ArrayList<ResultadosPruebas> listaResultados;

    public ListaContactosAdapter(ArrayList<ResultadosPruebas> listaResultados)
    {
        this.listaResultados = listaResultados;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_resultados, null, false);
        return new ContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {

        holder.tvCorrectos.setText(listaResultados.get(position).getCorrectos());
        holder.tvIncorrectos.setText(listaResultados.get(position).getIncorrectos());

    }

    @Override
    public int getItemCount() {
        return listaResultados.size();
    }

    public class ContactoViewHolder extends RecyclerView.ViewHolder {

        TextView tvCorrectos, tvIncorrectos;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);

            tvCorrectos = itemView.findViewById(R.id.tvCorrectas);
            tvIncorrectos = itemView.findViewById(R.id.tvIncorrectas);

        }
    }
}
