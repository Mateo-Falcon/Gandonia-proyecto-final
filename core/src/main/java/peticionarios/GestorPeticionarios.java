
package peticionarios;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import gestores.GestorEntrada;
import utilidadesUI.GloboTexto;

public class GestorPeticionarios {

    private final Array<PeticionarioAnimado> peticionarios;
    private final Stage stage;
    private final GloboTexto globoTexto;
    private final GestorEntrada gestorEntrada;
    private int indiceActual = 0;
    private boolean jornadaTerminada = false;

    public GestorPeticionarios(
        Stage stage,
        GloboTexto globoTexto,
        GestorEntrada gestorEntrada
    ) {
        this.stage = stage;
        this.globoTexto = globoTexto;
        this.gestorEntrada = gestorEntrada;
        peticionarios = new Array<>();
        peticionarios.add(new Mercader(50f, 40f));
        peticionarios.add(new Knight(50f, 100f));

    }

    public void iniciarJornada() {
        mostrarPeticionarioActual();
    }

    private void mostrarPeticionarioActual() {
        PeticionarioAnimado peticionario = peticionarios.get(indiceActual);
        peticionario.prepararPeticion(globoTexto);
        gestorEntrada.setPeticionarioActual(peticionario);
        stage.addActor(peticionario);
    }

    public void actualizar() {
        if (jornadaTerminada) return;
        PeticionarioAnimado actual = peticionarios.get(indiceActual);
        if (actual.puedeResponder()) return;
        if (actual.getStage() == null) {
            indiceActual++;
            if (indiceActual < peticionarios.size) {
                mostrarPeticionarioActual();
            } else {
                jornadaTerminada = true;
                gestorEntrada.setPeticionarioActual(null);
            }
        }
    }

    public boolean JornadaTerminada() {
        return jornadaTerminada;
    }

    public void dispose() {
        for (PeticionarioAnimado peticionario : peticionarios) {
            peticionario.dispose();
        }
    }
}
