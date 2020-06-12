package LogicaDeNegocio;

import Modelo.Avion;
import Modelo.Vuelo;
import Modelo.Usuario;
import Enums.Ciudad;
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


    public void agregarUsuario(Usuario usuario){
        if(usuario!=null){
            usuarios.add(usuario);
        }
    }

    public Vuelo buscarVueloPorID(int idVuelo){
        Vuelo vueloBuscado=null;
        for(Vuelo vuelo: vuelos){
            if(vuelo.getIdVuelo()==idVuelo){
                vueloBuscado=vuelo;
            }
        }
        return vueloBuscado;
    }

    public String mostrarVuelosPorFecha(LocalDate fecha){
        String retornoVuelos = " ";
        for(Vuelo vuelo : vuelos){
            if(fecha.equals(vuelo.getFecha())){
                retornoVuelos.concat(vuelo.toString());
            }
        }
        return retornoVuelos;
    }

    public String mostrarVuelosDisponibles(LocalDate fecha, Ciudad origen, Ciudad destino, int cantidadPasajeros){
            String vuelosDisponibles = null;
            for(Vuelo vuelo:this.vuelos){
                if(fecha.equals(vuelo.getFecha())){
                    if(origen.equals(vuelo.getOrigen())){
                        if(destino.equals(destino)){
                            if(vuelo.getAvion().getCapacidadMaxPasajeros()-vuelo.getPasajerosActuales() >= cantidadPasajeros){
                                vuelosDisponibles.concat(vuelo.toString());
                            }
                        }
                    }
                }
            }
            return vuelosDisponibles;
    }

    public String mostrarUsuarios(){
        String retornoUsuario = " ";
        for(Usuario usuario: usuarios){
            retornoUsuario.concat(usuario.toString());
        }
        return retornoUsuario;
    }

    public Usuario buscarUsuarioPorDNI(String DNI){
        Usuario usuarioBuscado=null;
        for(Usuario usuario : usuarios){
            if(usuario.getDni().equals(DNI)){
                usuarioBuscado=usuario;
            }
        }
        return usuarioBuscado;
    }

}
