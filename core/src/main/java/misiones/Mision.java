package misiones;

import recursos.Recurso;

import java.util.ArrayList;

public class Mision {
    private String nombre;
    private ArrayList<Recurso> recursosRequeridos= new ArrayList<>();
    private ArrayList<Recurso> recompensas = new ArrayList<>();

    protected Mision(String nombre) {
        this.nombre = nombre;
    }


}
