package alGoOh;

import java.util.ArrayList;
import java.util.Collection;

import cartas.*;

public class Campo {
	private ArrayList<CartaMonstruo> zonaMonstruos = new ArrayList<CartaMonstruo>();
	private ArrayList<CartaEspecial> zonaEspeciales = new ArrayList<CartaEspecial>();
	private Tablero tablero = Tablero.getInstance();
	private Jugador jugador;
	private ArrayList<Carta> cementerio= new ArrayList<Carta>();
	
	
	public void colocarCarta(CartaMonstruo monstruo, PosicionCarta posicion,LadoCarta lado) {
		if(this.zonaMonstruos.size()<5) {
			monstruo.invocar(posicion, lado,this);
			this.zonaMonstruos.add(monstruo);
		}
		else {
			throw new CapacidadMaximaEnZonaMontruosException();
		}
		
	}

	public void colocarCarta(CartaEspecial carta, LadoCarta lado) {
		if(this.zonaEspeciales.size()< 5) {
			this.zonaEspeciales.add(carta);
			carta.invocar(lado);
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

	public Collection<CartaMonstruo> monstruosInvocados() {
		return this.zonaMonstruos;
	}

	public void cartaRequiereSacrificio(int cantSacrificios) {
		if(this.zonaMonstruos.size()>=cantSacrificios) {
			for(int i = 0;i<cantSacrificios;i++) {
				Carta cartaMuerta = this.zonaMonstruos.remove(i);
				this.cementerio.add(cartaMuerta);
			}
		}
		else {
			throw new NoHaySuficientesCartasParaElSacrificioException();
		}
		
	}


	
}
