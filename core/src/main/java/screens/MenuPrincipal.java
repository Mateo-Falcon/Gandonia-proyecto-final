package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.practica.Main;

public class MenuPrincipal extends BaseScreen {
    private Stage stage;
    private Skin skin;
    private static final float ANCHO_ESCENARIO = 1672f;
    private static final float ALTO_ESCENARIO = 941f;

    public MenuPrincipal(Main game) {
        super(game);
    }

    @Override
    public void show() {
        stage = new Stage(new FitViewport(ANCHO_ESCENARIO, ALTO_ESCENARIO), game.batch);
        skin = crearSkinBasica();
        Gdx.input.setInputProcessor(stage);

        Table tablaMenu = new Table();
        tablaMenu.setFillParent(true);
        tablaMenu.center();

        Label titulo = new Label("GANDONIA", skin);
        titulo.setFontScale(2.5f);

        TextButton btnJugar = new TextButton("JUGAR", skin);
        TextButton btnSalir = new TextButton("SALIR", skin);

        btnJugar.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new TronoReal(game));
            }
        });

        btnSalir.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });

        tablaMenu.add(titulo).padBottom(50f).row();
        tablaMenu.add(btnJugar).width(300f).height(60f).padBottom(20f).row();
        tablaMenu.add(btnSalir).width(300f).height(60f);

        stage.addActor(tablaMenu);
    }

    private Skin crearSkinBasica() {
        Skin skin = new Skin();

        Pixmap pixmapWhite = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmapWhite.setColor(Color.WHITE);
        pixmapWhite.fill();
        Texture texWhite = new Texture(pixmapWhite);
        pixmapWhite.dispose();

        skin.add("white", texWhite, Texture.class);

        TextureRegionDrawable drawableWhite = new TextureRegionDrawable(texWhite);
        skin.add("white", drawableWhite, Drawable.class);

        BitmapFont fuente = new BitmapFont();
        skin.add("default-font", fuente);

        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = fuente;
        labelStyle.fontColor = Color.WHITE;
        skin.add("default", labelStyle);

        TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();
        buttonStyle.font = fuente;
        buttonStyle.fontColor = Color.WHITE;
        buttonStyle.up = drawableWhite.tint(Color.DARK_GRAY);
        buttonStyle.over = drawableWhite.tint(Color.GRAY);
        buttonStyle.down = drawableWhite.tint(Color.LIGHT_GRAY);
        skin.add("default", buttonStyle);

        return skin;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.15f, 1);
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
        if (skin != null) skin.dispose();
    }
}
