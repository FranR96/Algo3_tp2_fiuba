package cartas;

import alGoOh.*;

public class AgujeroNegro extends CartaMagica {
	
	
	public void efecto(Campo campo) {
		Tablero tablero = Tablero.getInstance();
		Campo campo1 = tablero.getCampo1();
		Campo campo2= tablero.getCampo2();
		
		for(int i=0; i<=campo1.monstruosInvocados().size(); i++)
			campo1.monstruosInvocados().remove(0);  
		for(int i=0; i<=campo2.monstruosInvocados().size(); i++)
			campo2.monstruosInvocados().remove(0); 
		campo.eliminarCartaEspecial(this);
	}



}
