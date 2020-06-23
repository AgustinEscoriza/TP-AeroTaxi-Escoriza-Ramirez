package Vista;

import java.util.Scanner;

public abstract class Menu {

    protected Scanner sn;
    protected boolean salir;
    protected int opcion;

    public Menu() {
        sn = new Scanner(System.in);
        salir = false;
        opcion = 0;
    }

    public static void limpiarPantalla() {
        for (int i = 0; i < 25; i++) {
            System.out.println();
        }
    }

    public static void presioneTeclaParaContinuar(){
        Scanner snAux = new Scanner(System.in);
        System.out.println("Ingrese cualquier caracter para continuar. ");
        snAux.next();
    }
}
