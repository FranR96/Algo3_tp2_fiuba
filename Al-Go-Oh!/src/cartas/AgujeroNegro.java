package cartas;

import alGoOh.*;

public class AgujeroNegro extends CartaMagica {

	public AgujeroNegro() {
		
	}
	
	@Override
	public void efecto() {
		
	}
	
	@Override
	public void efecto(Campo campo) {
		
		for(int i=0; i<=campo.monstruosInvocados().size()-1; i++)
			campo.monstruosInvocados().remove(i);  
	}

}
