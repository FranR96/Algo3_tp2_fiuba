package cartas;

import alGoOh.*;

public class EfectoAgujeroNegro extends Efecto {

    @Override
    public void aplicarEfectoSobreCampoActivo(Campo campo) {
        for(int i=0; i<=campo.monstruosInvocados().size(); i++)
            campo.monstruosInvocados().remove(0);
    }

    @Override
    public void aplicarEfectoSobreCampoOponente(Campo campo){
        for(int i=0; i<=campo.monstruosInvocados().size(); i++)
            campo.monstruosInvocados().remove(0);
    }
}