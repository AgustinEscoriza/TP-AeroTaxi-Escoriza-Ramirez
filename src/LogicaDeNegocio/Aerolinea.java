package LogicaDeNegocio;

import Modelo.Avion;
import Modelo.Vuelo;
import Modelo.Usuario;
import Enums.Ciudad;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

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
        if (vuelo != null) {
            vuelos.add(vuelo);
        }
    }

    public void eliminarVuelo(Vuelo vuelo) {
        vuelos.remove(vuelo);
    }

    public Vuelo buscarVueloPorID(int idVuelo) {
        Vuelo vueloBuscado = null;
        for (Vuelo vuelo : vuelos) {
            if (vuelo.getIdVuelo() == idVuelo) {
                vueloBuscado = vuelo;
            }
        }
        return vueloBuscado;
    }

    public String mostrarVuelosPorFecha(LocalDate fecha) {
        String retornoVuelos = " ";
        for (Vuelo vuelo : vuelos) {
            if (fecha.equals(vuelo.getFecha())) {
                retornoVuelos.concat(vuelo.toString());
            }
        }
        return retornoVuelos;
    }

    public ArrayList<Avion> buscarAvionesDisponibles(LocalDate fecha, int cantPasajeros) {
        ArrayList<Avion> avionesRetorno=new ArrayList<>();
        if(vuelos!=null) {
            for (Avion avion : aviones) {
                if (cantPasajeros <= avion.getCapacidadMaxPasajeros()) {
                    for (Vuelo vuelo : vuelos) {
                        if (vuelo.getAvion().equals(avion)) {
                            if (!vuelo.getFecha().equals(fecha)) {
                                avionesRetorno.add(avion);
                            }
                        }
                    }
                }
            }
        }
        else{
            avionesRetorno.addAll(aviones);
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

    public String mostrarUsuarios() {
        String retornoUsuario = " ";
        for (Usuario usuario : usuarios) {
            retornoUsuario.concat(usuario.toString());
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
}
