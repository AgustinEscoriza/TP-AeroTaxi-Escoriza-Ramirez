package Vista;

import Modelo.Usuario;
import LogicaDeNegocio.Aerolinea;
import Persistencia.JsonUsuario;
import Persistencia.JsonVuelo;
import java.io.IOException;


public class MenuPrincipal extends Menu {

    protected MenuVuelos menuVuelos;

    public MenuPrincipal() {
        super();
        menuVuelos = new MenuVuelos();
    }

    public void menuPrincipal(Usuario usuario, Aerolinea aerolinea) {
        while (!salir) {

            System.out.println("1. Contratar un vuelo");
            System.out.println("2. Cancelar un vuelo");
            System.out.println("3. Ver vuelos programados por fecha");
            System.out.println("4. Listar todos los clientes");
            System.out.println("5. Salir");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1:
                    limpiarPantalla();
                    menuVuelos.menuContratarVuelo(usuario, aerolinea);
                    break;
                case 2:
                    limpiarPantalla();
                    menuVuelos.menuCancelarVuelo(aerolinea);
                    break;
                case 3:
                    limpiarPantalla();
                    menuVuelos.menuBuscarVuelosPorFecha(aerolinea);
                    break;
                case 4:
                    limpiarPantalla();
                    System.out.println(aerolinea.mostrarUsuarios());
                    break;
                case 5:
                    actualizarJsonVuelos(aerolinea);
                    actualizarJsonUsuarios(aerolinea);
                    salir = true;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 5");
            }
        }
    }

    private void actualizarJsonVuelos(Aerolinea aerolinea) {
        JsonVuelo jsonVuelo = new JsonVuelo();
        if (aerolinea.getVuelos() != null) {
            try {
                jsonVuelo.cargarJsonVuelo(aerolinea.getVuelos());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void actualizarJsonUsuarios(Aerolinea aerolinea) {
        JsonUsuario jsonUsuarios = new JsonUsuario();
        if (aerolinea.getUsuarios() != null) {
            try {
                jsonUsuarios.cargarJsonUsuario(aerolinea.getUsuarios());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void limpiarPantalla() {
        for (int i = 0; i < 25; i++) {
            System.out.println();
        }
    }
}
