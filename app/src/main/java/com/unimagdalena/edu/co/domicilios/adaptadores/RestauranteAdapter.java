package com.unimagdalena.edu.co.domicilios.adaptadores;

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
import com.unimagdalena.edu.co.domicilios.R;
import com.unimagdalena.edu.co.domicilios.logica.Util;
import com.unimagdalena.edu.co.domicilios.modelo.Restaurante;
import com.unimagdalena.edu.co.domicilios.vista.RestauranteActivity;

import java.util.ArrayList;

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

        Picasso.with(activity).load(restaurante.getImagen()).into(holder.logo_restaurante);
        holder.nombre_restaurante.setText(restaurante.getNombre());
        holder.rating.setRating(restaurante.getCalificacion());
        holder.categoria.setText(restaurante.getCategoria());
        holder.pedido_minimo.setText(Util.formatoPeso(restaurante.getPrecioMinimo()));

        if (restaurante.getEstado()) {
            holder.estado_restaurante.setText("Abierto");
            holder.estado_restaurante.setTextColor(ContextCompat.getColor(activity, R.color.green_500));
        } else {
            holder.estado_restaurante.setText("Cerrado");
        }
    }

    @Override
    public int getItemCount() {
        return restaurantes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        public ImageView logo_restaurante;
        public TextView nombre_restaurante;
        public RatingBar rating;
        public TextView pedido_minimo;
        public TextView categoria;
        public TextView estado_restaurante;

        public ViewHolder(View itemView) {
            super(itemView);

            this.logo_restaurante = (ImageView) itemView.findViewById(R.id.logo_restaurante);
            this.nombre_restaurante = (TextView) itemView.findViewById(R.id.nombre_restaurante);
            this.rating = (RatingBar) itemView.findViewById(R.id.rating);
            this.pedido_minimo = (TextView) itemView.findViewById(R.id.pedido_minimo);
            this.categoria = (TextView) itemView.findViewById(R.id.categoria);
            this.estado_restaurante = (TextView) itemView.findViewById(R.id.estado_restaurante);
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
