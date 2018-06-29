package alGoOh.efectos;

import cartas.CartaMonstruo;
import alGoOh.Campo;

import java.util.ArrayList;


public class EfectoFisura extends Efecto {

    @Override
    public void aplicarEfectoSobreCampoOponente(Campo campo) {
        ArrayList<CartaMonstruo> zonaMonstruos = campo.monstruosInvocados();
        if(zonaMonstruos.size() != 0) {
            CartaMonstruo monstruoConMenorAtaque = zonaMonstruos.get(0);
            for(CartaMonstruo monstruo : zonaMonstruos)
                if(monstruoConMenorAtaque.getPtsAtaque() > monstruo.getPtsAtaque())
                    monstruoConMenorAtaque = monstruo;
            campo.eliminarCarta(monstruoConMenorAtaque);
        }
    }

}