package cartas;

import alGoOh.*;

public class AgujeroNegro extends CartaMagica {

	public AgujeroNegro() {
		this.efecto = new EfectoAgujeroNegro();
	}

	@Override
	public void aplicarEfecto(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente){

	    this.efecto.aplicarEfectoSobreCampoActivo(campo);
	    this.efecto.aplicarEfectoSobreCampoOponente(campoEnemigo);
        this.campo.eliminarCartaEspecial(this);
	}

}
