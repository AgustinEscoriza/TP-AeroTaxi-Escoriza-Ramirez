package Vista;
import Modelo.Usuario;
import Modelo.Vuelo;
import LogicaDeNegocio.Aerolinea;
import Persistencia.JsonVuelo;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MenuPrincipal extends Menu {

    protected MenuVuelos menuVuelos;

    public MenuPrincipal(){
        super();
        menuVuelos = new MenuVuelos();
    }

    public void menuPrincipal(Usuario usuario, Aerolinea aerolinea) {
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
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    menuVuelos.menuContratarVuelo(usuario, aerolinea);
                    break;
                case 2:
                    limpiarPantalla.limpiarPantalla();
                    menuVuelos.menuCancelarVuelo(aerolinea);
                    break;
                case 3:
                    limpiarPantalla.limpiarPantalla();
                    menuVuelos.menuBuscarVuelosPorFecha(aerolinea);
                    break;
                case 4:
                    limpiarPantalla.limpiarPantalla();
                    System.out.println(aerolinea.mostrarUsuarios());
                    break;
                case 5:
                    actualizarJsonVuelos(aerolinea);
                    salir=true;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 5");
            }
        }
    }

    private void actualizarJsonVuelos(Aerolinea aerolinea) {
        JsonVuelo jsonVuelo = new JsonVuelo();
        if(aerolinea.getVuelos()!=null) {
            try {
                jsonVuelo.cargarJsonVuelo(aerolinea.getVuelos());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}