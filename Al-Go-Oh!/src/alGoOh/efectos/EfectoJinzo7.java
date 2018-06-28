package alGoOh.efectos;

import alGoOh.componentes.Jugador;

public class EfectoJinzo7 extends Efecto {

	private int ptsAtaque;
	
	public EfectoJinzo7(int ataque) {
		ptsAtaque=ataque;
	}
    @Override
    public void aplicarEfectoSobreJugadorOponente(Jugador jugador) {

        jugador.recibirDaniosVitales(this.ptsAtaque);
    }

}