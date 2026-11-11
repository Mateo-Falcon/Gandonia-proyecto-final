package recursos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Provision extends Recurso{
    public Provision(RecursoLogico recursoLogico, Skin skin) {
        super(recursoLogico, new Texture("recursos/provision.png"), skin);
    }
}
