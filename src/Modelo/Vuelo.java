package Modelo;

import java.time.LocalDate;
import Enums.Ciudad;
import java.util.concurrent.atomic.AtomicInteger;

public class Vuelo {

    private static final AtomicInteger generadorId = new AtomicInteger(1000);

    private Integer idVuelo;
    private Avion avion;
    private int cantidadAcompañantes;
    private Ciudad origen;
    private Ciudad destino;
    private LocalDate fecha;
    private float costoTotal;
    private int distanciaKms;
    private boolean confirmacion;

    public Vuelo(Avion avion, Ciudad origen, Ciudad destino,int cantidadAcompañantes, LocalDate fecha, boolean confirmacion) {
        this.avion = avion;
        this.cantidadAcompañantes = cantidadAcompañantes;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.distanciaKms = calcularKms();
        this.costoTotal = calcularCosto();
        this.confirmacion = confirmacion;
        this.idVuelo = generadorId.getAndIncrement();
    }

    private int calcularKms(){
        int distancia = 0;
        if(origen == Ciudad.BUENOS_AIRES){
            if(destino == Ciudad.CORDOBA){
                distancia = 695;
            }
            if(destino == Ciudad.SANTIAGO_DE_CHILE){
                distancia = 1400;
            }
            if(destino == Ciudad.MONTEVIDEO){
                distancia = 950;
            }
        }
        else if(origen == Ciudad.CORDOBA){
            if(destino == Ciudad.BUENOS_AIRES){
                distancia = 695;
            }
            if(destino == Ciudad.MONTEVIDEO){
                distancia = 1190;
            }
            if(destino == Ciudad.SANTIAGO_DE_CHILE){
                distancia = 1050;
            }
        }
        else if(origen == Ciudad.MONTEVIDEO){
            if(destino == Ciudad.BUENOS_AIRES){
                distancia = 950;
            }
            if(destino == Ciudad.CORDOBA){
                distancia = 1190;
            }
            if(destino == Ciudad.SANTIAGO_DE_CHILE){
                distancia = 2100;
            }
        }
        else if(origen == Ciudad.SANTIAGO_DE_CHILE){
            if(destino == Ciudad.BUENOS_AIRES){
                distancia = 1400;
            }
            if(destino == Ciudad.CORDOBA){
                distancia = 1050;
            }
            if(destino == Ciudad.MONTEVIDEO){
                distancia = 2100;
            }
        }
        else{
            distancia = -1; // para pensar
        }
        return distancia;
    }

    private float calcularCosto(){
        float costoTotal = 0;
        costoTotal = ( distanciaKms * avion.getCostoPorKm() ) + ( (cantidadAcompañantes+1) * 3500 ) + avion.getTarifaFija();
        return costoTotal;
    }

    public Avion getAvion() {
        return avion;
    }

    public int getCantidadAcompañantes() {
        return cantidadAcompañantes;
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

    public int getDistanciaKms() {
        return distanciaKms;
    }

    public boolean isConfirmacion() {
        return confirmacion;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "idVuelo=" + idVuelo +
                ", avion=" + avion +
                ", cantidadAcompañantes=" + cantidadAcompañantes +
                ", origen=" + origen +
                ", destino=" + destino +
                ", fecha=" + fecha +
                ", costoTotal=" + costoTotal +
                ", distanciaKms=" + distanciaKms +
                ", confirmacion=" + confirmacion +
                '}';
    }
}

