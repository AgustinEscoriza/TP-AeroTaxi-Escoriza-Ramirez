import LogicaDeNegocio.Aerolinea;
import Modelo.Avion;
import Modelo.Usuario;
import Modelo.Vuelo;
import Persistencia.*;
import Vista.MenuLogin;
import Vista.MenuPrincipal;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Aerolinea aerolinea = cargarAerolinea();

        if(aerolinea.getAviones().isEmpty()) {
            System.out.println("No se encuentran aviones en los registros." + "\n" + "Por favor carguelos antes de iniciar el programa.");
        }
        else{
            MenuLogin menuLogin = new MenuLogin();
            MenuPrincipal menuPrincipal = new MenuPrincipal();

            Usuario usuario;
            usuario = menuLogin.menuLogin(aerolinea);
            menuPrincipal.menuPrincipal(usuario, aerolinea);
        }
    }

    public static Aerolinea cargarAerolinea(){
        Aerolinea aerolinea = null;
        JsonBronze jsonBronze = new JsonBronze();
        JsonSilver jsonSilver = new JsonSilver();
        JsonGold jsonGold = new JsonGold();
        JsonVuelo jsonVuelo = new JsonVuelo();
        JsonUsuario jsonUsuario = new JsonUsuario();
        ArrayList<Avion> aviones = new ArrayList<>();
        ArrayList<Vuelo> vuelos = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try{
            aviones.addAll(jsonGold.getJsonGold());
            aviones.addAll(jsonSilver.getJsonSilver());
            aviones.addAll(jsonBronze.getJsonBronze());
        }catch (IOException e){
            e.printStackTrace();
        }catch (NullPointerException e){
        }
         try{
             usuarios = jsonUsuario.getJsonUsuario();
         }catch (IOException e){
             e.printStackTrace();
         }

         try{
             vuelos = jsonVuelo.getJsonVuelo();
         }catch (IOException e){
             e.printStackTrace();
         }
        aerolinea = new Aerolinea(aviones,vuelos,usuarios);
        return aerolinea;
    }
}
