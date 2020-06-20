package Persistencia;

import Modelo.Avion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JsonAvion {

    private static File archivo = new File ("avion.json");


    public JsonAvion() {
    }

    public static void cargarJsonAvion(ArrayList<Avion> aviones) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(archivo));
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Avion.class,new JsonSerializerAvion());
        Gson gson = builder.create();
        List<Avion> list = Collections.synchronizedList(new ArrayList<Avion>());  //probar si anda sin esto despues de que corra bien, esta puesto por copiar de internet: https://stackoverflow.com/questions/5813434/trouble-with-gson-serializing-an-arraylist-of-pojos
        list = aviones;
        gson.toJson(list,bufferedWriter);
        bufferedWriter.close();

    }
    public static ArrayList<Avion> getJsonAvion() throws IOException {
        ArrayList<Avion> aviones = null;

        Type listOfAvion = new TypeToken<ArrayList<Avion>>(){}.getType();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo));

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Avion.class,new JsonDeserializerAvion<Avion>());
        Gson gson = builder.create();

        //List<Avion> list = Collections.synchronizedList(new ArrayList<Avion>());
        ArrayList<Avion> list = gson.fromJson(bufferedReader,listOfAvion);

        aviones = list;

        bufferedReader.close();
        return aviones;
    }


}
