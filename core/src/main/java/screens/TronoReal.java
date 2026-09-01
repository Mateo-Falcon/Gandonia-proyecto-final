package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.practica.Main;
import personajes.*;
import recursos.*;

public class TronoReal extends PlayScreen {
    private Stage stage;
    private Texture fondoEscenario;
    private Personaje dalkion;
    private Knight knight;
    private static final float ANCHO_ESCENARIO = 1672f;
    private static final float ALTO_ESCENARIO = 941f;
    private float anchoTrono = 130f;
    private float altoTrono = 246f;
    private Skin skinBasica;
    private TablaRecursos tablaRecursos;
    private TextButton btnAceptar;
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
        // 2. Definimos solo el ALTO que queremos que tenga (ej: 246 está bien)
        float altoDeseado = 246f;

        // 3. Obtenemos el ancho original de la textura de Dalkion
        float anchoOriginal = dalkion.getApariencia().getWidth();
        float altoOriginal = dalkion.getApariencia().getHeight();

        // 4. Calculamos la escala uniforme basada en el alto
        float escala = altoDeseado / altoOriginal;
        float anchoCalculado = anchoOriginal * escala;

        // 5. Asignamos el tamaño escalado UNIFORMEMENTE
        dalkion.setSize(anchoCalculado, altoDeseado);

        // 3. CENTRADO DINÁMICO EN X:
        // Mitad de la pantalla (836) menos la mitad del ancho del personaje
        float posX = (ANCHO_ESCENARIO / 2f) - (anchoCalculado / 2f);
        float posY = 270f;
        skinBasica = crearSkinBasica();
        tablaRecursos = new TablaRecursos(skinBasica);

        btnAceptar = new TextButton("Aceptar", skinBasica);
        btnAceptar.setSize(200,50);
        btnAceptar.setPosition(300, 100);
        btnAceptar.addListener(new ClickListener(){
            public void clicked (InputEvent event, float x, float y){
                tablaRecursos.getOro().restarCantidad(20);
            }
        });
        dalkion.setPosition(posX, posY);
        stage.addActor(fondo);
        stage.addActor(dalkion);
        stage.addActor(knight);
        stage.addActor(btnAceptar);
        stage.addActor(tablaRecursos);
    }

    private Skin crearSkinBasica() {
        Skin skin = new Skin();
        // 1. Creamos o cargamos una fuente
        BitmapFont fuente = new BitmapFont(); // Usa la fuente por defecto de LibGDX (o podés usar FreeType)
        // 2. Guardamos la fuente dentro de la skin
        skin.add("default-font", fuente);
        // 3. Creamos el estilo por defecto para los Labels
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = fuente;
        labelStyle.fontColor = Color.WHITE;
        skin.add("default", labelStyle);

        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.DARK_GRAY);
        pixmap.fill();
        Texture texUp = new Texture(pixmap);
        pixmap.dispose();

        TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();
        buttonStyle.font = fuente;
        buttonStyle.fontColor = Color.WHITE;
        buttonStyle.up = new TextureRegionDrawable(texUp); // Asigna el fondo
        skin.add("default", buttonStyle); // Registra el nombre "default"

        return skin;
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
        if (skinBasica != null) skinBasica.dispose();
        if (fondoEscenario != null) fondoEscenario.dispose();
        if (dalkion != null) dalkion.dispose();
        if (knight != null) knight.dispose();
    }
}
