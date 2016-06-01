package com.unimagdalena.edu.co.domicilios.adaptadores;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.unimagdalena.edu.co.domicilios.R;
import com.unimagdalena.edu.co.domicilios.logica.Util;
import com.unimagdalena.edu.co.domicilios.modelo.Plato;

import java.util.ArrayList;

public class CompraAdapter extends RecyclerView.Adapter<CompraAdapter.ViewHolder> {

    private ArrayList<Plato> platos;

    public CompraAdapter(ArrayList<Plato> platos) {
        this.platos = platos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View compras = layoutInflater.inflate(R.layout.compra_item_row, parent, false);

        return new ViewHolder(compras);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Plato plato = platos.get(position);
        holder.nombre_plato.setText(plato.getNombre());
        holder.precio_plato.setText(Util.formatoPeso(plato.getPrecio()));
    }

    @Override
    public int getItemCount() {
        return platos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nombre_plato;
        public TextView precio_plato;

        public ViewHolder(View itemView) {
            super(itemView);
            this.nombre_plato = (TextView) itemView.findViewById(R.id.nombre_plato);
            this.precio_plato = (TextView) itemView.findViewById(R.id.precio_plato);
        }

    }
}
