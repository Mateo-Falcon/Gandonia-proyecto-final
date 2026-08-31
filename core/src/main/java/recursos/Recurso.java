package recursos;

import com.badlogic.gdx.graphics.Texture;

public abstract class Recurso {
    private String nombre;
    private int cantidad;
    private Texture apariencia;

    protected Recurso(String nombre, Texture apariencia) {
        this.nombre = nombre;
        this.cantidad = 100;
        this.apariencia = apariencia;
    }
}
