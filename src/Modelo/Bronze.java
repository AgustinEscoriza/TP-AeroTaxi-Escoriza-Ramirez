package Modelo;

import Enums.Propulsion;

public class Bronze extends Avion {


    public Bronze(float capacidadCombustible, float costoPorKm, int capacidadMaxPasajeros, float velocidadMaxima, Propulsion propulsion) {
        super(capacidadCombustible, costoPorKm, capacidadMaxPasajeros, velocidadMaxima, propulsion);
        super.tarifaFija = 3000;
    }

    @Override
    public String toString() {
        return "Bronze{ " + super.toString() + "}";
    }
}
