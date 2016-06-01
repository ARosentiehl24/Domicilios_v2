package com.unimagdalena.edu.co.domicilios.vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.unimagdalena.edu.co.domicilios.R;
import com.unimagdalena.edu.co.domicilios.adaptadores.CompraAdapter;
import com.unimagdalena.edu.co.domicilios.logica.Util;
import com.unimagdalena.edu.co.domicilios.modelo.Compra;

public class OrdenActivity extends AppCompatActivity implements View.OnClickListener {

    private Compra compra;

    private ImageView button_expander;
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private TextView subtotal;
    private TextView costo_envio;
    private TextView precio_total;
    private Button confirmar_pedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orden);
        initView();

        compra = (Compra) getIntent().getSerializableExtra("compra");

        Double totalPedidos = compra.getTotal();
        Double precioEnvio = compra.getRestaurante().getPrecioEnvio();

        subtotal.setText(Util.formatoPeso(totalPedidos));
        costo_envio.setText(Util.formatoPeso(precioEnvio));
        confirmar_pedido.setText(Util.formatoPeso(totalPedidos + precioEnvio));

        CompraAdapter compraAdapter = new CompraAdapter(compra.getPlatos());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(compraAdapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom);
        finish();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        subtotal = (TextView) findViewById(R.id.subtotal);
        costo_envio = (TextView) findViewById(R.id.costo_envio);
        precio_total = (TextView) findViewById(R.id.precio_total);
        confirmar_pedido = (Button) findViewById(R.id.confirmar_pedido);

        assert confirmar_pedido != null;
        confirmar_pedido.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.confirmar_pedido:
                Intent intent = new Intent(OrdenActivity.this, ConfirmarPedidoActivity.class);

                Bundle bundle = new Bundle();
                bundle.putInt("duracion", compra.getRestaurante().getTiempoEntrega());

                intent.putExtras(bundle);

                startActivity(intent);
                finish();
                break;
        }
    }
}
