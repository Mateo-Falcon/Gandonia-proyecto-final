package recursos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Soldadesca extends Recurso{
    public Soldadesca(RecursoLogico recursoLogico, Skin skin) {
        super(recursoLogico, new Texture("recursos/soldadesca_sin_fondo.png"), skin);
    }
}
