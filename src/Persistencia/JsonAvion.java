package Persistencia;

import Modelo.Avion;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JsonAvion {

    private static ObjectMapper mapper = new ObjectMapper();
    private static String archivo = "avion.json";

    public static void aJson(ArrayList<Avion> aviones){
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
    public static ArrayList<Avion> aJava(){
        Avion[] arrayAviones = new Avion[0];
        ArrayList<Avion> aviones = null;
        try{

            File json = new File(archivo);
            arrayAviones = mapper.readValue(json,Avion[].class);
            aviones = avionToArrayList(arrayAviones);

        } catch (JsonMappingException e){
            e.printStackTrace();
        } catch (JsonGenerationException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        return aviones;
    }

    private static ArrayList<Avion> avionToArrayList(Avion[] arrayAviones) {
        ArrayList<Avion> aviones = null;
        Avion avion = null ;
        int contador = 0;
        int cantidad = 0;
        cantidad = arrayAviones.length;

        while(contador < cantidad){
            aviones.add(arrayAviones[contador]);
            contador ++;
        }

        return aviones;
    }


}
