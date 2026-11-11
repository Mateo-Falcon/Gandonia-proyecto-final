package recursos;

public class Costo {
    private TipoRecurso tipoRecurso;
    private int cantidad;

    public Costo(TipoRecurso tipoRecurso, int cantidad) {
        this.tipoRecurso = tipoRecurso;
        this.cantidad = cantidad;
    }

    public TipoRecurso getTipoRecurso() {
        return tipoRecurso;
    }

    public int getCantidad() {
        return cantidad;
    }
}
