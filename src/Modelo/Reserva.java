package Modelo;

public class Reserva {

    private Usuario usuario;
    private int cantidadAcompanantes;

    public Reserva(Usuario usuario, int nroAcompanantes) {
        this.usuario = usuario;
        this.cantidadAcompanantes = nroAcompanantes;
    }

    public int getNroAcompanantes() {
        return cantidadAcompanantes;
    }

    public Usuario getUsuario() {
        return usuario;
    }


}
