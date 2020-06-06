package Vistas;
import java.util.Scanner;

public class MenuPrincipal {
    private Scanner sn;
    private boolean salir;
    private int opcion;

    public MenuPrincipal(){
        this.sn = new Scanner(System.in);
        this.salir = false;
        this.opcion = 0;
    }

    public void menu(){
        while(!salir){

            System.out.println("1. Opcion 1");
            System.out.println("2. Opcion 2");
            System.out.println("3. Opcion 3");
            System.out.println("4. Salir");

            System.out.println("Escribe una de las opciones");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Has seleccionado la opcion 1");
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
}