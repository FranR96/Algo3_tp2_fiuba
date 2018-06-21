package alGoOh;

import java.util.ArrayList;
import java.util.Collection;

import cartas.*;


public class Jugador {

	private int puntosVida = 8000;
	private Campo campo;
	private Mazo mazo;
	private Collection<Carta> mano = new ArrayList<Carta>();


	public void recibirDaniosVitales(int danio) {
		puntosVida -=danio;
	}

	public int getPtsVida() {
		return puntosVida;
	}

	public void setCampo(Campo campo) {
		this.campo =campo ;
		
	}

	public void tomarCartaDelMazo() {
		Carta carta = mazo.tomarCartaDelMazo();
		mano.add(carta);
	}
	
	public Collection<Carta> cartasEnLaMano() {
		return mano;
	}

	public void obtenerManoInicial() {
		for(int i = 0 ; i<5; i++) {
			this.tomarCartaDelMazo();
		}
		
	}

	public boolean estaVivo() {
		if(puntosVida<=0)
			return false;
		return true;
	}

	public boolean tieneCartasEnMazo() {
		return mazo.estaVacio();
	}

	public Campo getCampo() {
		return campo;
	}
	
}
