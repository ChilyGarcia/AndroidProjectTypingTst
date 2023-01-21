package com.example.dedosrapidos_pruebadeescriturarpida.adaptadores;

import android.content.Intent;
import android.sax.ElementListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dedosrapidos_pruebadeescriturarpida.MainActivity;
import com.example.dedosrapidos_pruebadeescriturarpida.R;
import com.example.dedosrapidos_pruebadeescriturarpida.entidad.ResultadosPruebas;

import java.util.ArrayList;

public class ListaContactosAdapter extends RecyclerView.Adapter<ListaContactosAdapter.ContactoViewHolder> implements View.OnClickListener{

    ArrayList<ResultadosPruebas> listaResultados;
    private View.OnClickListener listener;


    public ListaContactosAdapter(ArrayList<ResultadosPruebas> listaResultados)
    {
        this.listaResultados = listaResultados;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_resultados, null, false);
        view.setOnClickListener(this);
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

    public void setOnClickListener(View.OnClickListener listener)
    {
        this.listener = listener;

    }

    @Override
    public void onClick(View view) {

        if(listener!=null)
        {
            listener.onClick(view);
        }

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
