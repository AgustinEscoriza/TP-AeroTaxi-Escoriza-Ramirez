package Persistencia;

import Modelo.Avion;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JsonAvion {

    private static ObjectMapper mapper = new ObjectMapper();
    private static String archivo = "avion.json";

    public JsonAvion() {
    }

    public static void cargarJsonAvion(ArrayList<Avion> aviones){
        try {
            File json = new File(archivo);
            mapper.writeValue(json,aviones);
        } catch (JsonMappingException e){
            e.printStackTrace();
        } catch (JsonGenerationException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Avion> getJsonAvion(){
        ArrayList<Avion> aviones = null;
        try{

            File json = new File(archivo);
            aviones = mapper.readValue(json, new TypeReference<ArrayList<Avion>>(){});

        } catch (JsonMappingException e){
            e.printStackTrace();
        } catch (JsonGenerationException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        return aviones;
    }


}
