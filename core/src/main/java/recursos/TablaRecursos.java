package recursos;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class TablaRecursos extends Table {
    private final Oro oro;
    private final Provision provision;
    private final Soldadesca soldadesca;
    private final Legitimidad legitimidad;

    public TablaRecursos(Skin skin, Reino reino) {
        oro = new Oro(reino.get(TipoRecurso.ORO), skin);
        provision = new Provision(reino.get(TipoRecurso.PROVISION), skin);
        soldadesca = new Soldadesca(reino.get(TipoRecurso.SOLDADESCA), skin);
        legitimidad = new Legitimidad(reino.get(TipoRecurso.LEGITIMIDAD), skin);
        this.top().right();
        this.setFillParent(true);
        this.pad(10);
        this.add(oro).padRight(20);
        this.add(provision).padRight(20);
        this.add(soldadesca).padRight(20);
        this.add(legitimidad).padRight(20);
    }

    public void dispose() {
        oro.dispose();
        provision.dispose();
        soldadesca.dispose();
        legitimidad.dispose();
    }
}
