package Vista;
import java.util.Scanner;
import LogicaDeNegocio.Aerolinea;

public class MenuPrincipal {
    protected Scanner sn;
    protected boolean salir;
    protected int opcion;

    public MenuPrincipal() {
        sn = new Scanner(System.in);
        salir = false;
        opcion = 0;
    }

    public void menuPrincipal(Aerolinea aerolinea) {
        while (!salir) {

            System.out.println("1. Opcion 1");
            System.out.println("2. Opcion 2");
            System.out.println("3. Opcion 3");
            System.out.println("4. Salir");

            System.out.println("Escribe una de las opciones");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1:
                    menuLogin();
                    break;
                case 2:
                    System.out.println("Has seleccionado la opcion 2");
                    break;
                case 3:
                    System.out.println("Has seleccionado la opcion 3");
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 4");
            }
        }
    }

    public boolean salirAMenuAnterior() {
        System.out.println("Desea salir al menu anterior? S/N");
        String eleccion = sn.next();
        if (eleccion == "S") {
            salir = true;
        } else if (eleccion == "N") {
            salir = false;
        } else {
            System.out.println("Debe ingresar S o N");
        }
        return salir;
    }
}