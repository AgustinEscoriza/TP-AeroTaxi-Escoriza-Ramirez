package Persistencia;

import Modelo.Silver;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class JsonSilver {
    private static File archivo = new File("Silver.json");

    public JsonSilver() {
    }

    public static ArrayList<Silver> getJsonSilver() throws IOException {
        ArrayList<Silver> silvers = null;
        Type tipoListOfSilver = new TypeToken<ArrayList<Silver>>(){}.getType();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo));

        Gson gson = new Gson();
        ArrayList<Silver> listaSilvers = gson.fromJson(bufferedReader,tipoListOfSilver);

        silvers = listaSilvers;

        bufferedReader.close();
        return silvers;
    }
}
