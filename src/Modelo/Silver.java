package Modelo;

import Enums.Propulsion;

public class Silver extends Avion {

    private boolean catering;

    public Silver(float capacidadCombustible, float costoPorKm, int capacidadMaxPasajeros, float velocidadMaxima, Propulsion propulsion, boolean catering) {
        super(capacidadCombustible, costoPorKm, capacidadMaxPasajeros, velocidadMaxima, propulsion);
        this.catering = catering;
    }

    public boolean isCatering() {
        return catering;
    }

}
