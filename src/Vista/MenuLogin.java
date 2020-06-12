package Vista;

import Modelo.Usuario;
import Modelo.Vuelo;
import LogicaDeNegocio.Aerolinea;

import java.time.LocalDate;

public class MenuLogin extends MenuPrincipal {

    public MenuLogin(Aerolinea aerolinea) {
        super(aerolinea);
    }

    public void menuLogin(){
        while (!salir) {

            System.out.println("1. Ingresar usuario registrado");
            System.out.println("2. Registrar nuevo usuario");

            System.out.println("Escribe una de las opciones");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1:
                    menuBuscarUsuarioPorDni();
                    break;
                case 2:
                    menuRegistrarUsuario();
                    break;
                default:
                    System.out.println("Solo números 1 o 2");
            }
        }
    }

    public Usuario menuRegistrarUsuario(){
        String nombre;
        String apellido;
        String dni;
        int edad;
        String confirmacion = null;
        Usuario usuario = null;
        while (!salir) {
            System.out.println("Ingrese nombre");
            nombre = sn.next();
            System.out.println("Ingrese apellido");
            apellido = sn.next();
            System.out.println("Ingrese DNI");
            dni = sn.next();
            System.out.print("Ingrese edad");
            edad = sn.nextInt();
            while (confirmacion != "S" || confirmacion != "N") {
                System.out.println("Confirmar? S/N");
                confirmacion = sn.next();
                if (confirmacion == "S") {
                    usuario = new Usuario(nombre,apellido,dni,edad);
                } else if (confirmacion == "N") {
                    usuario = null;
                } else {
                    System.out.println("Ingrese S o N");
                }
            }
            salir=salirAMenuAnterior();
        }
        return usuario;
    }

    public Usuario menuBuscarUsuarioPorDni(){
        String dni;
        String confirmacion=null;
        Usuario usuarioBuscado = null;
        while (!salir) {
            System.out.print("Ingrese DNI");
            dni = sn.next();
            usuarioBuscado = aerolinea.buscarUsuarioPorDNI(dni);
            salir=salirAMenuAnterior();
        }
        return usuarioBuscado;
    }
}
