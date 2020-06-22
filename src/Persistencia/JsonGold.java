package Persistencia;

import Modelo.Gold;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class JsonGold {
    private static File archivo = new File("Gold.json");

    public JsonGold() {
    }

    public static ArrayList<Gold> getJsonGold() throws IOException {
        ArrayList<Gold> golds = null;
        Type tipoListOfGold = new TypeToken<ArrayList<Gold>>(){}.getType();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo));

        Gson gson = new Gson();
        ArrayList<Gold> listaGolds = gson.fromJson(bufferedReader,tipoListOfGold);

        golds = listaGolds;

        bufferedReader.close();
        return golds;
    }
}
