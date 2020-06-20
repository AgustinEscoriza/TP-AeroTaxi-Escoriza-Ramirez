import LogicaDeNegocio.Aerolinea;
import Modelo.Avion;
import Modelo.Usuario;
import Modelo.Vuelo;
import Persistencia.JsonAvion;
import Persistencia.JsonUsuario;
import Persistencia.JsonVuelo;
import Vista.MenuLogin;
import Vista.MenuPrincipal;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Avion> aviones = new ArrayList<>();
        ArrayList<Vuelo> vuelos = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        JsonAvion jsonAvion = new JsonAvion();
        JsonVuelo jsonVuelo = new JsonVuelo();
        JsonUsuario jsonUsuario = new JsonUsuario();
        try{
            aviones = jsonAvion.getJsonAvion();
        }catch (IOException e){
            e.printStackTrace();
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

        Aerolinea aerolinea = new Aerolinea(aviones,vuelos,usuarios);

        System.out.println(aerolinea.mostrarUsuarios());
        MenuLogin menuLogin = new MenuLogin();
        MenuPrincipal menuPrincipal = new MenuPrincipal();

        Usuario usuario;
        usuario=menuLogin.menuLogin(aerolinea);
        menuPrincipal.menuPrincipal(usuario, aerolinea);
    }
}
