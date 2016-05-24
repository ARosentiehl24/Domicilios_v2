package com.unimagdalena.edu.co.domicilios;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class OrdenActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.confirmar_pedido)
    CardView confirmarPedido;

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    @Bind(R.id.subtotal)
    TextView subTotal;

    @Bind(R.id.costo_envio)
    TextView costoEnvio;

    @Bind(R.id.precio_total)
    TextView precioTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orden);
        ButterKnife.bind(this);

        final Compra compra = (Compra) getIntent().getSerializableExtra("compra");

        Double totalPedidos = compra.getTotal();
        Double precioEnvio = compra.getRestaurante().getPrecioEnvio();

        subTotal.setText(Util.formatoPeso(totalPedidos));
        costoEnvio.setText(Util.formatoPeso(precioEnvio));
        precioTotal.setText(Util.formatoPeso(totalPedidos + precioEnvio));

        CompraAdapter compraAdapter = new CompraAdapter(this, compra.getPlatos());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(compraAdapter);

        ImageView imageView = (ImageView) toolbar.findViewById(R.id.button_expander);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        confirmarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrdenActivity.this, ConfirmarPedidoActivity.class);

                Bundle bundle = new Bundle();
                bundle.putInt("duracion", compra.getRestaurante().getTiempoEntrega());

                intent.putExtras(bundle);

                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom);
        finish();
    }
}
