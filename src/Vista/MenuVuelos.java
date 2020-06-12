package Vista;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import LogicaDeNegocio.Aerolinea;
import Modelo.Vuelo;
import Modelo.Avion;
import Enums.Ciudad;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MenuVuelos extends MenuLogin{

    public MenuVuelos() {
        super();
    }

    public Vuelo menuContratarVuelo() {

        Vuelo vuelo=null;
        Avion avion=null;
        String fechaString;
        Ciudad destino=null;
        Ciudad origen=null;
        float costoTotal;
        int distanciaKms;
        String confirmacion = null;
        int cantidadAcompanantes;

        while (!salir) {

            System.out.println("Ingrese fecha");
            fechaString = sn.next();
            LocalDate fechaLocalDate = LocalDate.parse(fechaString);

            //SELECCION ORIGEN Y DESTINO//

            System.out.println("Ingrese cantidad de acompanantes");
            cantidadAcompanantes = sn.nextInt();

            //SELECCION DE AVION//
            while (confirmacion != "S" || confirmacion != "N") {

                System.out.println("Confirmar? S/N");
                confirmacion = sn.next();

                if (confirmacion == "S") {

                    vuelo = new Vuelo(avion, origen, destino, cantidadAcompanantes, fechaLocalDate);

                } else if (confirmacion == "N") {

                    vuelo = null;

                } else {

                    System.out.println("Ingrese S o N");

                }
            }
            salir=salirAMenuAnterior();
        }
        return vuelo;
    }

    public void menuCancelarVuelo(){

    }
    public void menuBuscarPorFecha(Aerolinea aerolinea){

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("DD/MM/YYYY");
        String fechaString;
        LocalDate fechaDate;
        Scanner scan = new Scanner(System.in);
        fechaString = scan.nextLine();
        fechaDate = LocalDate.parse(fechaString,formato);

        System.out.println(aerolinea.mostrarVuelosPorFecha(fechaDate));
    }

    public void menuSeleccionAvion(LocalDate fecha, Ciudad origen, Ciudad destino, int nroAcompañantes){


    }


}
