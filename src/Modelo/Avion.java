package Modelo;

import Enums.Propulsion;
import java.time.LocalDate;
import java.util.ArrayList;
import com.google.gson.annotations.SerializedName;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Avion {

    private static final AtomicInteger generadorId = new AtomicInteger(1000);

    private Integer idAvion;
    private float capacidadCombustible;
    private float costoPorKm;
    private int capacidadMaxPasajeros;
    private float velocidadMaxima;
    private Propulsion propulsion;
    protected float tarifaFija;


    public Avion(float capacidadCombustible, float costoPorKm, int capacidadMaxPasajeros, float velocidadMaxima, Propulsion propulsion) {
        this.capacidadCombustible = capacidadCombustible;
        this.costoPorKm = costoPorKm;
        this.capacidadMaxPasajeros = capacidadMaxPasajeros;
        this.velocidadMaxima = velocidadMaxima;
        this.propulsion = propulsion;
        this.idAvion = generadorId.getAndIncrement();
    }

    @Override
    public String toString() {
        return "capacidadCombustible=" + capacidadCombustible +
                ", costoPorKm=" + costoPorKm +
                ", capacidadMaxPasajeros=" + capacidadMaxPasajeros +
                ", velocidadMaxima=" + velocidadMaxima +
                ", propulsion=" + propulsion +
                ", tarifaFija=" + tarifaFija ;
    }


    public Integer getIdAvion() {
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



}
