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

}
