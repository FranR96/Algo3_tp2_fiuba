package alGoOh;

import cartas.Carta;
import cartas.CartaMonstruo;
import cartas.Mazo;
import cartasConcretas.ExodiaCompleto;

import java.util.ArrayList;
import java.util.Observer;


public class Jugador {

	private String nombre;
	private int puntosVida;
	private Campo campo;
	private Mazo mazo;
	private ArrayList<Carta> mano;
	private ExodiaCompleto exodia;
	private CartaMonstruo monstruoColocadoEnTurno = null;
	private ArrayList<Observer> observadoresVida;
    private ArrayList<Observer> observadoresMano;


    public Jugador() {
		puntosVida = 8000;
		mazo = new Mazo();
		mano = new ArrayList<>();
		exodia = new ExodiaCompleto();
		observadoresMano = new ArrayList<>();
		observadoresVida = new ArrayList<>();
	}

	public void recibirDaniosVitales(int danio) {
		puntosVida -=danio;
		notifyObserversVida();
	}

	public int getPtsVida() {
		return puntosVida;
	}

	public void tomarCartaDelMazo() {
		Carta carta = mazo.tomarCartaDelMazo();
		mano.add(carta);
		notifyObserversMano();
	}
	
	public ArrayList<Carta> cartasEnLaMano() {
		return mano;
	}

	public void obtenerManoInicial() {
		for(int i = 0 ; i<5; i++) {
			this.tomarCartaDelMazo();
		}
	}

	public void agregarObserverVida(Observer observador) {
        observadoresVida.add(observador);
    }

	private void notifyObserversVida() {
        for (Observer observador: observadoresVida) {
            observador.update(null, this);
        }
    }

    public void agregarObserverMano(Observer observador) {
        observadoresMano.add(observador);
    }

    private void notifyObserversMano() {
        for (Observer observador: observadoresMano) {
            observador.update(null, this);
        }
    }

	public boolean estaVivo() {
		return (puntosVida > 0);
	}

	public boolean tieneCartasEnMazo() {
		return (!mazo.estaVacio());
	}

	public Campo getCampo() {
		return campo;
	}
	
	public void setCampo(Campo campo) {
		this.campo =campo ;	
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public boolean completoAExodia() {
		return (exodia.exodiaEstaCompleto());
	}
	
	public boolean colocoEsteMonstruoEnEsteTurno(CartaMonstruo monstruo) {
		
		return (this.monstruoColocadoEnTurno == monstruo);
	}

	public boolean coloqueMonstruo() {
	    return this.monstruoColocadoEnTurno != null;
    }

	public void setMonstruoColocadoEnTurno(CartaMonstruo monstruo) {
		monstruoColocadoEnTurno = monstruo;
	}
	
	public void reiniciarMonstruoColocadoPorTurno() {
		this.monstruoColocadoEnTurno = null;
	}

	public void terminarTurno() {
		reiniciarMonstruoColocadoPorTurno();
		exodia.cartasActualesEnMano(mano);
	}

	public void eliminarDeLaMano(Carta carta){
		this.mano.remove(carta);
		notifyObserversMano();
	}
}
