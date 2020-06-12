package Persistencia;


import Modelo.Avion;
import Modelo.Usuario;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JsonUsuario {

    private static ObjectMapper mapper = new ObjectMapper();
    private static String archivo = "usuario.json";

    public JsonUsuario() {
    }

    public static void cargarJsonUsuario(ArrayList<Usuario> usuarios){
        try {
            File json = new File(archivo);
            mapper.writeValue(json,usuarios);
        } catch (JsonMappingException e){
            e.printStackTrace();
        } catch (JsonGenerationException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Usuario> getJsonUsuario(){
        ArrayList<Usuario> usuarios = null;
        try{

            File json = new File(archivo);
            usuarios = mapper.readValue(json, new TypeReference<ArrayList<Usuario>>(){} );

        } catch (JsonMappingException e){
            e.printStackTrace();
        } catch (JsonGenerationException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        return usuarios;
    }

}
