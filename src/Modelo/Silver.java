package Modelo;

import Enums.Propulsion;

public class Silver extends Avion implements Servicio{

    static float tarifaFijaSilver = 4000;

    public Silver(float capacidadCombustible, float costoPorKm, int capacidadMaxPasajeros, float velocidadMaxima, Propulsion propulsion) {
        super(capacidadCombustible, costoPorKm, capacidadMaxPasajeros, velocidadMaxima, propulsion);
        super.tarifaFija = tarifaFijaSilver;
    }

    @Override
    public String toString() {
        return "Silver{ " + super.toString() + "}";
    }

    @Override
    public String catering() {
        return "Este avion tiene servicio de catering";
    }
}
