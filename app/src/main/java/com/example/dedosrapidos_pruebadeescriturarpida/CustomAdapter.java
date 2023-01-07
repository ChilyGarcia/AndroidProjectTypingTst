package com.example.dedosrapidos_pruebadeescriturarpida;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter
{
    Context context;
    List<ResultadosPruebas> lst;

    public CustomAdapter(Context context, List<ResultadosPruebas> lst) {
        this.context = context;
        this.lst = lst;
    }


    @Override
    public int getCount() {
        return lst.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageViewContacto;
        TextView textViewNombre;
        TextView textViewDesc;

        ResultadosPruebas r =lst.get(i);

        if(view == null)
            view = LayoutInflater.from(context).inflate(R.layout.listview_resultados, null);


        imageViewContacto = view.findViewById(R.id.imageViewContacto);
        textViewNombre = view.findViewById(R.id.textViewNombre);
        textViewDesc = view.findViewById(R.id.textViewDesc);

        imageViewContacto.setImageResource(R.drawable.compartir);
        textViewNombre.setText(r.nombre);
        textViewDesc.setText(r.desc);

        return view;
    }
}
