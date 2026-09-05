package misiones;

import recursos.*;
import recursos.TablaRecursos;

import java.util.ArrayList;

public class MisionCaballero extends Mision{
    public MisionCaballero(Oro oro, Soldadesca soldadesca, int penalizacion) {
        super("Misión de caballero menor");
        this.penalizacion = penalizacion;
        oro.setCantidad(2);
        soldadesca.setCantidad(5);
        agregarRecursoRequerido(oro);
        agregarRecursoRequerido(soldadesca);
    }


    @Override
    protected void cargarMision(Recurso recursoRequerido, Recurso recursoRecompensa){
     getRecursosRequeridos().add(recursoRequerido);
     getRecompensas().add(recursoRecompensa);

    }
    @Override
    public void aceptarMision(TablaRecursos tablaRecursos) {
        for (Recurso recurso : getRecursosRequeridos()){
        tablaRecursos.restarRecurso(recurso.getNombre(), recurso.getCantidad());
    }

        for(Recurso recurso : getRecompensas()){
            tablaRecursos.sumarRecurso(recurso.getNombre(), recurso.getCantidad());
        }
    }

    @Override
    public void rechazarMision(TablaRecursos tablaRecursos) {
        tablaRecursos.restarRecurso("Legitimidad", this.penalizacion);
    }
}
