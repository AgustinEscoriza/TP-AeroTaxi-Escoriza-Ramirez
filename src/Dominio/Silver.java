package Dominio;

import Dominio.Avion;
import Enums.Propulsion;

public class Silver extends Avion {

    boolean catering;

    public Silver(float capacidadCombustible, float costoPorKm, int capacidadMaxPasajeros, float velocidadMaxima, Propulsion propulsion, boolean catering) {
        super(capacidadCombustible, costoPorKm, capacidadMaxPasajeros, velocidadMaxima, propulsion);
        this.catering = catering;
    }
}
