package Vista;

import LogicaDeNegocio.Aerolinea;
import Modelo.Vuelo;
import Modelo.Usuario;
import Modelo.Avion;
import Enums.Ciudad;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class MenuVuelos extends Menu {

    public MenuVuelos() {
        super();
    }

    public void menuContratarVuelo(Usuario usuario, Aerolinea aerolinea) {

        Avion avion;
        Vuelo vuelo = null;
        String fechaString;
        Ciudad destino;
        Ciudad origen;
        float costoTotal;
        boolean repetir=false;
        String confirmacion = null;
        int cantAcompanantes;
        LocalDate fechaLocalDate = null;
        do {
            do {
                System.out.println("Ingrese fecha");
                fechaString = sn.next();
                DateFormat formatoDeFecha = new SimpleDateFormat(fechaString);
                formatoDeFecha.setLenient(false);

                if (validateJavaDate(fechaString)) { //Validar que sea del futuro

                    fechaLocalDate = LocalDate.parse(fechaString);
                    LocalDateTime ahora = LocalDateTime.now();

                    if (fechaLocalDate.isAfter(ChronoLocalDate.from(ahora))) {
                        System.out.println(" esa fecha es valida");
                        salir = true;
                    } else {
                        System.out.println(" esa fecha no es futura");
                    }
                } else {
                    System.out.println(" esa fecha es invalida. Formato:YYYY-MM-DD");
                    salir = false;
                }

            } while (!salir);
            salir = false;
            System.out.println("Elija una de las siguientes ciudades de origen:");
            origen = menuSeleccionCiudadOrigen();
            System.out.println("Elija una de las siguientes ciudades de destino:");
            destino = menuSeleccionCiudadDestino(origen);

            System.out.println("Ingrese cantidad de acompanantes");
            cantAcompanantes = sn.nextInt();

            avion = menuSeleccionarAvion(aerolinea, fechaLocalDate, cantAcompanantes + 1);
            if (avion != null) {
                salir = true;
                vuelo = new Vuelo(avion, origen, destino, fechaLocalDate, usuario, cantAcompanantes);
                costoTotal = vuelo.calcularCosto(cantAcompanantes);
                System.out.println("El costo total del vuelo es" + costoTotal);
                boolean flag=false;
                while (!flag) {
                    System.out.println("Confirmar? S/N");
                    confirmacion = sn.next();
                    if (confirmacion.equals("S")) {
                        flag=true;
                        aerolinea.agregarVuelo(vuelo);
                        usuario.setTotalDineroGastado(costoTotal);
                        System.out.println("Vuelo contratado. El id de su vuelo es" + vuelo.getIdVuelo());
                    } else if (confirmacion.equals("N")) {
                        flag=true;
                        System.out.println("Vuelo no ha sido contratado");
                    } else {
                        System.out.println("Ingrese S o N");
                    }
                }
            }
        } while (!salir);
    }

    public void menuBuscarVuelosPorFecha(Aerolinea aerolinea) {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("DD/MM/YYYY");
        String fechaString;
        LocalDate fechaDate;
        System.out.println("Ingrese una fecha");
        fechaString = sn.nextLine();
        fechaDate = LocalDate.parse(fechaString, formato);
        System.out.println(aerolinea.mostrarVuelosPorFecha(fechaDate));
    }


    public Ciudad menuSeleccionCiudadOrigen() {
        Ciudad ciudad = null;
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

        return ciudad;
    }

    public Ciudad menuSeleccionCiudadDestino(Ciudad origen) {
        Ciudad ciudad = null;
        if (origen.equals(Ciudad.BUENOS_AIRES)) {
            System.out.println("1. CORDOBA");
            System.out.println("2. SANTIAGO DE CHILE");
            System.out.println("3. MONTEVIDEO");
            System.out.println("Elija una opcion");
            opcion = sn.nextInt();
            switch (opcion) {
                case 1:
                    ciudad = Ciudad.CORDOBA;
                    break;
                case 2:
                    ciudad = Ciudad.SANTIAGO_DE_CHILE;
                    break;
                case 3:
                    ciudad = Ciudad.MONTEVIDEO;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 3");
            }
        }
        if (origen.equals(Ciudad.CORDOBA)) {
            System.out.println("1. BUENOS AIRES");
            System.out.println("2. SANTIAGO DE CHILE");
            System.out.println("3. MONTEVIDEO");
            System.out.println("Elija una opcion");
            opcion = sn.nextInt();
            switch (opcion) {
                case 1:
                    ciudad = Ciudad.BUENOS_AIRES;
                    break;
                case 2:
                    ciudad = Ciudad.SANTIAGO_DE_CHILE;
                    break;
                case 3:
                    ciudad = Ciudad.MONTEVIDEO;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 3");
            }
        }
        if (origen.equals(Ciudad.SANTIAGO_DE_CHILE)) {
            System.out.println("1. BUENOS AIRES");
            System.out.println("2. CORDOBA");
            System.out.println("3. MONTEVIDEO");
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
                    ciudad = Ciudad.MONTEVIDEO;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 3");
            }
        }
        if (origen.equals(Ciudad.MONTEVIDEO)) {
            System.out.println("1. BUENOS AIRES");
            System.out.println("2. CORDOBA");
            System.out.println("3. SANTIAGO DE CHILE");
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
                default:
                    System.out.println("Solo números entre 1 y 3");
            }
        }

        return ciudad;
    }

    public Avion menuSeleccionarAvion(Aerolinea aerolinea, LocalDate fecha, int cantPasajeros) {
        int idAvion;
        Avion avion = null;
        boolean salir = false;
        ArrayList<Avion> aviones = aerolinea.buscarAvionesDisponibles(fecha, cantPasajeros);
        if (aviones != null) {
            for (Avion aux : aviones) {
                System.out.println(aux.toString());
            }
            do {
                System.out.println("Seleccione la id del avion que desea contratar:");
                idAvion = sn.nextInt();
                for (Avion aux : aviones) {
                    if (aux.getIdAvion() == idAvion) {
                        salir = true;
                    }
                }
                if (!salir) {
                    System.out.println("Ingrese uno de los id mostrados previamente");
                }
            } while (!salir);

            avion = aerolinea.buscarAvionPorID(idAvion);
        } else {
            System.out.println("No se encontraron aviones disponibles en esa fecha o con esa cantidad de pasajeros");
        }
        return avion;
    }

    public void menuCancelarVuelo(Aerolinea aerolinea) {
        int idVuelo;
        Vuelo vuelo;
        String confirmacion = null;
        System.out.println("Ingrese id del vuelo a cancelar");
        idVuelo = sn.nextInt();
        vuelo = aerolinea.buscarVueloPorID(idVuelo);
        System.out.println(vuelo.toString());

        while (confirmacion != "S" || confirmacion != "N") {
            System.out.println("Confirmar cancelacion? S/N");
            confirmacion = sn.next();
            if (confirmacion == "S") {
                aerolinea.eliminarVuelo(vuelo);
                System.out.println("Vuelo cancelado con exito");
            } else if (confirmacion == "N") {
                break;
            } else {
                System.out.println("Ingrese S o N");
            }
        }
    }

    public static boolean validateJavaDate(String strDate) {
        /* Check if date is 'null' */
        if (strDate.trim().equals("")) {
            return true;
        }
        /* Date is not 'null' */
        else {
            /*
             * Set preferred date format,
             * For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.*/
            SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
            sdfrmt.setLenient(false);
            /* Create Date object
             * parse the string into date
             */
            try {
                Date javaDate = sdfrmt.parse(strDate);
            }
            /* Date format is invalid */ catch (ParseException e) {
                return false;
            }
            /* Return true if date format is valid */
            return true;
        }
    }


}
