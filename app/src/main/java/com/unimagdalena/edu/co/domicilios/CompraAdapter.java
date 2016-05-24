package com.unimagdalena.edu.co.domicilios;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CompraAdapter extends RecyclerView.Adapter<CompraAdapter.ViewHolder> {

    private Activity activity;
    private ArrayList<Plato> platos;

    public CompraAdapter(Activity activity, ArrayList<Plato> platos) {
        this.activity = activity;
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

        holder.nombrePlato.setText(plato.getNombre());
        holder.precioPlato.setText(Util.formatoPeso(plato.getPrecio()));
    }

    @Override
    public int getItemCount() {
        return platos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.nombre_plato)
        TextView nombrePlato;

        @Bind(R.id.precio_plato)
        TextView precioPlato;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
