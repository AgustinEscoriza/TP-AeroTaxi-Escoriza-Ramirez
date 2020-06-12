package Persistencia;

import Modelo.Avion;
import Modelo.Vuelo;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JsonVuelo {

    private static ObjectMapper mapper = new ObjectMapper();
    private static String archivo = "vuelo.json";

    public JsonVuelo() {
    }

    public static void cargarJsonVuelo(ArrayList<Vuelo> vuelos){
        try {
            File json = new File(archivo);
            mapper.writeValue(json,vuelos);
        } catch (JsonMappingException e){
            e.printStackTrace();
        } catch (JsonGenerationException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Vuelo> getJsonVuelo(){
        ArrayList<Vuelo> vuelos = null;
        try{

            File json = new File(archivo);
            vuelos = mapper.readValue(json,new TypeReference<ArrayList<Vuelo>>(){});

        } catch (JsonMappingException e){
            e.printStackTrace();
        } catch (JsonGenerationException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        return vuelos;
    }

}
