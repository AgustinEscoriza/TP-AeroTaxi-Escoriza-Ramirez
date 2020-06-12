import LogicaDeNegocio.Aerolinea;
import Modelo.Avion;
import Modelo.Usuario;
import Modelo.Vuelo;
import Persistencia.JsonAvion;
import Persistencia.JsonUsuario;
import Persistencia.JsonVuelo;
import Vista.MenuLogin;
import Vista.MenuPrincipal;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Avion> aviones;
        ArrayList<Vuelo> vuelos;
        ArrayList<Usuario> usuarios;
        JsonAvion jsonAvion = new JsonAvion();
        JsonVuelo jsonVuelo = new JsonVuelo();
        JsonUsuario jsonUsuario = new JsonUsuario();
        aviones = jsonAvion.aJava();
        usuarios = jsonUsuario.aJava();
        vuelos = jsonVuelo.aJava();

        Aerolinea aerolinea = new Aerolinea(aviones,vuelos,usuarios);

        MenuLogin menuLogin = new MenuLogin();
        MenuPrincipal menuPrincipal = new MenuPrincipal();

        Usuario usuario;
        usuario=menuLogin.menuLogin(aerolinea);
        menuPrincipal.menuPrincipal(usuario, aerolinea);
    }
}
