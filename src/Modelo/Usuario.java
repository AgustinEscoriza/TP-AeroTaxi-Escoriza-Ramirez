package Modelo;

public class Usuario {

    private String nombre;
    private String apellido;
    private String dni;
    private int edad;
    private float totalDineroGastado;

    public Usuario(String nombre, String apellido, String dni, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.totalDineroGastado=0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public int getEdad() {
        return edad;
    }

    public float getTotalDineroGastado(){
        return totalDineroGastado;
    }

    public void sumarDineroGastado(float dineroGastado){
        totalDineroGastado += dineroGastado;
    }

    public void restarDineroGastado(float dineroGastado){
        totalDineroGastado -= dineroGastado;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                ", Apellido: " + apellido +
                ", DNI: " + dni +
                ", Edad: " + edad +
                ", Dinero gastado: " + totalDineroGastado + "," ;
    }
}
