package Vista;
import Modelo.Usuario;
import LogicaDeNegocio.Aerolinea;

import java.util.Scanner;

public class MenuPrincipal extends MenuLogin {

    protected MenuVuelos menuVuelos;

    public MenuPrincipal(){
        super();
        menuVuelos = new MenuVuelos();
    }

    public void menuPrincipal(Aerolinea aerolinea, Usuario usuario) {
        while (!salir) {

            limpiarPantalla.limpiarPantalla();
            System.out.println("1. Contratar un vuelo");
            System.out.println("2. Cancelar un vuelo");
            System.out.println("3. Ver vuelos programados por fecha");
            System.out.println("4. Listar todos los clientes");
            System.out.println("5. Salir");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1:
                    limpiarPantalla.limpiarPantalla();
                    menuVuelos.menuContratarVuelo();
                    break;
                case 2:
                    limpiarPantalla.limpiarPantalla();
                    menuVuelos.menuCancelarVuelo();
                    break;
                case 3:
                    limpiarPantalla.limpiarPantalla();
                    menuVuelos.menuBuscarPorFecha(aerolinea);

                    break;
                case 4:
                    limpiarPantalla.limpiarPantalla();
                    System.out.println(aerolinea.mostrarUsuarios());
                    break;
                case 5:
                    salir=true;
                default:
                    System.out.println("Solo números entre 1 y 5");
            }
        }
    }
}