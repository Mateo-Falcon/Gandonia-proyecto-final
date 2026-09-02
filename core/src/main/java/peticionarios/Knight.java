package peticionarios;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import utilidadesUI.GloboTexto;

public class Knight extends Peticionario {
    private Animation<TextureRegion> knightAnimation;
    private float stateTime = 0f;
    private float velocidad = 50f;
    private boolean seMueve = true; // Controla el estado de movimiento

    private static final int ANCHO_SPRITESHEET = 320;
    private static final int ALTO_SPRITESHEET = 160;
    private static final float POSICION_DESTINO_X = 400f;

    public Knight(float x, float y) {
        super("Caballero menor", new Texture("BlackKnight.png"));
        TextureRegion knightRegion = new TextureRegion(getApariencia(), ANCHO_SPRITESHEET, ALTO_SPRITESHEET);
        TextureRegion[][] temp = knightRegion.split(ANCHO_SPRITESHEET / 10, ALTO_SPRITESHEET / 5);

        TextureRegion[] knightFrames = new TextureRegion[temp[2].length];
        for (int i = 0; i < temp[2].length; i++) {
            knightFrames[i] = temp[2][i];
        }

        knightAnimation = new Animation<TextureRegion>(0.2f, knightFrames);

        int anchoFrame = ANCHO_SPRITESHEET / 10;
        int altoFrame = ALTO_SPRITESHEET / 5;

        setPosition(x, y);
        setSize(anchoFrame * 6, altoFrame * 6);
    }

    @Override
    public void hacerPeticion(GloboTexto globoTexto){
        globoTexto.setTexto("Mi señor, unos bandidos han saqueado una casucha. Debemos mandar 5 soldados, una compensacion de 2 de oro y 8 de provisiones. ¿Lo hacemos?");

    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (seMueve) {
            // 1. Avanzar la posición X
            float nuevaX = getX() + velocidad * delta;

            // 2. Comprobar si alcanzó o superó los 736 px
            if (nuevaX >= POSICION_DESTINO_X) {
                setX(POSICION_DESTINO_X); // Fijar exactamente en 736
                seMueve = false;         // Frenar movimiento
            } else {
                setX(nuevaX);
                stateTime += delta;      // Solo avanza la animación si se está moviendo
            }
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        // Al congelar stateTime en el 'act', getKeyFrame devuelve el frame estático correspondiente
        TextureRegion currentFrame = knightAnimation.getKeyFrame(stateTime, true);
        batch.draw(currentFrame, getX(), getY(), getWidth(), getHeight());
    }

    public void dispose() {
        if (getApariencia() != null) {
            getApariencia().dispose();
        }
    }
}
