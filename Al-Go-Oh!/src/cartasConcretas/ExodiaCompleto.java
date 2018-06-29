package cartasConcretas;


import cartas.Carta;
import cartas.CartaMonstruo;
import alGoOh.efectos.EfectoNulo;

import java.util.ArrayList;

public class ExodiaCompleto extends CartaMonstruo{

	private boolean piernaIzquierda;
	private boolean piernaDerecha;
	private boolean brazoIzquierdo;
	private boolean brazoDerecho;
	private boolean cabeza;
	private boolean completo;

	public ExodiaCompleto() {
		super(100000,100000,10,new EfectoNulo());
		piernaIzquierda = false;
		piernaDerecha = false;
		brazoDerecho = false;
		brazoIzquierdo = false;
		cabeza = false;
		completo = false;
	}
	
	public boolean exodiaEstaCompleto() {
		if(cabeza && brazoDerecho && brazoIzquierdo && piernaDerecha && piernaIzquierda) {
			completo= true;
		}
		this.reiniciarPartes();
		return completo;
	}
	
	private void reiniciarPartes() {
		piernaIzquierda = false;
		piernaDerecha = false;
		brazoDerecho = false;
		brazoIzquierdo = false;
		cabeza = false;
	}


	public void piernaDerecha() {
		piernaDerecha = true;
	}
	
	public void piernaIzquierda() {
		piernaIzquierda = true;
	}
	public void brazoDerecho() {
		brazoDerecho = true;
	}
	public void brazoIzquierdo() {
		brazoIzquierdo = true;
	}
	public void cabeza() {
		cabeza = true;
	}

	public void cartasActualesEnMano(ArrayList<Carta> mano) {
		int cantidadCartas = mano.size();
		for(int i = 0 ; i< cantidadCartas ; i++) {
			mano.get(i).getEfecto().aplicarEfectoExodia(this);
		}
		this.exodiaEstaCompleto();
	}
	
	public int resetPtsAtaque() {
		return 100000;
	}
	
	public int resetPtsDefensa() {
		return 100000;
	}
}
