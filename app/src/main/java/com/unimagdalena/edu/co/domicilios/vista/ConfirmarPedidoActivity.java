package com.unimagdalena.edu.co.domicilios.vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.unimagdalena.edu.co.domicilios.R;

public class ConfirmarPedidoActivity extends AppCompatActivity {

    private TextView tiempoEntrega;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_pedido);

        initView();

        int tiempoEntrega = getIntent().getIntExtra("duracion", 0);

        this.tiempoEntrega.setText(getString(R.string.mensaje_tiempo_entrega) + " " + (tiempoEntrega - 5) + " a " + (tiempoEntrega + 5) + " minutos.");
    }

    @Override
    public void onBackPressed() {
        Intent intent = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        startActivity(intent);
    }

    private void initView() {
        tiempoEntrega = (TextView) findViewById(R.id.tiempo_entrega);
    }
}
