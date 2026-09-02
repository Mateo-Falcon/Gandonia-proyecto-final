package botones;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

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
}
