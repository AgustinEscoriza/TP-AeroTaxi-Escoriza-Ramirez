package Modelo;

import Enums.Propulsion;

public class Gold extends Avion {

    private boolean wifi;
    private boolean catering;

    public Gold(float capacidadCombustible, float costoPorKm, int capacidadMaxPasajeros, float velocidadMaxima, Propulsion propulsion, boolean wifi, boolean catering) {
        super(capacidadCombustible, costoPorKm, capacidadMaxPasajeros, velocidadMaxima, propulsion);
        this.wifi = wifi;
        this.catering = catering;
    }

    public boolean isWifi() {
        return wifi;
    }
}
