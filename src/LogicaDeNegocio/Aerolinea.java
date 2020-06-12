package LogicaDeNegocio;

import Modelo.Avion;
import Modelo.Vuelo;
import Modelo.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;

    /// CHEQUEAR SI NO HAY QUE AGREGAR ELIMINAR AVIONES,VUELOS,USUARIOS U OTROS METODOS;
public class Aerolinea {
    public ArrayList<Avion> aviones;
    public ArrayList<Vuelo> vuelos;
    public ArrayList<Usuario> usuarios;

    public Aerolinea(){
        this.aviones = new ArrayList<Avion>();
        this.usuarios = new ArrayList<Usuario>();
        this.vuelos = new ArrayList<Vuelo>();
    }

    public void agregarAvion(Avion avion){
        if(avion!=null) {
            aviones.add(avion);
        }
    }

    public void agregarVuelo(Vuelo vuelo){
        if(vuelo!=null) {
            vuelos.add(vuelo);
        }
    }

    public void agregarUsuario(Usuario usuario){
        if(usuario!=null){
            usuarios.add(usuario);
        }
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

    public String mostrarVuelos(){
        String retornoVuelos = " ";
        for(Vuelo vuelo : vuelos){
            retornoVuelos.concat(vuelo.toString());
        }
        return retornoVuelos;
    }

    public String mostrarUsuarios(){
        String retornoUsuario = " ";
        for(Usuario usuario: usuarios){
            retornoUsuario.concat(usuario.toString());
        }
        return retornoUsuario;
    }
    public String mostrarAviones(){
        String retornoAviones = " ";
        for(Avion avion:aviones){
            retornoAviones.concat(avion.toString());
        }
        return retornoAviones;
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
