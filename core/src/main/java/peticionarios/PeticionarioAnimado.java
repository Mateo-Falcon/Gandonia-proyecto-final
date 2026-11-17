
package peticionarios;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import misiones.Mision;
import utilidadesUI.GloboTexto;

public abstract class PeticionarioAnimado extends Peticionario {

    private final Animation<TextureRegion> animacion;
    private float stateTime = 0f;
    private float velocidad = 50f;
    private boolean seMueve = true;
    private boolean seVa = false;
    private GloboTexto globoTextoRef;
    private static final float POSICION_DESTINO_X = 400f;

    protected PeticionarioAnimado(String nombre, Texture apariencia, Mision mision, float x, float y, int anchoSpritesheet, int altoSpritesheet, int columnas, int filas, int filaAnimacion, float escala) {
        super(nombre, apariencia, mision);
        TextureRegion region = new TextureRegion(getApariencia(), anchoSpritesheet, altoSpritesheet);
        TextureRegion[][] frames = region.split(anchoSpritesheet / columnas,altoSpritesheet / filas);
        TextureRegion[] framesAnimacion = new TextureRegion[frames[filaAnimacion].length];
        for (int i = 0; i < framesAnimacion.length; i++) {
            framesAnimacion[i] = frames[filaAnimacion][i];
        }
        animacion = new Animation<>(0.2f, framesAnimacion);
        int anchoFrame = anchoSpritesheet / columnas;
        int altoFrame = altoSpritesheet / filas;
        setPosition(x, y);
        setSize(anchoFrame * escala, altoFrame * escala);
    }

    public void prepararPeticion(GloboTexto globoTexto) {
        this.globoTextoRef = globoTexto;
    }

    @Override
    public void retirarse() {
        seVa = true;
        seMueve = true;
        if (globoTextoRef != null) {
            globoTextoRef.setVisible(false);
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (seMueve) {
            stateTime += delta;
            if (seVa) {
                setX(getX() - velocidad * delta);
                if (getX() + getWidth() < 0) {
                    remove();
                }
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
            if (globoTextoRef != null) {
                presentarPeticion(globoTextoRef);
            }
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        TextureRegion currentFrame = animacion.getKeyFrame(stateTime, true);
        if (currentFrame != null) {
            Color color = getColor();
            batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
            float ancho = seVa ? -getWidth() : getWidth();
            float x = seVa ? getX() + getWidth() : getX();
            batch.draw(currentFrame, x, getY(), ancho, getHeight());
            batch.setColor(Color.WHITE);
        }
    }

    public boolean getMovimiento() {
        return seMueve;
    }

    public void dispose() {
        getApariencia().dispose();
    }
}
