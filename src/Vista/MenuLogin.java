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
        Usuario usuario = null;
        while (!salir) {
            limpiarPantalla.limpiarPantalla();
            System.out.println("1. Ingresar usuario registrado");
            System.out.println("2. Registrar nuevo usuario");
            System.out.println("Escribe una de las opciones");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1:
                    limpiarPantalla.limpiarPantalla();
                    usuario=menuBuscarUsuarioPorDni(aerolinea);
                    break;
                case 2:
                    limpiarPantalla.limpiarPantalla();
                    usuario=menuRegistrarUsuario();
                    break;
                default:
                    System.out.println("Solo números 1 o 2");
            }
        }
        return usuario;
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
            while (!sn.hasNext()) {
                System.out.println("Ingrese nombre valido");
                sn.next();
            }
            nombre = sn.next();
            System.out.println("Ingrese apellido");
            apellido = sn.next();
            System.out.println("Ingrese DNI");
            dni = sn.next();
            System.out.print("Ingrese edad");
            while(!sn.hasNextInt()){
                System.out.print("Ingrese edad valida");
                sn.next();
            }
            edad = sn.nextInt();
            while (confirmacion != "S" || confirmacion != "N") {
                System.out.println("Confirmar? S/N");
                confirmacion = sn.next();
                if (confirmacion == "S") {
                    usuario = new Usuario(nombre,apellido,dni,edad);
                } else if (confirmacion == "N") {
                    usuario = null;
                } else {
                    System.out.println("Caracter incorrecto. Por favor ingrese S o N");
                }
            }
            salir=salirAMenuAnterior();
        }
        return usuario;
    }

    public Usuario menuBuscarUsuarioPorDni(Aerolinea aerolinea){
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
