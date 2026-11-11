package recursos;

public enum TipoRecurso {
    ORO("Oro"),
    PROVISION("Provisiones"),
    SOLDADESCA("Soldadesca"),
    LEGITIMIDAD("Legitimidad");

    private String nombre;
    TipoRecurso(String nombre){
     this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
