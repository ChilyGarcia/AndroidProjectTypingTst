package com.example.dedosrapidos_pruebadeescriturarpida.adaptadores;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dedosrapidos_pruebadeescriturarpida.MainActivity;
import com.example.dedosrapidos_pruebadeescriturarpida.R;
import com.example.dedosrapidos_pruebadeescriturarpida.entidad.ResultadosPruebas;

import java.util.ArrayList;


public class ListaContactosAdapter extends RecyclerView.Adapter<ListaContactosAdapter.ContactoViewHolder> implements View.OnClickListener{

    ArrayList<ResultadosPruebas> listaContactos;
    private View.OnClickListener listener;



    public ListaContactosAdapter(ArrayList<ResultadosPruebas> listaContactos) {
        this.listaContactos = listaContactos;

    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_resultados, null, false);
        //Poner a la escucha el click listener
        view.setOnClickListener(this);
        return new ContactoViewHolder(view);



    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        holder.tvCorrectas.setText(listaContactos.get(position).getCorrectos());
        holder.tvIncorrectas.setText(listaContactos.get(position).getIncorrectos());

        //Se pone el evento para cada item de el recyclerView
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), MainActivity.class);
                holder.itemView.getContext().startActivity(intent);

            }
        });

    }


    @Override
    public int getItemCount() {
        return listaContactos.size();
    }


    public void setOnClickListener(View.OnClickListener listener)
    {
        this.listener = listener;

    }

    @Override
    public void onClick(View view) {

        if(listener != null)
        {
            listener.onClick(view);
        }

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
