package Vista;

import LogicaDeNegocio.Aerolinea;
import Modelo.Vuelo;
import Modelo.Usuario;
import Modelo.Avion;
import Enums.Ciudad;
import Persistencia.JsonUsuario;
import Persistencia.JsonVuelo;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Date;

public class MenuVuelos extends Menu {

    public MenuVuelos() {
        super();
    }

    public void menuContratarVuelo(Usuario usuario, Aerolinea aerolinea) {

        Avion avion;
        Vuelo vuelo;
        String fechaString;
        Ciudad destino;
        Ciudad origen;
        float costoTotal;
        String confirmacion;
        int cantAcompanantes;
        LocalDate fechaLocalDate = null;
        do {
            do {
                System.out.println("Ingrese fecha: ");
                fechaString = sn.nextLine();
                if (validarJavaLocalDate(fechaString)) {

                    fechaLocalDate = LocalDate.parse(fechaString);
                    LocalDateTime ahora = LocalDateTime.now();

                    if (!fechaLocalDate.isBefore(ChronoLocalDate.from(ahora))) {
                        System.out.println("Fecha valida. ");
                        salir = true;
                    } else {
                        System.out.println("Esa fecha no es futura. ");
                    }
                } else {
                    System.out.println("Fecha invalida. Formato:YYYY-MM-DD");
                    salir = false;
                }

            } while (!salir);
            salir = false;
            System.out.println("Elija una de las siguientes ciudades de origen: ");
            origen = menuSeleccionCiudadOrigen();
            System.out.println("Elija una de las siguientes ciudades de destino: ");
            destino = menuSeleccionCiudadDestino(origen);

            System.out.println("Ingrese cantidad de acompanantes: ");
            cantAcompanantes = sn.nextInt();
            sn.nextLine();
            limpiarPantalla();

            avion = menuSeleccionarAvion(aerolinea, fechaLocalDate, cantAcompanantes + 1);

            if (avion != null) {
                salir = true;
                vuelo = new Vuelo(avion, origen, destino, fechaLocalDate, usuario, cantAcompanantes);
                costoTotal = vuelo.calcularCosto();
                System.out.println("El costo total del vuelo es " + costoTotal);
                boolean flag = false;

                while (!flag) {
                    sn.nextLine();
                    System.out.println("Confirmar? S/N. ");
                    confirmacion = sn.nextLine();
                    if (confirmacion.equals("S")) {
                        flag = true;
                        aerolinea.agregarVuelo(vuelo);
                        usuario.sumarDineroGastado(costoTotal);
                        actualizarJsonVuelos(aerolinea.getVuelos());
                        actualizarJsonUsuarios(aerolinea.getUsuarios());
                        System.out.println("Vuelo contratado. El id de su vuelo es " + vuelo.getIdVuelo());
                        presioneTeclaParaContinuar();

                    } else if (confirmacion.equals("N")) {
                        flag = true;
                        System.out.println("Vuelo no ha sido contratado. ");
                        presioneTeclaParaContinuar();
                    } else {
                        System.out.println("Ingrese S o N. ");
                    }
                }
            }
        } while (!salir);
    }

