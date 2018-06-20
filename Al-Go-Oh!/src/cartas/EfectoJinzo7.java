package cartas;

import alGoOh.*;

public class EfectoJinzo7 extends Efecto {

    @Override
    public void aplicarEfectoSobreJugadorOponente(Jugador jugador) {

        jugador.recibirDaniosVitales(/*this.carta.getPtsAtaques()*/ 500);
    }

}