package cartas;

import alGoOh.*;

public class EfectoAgujeroNegro extends Efecto {

	@Override
	public void aplicarEfecto() {
		
		Tablero tablero = Tablero.getInstance();
		Campo campo1 = tablero.getCampo1();
		Campo campo2 = tablero.getCampo2();
		
		for(int i=0; i<=campo1.monstruosInvocados().size(); i++)
			campo1.monstruosInvocados().remove(0);  
		for(int i=0; i<=campo2.monstruosInvocados().size(); i++)
			campo2.monstruosInvocados().remove(0);
	}

	@Override
	public void aplicarEfecto(Jugador jugador) {}

	@Override
	public void aplicarEfecto(Campo campo) {}	
}