    public Ciudad menuSeleccionCiudadOrigen() {
        Ciudad ciudad = null;
        boolean salir = false;
        do {
            System.out.println("1. BUENOS AIRES");
            System.out.println("2. CORDOBA");
            System.out.println("3. SANTIAGO DE CHILE");
            System.out.println("4. MONTEVIDEO");
            System.out.println("Elija una opcion: ");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1:
                    ciudad = Ciudad.BUENOS_AIRES;
                    salir = true;
                    break;
                case 2:
                    ciudad = Ciudad.CORDOBA;
                    salir = true;
                    break;
                case 3:
                    ciudad = Ciudad.SANTIAGO_DE_CHILE;
                    salir = true;
                    break;
                case 4:
                    ciudad = Ciudad.MONTEVIDEO;
                    salir = true;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 4");
            }
        } while (!salir);
        return ciudad;
    }

    public Ciudad menuSeleccionCiudadDestino(Ciudad origen) {
        Ciudad ciudad = null;
        boolean salir = false;
        do {
            if (origen.equals(Ciudad.BUENOS_AIRES)) {
                System.out.println("1. CORDOBA");
                System.out.println("2. SANTIAGO DE CHILE");
                System.out.println("3. MONTEVIDEO");
                System.out.println("Elija una opcion: ");
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1:
                        ciudad = Ciudad.CORDOBA;
                        salir = true;
                        break;
                    case 2:
                        ciudad = Ciudad.SANTIAGO_DE_CHILE;
                        salir = true;
                        break;
                    case 3:
                        ciudad = Ciudad.MONTEVIDEO;
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            }
            if (origen.equals(Ciudad.CORDOBA)) {
                System.out.println("1. BUENOS AIRES");
                System.out.println("2. SANTIAGO DE CHILE");
                System.out.println("3. MONTEVIDEO");
                System.out.println("Elija una opcion: ");
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1:
                        ciudad = Ciudad.BUENOS_AIRES;
                        salir = true;
                        break;
                    case 2:
                        ciudad = Ciudad.SANTIAGO_DE_CHILE;
                        salir = true;
                        break;
                    case 3:
                        ciudad = Ciudad.MONTEVIDEO;
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            }
            if (origen.equals(Ciudad.SANTIAGO_DE_CHILE)) {
                System.out.println("1. BUENOS AIRES");
                System.out.println("2. CORDOBA");
                System.out.println("3. MONTEVIDEO");
                System.out.println("Elija una opcion: ");
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1:
                        ciudad = Ciudad.BUENOS_AIRES;
                        salir = true;
                        break;
                    case 2:
                        ciudad = Ciudad.CORDOBA;
                        salir = true;
                        break;
                    case 3:
                        ciudad = Ciudad.MONTEVIDEO;
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            }
            if (origen.equals(Ciudad.MONTEVIDEO)) {
                System.out.println("1. BUENOS AIRES");
                System.out.println("2. CORDOBA");
                System.out.println("3. SANTIAGO DE CHILE");
                System.out.println("Elija una opcion: ");
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1:
                        ciudad = Ciudad.BUENOS_AIRES;
                        salir = true;
                        break;
                    case 2:
                        ciudad = Ciudad.CORDOBA;
                        salir = true;
                        break;
                    case 3:
                        ciudad = Ciudad.SANTIAGO_DE_CHILE;
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            }
        } while (!salir);
        return ciudad;
    }

    public Avion menuSeleccionarAvion(Aerolinea aerolinea, LocalDate fecha, int cantPasajeros) {
        int idAvion = 0;
        Avion avion = null;
        boolean salir = false;
        ArrayList<Avion> aviones = aerolinea.buscarAvionesDisponibles(fecha, cantPasajeros);
        if (!aviones.isEmpty()) {
            for (Avion aux : aviones) {
                System.out.println(aux.toString());
            }
            do {
                System.out.println("Seleccione la id del avion que desea contratar: ");

                while (!sn.hasNextInt()) {
                    System.out.println("Ingrese uno de los id mostrados previamente: ");
                    sn.next();
                }
                idAvion = sn.nextInt();

                for (Avion aux : aviones) {
                    if (aux.getIdAvion() == idAvion) {
                        salir = true;
                    }
                }
                if (!salir) {
                    System.out.println("Ingrese uno de los id mostrados previamente: ");
                }
            } while (!salir);

            avion = aerolinea.buscarAvionPorID(idAvion);
        } else {
            System.out.println("No se encontraron aviones disponibles en esa fecha o con esa cantidad de pasajeros. ");
        }
        return avion;
    }

    public void menuCancelarVuelo(Aerolinea aerolinea) {
        int idVuelo;
        String confirmacion;
        LocalDateTime ahora = LocalDateTime.now();
        if(aerolinea.getVuelos()!=null) {
            System.out.println(aerolinea.mostrarVuelos());
            System.out.println("Ingrese id del vuelo a cancelar: ");
            while (!sn.hasNextInt()) {
                System.out.println("Ingrese un numero valido: ");
                sn.next();
            }
            idVuelo = sn.nextInt();


            Vuelo vuelo = aerolinea.buscarVueloPorID(idVuelo);

            if (vuelo != null) {
                if (vuelo.getFecha().isEqual(ChronoLocalDate.from(ahora))) {
                    System.out.println("No se puede cancelar un vuelo con menos de 24hs de anticipacion. ");
                    presioneTeclaParaContinuar();
                } else {
                    System.out.println("El vuelo a cancelar es el siguiente: ");
                    System.out.println(vuelo.toString());
                    boolean flag = false;
                    while (!flag) {
                        System.out.println("Confirmar cancelacion? S/N. ");
                        confirmacion = sn.next();
                        if (confirmacion.equals("S")) {
                            flag = true;
                            if (vuelo.getFecha().isAfter(ChronoLocalDate.from(ahora))) {
                                aerolinea.buscarUsuarioPorDNI(vuelo.getUsuario().getDni()).restarDineroGastado(vuelo.calcularCosto());
                            }
                            aerolinea.eliminarVuelo(vuelo);
                            actualizarJsonVuelos(aerolinea.getVuelos());
                            actualizarJsonUsuarios(aerolinea.getUsuarios());
                            System.out.println("Vuelo cancelado con exito. ");
                            presioneTeclaParaContinuar();
                        } else if (confirmacion.equals("N")) {
                            flag = true;
                            System.out.println("El vuelo no ha sido cancelado. ");
                            presioneTeclaParaContinuar();
                        } else {
                            System.out.println("Ingrese S o N. ");
                        }
                    }
                }
            } else {
                System.out.println("No hay un vuelo con esa Id registrado.");
                presioneTeclaParaContinuar();
            }
        }else{
            System.out.println("No hay un vuelos cargados en el sistema.");
            presioneTeclaParaContinuar();
        }
    }


    public void menuBuscarVuelosPorFecha(Aerolinea aerolinea) {
        String fechaString;
        LocalDate fechaDate = null;
        salir = false;
        do { //validacion de fecha
            System.out.println("Ingrese una fecha: ");
            fechaString = sn.next();
                if (validarJavaLocalDate(fechaString)) { //Validar que sea en el futuro

                    fechaDate = LocalDate.parse(fechaString);
                    salir = true;

                } else {
                    System.out.println("Esa fecha es invalida. Formato: YYYY-MM-DD. ");
                }
        } while (!salir);

        if (aerolinea.mostrarVuelosPorFecha(fechaDate) != "") { //si devuelte string cargado
            System.out.println(aerolinea.mostrarVuelosPorFecha(fechaDate)); // imprimo
            presioneTeclaParaContinuar();
        } else {
            if (aerolinea.getVuelos() == null) {
                System.out.println("No hay vuelos cargados aun. ");
                presioneTeclaParaContinuar();
            } else {
                System.out.println("No hay vuelos cargados en esa fecha. ");
                presioneTeclaParaContinuar();
            }

        }

    }

    private void actualizarJsonVuelos(ArrayList<Vuelo> vuelos) {
        JsonVuelo jsonVuelo = new JsonVuelo();
        if (vuelos != null) {
            try {
                jsonVuelo.cargarJsonVuelo(vuelos);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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

    public boolean validarJavaLocalDate(String strDate) {
        /* Check if date is 'null' */
        boolean flag = false;
        if (strDate.trim().equals("")) {
            flag = false;
        }
        /* Date is not 'null' */
        else {

            if (strDate.matches("[0-9\\.-]*")) {
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
                    flag = true;
                }
                /* Date format is invalid */ catch (ParseException e) {
                    flag = false;
                }
            }

        }
        return flag;
        /* Return true if date format is valid */
    }

}
