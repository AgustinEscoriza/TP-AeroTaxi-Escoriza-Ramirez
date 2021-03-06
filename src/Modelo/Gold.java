package Modelo;

import Enums.Propulsion;

public class Gold extends Avion implements Servicio{

    private boolean wifi;
    static float tarifaFijaGold = 6000;

    public Gold(int idAvion, float capacidadCombustible, float costoPorKm, int capacidadMaxPasajeros, float velocidadMaxima, Propulsion propulsion, boolean wifi) {
        super(idAvion, capacidadCombustible, costoPorKm, capacidadMaxPasajeros, velocidadMaxima, propulsion);
        super.tarifaFija = tarifaFijaGold;
        this.wifi = wifi;
    }

    public boolean tieneWifi() {
        return wifi;
    }

    @Override
    public String toString() {
        return "Clase Gold: " +
                super.toString() + catering() +
                "Wifi: " + wifi + "\n";
    }

    @Override
    public String catering() {
        return "Este avion tiene servicio de catering. ";
    }
}
