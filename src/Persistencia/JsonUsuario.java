package Persistencia;

import Modelo.Avion;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JsonUsuario {

    private static ObjectMapper mapper = new ObjectMapper();
    private static String archivo = "usuario.json";

}
