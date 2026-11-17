package peticionarios;

import com.badlogic.gdx.graphics.Texture;
import misiones.MisionMercader;

public class Mercader extends PeticionarioAnimado{

    public Mercader(float x, float y) {
        super(
            "Mercader", new Texture("peticionarios/mercader_spritesheet_320x160.png"), new MisionMercader(), x, y,
            320,160,8,1,0, 3f);
    }
}
