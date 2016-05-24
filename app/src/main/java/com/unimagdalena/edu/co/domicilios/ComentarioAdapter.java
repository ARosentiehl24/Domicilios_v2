package com.unimagdalena.edu.co.domicilios;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ComentarioAdapter extends RecyclerView.Adapter<ComentarioAdapter.ViewHolder> {

    private Activity activity;
    private ArrayList<Comentario> comentarios;
    private ArrayList<Integer> pedidos;

    public ComentarioAdapter(Activity activity, ArrayList<Comentario> comentarios) {
        this.activity = activity;
        this.comentarios = comentarios;

        pedidos = new ArrayList<>();

        for (int i = 0; i < comentarios.size(); i++) {
            pedidos.add((int) (Math.random() * 10 + 1));
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View restaurantes = layoutInflater.inflate(R.layout.comentario_item_row, parent, false);

        return new ViewHolder(restaurantes);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Comentario comentario = comentarios.get(position);
        int pedido = pedidos.get(position);

        holder.nombreUsuario.setText(comentario.getUsuario());
        holder.comentario.setText(comentario.getComentario());
        holder.pedidos.setText(String.format(Locale.US, "%d pedidos", pedido));
    }

    @Override
    public int getItemCount() {
        return comentarios.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.nombre_usuario)
        TextView nombreUsuario;

        @Bind(R.id.comentario)
        TextView comentario;

        @Bind(R.id.pedidos)
        TextView pedidos;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
