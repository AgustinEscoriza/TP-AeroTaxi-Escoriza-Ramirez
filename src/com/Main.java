package com;

import LogicaDeNegocio.Aerolinea;
import Vista.MenuPrincipal;

public class Main {

    public static void main(String[] args) {
        Aerolinea aerolinea = new Aerolinea();

        MenuPrincipal menuPrincipal = new MenuPrincipal(aerolinea);
        menuPrincipal.menuPrincipal();
    }
}
