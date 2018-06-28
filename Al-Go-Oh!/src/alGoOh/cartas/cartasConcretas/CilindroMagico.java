package alGoOh.cartas.cartasConcretas;

import alGoOh.cartas.LogicaCartas.CartaTrampa;
import alGoOh.componentes.Campo;
import alGoOh.componentes.Jugador;
import alGoOh.efectos.EfectoCilindroMagico;

public class CilindroMagico extends CartaTrampa {

    public CilindroMagico() {
        this.efecto = new EfectoCilindroMagico();
    }

    @Override
    public void aplicarEfecto(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente){
        this.efecto.aplicarEfectoSobreCampoOponente(campoEnemigo);
    }


}
