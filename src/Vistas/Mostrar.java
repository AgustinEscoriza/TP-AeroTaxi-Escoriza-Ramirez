package Vistas;

import LogicaDeNegocio.Aerolinea;
import Modelo.Vuelo;
import Modelo.Avion;
import Modelo.Usuario;
import java.time.LocalDate;

public class Mostrar {
    public Aerolinea aerolinea;

    public Mostrar(){
        this.aerolinea = new Aerolinea();
    }

    public Mostrar(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }

    public void mostrarVuelosPorFecha(LocalDate fecha){
        for(aerolinea.vuelos: Vuelo vuelo){
            if(vuelo.getFecha()==fecha){
                System.out.println(vuelo.toString());
            }
        }
    }

    public void mostrarVuelos(){
        for(aerolinea.vuelos : Vuelo vuelo){
            System.out.println(vuelo.toString());
        }
    }

    public void mostrarUsuarios(){
        for(aerolinea.usuarios : Usuario usuario){
            System.out.println(usuario.toString());
        }
    }
}
