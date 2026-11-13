package peticionarios;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import misiones.Mision;
import utilidadesUI.GloboTexto;

public abstract class Peticionario extends Actor {
    private final String nombre;
    private final Texture apariencia;
    private final Mision mision;
    private Estados estado = Estados.LLEGANDO;

    protected Peticionario(String nombre, Texture apariencia, Mision mision) {
        this.nombre = nombre;
        this.apariencia = apariencia;
        this.mision = mision;
    }

    /** Cada peticionario decide cómo se retira. */
    public abstract void retirarse();

    /** Los hijos lo llaman al llegar. Actúa una sola vez. */
    protected final void presentarPeticion(GloboTexto globoTexto) {
        if (estado != Estados.LLEGANDO) return;
        hacerPeticion(globoTexto);
        estado = Estados.ESPERANDO_RESPUESTA;
    }

    /** Por defecto dice el texto de su misión. Un hijo puede sobrescribirlo si necesita algo especial. */
    protected void hacerPeticion(GloboTexto globoTexto) {
        decir(globoTexto, mision.getTextoPeticion());
    }

    /** Muestra un texto en el globo, encima de este peticionario. */
    public void decir(GloboTexto globoTexto, String texto) {
        if (globoTexto == null) return;
        globoTexto.setTexto(texto);
        globoTexto.setPosition(getX() - 50f, getY() + getHeight() + 10f);
        globoTexto.setVisible(true);
    }

    public boolean puedeResponder() {
        return estado == Estados.ESPERANDO_RESPUESTA;
    }

    public void marcarRespondido() {
        estado = Estados.RESPONDIDO;
    }

    public Mision getMision() {
        return mision;
    }

    protected Texture getApariencia() {
        return apariencia;
    }
}
