package Modelo;

import java.time.LocalDate;
import Enums.Ciudad;
import java.util.concurrent.atomic.AtomicInteger;


public class Vuelo {

    private static final AtomicInteger generadorId = new AtomicInteger(1000);
    private Integer idVuelo;
    private Avion avion;
    private Ciudad origen;
    private Ciudad destino;
    private LocalDate fecha;
    private Usuario usuario;
    private int cantPasajeros;
    private int distanciaKms;

    public Vuelo(Avion avion, Ciudad origen, Ciudad destino, LocalDate fecha, Usuario usuario, int cantAcompanantes) {
        this.avion = avion;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.distanciaKms = calcularKms();
        this.usuario = usuario;
        setCantPasajeros(cantAcompanantes);
        this.idVuelo = generadorId.get();
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

    public Integer getIdVuelo() {
        return idVuelo;
    }

    public int getDistanciaKms() {
        return distanciaKms;
    }

    public int getCantPasajeros(){
        return cantPasajeros;
    }

    public void setCantPasajeros(int cantAcompanantes){
        cantPasajeros=cantAcompanantes+1;
    }

    public void setIdVuelo(Integer idVuelo) {
        this.idVuelo = idVuelo;
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
        costoTotal = ( distanciaKms * avion.getCostoPorKm() ) + ((cantidadAcompanantes+1) * 3500 ) + avion.getTarifaFija();
        return costoTotal;
    }

    @Override
    public String toString() {
        return  "\n" + "ID de vuelo: " + idVuelo +
                ", ID de Avion: " + avion.getIdAvion() +
                ", DNI Usuario: " + usuario.getDni() +
                ", Origen: " + origen +
                ", Destino: " + destino +
                ", Fecha: " + fecha +
                ", Distancia KMS: " + distanciaKms + "\n";
    }

}

