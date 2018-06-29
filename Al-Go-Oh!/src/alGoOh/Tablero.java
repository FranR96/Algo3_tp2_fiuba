package alGoOh;

import alGoOh.controladorJuego.Juego;

import java.util.ArrayList;
import java.util.Observer;

public class Tablero {
	private static Tablero INSTANCE =null;
	private Campo campo1;
	private Campo campo2;
	private Juego juego = new Juego();
	private ArrayList<Observer> observers = new ArrayList<>();

	private Tablero() {}

	private synchronized static void createInstance() {
		if (INSTANCE == null) { 
	       INSTANCE = new Tablero();
	    }
	}

	public static Tablero getInstance() {
	    if (INSTANCE == null) 
	    	createInstance();
	    return INSTANCE;
	}
	
	public void inicializarTablero(Jugador jugador1, Jugador jugador2) {
		campo1 = new Campo();
		campo2= new Campo();
		campo1.setJugador(jugador1);
		campo2.setJugador(jugador2);
		campo1.setTablero(this);
		campo2.setTablero(this);

		juego.sortearInicio(jugador1,jugador2);
	}
	
	public Jugador getOponente() {
		return juego.getOponente();
	}
	
	public Jugador getJugadorActivo() {
		return juego.getJugadorActivo();
	}
	
	public Campo getCampoOponente() {
		Jugador oponente = juego.getOponente();
		return oponente.getCampo();
	}
	
	public Jugador hayGanador() {
		return juego.hayGanador();
	}
	
	public Jugador terminarTurno() {
		this.campo1.terminarTurno();
		this.campo2.terminarTurno();
		Jugador ganador= this.juego.terminarTurno();
		notifyObservers();
		return ganador;
	}


	public void agregarObserver(Observer observador) {
		observers.add(observador);
	}

	private void notifyObservers() {
		for (Observer observador: observers) {
			observador.update(null, this);
		}
	}
}
