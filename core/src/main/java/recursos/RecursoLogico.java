package recursos;

    public class RecursoLogico {
    private TipoRecurso tipoRecurso;
    private int cantidad;

    public RecursoLogico(TipoRecurso tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
        this.cantidad = 100;

    }

    public String getNombre() {
        return tipoRecurso.getNombre();
    }

    public int getCantidad() {
        return cantidad;
    }

    public int restarCantidad(int monto){
        this.cantidad-=monto;
        if(this.cantidad < 0) this.cantidad = 0;
        return this.cantidad;
    }

    public int sumarCantidad(int monto){
        this.cantidad+=monto;
        if(this.cantidad>100) this.cantidad = 100;
        return this.cantidad;
    }
}
