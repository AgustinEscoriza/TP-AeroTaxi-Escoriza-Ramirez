package Modelo;

import Enums.Propulsion;

public class Bronze extends Avion {

    static float tarifaFijaBronze = 3000;

    public Bronze(int idAvion, float capacidadCombustible, float costoPorKm, int capacidadMaxPasajeros, float velocidadMaxima, Propulsion propulsion) {
        super(idAvion, capacidadCombustible, costoPorKm, capacidadMaxPasajeros, velocidadMaxima, propulsion);
        super.tarifaFija = tarifaFijaBronze;
    }

    @Override
    public String toString() {
        return "Clase Bronze: " + super.toString() + "\n";
    }
}
