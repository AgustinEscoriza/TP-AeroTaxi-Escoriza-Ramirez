package LogicaDeNegocio;

import Modelo.Avion;
import Modelo.Vuelo;
import java.util.ArrayList;

public class Aerolinea {
    public ArrayList<Avion> aviones;
    public ArrayList<Vuelo> vuelos;

    public Aerolinea(){
        this.aviones = new ArrayList<Avion>();
        this.vuelos = new ArrayList<Vuelo>();
    }

    public void agregarAvion(Avion avion){
        aviones.add(avion);
    }

    public void agregarVuelo(Vuelo vuelo){
        vuelos.add(vuelo);
    }




}
