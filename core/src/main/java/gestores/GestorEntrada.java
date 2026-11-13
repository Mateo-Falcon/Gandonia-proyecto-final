package gestores;

import botones.TablaBotones;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.gandonia.Main;
import misiones.Mision;
import misiones.TablaMisiones;
import peticionarios.*;
import recursos.Reino;
import screens.MenuPrincipal;
import utilidadesUI.GloboTexto;

public class GestorEntrada {
    private Peticionario peticionarioActual;

    public void aceptarMision(TablaBotones tablaBotones, TablaMisiones tablaMisiones, GloboTexto globoTexto, Reino reino) {
        tablaBotones.getBtnAceptar().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (peticionarioActual == null || !peticionarioActual.puedeResponder()) return;
                final Peticionario peticionario = peticionarioActual;
                Mision mision = peticionario.getMision();
                if (mision == null) return;

                mision.aceptarMision(reino);
                tablaMisiones.mostrarMisionAceptada(mision);
                peticionario.decir(globoTexto, mision.getRespuestaAceptada());
                peticionario.marcarRespondido();
                programarRetirada(peticionario);
            }
        });
    }

    public void rechazarMision(TablaBotones tablaBotones, TablaMisiones tablaMisiones, GloboTexto globoTexto, Reino reino) {
        tablaBotones.getBtnRechazar().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (peticionarioActual == null || !peticionarioActual.puedeResponder()) return;
                final Peticionario peticionario = peticionarioActual;
                Mision mision = peticionario.getMision();
                if (mision == null) return;

                mision.rechazarMision(reino);
                tablaMisiones.mostrarMisionRechazada(mision);
                peticionario.decir(globoTexto, mision.getRespuestaRechazada());
                peticionario.marcarRespondido();
                programarRetirada(peticionario);
            }
        });
    }
    public void volverMenu (Main game, TextButton btnVolverMenu){
        btnVolverMenu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new MenuPrincipal(game));
            }
        });
    }

    private void programarRetirada(final Peticionario peticionario) {
        peticionario.addAction(Actions.sequence(
            Actions.delay(2.5f),
            Actions.run(new Runnable() {
                @Override
                public void run() {
                    peticionario.retirarse();
                }
            })
        ));
    }

    public void setPeticionarioActual(Peticionario peticionario) {
        this.peticionarioActual = peticionario;
    }
}
