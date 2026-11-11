package recursos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Oro extends Recurso{
    public Oro(RecursoLogico recursoLogico, Skin skin) {
        super(recursoLogico, new Texture("recursos/oro.png"), skin);
    }
}
