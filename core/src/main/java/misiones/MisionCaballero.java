package misiones;

import recursos.Costo;
import recursos.TipoRecurso;

public class MisionCaballero extends Mision {
    public MisionCaballero() {
        super("Misión de caballero menor",
            new Costo[] {
                new Costo(TipoRecurso.ORO, 2),
                new Costo(TipoRecurso.SOLDADESCA, 5)
            },
            new Costo[0],
            5);
    }
}
