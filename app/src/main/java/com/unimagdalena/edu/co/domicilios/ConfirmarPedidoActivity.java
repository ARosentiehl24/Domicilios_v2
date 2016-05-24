package com.unimagdalena.edu.co.domicilios;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ConfirmarPedidoActivity extends AppCompatActivity {

    @Bind(R.id.tiempo_entrega)
    TextView tiempoEntrega;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_pedido);
        ButterKnife.bind(this);

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
}
