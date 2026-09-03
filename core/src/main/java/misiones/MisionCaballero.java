package misiones;

import recursos.Recurso;
import recursos.TablaRecursos;

import java.util.ArrayList;

public class MisionCaballero extends Mision{
    public MisionCaballero(Recurso recursoRequerido, Recurso recompensa, int penalizacion) {
        super("Mision de caballero menor");
        this.penalizacion = penalizacion;
        cargarMision(recursoRequerido, recompensa);
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
    }
}
