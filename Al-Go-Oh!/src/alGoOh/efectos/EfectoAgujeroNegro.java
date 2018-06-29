package alGoOh.efectos;

import cartas.CartaMonstruo;
import alGoOh.Campo;

public class EfectoAgujeroNegro extends Efecto {

    @Override
    public void aplicarEfectoSobreCampoActivo(Campo campo) {
        for(int i=0; i<campo.monstruosInvocados().size(); i++) {
            CartaMonstruo carta = campo.monstruosInvocados().get(0);
            campo.eliminarCarta(carta);
        }
    }

    @Override
    public void aplicarEfectoSobreCampoOponente(Campo campo){
        for(int i=0; i<campo.monstruosInvocados().size(); i++) {
            CartaMonstruo carta = campo.monstruosInvocados().get(0);
            campo.eliminarCarta(carta);
        }
    }
}