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
    private ArrayList<LocalDate> fechasReservadas;
    @SerializedName("type")
    private String typeName;


    public Avion(float capacidadCombustible, float costoPorKm, int capacidadMaxPasajeros, float velocidadMaxima, Propulsion propulsion) {
        this.capacidadCombustible = capacidadCombustible;
        this.costoPorKm = costoPorKm;
        this.capacidadMaxPasajeros = capacidadMaxPasajeros;
        this.velocidadMaxima = velocidadMaxima;
        this.propulsion = propulsion;
        this.idAvion = generadorId.getAndIncrement();
        this.typeName = getClass().getName();
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

    public String getTypeName() {
        return typeName;
    }

    public void agregarFechaReservada(LocalDate fecha){
        fechasReservadas.add(fecha);
    }

    public void eliminarFechaReservada(LocalDate fecha){
        fechasReservadas.remove(fecha);
    }

    public boolean isDisponible(LocalDate fechaABuscar){
        Boolean disponible=true;
        for(LocalDate fecha: fechasReservadas){
            if(fecha.equals(fechaABuscar)){
                disponible=false;
                break;
            }
        }
        return disponible;
    }

}
