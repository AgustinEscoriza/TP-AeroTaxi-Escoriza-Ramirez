package Vista;

import Modelo.Usuario;
import LogicaDeNegocio.Aerolinea;

import java.util.Scanner;

public class MenuLogin {

    protected Scanner sn;
    protected boolean salir;
    protected int opcion;
    protected LimpiarPantalla limpiarPantalla;

    public MenuLogin() {
        limpiarPantalla = new LimpiarPantalla();
        sn = new Scanner(System.in);
        salir = false;
        opcion = 0;
    }

    public Usuario menuLogin(Aerolinea aerolinea){
        Usuario usuario;
        limpiarPantalla.limpiarPantalla();
        usuario=menuBuscarUsuarioPorDni(aerolinea);
        return usuario;
    }

    public Usuario menuBuscarUsuarioPorDni(Aerolinea aerolinea){
        String dni;
        Usuario usuarioBuscado = null;
        while (!salir) {
            System.out.print("Ingrese DNI de usuario registrado");
            dni = sn.next();
            usuarioBuscado = aerolinea.buscarUsuarioPorDNI(dni);
            salir=salirAMenuAnterior();
        }
        return usuarioBuscado;
    }

    public boolean salirAMenuAnterior() {
        System.out.println("Desea salir al menu anterior? S/N");
        String eleccion = sn.next();
        if (eleccion == "S") {
            salir = true;
        } else if (eleccion == "N") {
            salir = false;
        } else {
            System.out.println("Debe ingresar S o N");
        }
        return salir;
    }
}
