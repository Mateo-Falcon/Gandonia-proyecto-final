package peticionarios;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import misiones.Mision;
import utilidadesUI.GloboTexto;

public abstract class Peticionario extends Actor {
    private String nombre;
    private Texture apariencia;
    private Mision mision;
    protected Peticionario(String nombre, Texture apariencia, Mision mision) {
        this.nombre = nombre;
        this.apariencia = apariencia;
        this.mision = mision;
    }

    protected abstract void hacerPeticion(GloboTexto globoTexto);

    public Mision getMision() {
        return mision;
    }

    protected Texture getApariencia() {
        return apariencia;
    }
}
