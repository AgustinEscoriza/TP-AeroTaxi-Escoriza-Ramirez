package Vista;

import Modelo.Usuario;
import LogicaDeNegocio.Aerolinea;
import Persistencia.JsonUsuario;

import java.io.IOException;
import java.util.ArrayList;

public class MenuLogin extends Menu {


    public MenuLogin() {
        super();
    }

    public Usuario menuLogin(Aerolinea aerolinea) {
        Usuario usuario = null;
        while (!salir) {
            System.out.println("1. Ingresar usuario registrado");
            System.out.println("2. Registrar nuevo usuario");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1:
                    limpiarPantalla();
                    usuario = menuBuscarUsuarioPorDni(aerolinea);
                    break;
                case 2:
                    limpiarPantalla();
                    usuario = menuRegistrarUsuario(aerolinea);
                    salir = false;
                    if (usuario != null) {
                        salir = true;
                    }
                    break;
                default:
                    System.out.println("Solo números 1 o 2");
            }
        }
        return usuario;
    }

    private Usuario menuRegistrarUsuario(Aerolinea aerolinea) {
        String nombre;
        String apellido;
        String dni;
        int edad;
        String confirmacion = null;
        Usuario usuario = null;


        while (!salir) {
            do {
                System.out.println("Ingrese nombre: ");
                nombre = sn.next();
                if (!nombre.matches("[A-Z][a-z]*")) {
                    System.out.println("Ingrese nombre valido. ");
                }
            } while (!nombre.matches("[A-Z][a-z]*"));

            do {
                System.out.println("Ingrese apellido: ");
                apellido = sn.next();
                if (!apellido.matches("[A-Z][a-z]*")) {
                    System.out.println("Ingrese un apellido valido. ");
                }
            } while (!apellido.matches("[A-Z][a-z]*"));

            boolean flag = false;
            do {
                System.out.println("Ingrese DNI:");
                dni = sn.next();
                if (!dni.matches("[0-9]*")) {
                    System.out.println("Ingrese un DNI valido. ");
                }
                else{
                    if (aerolinea.buscarUsuarioPorDNI(dni) != null) {
                        System.out.println("Este DNI ya se encuentra en uso. ");
                    } else {
                        flag = true;
                    }
                }
            } while (!flag);


            System.out.println("Ingrese edad: ");
            while (!sn.hasNextInt()) {
                System.out.println("Ingrese edad valida. ");
                sn.next();
            }
            edad = sn.nextInt();

            flag = false;
            while (!flag) {
                System.out.println("Confirmar? S/N: ");
                confirmacion = sn.next();
                if (confirmacion.equals("S")) {
                    usuario = new Usuario(nombre, apellido, dni, edad);
                    aerolinea.agregarUsuario(usuario);
                    actualizarJsonUsuarios(aerolinea.getUsuarios());
                    System.out.println("Usuario registrado exitosamente. ");
                    flag = true;
                } else if (confirmacion.equals("N")) {
                    System.out.println("Usuario no ingresado a los registros. ");
                    usuario = null;
                    flag = true;
                } else {
                    System.out.println("Caracter incorrecto. Por favor ingrese S o N. ");
                }
            }
            salir = true;
        }
        return usuario;
    }

    public Usuario menuBuscarUsuarioPorDni(Aerolinea aerolinea) {
        String dni;
        Usuario usuarioBuscado = null;
        while (!salir) {
            System.out.println("Ingrese DNI de usuario registrado: ");
            dni = sn.next();
            usuarioBuscado = aerolinea.buscarUsuarioPorDNI(dni);
            if (usuarioBuscado == null) {

                System.out.println("Ese usuario no existe. Ingrese uno nuevamente. ");

            } else {

                salir = true;

            }
        }
        return usuarioBuscado;
    }

    private void actualizarJsonUsuarios(ArrayList<Usuario> usuarios) {
        JsonUsuario jsonUsuarios = new JsonUsuario();
        if (usuarios != null) {
            try {
                jsonUsuarios.cargarJsonUsuario(usuarios);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
