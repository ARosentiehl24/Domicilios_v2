package com.unimagdalena.edu.co.domicilios.adaptadores;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.unimagdalena.edu.co.domicilios.R;
import com.unimagdalena.edu.co.domicilios.modelo.Comentario;

import java.util.ArrayList;

public class ComentarioAdapter extends RecyclerView.Adapter<ComentarioAdapter.ViewHolder> {

    private ArrayList<Comentario> comentarios;

    public ComentarioAdapter(ArrayList<Comentario> comentarios) {
        this.comentarios = comentarios;
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

        holder.nombre_usuario.setText(comentario.getUsuario());
        holder.comentario.setText(comentario.getComentario());
    }

    @Override
    public int getItemCount() {
        return comentarios.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nombre_usuario;
        public TextView comentario;

        public ViewHolder(View itemView) {
            super(itemView);

            this.nombre_usuario = (TextView) itemView.findViewById(R.id.nombre_usuario);
            this.comentario = (TextView) itemView.findViewById(R.id.comentario);
        }
    }
}
