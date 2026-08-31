package com.practica;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import screens.TronoReal;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    public SpriteBatch batch;
    @Override
    public void create() {
        batch = new SpriteBatch();
        this.setScreen(new TronoReal(this));

    }

    @Override
    public void render() {
    super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
