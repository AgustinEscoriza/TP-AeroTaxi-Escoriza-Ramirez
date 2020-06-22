package Vista;

import Modelo.Usuario;
import LogicaDeNegocio.Aerolinea;

public class MenuLogin extends Menu {


    public MenuLogin() {
        super();
    }

    public Usuario menuLogin(Aerolinea aerolinea) {
        Usuario usuario;
        usuario = menuBuscarUsuarioPorDni(aerolinea);
        return usuario;
    }

    public Usuario menuBuscarUsuarioPorDni(Aerolinea aerolinea) {
        String dni;
        Usuario usuarioBuscado = null;
        while (!salir) {
            System.out.println("Ingrese DNI de usuario registrado: ");
            dni = sn.nextLine();
            usuarioBuscado = aerolinea.buscarUsuarioPorDNI(dni);
            if (usuarioBuscado == null) {

                System.out.println("Ese usuario no existe. Ingrese uno nuevamente. ");

            } else {

                salir = true;

            }
        }
        return usuarioBuscado;
    }

}
