package Modelo;

import Enums.Propulsion;

public abstract class Avion {

    private float capacidadCombustible;
    private float costoPorKm;
    private int capacidadMaxPasajeros;
    private float velocidadMaxima;
    private Propulsion propulsion;
    private boolean disponible;
    private int pasajerosActuales;
    protected float tarifaFija;


    public Avion(float capacidadCombustible, float costoPorKm, int capacidadMaxPasajeros, float velocidadMaxima, Propulsion propulsion) {
        this.capacidadCombustible = capacidadCombustible;
        this.costoPorKm = costoPorKm;
        this.capacidadMaxPasajeros = capacidadMaxPasajeros;
        this.velocidadMaxima = velocidadMaxima;
        this.propulsion = propulsion;
        this.disponible = true;
        this.pasajerosActuales = 0;
    }

    @Override
    public String toString() {
        return "capacidadCombustible=" + capacidadCombustible +
                ", costoPorKm=" + costoPorKm +
                ", capacidadMaxPasajeros=" + capacidadMaxPasajeros +
                ", velocidadMaxima=" + velocidadMaxima +
                ", propulsion=" + propulsion +
                ", disponible=" + disponible +
                ", pasajerosActuales=" + pasajerosActuales +
                ", tarifaFija=" + tarifaFija ;
    }

    public float getCapacidadCombustible() {
        return capacidadCombustible;
    }

    public float getCostoPorKm() {
        return costoPorKm;
    }

    public int getCapacidadMaxPasajeros() {
        return capacidadMaxPasajeros;
    }

    public float getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public Propulsion getPropulsion() {
        return propulsion;
    }
}
