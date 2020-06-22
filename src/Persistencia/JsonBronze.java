package Persistencia;

import Modelo.Bronze;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class JsonBronze {
    private static File archivo = new File("Bronze.json");

    public JsonBronze() {
    }

    public static ArrayList<Bronze> getJsonBronze() throws IOException {
        ArrayList<Bronze> bronzes = null;
        Type tipoListOfBronze = new TypeToken<ArrayList<Bronze>>(){}.getType();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo));

        Gson gson = new Gson();
        ArrayList<Bronze> listaBronzes = gson.fromJson(bufferedReader,tipoListOfBronze);

        bronzes = listaBronzes;

        bufferedReader.close();
        return bronzes;
    }
}
