package recursos;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;


public abstract class Recurso extends Table {
    private String nombre;
    private int cantidad;
    private Texture apariencia;
    private Image icono;
    private Label labelCantidad;

    protected Recurso(String nombre, Texture apariencia, Skin skin) {
        this.nombre = nombre;
        this.cantidad = 100;
        this.apariencia = apariencia;
        this.icono = new Image(apariencia);
        this.labelCantidad = new Label(String.valueOf(this.cantidad), skin);
        this.add(icono).size(64, 64).padRight(5);
        this.add(labelCantidad);
    }

    public void sumarCantidad(int valor) {
        this.cantidad += valor;
        actualizarLabel();
    }

    public void restarCantidad(int valor) {
        this.cantidad -= valor;
        if (this.cantidad < 0) this.cantidad = 0;
        actualizarLabel();
    }

    private void actualizarLabel() {
        this.labelCantidad.setText(String.valueOf(this.cantidad));
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
    }
}
