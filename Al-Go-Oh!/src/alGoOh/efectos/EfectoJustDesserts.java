package alGoOh.efectos;

import alGoOh.componentes.Jugador;

public class EfectoJustDesserts extends Efecto {

	@Override
	public void aplicarEfectoSobreJugadorOponente(Jugador jugador) {
		
		int cantidadMonstruosEnCampo = jugador.getCampo().monstruosInvocados().size();
		jugador.recibirDaniosVitales(500 * cantidadMonstruosEnCampo);
	}
}
