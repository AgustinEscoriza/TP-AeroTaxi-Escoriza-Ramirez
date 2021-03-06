package Persistencia;


import Modelo.Avion;
import Modelo.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class JsonUsuario {

    private static File archivo = new File("usuario.json");

    public JsonUsuario() {
    }

    public static void cargarJsonUsuario(ArrayList<Usuario> usuarios) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(archivo));
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        gson.toJson(usuarios,bufferedWriter);

        bufferedWriter.close();
    }

    public static ArrayList<Usuario> getJsonUsuario() throws IOException {
        ArrayList<Usuario> usuarios = null;
        Type tipoListOfUsuario = new TypeToken<ArrayList<Usuario>>(){}.getType();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo));

        Gson gson = new Gson();
        usuarios = gson.fromJson(bufferedReader,tipoListOfUsuario);

        bufferedReader.close();
        return usuarios;
    }

}
