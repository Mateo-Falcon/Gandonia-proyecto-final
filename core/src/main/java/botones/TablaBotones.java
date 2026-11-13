package botones;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public class TablaBotones extends Table {
    private TextButton btnAceptar;
    private TextButton btnRechazar;

    public TablaBotones(Skin skin){
         btnAceptar = new TextButton("aceptar",skin);
         btnRechazar = new TextButton("Rechazar", skin);
         this.center().bottom();
         this.setFillParent(true);
         this.pad(10);
         this.add(btnAceptar).size(100,50).padRight(40);
         this.add(btnRechazar).size(100,50);
    }

    public TextButton getBtnAceptar() {
        return btnAceptar;
    }

    public TextButton getBtnRechazar() {
        return btnRechazar;
    }

    public void habilitarBotones() {
        btnAceptar.setTouchable(Touchable.enabled);
        btnRechazar.setTouchable(Touchable.enabled);
        btnAceptar.getColor().a = 1f;
        btnRechazar.getColor().a = 1f;
    }

    public void deshabilitarBotones() {
        btnAceptar.setTouchable(Touchable.disabled);
        btnRechazar.setTouchable(Touchable.disabled);
        btnAceptar.getColor().a = 0.4f;
        btnRechazar.getColor().a = 0.4f;
    }
}
