package personajes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Personaje extends Actor {
    private String nombre;
    private Texture apariencia;

    public Personaje() {
        this.nombre = "Dalkion Gandas";
        this.apariencia = new Texture("Dalkion_nuevo.png");
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(apariencia, getX(), getY(), getWidth(), getHeight());
    }

    public void dispose() {
        if (apariencia != null) {
            apariencia.dispose();
        }
    }

    public Texture getApariencia() {
        return apariencia;
    }
}
