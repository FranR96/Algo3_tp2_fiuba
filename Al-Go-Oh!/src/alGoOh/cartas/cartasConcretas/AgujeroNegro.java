package alGoOh.cartas.cartasConcretas;

import alGoOh.cartas.LogicaCartas.CartaMagica;
import alGoOh.componentes.Campo;
import alGoOh.componentes.Jugador;
import alGoOh.efectos.EfectoAgujeroNegro;

public class AgujeroNegro extends CartaMagica {

	public AgujeroNegro() {
		this.efecto = new EfectoAgujeroNegro();
	}

	@Override
	public void aplicarEfecto(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente){

	    this.efecto.aplicarEfectoSobreCampoActivo(campo);
	    this.efecto.aplicarEfectoSobreCampoOponente(campoEnemigo);
        this.campo.eliminarCarta(this);
	}

}
