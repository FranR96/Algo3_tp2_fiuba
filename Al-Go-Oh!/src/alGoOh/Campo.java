package alGoOh;

import java.util.ArrayList;
import java.util.Collection;

import cartas.*;

public class Campo {
	private ArrayList<CartaMonstruo> zonaMonstruos = new ArrayList<CartaMonstruo>();
	private ArrayList<CartaEspecial> zonaEspeciales = new ArrayList<CartaEspecial>();
	private Jugador jugador;
	private Tablero tablero;
	private ArrayList<Carta> cementerio= new ArrayList<Carta>();
	
	
	public void colocarCarta(CartaMonstruo monstruo, PosicionCarta posicion,LadoCarta lado) {
		monstruo.invocar(posicion, lado,this);
		if(this.zonaMonstruos.size()<5) {
			this.zonaMonstruos.add(monstruo);
		}
		else {
			throw new CapacidadMaximaEnZonaMonstruosException();
		}
		
	}

	public void setTablero(Tablero tablero) {
		
		this.tablero=tablero;
	}
	
	public void colocarCarta(CartaEspecial carta, LadoCarta lado) {
		if(this.zonaEspeciales.size()< 5) {
			this.zonaEspeciales.add(carta);
			carta.invocar(lado, this);
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

	public void eliminarCartaEspecial(CartaEspecial carta) {
		int celda = this.zonaEspeciales.indexOf(carta);
		Carta cartaUsada = this.zonaEspeciales.remove(celda);
		this.cementerio.add(cartaUsada);
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

	public ArrayList<CartaEspecial> cartasEspeciales() {
		return this.zonaEspeciales;
	}
	


}


	

