package com;

import LogicaDeNegocio.Aerolinea;
import Vista.MenuLogin;
import Vista.MenuPrincipal;

public class Main {

    public static void main(String[] args) {
        Aerolinea aerolinea = new Aerolinea();

        MenuLogin menuLogin = new MenuLogin(aerolinea);
        MenuPrincipal menuPrincipal = new MenuPrincipal(aerolinea);

        menuPrincipal.menuPrincipal(aerolinea, menuLogin.menuLogin(aerolinea));
    }
}
