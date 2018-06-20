package cartas;

import java.util.ArrayList;

import alGoOh.*;


public class EfectoFisura extends Efecto {

    @Override
    public void aplicarEfectoSobreCampoOponente(Campo campo) {
        ArrayList<CartaMonstruo> zonaMonstruos = campo.monstruosInvocados();
        if(zonaMonstruos.size() != 0) {
            CartaMonstruo monstruoConMenorAtaque = zonaMonstruos.get(0);
            for(CartaMonstruo monstruo : zonaMonstruos)
                if(monstruoConMenorAtaque.getPtsAtaque() > monstruo.getPtsAtaque())
                    monstruoConMenorAtaque = monstruo;
            zonaMonstruos.remove(monstruoConMenorAtaque);
        }
    }

}