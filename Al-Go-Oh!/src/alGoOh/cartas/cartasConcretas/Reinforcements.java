package alGoOh.cartas.cartasConcretas;

import alGoOh.cartas.LogicaCartas.CartaTrampa;
import alGoOh.componentes.Campo;
import alGoOh.componentes.Jugador;
import alGoOh.efectos.EfectoReinforcements;

public class Reinforcements extends CartaTrampa {
	
	public Reinforcements() {
		
		this.efecto = new EfectoReinforcements();
	}
	
	@Override
	public void aplicarEfecto(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente) {
		this.efecto.aplicarEfectoSobreCampoActivo(campo);
		
	}

}
