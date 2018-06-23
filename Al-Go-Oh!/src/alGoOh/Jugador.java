package alGoOh;

import java.util.ArrayList;
import java.util.Collection;

import cartas.*;
import cartasConcretas.ExodiaCompleto;


public class Jugador {

	private String nombre;
	private int puntosVida = 8000;
	private Campo campo;
	private Mazo mazo;
	private ArrayList<Carta> mano = new ArrayList<Carta>();
	private ExodiaCompleto exodia = new ExodiaCompleto(); 


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
		exodia.cartasActualesEnMano(mano);
	}
	
	public ArrayList<Carta> cartasEnLaMano() {
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
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
}
