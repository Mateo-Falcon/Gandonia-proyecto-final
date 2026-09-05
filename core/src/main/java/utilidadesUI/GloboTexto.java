package utilidadesUI;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;

public class GloboTexto extends Table {
    private Label labelTexto;

    public GloboTexto(Skin skin, float anchoMaximo) {
        labelTexto = new Label("",skin);
        labelTexto.setWrap(true);
        labelTexto.setAlignment(Align.center);
        this.setBackground(skin.newDrawable("white", new Color(0.1f, 0.1f, 0.1f, 0.85f)));
        this.pad(15, 20, 15, 20);
        this.add(labelTexto).width(anchoMaximo - 40f);
        this.pack();
    }

    public void setTexto(String nuevoTexto) {
        labelTexto.setText(nuevoTexto);
        this.pack();
    }
}
