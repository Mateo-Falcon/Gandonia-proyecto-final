package personajes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Knight extends Actor {
    private Texture knightTexture;
    private Animation<TextureRegion> knightAnimation;
    private float stateTime = 0f;
    private float velocidad = 50f;
    private boolean seMueve = true;

    private static final int ANCHO_SPRITESHEET = 320;
    private static final int ALTO_SPRITESHEET = 160;
    private static final float POSICION_DESTINO_X = 400f;

    public Knight(float x, float y) {
        knightTexture = new Texture("BlackKnight.png");
        TextureRegion knightRegion = new TextureRegion(knightTexture, ANCHO_SPRITESHEET, ALTO_SPRITESHEET);
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
    public void act(float delta) {
        super.act(delta);

        if (seMueve) {
            float nuevaX = getX() + velocidad * delta;
            if (nuevaX >= POSICION_DESTINO_X) {
                setX(POSICION_DESTINO_X);
                seMueve = false;
            } else {
                setX(nuevaX);
                stateTime += delta;
            }
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        TextureRegion currentFrame = knightAnimation.getKeyFrame(stateTime, true);
        batch.draw(currentFrame, getX(), getY(), getWidth(), getHeight());
    }

    public void dispose() {
        if (knightTexture != null) {
            knightTexture.dispose();
        }
    }
}
