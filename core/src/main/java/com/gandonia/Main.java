package com.gandonia;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import screens.TronoReal;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    public SpriteBatch batch;
    private Texture image;

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
        image.dispose();
    }
}
