package com.unimagdalena.edu.co.domicilios;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GSonRestauranteParser {

    public GSonRestauranteParser() {

    }

    public ArrayList<Restaurante> restaurantes(InputStream inputStream) throws IOException {
        ArrayList<Restaurante> restaurantes = new ArrayList<>();

        Gson gson = new Gson();

        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));

        jsonReader.beginArray();

        while (jsonReader.hasNext()) {
            Restaurante restaurante = gson.fromJson(jsonReader, Restaurante.class);
            restaurantes.add(restaurante);
        }

        jsonReader.endArray();
        jsonReader.close();

        return restaurantes;
    }
}
