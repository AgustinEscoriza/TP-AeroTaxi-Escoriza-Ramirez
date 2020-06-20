package Persistencia;

import Modelo.Avion;
import Modelo.Usuario;
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


        GsonBuilder builder = new GsonBuilder();
        builder.setDateFormat("yyyy-MM-dd");
        Gson gson = builder.create();
        ArrayList<Vuelo> listaVuelos = new ArrayList<>();
        listaVuelos = vuelos;
        gson.toJson(listaVuelos,bufferedWriter);

        bufferedWriter.close();
    }
    public static ArrayList<Vuelo> getJsonVuelo() throws IOException {

        ArrayList<Vuelo> vuelos = null;
        Type tipoListOfVuelo = new TypeToken<ArrayList<Vuelo>>(){}.getType();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo));

        GsonBuilder builder = new GsonBuilder();
        builder.setDateFormat("yyyy-MM-dd");
        Gson gson = builder.create();
        ArrayList<Vuelo> listaVuelos = gson.fromJson(bufferedReader,tipoListOfVuelo);

        vuelos = listaVuelos;

        bufferedReader.close();
        return vuelos;
    }

}
