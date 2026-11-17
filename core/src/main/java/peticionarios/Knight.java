
package peticionarios;

import com.badlogic.gdx.graphics.Texture;
import misiones.MisionCaballero;

public class Knight extends PeticionarioAnimado {

    public Knight(float x, float y) {
        super(
            "Caballero menor", new Texture("peticionarios/BlackKnight.png"), new MisionCaballero(), x, y,
            320, 160, 10, 5, 2, 6f);
    }
}

