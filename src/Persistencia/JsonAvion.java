package Persistencia;

import Modelo.Avion;
import Modelo.Vuelo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class JsonAvion {

    private static File archivo = new File("Avion.json");


    public static ArrayList<Avion> getJsonAvion() throws IOException {

        ArrayList<Avion> aviones = null;
        Type tipoListOfAvion = new TypeToken<ArrayList<Avion>>(){}.getType();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo));

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Avion.class,new ApdatadorAviones<Avion>());
        builder.setDateFormat("yyyy-MM-dd");
        Gson gson = builder.create();
        aviones = gson.fromJson(bufferedReader,tipoListOfAvion);

        bufferedReader.close();
        return aviones;
    }
}
