package screens;

import botones.TablaBotones;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.gandonia.Main;
import gestores.GestorEntrada;
import misiones.TablaMisiones;
import personajes.*;
import peticionarios.GestorPeticionarios;
import peticionarios.Knight;
import recursos.*;
import utilidadesUI.GloboTexto;
public class TronoReal extends BaseScreen {
    private Stage stage;
    private Texture fondoEscenario;
    private Personaje dalkion;
    private static final float ANCHO_ESCENARIO = 1672f;
    private static final float ALTO_ESCENARIO = 941f;
    private Skin skinBasica;
    private TablaRecursos tablaRecursos;
    private TablaBotones tablaBotones;
    private TablaMisiones tablaMisiones;
    private GloboTexto globoTexto;
    private GestorEntrada gestorEntrada;
    private Reino reino;
    private GestorPeticionarios gestorPeticionarios;
    public TronoReal(Main game) {
        super(game);
    }

    @Override
    public void show() {
        stage = new Stage(new FitViewport(ANCHO_ESCENARIO, ALTO_ESCENARIO), game.batch);
        skinBasica = crearSkinBasica();
        Gdx.input.setInputProcessor(stage);

        fondoEscenario = new Texture(Gdx.files.internal("TronoReal.png"));
        Image fondo = new Image(fondoEscenario);
        fondo.setSize(ANCHO_ESCENARIO, ALTO_ESCENARIO);

        dalkion = new Personaje();

        float altoDeseado = 246f;
        float anchoOriginal = dalkion.getApariencia().getWidth();
        float altoOriginal = dalkion.getApariencia().getHeight();

        float escala = altoDeseado / altoOriginal;
        float anchoCalculado = anchoOriginal * escala;
        dalkion.setSize(anchoCalculado, altoDeseado);
        float posX = (ANCHO_ESCENARIO / 2f) - (anchoCalculado / 2f);
        float posY = 270f;
        dalkion.setPosition(posX, posY);

        reino = game.getGestorPartida().getReino();
        tablaRecursos = new TablaRecursos(skinBasica, reino);
        tablaBotones = new TablaBotones(skinBasica);
        tablaMisiones = new TablaMisiones(skinBasica);
        globoTexto = new GloboTexto(skinBasica, 400f);
        gestorEntrada = new GestorEntrada();
        gestorPeticionarios = new GestorPeticionarios(this.stage, globoTexto, gestorEntrada);
        TextButton btnVolverMenu = new TextButton("Menú", skinBasica);
        tablaMisiones.setPosition(1520, 580);
        btnVolverMenu.setSize(120f, 40f);
        btnVolverMenu.setPosition(20f, ALTO_ESCENARIO - 60f);
        gestorEntrada.aceptarMision(tablaBotones, tablaMisiones, globoTexto, reino, this.stage, skinBasica);
        gestorEntrada.rechazarMision(tablaBotones, tablaMisiones, globoTexto, reino);
        gestorEntrada.volverMenu(game, btnVolverMenu);


        stage.addActor(fondo);
        stage.addActor(dalkion);
        stage.addActor(tablaBotones);
        stage.addActor(globoTexto);
        stage.addActor(tablaMisiones);
        stage.addActor(btnVolverMenu);
        stage.addActor(tablaRecursos);
        gestorPeticionarios.iniciarJornada();
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
        skin.add("default", buttonStyle);

        Window.WindowStyle windowStyle = new Window.WindowStyle();
        windowStyle.titleFont = skin.getFont("default-font");
        windowStyle.background = skin.newDrawable("white", Color.DARK_GRAY);
        skin.add("default", windowStyle);

        return skin;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        gestorPeticionarios.actualizar();
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
        skinBasica.dispose();
        fondoEscenario.dispose();
        dalkion.dispose();
        tablaRecursos.dispose();
        gestorPeticionarios.dispose();
    }
}
