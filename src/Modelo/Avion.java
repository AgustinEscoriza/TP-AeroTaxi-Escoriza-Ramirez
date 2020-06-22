package Modelo;

import Enums.Propulsion;

public abstract class Avion {

    private int idAvion;
    private float capacidadCombustible;
    private float costoPorKm;
    private int capacidadMaxPasajeros;
    private float velocidadMaxima;
    private Propulsion propulsion;
    protected float tarifaFija;

    public Avion(int idAvion, float capacidadCombustible, float costoPorKm, int capacidadMaxPasajeros, float velocidadMaxima, Propulsion propulsion) {
        this.idAvion = idAvion;
        this.capacidadCombustible = capacidadCombustible;
        this.costoPorKm = costoPorKm;
        this.capacidadMaxPasajeros = capacidadMaxPasajeros;
        this.velocidadMaxima = velocidadMaxima;
        this.propulsion = propulsion;
    }

    public int getIdAvion() {
        return idAvion;
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

    public float getTarifaFija() {
        return tarifaFija;
    }

    @Override
    public String toString() {
        return "ID Avion: " + idAvion +
                ", Tarifa fija: " + tarifaFija +
                ", Costo por KM: " + costoPorKm +
                ", Capacidad maxima: " + capacidadMaxPasajeros +
                ", Propulsion: " + propulsion +
                ", Capacidad de combustible: " + capacidadCombustible +
                ", Velocidad maxima: " + velocidadMaxima;
    }



}
