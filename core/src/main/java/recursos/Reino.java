package recursos;

public class Reino {
    private final RecursoLogico oro;
    private final RecursoLogico provision;
    private final RecursoLogico soldadesca;
    private final RecursoLogico legitimidad;

    public Reino() {
        oro = new RecursoLogico(TipoRecurso.ORO);
        provision = new RecursoLogico(TipoRecurso.PROVISION);
        soldadesca = new RecursoLogico(TipoRecurso.SOLDADESCA);
        legitimidad = new RecursoLogico(TipoRecurso.LEGITIMIDAD);
    }

    public RecursoLogico get(TipoRecurso tipo) {
        switch (tipo) {
            case ORO:
                return oro;
            case PROVISION:
                return provision;
            case SOLDADESCA:
                return soldadesca;
            case LEGITIMIDAD:
                return legitimidad;
            default:
                throw new IllegalArgumentException("Recurso no contemplado: " + tipo);
        }
    }

    public void sumar(TipoRecurso tipo, int monto) {
        get(tipo).sumarCantidad(monto);
    }

    public void restar(TipoRecurso tipo, int monto) {
        get(tipo).restarCantidad(monto);
    }
}
