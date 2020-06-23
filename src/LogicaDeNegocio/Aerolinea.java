package LogicaDeNegocio;

import Modelo.*;

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
        ArrayList<Avion> avionesRetorno = new ArrayList<>();
        avionesRetorno.addAll(aviones);
        ArrayList<Avion> avionesABorrar = new ArrayList<>();

        if(vuelos!=null) {
            for(Avion avion : avionesRetorno) {
                if (cantPasajeros <= avion.getCapacidadMaxPasajeros()) {
                    for (Vuelo vuelo : vuelos) {
                        if (vuelo.getFecha().equals(fecha)) {
                            if (vuelo.getAvion().equals(avion)){
                                avionesABorrar.add(avion);
                            }
                        }
                    }
                }
                else{
                    avionesABorrar.add(avion);
                }
            }
        }
        else{
            for(Avion avion : avionesRetorno){
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
    public StringBuilder mostrarVuelos(){
        StringBuilder retornoVuelos = new StringBuilder();
        for(Vuelo vuelo : vuelos){
            retornoVuelos.append(vuelo.toString());
        }
        return retornoVuelos;
    }

    public StringBuilder mostrarUsuarios() {
        StringBuilder retornoUsuario = new StringBuilder();
        for (Usuario usuario : usuarios) {
            retornoUsuario.append(usuario.toString());
            retornoUsuario.append(buscarMejorAvionDeUsuario(usuario));
            retornoUsuario.append("\n");
        }
        return retornoUsuario;
    }

    private String buscarMejorAvionDeUsuario(Usuario usuario) {
        String mejorCategoria = "";
        boolean silver = false;
        if(vuelos != null) {
            for (Vuelo vuelo : vuelos) {
                if(vuelo.getUsuario().getDni().equals(usuario.getDni())){
                    if(vuelo.getAvion() instanceof Gold){
                        mejorCategoria = " Mejor avion: Gold";
                        break;
                    }
                    else if(vuelo.getAvion() instanceof  Silver){
                        mejorCategoria = " Mejor avion: Silver";
                        silver = true;
                    }
                    else if(vuelo.getAvion() instanceof Bronze && !silver){
                        mejorCategoria = " Mejor avion: Bronze";
                    }

                }
            }
        }
        return mejorCategoria;
    }

    public Usuario buscarUsuarioPorDNI(String DNI) {
        Usuario usuarioBuscado = null;
        if(usuarios != null) {
            for (Usuario usuario : usuarios) {
                if (usuario.getDni().equals(DNI)) {
                    usuarioBuscado = usuario;
                }
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

    public void agregarUsuario(Usuario usuario) {
        if(usuarios == null){ //si el json llega cargado vacio lo inicializa sino no anda
            usuarios = new ArrayList<>();
        }
        if (usuario != null) {
            usuarios.add(usuario);
        }
    }
}
