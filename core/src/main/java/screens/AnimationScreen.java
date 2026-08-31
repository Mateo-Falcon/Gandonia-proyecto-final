package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.practica.Main;

public class AnimationScreen extends PlayScreen {
    private Texture knight;
    private TextureRegion knightRegion;
    private Animation<TextureRegion> knightAnimation;
    private TextureRegion [] knightFrames;
    private static final int ANCHO = 320;
    private static final int ALTO = 160;
    private float duracion = 0;
    private float posX = 100f;
    private float posY = 100f;
    private final float VELOCIDAD = 50f;
    public AnimationScreen(Main game) {
        super(game);
    }

    @Override
    public void show() {
        knight = new Texture("BlackKnight.png");
        knightRegion = new TextureRegion(knight, ANCHO, ALTO);
        TextureRegion [][] temp = knightRegion.split(ANCHO / 10, ALTO / 5);
        knightFrames= new TextureRegion [temp[2].length];

        for (int i = 0; i< temp[2].length; i++){
            knightFrames[i] = temp[2][i];
        }
        knightAnimation = new Animation<TextureRegion>(0.2f, knightFrames);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        posX += VELOCIDAD * delta;
        if (posX > Gdx.graphics.getWidth()) {
            posX = -32f;
        }
        duracion += delta;
        TextureRegion frame = knightAnimation.getKeyFrame(duracion, true);
        game.batch.begin();
        game.batch.draw(frame, posX, posY);
        game.batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

        if(knight!=null) knight.dispose();
    }
}
