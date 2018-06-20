package cartas;

import alGoOh.*;

public class AgujeroNegro extends CartaMagica {
	
	
	public AgujeroNegro() {
		
		this.efecto = new EfectoAgujeroNegro();
		
	}
	
	public void aplicarEfecto() {
		
		this.efecto.aplicarEfecto();
		this.campo.eliminarCartaEspecial(this);
	}



}
