package LogicaDeNegocio;

import Modelo.Avion;
import Modelo.Vuelo;
import Modelo.Usuario;
import java.util.ArrayList;

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
        aviones.add(avion);
    }

    public void agregarVuelo(Vuelo vuelo){
        vuelos.add(vuelo);
    }

    public void agregarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }




}
