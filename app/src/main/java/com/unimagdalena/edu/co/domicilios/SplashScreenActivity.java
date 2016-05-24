package com.unimagdalena.edu.co.domicilios;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            try {
                new CargarRestaurantes().execute(new URL("https://www.dropbox.com/s/jmsznxc8560zgsm/restaurantes.json?dl=1"));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(this, "Error en la conexión", Toast.LENGTH_SHORT).show();
        }
    }

    class CargarRestaurantes extends AsyncTask<URL, Void, ArrayList<Restaurante>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected ArrayList<Restaurante> doInBackground(URL... params) {
            ArrayList<Restaurante> restaurantes = null;
            HttpURLConnection httpURLConnection = null;

            try {
                httpURLConnection = (HttpURLConnection) params[0].openConnection();
                httpURLConnection.setConnectTimeout(20 * 1000);
                httpURLConnection.setReadTimeout(10 * 1000);

                if (httpURLConnection.getResponseCode() == 200) {
                    InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());

                    GSonRestauranteParser gSonRestauranteParser = new GSonRestauranteParser();
                    restaurantes = gSonRestauranteParser.restaurantes(inputStream);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                assert httpURLConnection != null;
                httpURLConnection.disconnect();
            }

            return restaurantes;
        }

        @Override
        protected void onPostExecute(ArrayList<Restaurante> restaurantes) {
            super.onPostExecute(restaurantes);

            if (restaurantes == null) {
                Toast.makeText(SplashScreenActivity.this, "Hubo un error de lectura", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("restaurantes", restaurantes);

                intent.putExtras(bundle);

                startActivity(intent);
                finish();
            }
        }
    }
}
