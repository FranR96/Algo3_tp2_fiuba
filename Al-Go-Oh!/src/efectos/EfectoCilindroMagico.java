package efectos;

import alGoOh.*;
import cartas.CartaMonstruo;

public class EfectoCilindroMagico extends Efecto {

	@Override
	public void aplicarEfectoSobreCampoOponente(Campo campoOponente) {
		CartaMonstruo atacante = campoOponente.cartaAtacante();
		campoOponente.atacarJugador(atacante.getPtsAtaque());
	}

	@Override
	public void aplicarEfectoSobreCampoActivo(Campo campoActivo){
		campoActivo.activarFiltroDeAtaque();
	}
}