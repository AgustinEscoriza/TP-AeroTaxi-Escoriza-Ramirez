package Vista;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import LogicaDeNegocio.Aerolinea;
import Modelo.Vuelo;
import Modelo.Avion;
import Modelo.Usuario;
import Modelo.Reserva;
import Enums.Ciudad;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MenuVuelos extends MenuLogin{

    public MenuVuelos() {
        super();
    }

    public void menuContratarVuelo(Usuario usuario, Aerolinea aerolinea) {

        Vuelo vuelo;
        String fechaString;
        Ciudad destino=null;
        Ciudad origen=null;
        float costoTotal;
        String confirmacion = null;
        int cantidadAcompanantes;

        while (!salir) {

            System.out.println("Ingrese fecha");
            fechaString = sn.next();
            LocalDate fechaLocalDate = LocalDate.parse(fechaString);

            //SELECCION ORIGEN Y DESTINO//

            System.out.println("Ingrese cantidad de acompanantes");
            cantidadAcompanantes = sn.nextInt();

            //SELECCION DE VUELO//

            while (confirmacion != "S" || confirmacion != "N") {
                System.out.println("Confirmar? S/N");
                confirmacion = sn.next();
                if (confirmacion == "S") {
                    Reserva reserva = new Reserva(usuario,cantidadAcompanantes);
                    vuelo.agregarReserva(reserva);
                } else if (confirmacion == "N") {
                    salir=true;
                } else {
                    System.out.println("Ingrese S o N");
                }
            }
            salir=salirAMenuAnterior();
        }
    }


    public void menuBuscarVueloPorFecha(Aerolinea aerolinea){

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("DD/MM/YYYY");
        String fechaString;
        LocalDate fechaDate;
        System.out.println("Ingrese una fecha");
        fechaString = sn.nextLine();
        fechaDate = LocalDate.parse(fechaString,formato);
        System.out.println(aerolinea.mostrarVuelosPorFecha(fechaDate));
    }

    public void menuCancelarVuelo(){
    }

    public void menuSeleccionVuelo(){
    }


}
