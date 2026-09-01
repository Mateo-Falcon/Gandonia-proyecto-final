package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.gandonia.Main;
import personajes.*;

public class TronoReal extends BaseScreen {
    private Stage stage;
    private Texture fondoEscenario;
    private Personaje dalkion;
    private Knight knight;
    private static final float ANCHO_ESCENARIO = 1672f;
    private static final float ALTO_ESCENARIO = 941f;

    public TronoReal(Main game) {
        super(game);
    }

    @Override
    public void show() {
        stage = new Stage(new FitViewport(ANCHO_ESCENARIO, ALTO_ESCENARIO), game.batch);
        Gdx.input.setInputProcessor(stage);

        fondoEscenario = new Texture(Gdx.files.internal("TronoReal.png"));
        Image fondo = new Image(fondoEscenario);
        fondo.setSize(ANCHO_ESCENARIO, ALTO_ESCENARIO);

        dalkion = new Personaje();
        knight = new Knight(50f, 100f);
        float altoDeseado = 246f;
        float anchoOriginal = dalkion.getApariencia().getWidth();
        float altoOriginal = dalkion.getApariencia().getHeight();
        float escala = altoDeseado / altoOriginal;
        float anchoCalculado = anchoOriginal * escala;
        dalkion.setSize(anchoCalculado, altoDeseado);
        float posX = (ANCHO_ESCENARIO / 2f) - (anchoCalculado / 2f);
        float posY = 270f;
        dalkion.setPosition(posX, posY);
        stage.addActor(fondo);
        stage.addActor(dalkion);
        stage.addActor(knight);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        stage.dispose();
        if (fondoEscenario != null) {
            fondoEscenario.dispose();
        }
        if (dalkion != null) {
            dalkion.dispose();
        }
    }
}
