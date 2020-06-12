package Modelo;

public class Reserva {

    private Usuario usuario;
    private int nroAcompanantes;

    public Reserva(Usuario usuario, int nroAcompanantes) {
        this.usuario = usuario;
        this.nroAcompanantes = nroAcompanantes;
    }

    public int getNroAcompanantes() {
        return nroAcompanantes;
    }

    public Usuario getUsuario() {
        return usuario;
    }


}
