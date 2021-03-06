package Persistencia;

import Modelo.Avion;
import Modelo.Vuelo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class JsonVuelo {

    private static String archivo = "vuelo.json";

    public JsonVuelo() {
    }

    public static void cargarJsonVuelo(ArrayList<Vuelo> vuelos) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(archivo));

        int contador = 1000;
        for(Vuelo vuelo:vuelos){
            vuelo.setIdVuelo(contador++);
        }

        GsonBuilder builder = new GsonBuilder();
        builder.setDateFormat("yyyy-MM-dd");
        builder.registerTypeAdapter(Avion.class,new ApdatadorAviones<Avion>());
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        gson.toJson(vuelos,bufferedWriter);

        bufferedWriter.close();
    }
    public static ArrayList<Vuelo> getJsonVuelo() throws IOException {

        ArrayList<Vuelo> vuelos = null;
        Type tipoListOfVuelo = new TypeToken<ArrayList<Vuelo>>(){}.getType();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo));

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Avion.class,new ApdatadorAviones<Avion>());
        builder.setDateFormat("yyyy-MM-dd");
        Gson gson = builder.create();
        vuelos = gson.fromJson(bufferedReader,tipoListOfVuelo);
        bufferedReader.close();
        return vuelos;
    }

}
