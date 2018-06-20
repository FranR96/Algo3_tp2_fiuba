package cartas;

import java.util.Collection;
import java.util.Stack;

public class Mazo {

	private Stack<Carta> mazo = new Stack<Carta>();
	
	public Mazo() {
		this.inicializarMazo(mazo);
		
	}
	
	public void inicializarMazo(Collection<Carta> mazo) {
		for(int i = 0; i<40; i++) {
			//Carta  carta = Seleccionar Random de una coleccion de todas cartas.
		//	mazo.push(carta);
		}
		
	}
	
	public Carta tomarCartaDelMazo() {
		return mazo.pop();
	}
	
	
}
