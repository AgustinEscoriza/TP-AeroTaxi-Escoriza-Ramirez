package Persistencia;

import Modelo.Avion;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonAvion {

    private static ObjectMapper mapper = new ObjectMapper();
    private static String archivo = "avion.json";

    public static void aJson(Avion avion){
        try {
            File json = new File(archivo);
            mapper.writeValue(json,avion);
        } catch (JsonMappingException e){
            e.printStackTrace();
        } catch (JsonGenerationException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static Avion aJava(){
        try{
            File json = new File(archivo);

        }
    }


}
