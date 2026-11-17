package com.gandonia;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import gestores.GestorPartida;
import screens.MenuPrincipal;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    public SpriteBatch batch;
    private GestorPartida gestorPartida;
    @Override
    public void create() {
        batch = new SpriteBatch();
        gestorPartida = new GestorPartida();
        this.setScreen(new MenuPrincipal(this));

    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void setScreen(Screen nuevaPantalla) {
        Screen pantallaAnterior = getScreen();
        super.setScreen(nuevaPantalla);
        if (pantallaAnterior != null && pantallaAnterior != nuevaPantalla) {
            pantallaAnterior.dispose();
        }
    }

    public GestorPartida getGestorPartida() {
        return gestorPartida;
    }

    @Override
    public void dispose() {
        getScreen().dispose();
        batch.dispose();
    }
}
