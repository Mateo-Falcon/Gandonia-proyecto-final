package peticionarios;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import utilidadesUI.GloboTexto;

public abstract class Peticionario extends Actor {
    private String nombre;
    private Texture apariencia;

    protected Peticionario(String nombre, Texture apariencia) {
        this.nombre = nombre;
        this.apariencia = apariencia;
    }

    protected abstract void hacerPeticion(GloboTexto globoTexto);

    protected Texture getApariencia() {
        return apariencia;
    }
}
