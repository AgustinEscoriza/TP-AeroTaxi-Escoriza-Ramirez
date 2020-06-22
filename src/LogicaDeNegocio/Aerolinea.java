package LogicaDeNegocio;

import Modelo.Avion;
import Modelo.Vuelo;
import Modelo.Usuario;
import Enums.Ciudad;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Aerolinea {
    public ArrayList<Avion> aviones;
    public ArrayList<Vuelo> vuelos;
    public ArrayList<Usuario> usuarios;

    public Aerolinea(ArrayList<Avion> aviones, ArrayList<Vuelo> vuelos, ArrayList<Usuario> usuarios) {
        this.aviones = aviones;
        this.vuelos = vuelos;
        this.usuarios = usuarios;
    }

    public void agregarVuelo(Vuelo vuelo) {
        if(vuelos == null){ //si el json llega cargado vacio lo inicializa sino no anda
            vuelos = new ArrayList<>();
        }
        if (vuelo != null) {
            vuelos.add(vuelo);
        }
    }

    public void eliminarVuelo(Vuelo vuelo) {
        vuelos.remove(vuelo);
    }

    public Vuelo buscarVueloPorID(int idVuelo) {
        Vuelo vueloBuscado = null;
        if(vuelos!=null){
            for (Vuelo vuelo : vuelos) {
                if (vuelo.getIdVuelo() == idVuelo) {
                    vueloBuscado = vuelo;
                }
            }
        }
        return vueloBuscado;
    }

    public String mostrarVuelosPorFecha(LocalDate fecha) {
        String retornoVuelos = "";
        if(vuelos != null) {
            for (Vuelo vuelo : vuelos) {
                if (fecha.isEqual(vuelo.getFecha())) {
                    retornoVuelos+=(vuelo.toString());
                }
            }
        }
        return retornoVuelos;
    }

    public ArrayList<Avion> buscarAvionesDisponibles(LocalDate fecha, int cantPasajeros) {
        ArrayList<Avion> avionesRetorno=aviones;
        ArrayList<Avion> avionesABorrar = new ArrayList<>();
        if(vuelos!=null) {
            for(Avion avion : aviones) {
                if (cantPasajeros <= avion.getCapacidadMaxPasajeros()) {
                    for (Vuelo vuelo : vuelos) {
                        if (vuelo.getFecha().equals(fecha)) {
                            if (vuelo.getAvion().equals(avion)){
                                avionesABorrar.add(avion);
                            }
                        }
                    }
                }
            }
        }
        else{
            for(Avion avion : aviones){
                if(cantPasajeros > avion.getCapacidadMaxPasajeros()){
                    avionesABorrar.add(avion);
                }
            }
        }
        for(Avion avion:avionesABorrar){
            avionesRetorno.remove(avion);
        }
        return avionesRetorno;
    }

    public Avion buscarAvionPorID(int idAvion) {
        Avion avionBuscado = null;
        for (Avion avion : aviones) {
            if (avion.getIdAvion() == idAvion) {
                avionBuscado = avion;
            }
        }
        return avionBuscado;
    }

    public StringBuilder mostrarUsuarios() {
        StringBuilder retornoUsuario = new StringBuilder();
        for (Usuario usuario : usuarios) {
            retornoUsuario.append(usuario.toString());
        }
        return retornoUsuario;
    }

    public Usuario buscarUsuarioPorDNI(String DNI) {
        Usuario usuarioBuscado = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getDni().equals(DNI)) {
                usuarioBuscado = usuario;
            }
        }
        return usuarioBuscado;
    }

    public ArrayList<Avion> getAviones() {
        return aviones;
    }

    public ArrayList<Vuelo> getVuelos() {
        return vuelos;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
