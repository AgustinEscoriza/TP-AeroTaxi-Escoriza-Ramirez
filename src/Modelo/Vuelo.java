package Modelo;

import java.time.LocalDate;
import Enums.Ciudad;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;

public class Vuelo {

    private static final AtomicInteger generadorId = new AtomicInteger(1000);
    private Integer idVuelo;
    private Avion avion;
    private Ciudad origen;
    private Ciudad destino;
    private LocalDate fecha;
    private int pasajerosActuales;
    private float costoTotal;
    private int distanciaKms;
    public ArrayList<Reserva> reservas;

    public Vuelo(Avion avion, Ciudad origen, Ciudad destino, LocalDate fecha) {
        this.avion = avion;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.distanciaKms = calcularKms();
        this.costoTotal = calcularCosto();
        this.idVuelo = generadorId.getAndIncrement();
    }

    public Avion getAvion() {
        return avion;
    }

    public Ciudad getOrigen() {
        return origen;
    }

    public Ciudad getDestino() {
        return destino;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public float getCostoTotal() {
        return costoTotal;
    }

    public Integer getIdVuelo() {
        return idVuelo;
    }

    public int getPasajerosActuales(){
        return pasajerosActuales;
    }

    public int getDistanciaKms() {
        return distanciaKms;
    }


    @Override
    public String toString() {
        return "Vuelo{" +
                "idVuelo=" + idVuelo +
                ", avion=" + avion +
                ", origen=" + origen +
                ", destino=" + destino +
                ", fecha=" + fecha +
                ", costoTotal=" + costoTotal +
                ", distanciaKms=" + distanciaKms +
                '}';
    }

    public int calcularKms(){
        int distancia = 0;
        if(origen == Ciudad.BUENOS_AIRES || destino == Ciudad.BUENOS_AIRES){

            if(origen == Ciudad.CORDOBA || destino == Ciudad.CORDOBA){
                distancia = 695;
            }
            if(origen == Ciudad.MONTEVIDEO || destino == Ciudad.MONTEVIDEO){
                distancia = 950;
            }
            if(origen == Ciudad.SANTIAGO_DE_CHILE || destino == Ciudad.SANTIAGO_DE_CHILE){
                distancia = 1400;
            }
        }
        else if(origen == Ciudad.CORDOBA || destino == Ciudad.CORDOBA){
            if(origen == Ciudad.MONTEVIDEO || destino == Ciudad.MONTEVIDEO){
                distancia = 1190;
            }
            if(origen == Ciudad.SANTIAGO_DE_CHILE || destino == Ciudad.SANTIAGO_DE_CHILE){
                distancia = 1050;
            }
        }
        else if(origen == Ciudad.MONTEVIDEO || destino == Ciudad.MONTEVIDEO){

            if(origen == Ciudad.SANTIAGO_DE_CHILE || destino == Ciudad.SANTIAGO_DE_CHILE){
                distancia = 2100;
            }
        }
        return distancia;
    }

    public float calcularCosto(int cantidadAcompanantes){
        float costoTotal = 0;
        costoTotal = ( distanciaKms * avion.getCostoPorKm() ) + ( (cantidadAcompanantes+1) * 3500 ) + avion.getTarifaFija();
        return costoTotal;
    }

    public void agregarReserva(Reserva reserva){
        reservas.add(reserva);
        pasajerosActuales=+reserva.getNroAcompanantes()+1;
    }

    public Boolean isDisponible(int pasajerosAReservar){
        if(getPasajerosActuales()+pasajerosAReservar<avion.getCapacidadMaxPasajeros()&&avion.isDisponible()){
            return true;
        }
        else{
            return false;
        }
    }

}

