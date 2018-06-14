package alGoOh;

import java.util.ArrayList;
import java.util.Collection;

import cartas.*;

public class Campo {
	private ArrayList<CartaMonstruo> zonaMonstruos = new ArrayList<CartaMonstruo>();
	private ArrayList<CartaEspecial> zonaEspeciales = new ArrayList<CartaEspecial>();
	private Tablero tablero;
	private Jugador jugador;
	private ArrayList<Carta> cementerio= new ArrayList<Carta>();
	
	public void setTablero(Tablero tablero) {
		
		this.tablero=tablero;
	}
	
	public void colocarCarta(CartaMonstruo monstruo, PosicionCarta posicion,LadoCarta lado) {
		if(this.zonaMonstruos.size()<=5) {
			monstruo.invocar(posicion, lado,this);
			this.zonaMonstruos.add(monstruo);
		}
		else {
			throw new CapacidadMaximaEnZonaMonstruosException();
		}
		
	}

	public void colocarCarta(CartaEspecial carta, LadoCarta lado) {
		if(this.zonaEspeciales.size()< 5) {
			carta.invocar(lado, this);
			this.zonaEspeciales.add(carta);
			this.tablero.aplicarEfecto(carta);
		}
		else {
			throw new CapacidadMaximaEnZonaEspecialesException();
		}
	}

	public void setJugador(Jugador jugador) {
		this.jugador=jugador;
	}

	public void eliminarMonstruo(CartaMonstruo carta) {
		int celda = this.zonaMonstruos.indexOf(carta);
		Carta cartaMuerta = this.zonaMonstruos.remove(celda);
		this.cementerio.add(cartaMuerta);
	}

	public void atacarJugador(int danio) {
		this.jugador.recibirDaniosVitales(danio);
		
	}

	public Collection<Carta> cartasEnCementerio() {
		return this.cementerio;
		
	}

	public ArrayList<CartaMonstruo> monstruosInvocados() {
		return this.zonaMonstruos;
	}

	public void cartaRequiereSacrificio(int cantSacrificios) {
		if(this.zonaMonstruos.size()>=cantSacrificios) {
			for(int i = 0;i<cantSacrificios;i++) {
				Carta cartaMuerta = this.zonaMonstruos.remove(0);
				this.cementerio.add(cartaMuerta);
			}
		}
		else {
			throw new NoHaySuficientesCartasParaElSacrificioException();
		}
		
	}
	
	public void aplicarEfecto(CartaEspecial carta) {
		carta.aplicarEfecto(this);
	}


}


	

