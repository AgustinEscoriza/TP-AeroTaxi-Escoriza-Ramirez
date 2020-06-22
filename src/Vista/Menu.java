package Vista;

import java.util.Scanner;

public abstract class Menu {

    protected Scanner sn;
    protected boolean salir;
    protected int opcion;
    protected LimpiarPantalla limpiarPantalla;

    public Menu() {
        limpiarPantalla = new LimpiarPantalla();
        sn = new Scanner(System.in);
        salir = false;
        opcion = 0;
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
