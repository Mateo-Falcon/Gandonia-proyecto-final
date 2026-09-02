package utilidadesUI;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;

public class GloboTexto extends Table {
    private Label labelTexto;

    public GloboTexto(String mensaje, Skin skin, float anchoMaximo) {
        // 1. Label para el texto con salto de línea automático
        labelTexto = new Label(mensaje, skin);
        labelTexto.setWrap(true);
        labelTexto.setAlignment(Align.center);

        // 2. Usamos la textura blanca por defecto que trae Scene2D y le damos color/transparencia
        // "white" es el nombre del asset por defecto en Skins de LibGDX
        this.setBackground(skin.newDrawable("white", new Color(0.1f, 0.1f, 0.1f, 0.85f)));

        // 3. Márgenes internos (padding)
        this.pad(15, 20, 15, 20);

        // 4. Agregamos el texto
        this.add(labelTexto).width(anchoMaximo - 40f);
        this.pack();
    }

    public void setTexto(String nuevoTexto) {
        labelTexto.setText(nuevoTexto);
        this.pack();
    }
}
