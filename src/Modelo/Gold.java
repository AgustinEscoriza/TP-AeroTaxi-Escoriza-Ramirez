package Dominio;

import Dominio.Avion;
import Enums.Propulsion;

public class Gold extends Avion {

    boolean wifi;

    public Gold(float capacidadCombustible, float costoPorKm, int capacidadMaxPasajeros, float velocidadMaxima, Propulsion propulsion, boolean wifi) {
        super(capacidadCombustible, costoPorKm, capacidadMaxPasajeros, velocidadMaxima, propulsion);
        this.wifi = wifi;
    }

}
