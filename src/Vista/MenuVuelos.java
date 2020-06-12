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
        boolean flag = false;

        while (!salir) {

            System.out.println("Ingrese fecha");
            fechaString = sn.next();
            LocalDate fechaLocalDate = LocalDate.parse(fechaString);

            System.out.println("Elija una de las siguientes ciudades de origen:");
            origen= menuSeleccionCiudad();
            while(flag == false){
                System.out.println("Elija una de las siguientes ciudades de destino:");
                destino= menuSeleccionCiudad();
                if(destino.equals(origen)){
                    flag = false;
                    System.out.println("El destino no puede ser "+ destino.toString() +"ya que es el origen. Ingrese otra ciudad");
                }else{
                    flag = true;
                }
            }


            System.out.println("Ingrese cantidad de acompanantes");
            cantidadAcompanantes = sn.nextInt();

            vuelo=menuSeleccionarVuelo(aerolinea,fechaLocalDate,origen,destino,cantidadAcompanantes);

            costoTotal=vuelo.calcularCosto(cantidadAcompanantes);
            System.out.println("El costo total del vuelo es" + costoTotal);

            while (confirmacion != "S" || confirmacion != "N") {
                System.out.println("Confirmar? S/N");
                confirmacion = sn.next();
                if (confirmacion == "S") {
                    Reserva reserva = new Reserva(usuario,cantidadAcompanantes);
                    vuelo.agregarReserva(reserva);
                    usuario.setTotalDineroGastado(costoTotal);
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

    public Ciudad menuSeleccionCiudad(){
        Ciudad ciudad = null;
        while (!salir) {
            
            System.out.println("1. BUENOS AIRES");
            System.out.println("2. CORDOBA");
            System.out.println("3. SANTIAGO DE CHILE");
            System.out.println("4. MONTEVIDEO");
            System.out.println("Elija una opcion");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1:
                    ciudad = Ciudad.BUENOS_AIRES;
                    break;
                case 2:
                    ciudad = Ciudad.CORDOBA;
                    break;
                case 3:
                    ciudad = Ciudad.SANTIAGO_DE_CHILE;
                    break;
                case 4:
                    ciudad = Ciudad.MONTEVIDEO;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 4");
            }
        }
        return ciudad;
    }

    public Vuelo menuSeleccionarVuelo(Aerolinea aerolinea, LocalDate fecha, Ciudad origen, Ciudad destino, int cantidadAcompanantes){
        int idVuelo;
        Vuelo vuelo;
        aerolinea.mostrarVuelosDisponibles(fecha,origen,destino,cantidadAcompanantes+1);
        System.out.println("Seleccione la id del vuelo que desea reservar:");
        idVuelo = sn.nextInt();
        vuelo=aerolinea.buscarVueloPorID(idVuelo);
        return vuelo;
    }

    public void menuCancelarVuelo(){
    }



}
