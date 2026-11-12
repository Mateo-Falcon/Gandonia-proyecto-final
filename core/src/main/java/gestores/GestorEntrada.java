package gestores;

import botones.TablaBotones;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.gandonia.Main;
import misiones.Mision;
import misiones.TablaMisiones;
import peticionarios.*;
import recursos.Reino;
import recursos.TablaRecursos;
import screens.MenuPrincipal;
import screens.TronoReal;
import utilidadesUI.GloboTexto;

public class GestorEntrada {

    public void aceptarMision (TablaBotones tablaBotones, Knight knight, TablaRecursos tablaRecursos, TablaMisiones tablaMisiones, GloboTexto globoTexto, Reino reino){
        tablaBotones.getBtnAceptar().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (tablaBotones.getBtnAceptar().getTouchable() == Touchable.disabled) return;
                Mision misionActual = knight.getMision();
                if (misionActual != null) {
                    misionActual.aceptarMision(reino);
                    tablaMisiones.mostrarMisionAceptada(misionActual);
                    globoTexto.setTexto("¡A la orden, mi señor! Los 5 soldados parten de inmediato.");
                    globoTexto.setPosition(knight.getX() - 50f, knight.getY() + knight.getHeight() + 10f);
                    tablaBotones.getBtnAceptar().setTouchable(Touchable.disabled);
                    tablaBotones.getBtnRechazar().setTouchable(Touchable.disabled);
                    knight.addAction(Actions.sequence(
                        Actions.delay(2.5f),
                        Actions.run(new Runnable() {
                            @Override
                            public void run() {
                                knight.retirarse();
                            }
                        })
                    ));
                }
            }
        });
    }

    public void rechazarMision (TablaBotones tablaBotones, Knight knight, TablaRecursos tablaRecursos, TablaMisiones tablaMisiones, GloboTexto globoTexto, Reino reino) {
        tablaBotones.getBtnRechazar().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (tablaBotones.getBtnRechazar().getTouchable() == Touchable.disabled) return;
                Mision misionActual = knight.getMision();
                if (misionActual != null) {
                    misionActual.rechazarMision(reino);
                    tablaMisiones.mostrarMisionRechazada(misionActual);
                    globoTexto.setTexto("Entendido, mi señor... Haremos lo que podamos.");
                    globoTexto.setPosition(knight.getX() - 50f, knight.getY() + knight.getHeight() + 10f);
                    tablaBotones.getBtnAceptar().setTouchable(Touchable.disabled);
                    tablaBotones.getBtnRechazar().setTouchable(Touchable.disabled);
                    knight.addAction(Actions.sequence(
                        Actions.delay(2.5f),
                        Actions.run(new Runnable() {
                            @Override
                            public void run() {
                                knight.retirarse();
                            }
                        })
                    ));
                }
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

    public void jugar(TextButton btnJugar, Main game){
        btnJugar.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new TronoReal(game));
            }
        });
    }

    public void salir(TextButton btnSalir){
        btnSalir.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
    }
}
