package misiones;

import recursos.Costo;
import recursos.TipoRecurso;

public class MisionCaballero extends Mision {
    public MisionCaballero() {
        super("Misión de caballero menor",
            "Mi señor, unos bandidos han saqueado una casucha.\n"
                + "Debemos mandar 5 soldados y una compensación de 2 de oro. ¿Lo hacemos?",
            "¡A la orden, mi señor! Los 5 soldados parten de inmediato.",
            "Entendido, mi señor... Haremos lo que podamos.",
            new Costo[] { new Costo(TipoRecurso.ORO, 2), new Costo(TipoRecurso.SOLDADESCA, 5) },
            new Costo[0],
            5);
    }
}
