package gestores;
import recursos.*;
public class GestorPartida {
    private Reino reino;
    private int diaActual;

    public GestorPartida() {
        this.reino = new Reino();
        this.diaActual = 1;
    }

    public void avanzarDia(){
        diaActual++;
    }

    public Reino getReino() {
        return reino;
    }
}
