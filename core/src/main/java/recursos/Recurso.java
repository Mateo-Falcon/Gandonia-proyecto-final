package recursos;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.*;


public abstract class Recurso extends Table {
    private RecursoLogico recursoLogico;
    private Texture apariencia;
    private Image icono;
    private Label labelCantidad;
    private int cantidadEnPantalla;

    protected Recurso(RecursoLogico recursoLogico, Texture apariencia, Skin skin) {
        this.recursoLogico = recursoLogico;
        this.apariencia = apariencia;
        this.icono = new Image(apariencia);
        this.cantidadEnPantalla = recursoLogico.getCantidad();
        this.labelCantidad = new Label(String.valueOf(cantidadEnPantalla), skin);
        this.add(icono).size(64, 64).padRight(5);
        this.add(labelCantidad);
    }
    @Override
    public void act(float delta) {
        super.act(delta);
        int actual = recursoLogico.getCantidad();
        if (actual != cantidadEnPantalla) {
            cantidadEnPantalla = actual;
            labelCantidad.setText(String.valueOf(actual));
        }
    }

    public void dispose(){
        apariencia.dispose();
    }
}
