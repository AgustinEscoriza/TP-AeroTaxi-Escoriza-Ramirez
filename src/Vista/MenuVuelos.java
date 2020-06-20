package Vista;

import LogicaDeNegocio.Aerolinea;
import Modelo.Vuelo;
import Modelo.Usuario;
import Modelo.Avion;
import Enums.Ciudad;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MenuVuelos extends MenuLogin{

    public MenuVuelos() {
        super();
    }

    public Vuelo menuContratarVuelo(Usuario usuario, Aerolinea aerolinea) {

        Avion avion;
        Vuelo vuelo = null;
        String fechaString;
        Ciudad destino;
        Ciudad origen;
        float costoTotal;
        String confirmacion = null;
        int cantAcompanantes;

        while (!salir) {

            System.out.println("Ingrese fecha");
            fechaString = sn.next();
            LocalDate fechaLocalDate = LocalDate.parse(fechaString);

            System.out.println("Elija una de las siguientes ciudades de origen:");
            origen= menuSeleccionCiudad();
            System.out.println("Elija una de las siguientes ciudades de destino:");
            destino= menuSeleccionCiudad();

            System.out.println("Ingrese cantidad de acompanantes");
            cantAcompanantes = sn.nextInt();

            avion=menuSeleccionarAvion();

            vuelo = new Vuelo(avion, origen, destino, fechaLocalDate, usuario, cantAcompanantes);

            costoTotal=vuelo.calcularCosto(cantAcompanantes);
            System.out.println("El costo total del vuelo es" + costoTotal);

            while (confirmacion != "S" || confirmacion != "N") {
                System.out.println("Confirmar? S/N");
                confirmacion = sn.next();
                if (confirmacion == "S") {
                    usuario.setTotalDineroGastado(costoTotal);
                } else if (confirmacion == "N") {
                    vuelo=null;
                    salir=true;
                } else {
                    System.out.println("Ingrese S o N");
                }
            }
            salir=salirAMenuAnterior();
        }
        return vuelo;
    }

    public void menuBuscarVuelosPorFecha(Aerolinea aerolinea){

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

    public Avion menuSeleccionarAvion(){
        //int idVuelo;
        Avion avion = null;
        //aerolinea.mostrarVuelosDisponibles(fecha,origen,destino,cantidadAcompanantes+1);
        //System.out.println("Seleccione la id del vuelo que desea reservar:");
        //idVuelo = sn.nextInt();
        //vuelo=aerolinea.buscarVueloPorID(idVuelo);
        return avion;
    }

    public void menuCancelarVuelo(){
    }



}
