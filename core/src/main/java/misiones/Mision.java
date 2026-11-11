package misiones;

import recursos.Costo;
import recursos.Reino;
import recursos.TipoRecurso;

public abstract class Mision {
    private final String nombre;
    private final Costo[] requisitos;
    private final Costo[] recompensas;
    private final int penalizacion;

    protected Mision(String nombre, Costo[] requisitos, Costo[] recompensas, int penalizacion) {
        this.nombre = nombre;
        this.requisitos = requisitos;
        this.recompensas = recompensas;
        this.penalizacion = penalizacion;
    }

    public void aceptarMision(Reino reino) {
        for (Costo requisito : requisitos) {
            reino.restar(requisito.getTipoRecurso(), requisito.getCantidad());
        }
        for (Costo recompensa : recompensas) {
            reino.sumar(recompensa.getTipoRecurso(), recompensa.getCantidad());
        }
    }

    public void rechazarMision(Reino reino) {
        reino.restar(TipoRecurso.LEGITIMIDAD, penalizacion);
    }

    protected String getNombre() {
        return nombre;
    }
}
