package misiones;

import recursos.Costo;
import recursos.TipoRecurso;

public class MisionMercader extends Mision{
    public MisionMercader() {
        super("Mision de mercader", "Mi señor, necesito su ayuda. Un malviviente me destrozó mi puesto de venta y necesito reponer la mercancía. ¿Me daría 20 provisiones y 5 de oro? Puedo entregar 10 de mis mejores hombres a su disposición", "Muchas gracias mi señor, volveré pronto a informarle mi situación", "Entiendo, mi señor. Pediré ayuda en otro momento", new Costo[]{new Costo(TipoRecurso.PROVISION, 20), new Costo(TipoRecurso.ORO, 5)}, new Costo[]{new Costo(TipoRecurso.SOLDADESCA, 10)}, 10);
    }
}
