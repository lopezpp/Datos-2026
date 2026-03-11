public class suministros {

    private String id;
    private double nivelEnergia;
    private String prioridad;

    public suministros(String id, double nivelEnergia, String prioridad) {
        this.id = id;
        this.nivelEnergia = nivelEnergia;
        this.prioridad = prioridad  ;

        if (nivelEnergia > 100) {
    prioridad = "ALTA";
} else {
    prioridad = "ESTANDAR";
}
    }

    public String getId() {
        return id;
    }

    public double getNivelEnergia() {
        return nivelEnergia;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNivelEnergia(double nivelEnergia) {
        this.nivelEnergia = nivelEnergia;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
}