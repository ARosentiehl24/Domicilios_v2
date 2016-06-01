package com.unimagdalena.edu.co.domicilios.vista;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.unimagdalena.edu.co.domicilios.logica.DividerItemDecoration;
import com.unimagdalena.edu.co.domicilios.modelo.Plato;
import com.unimagdalena.edu.co.domicilios.R;
import com.unimagdalena.edu.co.domicilios.modelo.Restaurante;
import com.unimagdalena.edu.co.domicilios.adaptadores.PlatoAdapter;
import com.unimagdalena.edu.co.domicilios.adaptadores.RestauranteAdapter;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {

    private EditText searchView;
    private RecyclerView recyclerView;
    private ArrayList<Restaurante> restaurantes;
    private ArrayList<Plato> platos;
    private RestauranteAdapter restauranteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        configView();
    }


    private void initView() {
        searchView = (EditText) findViewById(R.id.searchView);
        Button botonPromociones = (Button) findViewById(R.id.botonPromociones);
        Button mapa = (Button) findViewById(R.id.mapa);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        botonPromociones.setOnClickListener(this);
        mapa.setOnClickListener(this);
    }

    private void configView() {
        restaurantes = (ArrayList<Restaurante>) getIntent().getSerializableExtra("restaurantes");

        restauranteAdapter = new RestauranteAdapter(this, restaurantes);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, null, false, true));
        recyclerView.setAdapter(restauranteAdapter);

        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ArrayList<Restaurante> restaurantesFiltrados = new ArrayList<>();

                for (Restaurante restaurante : restaurantes) {
                    if (restaurante.getNombre().toLowerCase().contains(s.toString().toLowerCase())) {
                        restaurantesFiltrados.add(restaurante);
                    }
                }

                restauranteAdapter = new RestauranteAdapter(MainActivity.this, restaurantesFiltrados);

                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setHasFixedSize(true);
                recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), null, false, true));
                recyclerView.setAdapter(restauranteAdapter);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.botonPromociones:
                if (platos == null) {
                    platos = new ArrayList<>();

                    for (Restaurante restaurante : restaurantes) {
                        for (int i = 0; i < (int) (Math.random() * restaurante.getMenu().size()); i++) {
                            platos.add(restaurante.getMenu().get(i));
                        }
                    }
                }

                PlatoAdapter platoAdapter = new PlatoAdapter(this, restaurantes, platos, true);

                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setHasFixedSize(true);
                recyclerView.addItemDecoration(new DividerItemDecoration(this, null, false, true));
                recyclerView.setAdapter(platoAdapter);
                break;
            case R.id.mapa:
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("restaurantes", restaurantes);

                intent.putExtras(bundle);

                startActivity(intent);

                break;
        }
    }
}
