package Modelo;

import java.time.LocalDate;
import Enums.Ciudad;
import java.util.concurrent.atomic.AtomicInteger;

public class Vuelo {

    private static final AtomicInteger generadorId = new AtomicInteger(1000);

    private Integer idVuelo;
    private Avion avion;
    private int cantidadAcompanantes;
    private Ciudad origen;
    private Ciudad destino;
    private LocalDate fecha;
    private float costoTotal;
    private int distanciaKms;

    public Vuelo(Avion avion, Ciudad origen, Ciudad destino,int cantidadAcompanantes, LocalDate fecha) {
        this.avion = avion;
        this.cantidadAcompanantes = cantidadAcompanantes;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.distanciaKms = calcularKms();
        this.costoTotal = calcularCosto();
        this.idVuelo = generadorId.getAndIncrement();
    }

    private int calcularKms(){
        int distancia = 0;
      // if(origen == Ciudad.BUENOS_AIRES){
      //     if(destino == Ciudad.CORDOBA){
      //         distancia = 695;
      //     }
      //     if(destino == Ciudad.SANTIAGO_DE_CHILE){
      //         distancia = 1400;
      //     }
      //     if(destino == Ciudad.MONTEVIDEO){
      //         distancia = 950;
      //     }
      // }
      // else if(origen == Ciudad.CORDOBA){
      //     if(destino == Ciudad.BUENOS_AIRES){
      //         distancia = 695;
      //     }
      //     if(destino == Ciudad.MONTEVIDEO){
      //         distancia = 1190;
      //     }
      //     if(destino == Ciudad.SANTIAGO_DE_CHILE){
      //         distancia = 1050;
      //     }
      // }
      // else if(origen == Ciudad.MONTEVIDEO){
      //     if(destino == Ciudad.BUENOS_AIRES){
      //         distancia = 950;
      //     }
      //     if(destino == Ciudad.CORDOBA){
      //         distancia = 1190;
      //     }
      //     if(destino == Ciudad.SANTIAGO_DE_CHILE){
      //         distancia = 2100;
      //     }
      // }
      // else if(origen == Ciudad.SANTIAGO_DE_CHILE){
      //     if(destino == Ciudad.BUENOS_AIRES){
      //         distancia = 1400;
      //     }
      //     if(destino == Ciudad.CORDOBA){
      //         distancia = 1050;
      //     }
      //     if(destino == Ciudad.MONTEVIDEO){
      //         distancia = 2100;
      //     }
      // }
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

    private float calcularCosto(){
        float costoTotal = 0;
        costoTotal = ( distanciaKms * avion.getCostoPorKm() ) + ( (cantidadAcompanantes+1) * 3500 ) + avion.getTarifaFija();
        return costoTotal;
    }

    public Avion getAvion() {
        return avion;
    }

    public int getCantidadAcompanantes() {
        return cantidadAcompanantes;
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


    @Override
    public String toString() {
        return "Vuelo{" +
                "idVuelo=" + idVuelo +
                ", avion=" + avion +
                ", cantidadAcompanantes=" + cantidadAcompanantes +
                ", origen=" + origen +
                ", destino=" + destino +
                ", fecha=" + fecha +
                ", costoTotal=" + costoTotal +
                ", distanciaKms=" + distanciaKms +
                '}';
    }
}

