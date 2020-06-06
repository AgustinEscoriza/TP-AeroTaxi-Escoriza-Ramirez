package Modelo;

import java.time.LocalDate;
import Enums.Ciudad;

public class Vuelo {

    private Avion avion;
    private int cantidadAcompañantes;
    private Ciudad origen;
    private Ciudad destino;
    private LocalDate fecha;
    private float costo;
    private boolean confirmacion;

    public Vuelo(Avion avion, int cantidadAcompañantes, Ciudad origen, Ciudad destino, LocalDate fecha, float costo, boolean confirmacion) {
        this.avion = avion;
        this.cantidadAcompañantes = cantidadAcompañantes;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.costo = costo;
        this.confirmacion = confirmacion;
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

    public float getCosto() {
        return costo;
    }

    public boolean isConfirmacion() {
        return confirmacion;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "avion=" + avion +
                ", cantidadAcompañantes=" + cantidadAcompañantes +
                ", origen=" + origen +
                ", destino=" + destino +
                ", fecha=" + fecha +
                ", costo=" + costo +
                ", confirmacion=" + confirmacion +
                '}';
    }
}
