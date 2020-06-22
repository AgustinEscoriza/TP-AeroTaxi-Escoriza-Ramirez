package Modelo;

import Enums.Propulsion;

public class Silver extends Avion implements Servicio{

    static float tarifaFijaSilver = 4000;

    public Silver(int idAvion, float capacidadCombustible, float costoPorKm, int capacidadMaxPasajeros, float velocidadMaxima, Propulsion propulsion) {
        super(idAvion, capacidadCombustible, costoPorKm, capacidadMaxPasajeros, velocidadMaxima, propulsion);
        super.tarifaFija = tarifaFijaSilver;
    }

    @Override
    public String toString() {
        return "Clase Silver: " + super.toString() + catering() +  "\n";
    }

    @Override
    public String catering() {
        return " Este avion tiene servicio de catering. ";
    }
}
