package alGoOh;

import java.util.ArrayList;
import cartas.*;

public class Jugador {

	private Tablero tablero;
	private int puntosVida = 8000;
	protected ArrayList<Carta> mano = new ArrayList<Carta>();
	

	public void setTablero(Tablero tablero) {
		this.tablero=tablero;
	}
	public void recibirDaniosVitales(int danio) {
		if(puntosVida <= 0) {
			throw new PartidaFinalizadaException();
		}
		puntosVida -=danio;
	}

	public int getPtsVida() {
		return puntosVida;
	}
	
}
