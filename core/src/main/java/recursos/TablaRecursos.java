package recursos;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class TablaRecursos extends Table {
    private Oro oro;
    private Provision provision;
    private Soldadesca soldadesca;
    private Legitimidad legitimidad;
    public TablaRecursos(Skin skin) {
        oro = new Oro(skin);
        provision = new Provision(skin);
        soldadesca = new Soldadesca(skin);
        legitimidad = new Legitimidad(skin);
        this.top().right();
        this.setFillParent(true);
        this.pad(10);
        this.add(oro).padRight(20);
        this.add(provision).padRight(20);
        this.add(soldadesca).padRight(20);
        this.add(legitimidad).padRight(20);
    }

    public Oro getOro() {
        return oro;
    }
}
