package com.unimagdalena.edu.co.domicilios;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RestauranteAdapter extends RecyclerView.Adapter<RestauranteAdapter.ViewHolder> {

    private Activity activity;
    private ArrayList<Restaurante> restaurantes;

    public RestauranteAdapter(Activity activity, ArrayList<Restaurante> restaurantes) {
        this.activity = activity;
        this.restaurantes = restaurantes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View restaurantes = layoutInflater.inflate(R.layout.restaurante_item_row, parent, false);

        return new ViewHolder(restaurantes);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Restaurante restaurante = restaurantes.get(position);

        Picasso.with(activity).load(restaurante.getImagen()).into(holder.logoRestaurante);
        holder.nombreRestaurante.setText(restaurante.getNombre());
        holder.rating.setRating(restaurante.getCalificacion());
        holder.categoria.setText(restaurante.getCategoria());
        holder.pedidoMinimo.setText(Util.formatoPeso(restaurante.getPrecioMinimo()));

        if (restaurante.getEstado()) {
            holder.estadoRestaurante.setText("Abierto");
            holder.estadoRestaurante.setTextColor(ContextCompat.getColor(activity, R.color.green_500));
        } else {
            holder.estadoRestaurante.setText("Cerrado");
        }
    }

    @Override
    public int getItemCount() {
        return restaurantes.size();
    }

    public Restaurante getRestaurante(int position) {
        return restaurantes.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.logo_restaurante)
        ImageView logoRestaurante;

        @Bind(R.id.nombre_restaurante)
        TextView nombreRestaurante;

        @Bind(R.id.rating)
        RatingBar rating;

        @Bind(R.id.categoria)
        TextView categoria;

        @Bind(R.id.pedido_minimo)
        TextView pedidoMinimo;

        @Bind(R.id.estado_restaurante)
        TextView estadoRestaurante;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(activity, RestauranteActivity.class);

            Bundle bundle = new Bundle();
            bundle.putSerializable("restaurante", restaurantes.get(getLayoutPosition()));

            intent.putExtras(bundle);

            activity.startActivity(intent);
        }
    }
}
