public class Buque {

    private String nombre;
    private String tipo;
    private double capacidad;

    public Buque(String nombre, String tipo, double capacidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public double getCapacidad() {
        return capacidad;
    }
}