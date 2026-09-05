package misiones;

import recursos.Recurso;
import recursos.TablaRecursos;

import java.util.ArrayList;

public abstract class Mision {
    private String nombre;
    private ArrayList <Recurso> recursosRequeridos = new ArrayList<>();
    private ArrayList <Recurso> recompensas = new ArrayList<>();
    protected int penalizacion;

    protected Mision(String nombre) {
        this.nombre = nombre;
    }

    protected ArrayList<Recurso> getRecursosRequeridos() {
        return recursosRequeridos;
    }

    protected ArrayList<Recurso> getRecompensas() {
        return recompensas;
    }

    public void agregarRecursoRequerido(Recurso recurso) {
        this.recursosRequeridos.add(recurso);
    }

    protected abstract void cargarMision(Recurso recursoRequerido, Recurso recursoRecompensa);
    public abstract void aceptarMision(TablaRecursos tablaRecursos);
    public abstract void rechazarMision(TablaRecursos tablaRecursos);

    protected String getNombre() {
        return nombre;
    }
}
