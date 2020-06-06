package Dominio;

import Dominio.Avion;
import Enums.Propulsion;

public class Bronze extends Avion {

    boolean catering;

    public Bronze(float capacidadCombustible, float costoPorKm, int capacidadMaxPasajeros, float velocidadMaxima, Propulsion propulsion, boolean catering) {
        super(capacidadCombustible, costoPorKm, capacidadMaxPasajeros, velocidadMaxima, propulsion);
        this.catering = catering;
    }
}
