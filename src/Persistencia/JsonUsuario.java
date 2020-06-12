package Persistencia;


import Modelo.Usuario;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JsonUsuario {

    private static ObjectMapper mapper = new ObjectMapper();
    private static String archivo = "usuario.json";

    public static void aJson(ArrayList<Usuario> usuarios){
        try {
            File json = new File(archivo);
            mapper.writeValue(json,);
        } catch (JsonMappingException e){
            e.printStackTrace();
        } catch (JsonGenerationException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Usuario> aJava(){
        Usuario[] arrayUsuario = new Usuario[0];
        ArrayList<Usuario> usuarios = null;
        try{

            File json = new File(archivo);
            arrayUsuario = mapper.readValue(json,Usuario[].class);
            usuarios = usuarioToArrayList(arrayUsuario);

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
