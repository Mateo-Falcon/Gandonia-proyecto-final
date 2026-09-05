package misiones;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;

public class TablaMisiones extends Table {
    private Label label;

    public TablaMisiones(Skin skin) {
        this.center().right();
        this.setFillParent(true);
        this.pad(20);

        label = new Label("Sin misiones activas", skin);
        label.setWrap(true);
        label.setAlignment(Align.center);

        this.add(label).width(250f);
    }

    public void mostrarMisionAceptada(Mision mision) {
        label.setText("Misión aceptada:\n" + mision.getNombre());
    }

    public void mostrarMisionRechazada(Mision mision) {
        label.setText("Misión rechazada:\n" + mision.getNombre());
    }

    public void setTexto(String texto) {
        label.setText(texto);
    }
}
