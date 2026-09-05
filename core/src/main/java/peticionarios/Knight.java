package peticionarios;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import misiones.MisionCaballero;
import recursos.Oro;
import recursos.Soldadesca;
import utilidadesUI.GloboTexto;

public class Knight extends Peticionario {
    private Animation<TextureRegion> knightAnimation;
    private float stateTime = 0f;
    private float velocidad = 50f;
    private boolean seMueve = true;
    private boolean seVa = false;
    private boolean peticionHecha = false;
    private GloboTexto globoTextoRef;

    private static final int ANCHO_SPRITESHEET = 320;
    private static final int ALTO_SPRITESHEET = 160;
    private static final float POSICION_DESTINO_X = 400f;

    public Knight(float x, float y, Skin skin) {
        super("Caballero menor", new Texture("BlackKnight.png"), new MisionCaballero(
            new Oro(skin),
            new Soldadesca(skin),
            5
        ));

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

    public void prepararPeticion(GloboTexto globoTexto) {
        this.globoTextoRef = globoTexto;
    }

    public void retirarse() {
        this.seVa = true;
        this.seMueve = true;
        if (globoTextoRef != null) {
            globoTextoRef.setVisible(false);
        }
    }

    @Override
    public void hacerPeticion(GloboTexto globoTexto) {
        if (globoTexto != null) {
            globoTexto.setTexto(
                "Mi señor, unos bandidos han saqueado una casucha.\n" +
                    "Debemos mandar 5 soldados y una compensación de 2 de oro. ¿Lo hacemos?"
            );
            globoTexto.setPosition(getX() - 50f, getY() + getHeight() + 10f);
            globoTexto.setVisible(true);
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (seMueve) {
            stateTime += delta;
            if (seVa) {
                setX(getX() - velocidad * delta);
            } else {
                float nuevaX = getX() + velocidad * delta;
                if (nuevaX >= POSICION_DESTINO_X) {
                    setX(POSICION_DESTINO_X);
                    seMueve = false;
                } else {
                    setX(nuevaX);
                }
            }
        } else {
            if (!peticionHecha && globoTextoRef != null) {
                hacerPeticion(globoTextoRef);
                peticionHecha = true;
            }
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (knightAnimation != null) {
            TextureRegion currentFrame = knightAnimation.getKeyFrame(stateTime, true);
            if (currentFrame != null) {
                TextureRegion frameADibujar = new TextureRegion(currentFrame);
                if (seVa) {
                    frameADibujar.flip(true, false);
                }
                Color color = getColor();
                batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
                batch.draw(frameADibujar, getX(), getY(), getWidth(), getHeight());
                batch.setColor(Color.WHITE);
            }
        }
    }

    public void dispose() {
        if (getApariencia() != null) {
            getApariencia().dispose();
        }
    }
}
