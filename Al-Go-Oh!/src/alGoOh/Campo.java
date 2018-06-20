package alGoOh;

import java.util.ArrayList;
import java.util.Collection;

import cartas.*;

public class Campo {
	private ZonaMonstruos zonaMonstruos = new ZonaMonstruos();
	private ZonaEspecial zonaEspeciales = new ZonaEspecial();
	private Jugador jugador;
	private Tablero tablero;
	private ArrayList<Carta> cementerio= new ArrayList<Carta>();


	// Hay que borrar esto y reemplazar con los metodos de ZonaMonstruo
	public void colocarCarta(CartaMonstruo monstruo, PosicionCarta posicion,LadoCarta lado) {
		int sacrificiosNecesarios = monstruo.requiereSacrificio();
		if((this.zonaMonstruos.size()-sacrificiosNecesarios)<5) {
			this.realizarSacrificio(sacrificiosNecesarios);
			this.zonaMonstruos.colocarCarta(monstruo);
			monstruo.invocar(posicion, lado,this, tablero.getCampo2(), this.jugador, tablero.getJugador2());
		}
		else {
			throw new CapacidadMaximaEnZonaMonstruosException();
		}

	}
	
	public void colocarCarta(CartaTrampa carta) {
		this.zonaEspeciales.colocarCarta(carta);
		carta.invocar(this);
	}

	public void colocarCarta(CartaMagica carta) {
	    this.zonaEspeciales.colocarCarta(carta);
        carta.invocar(this);
    }

    public void setTablero(Tablero tablero) {

        this.tablero=tablero;
    }

	public void setJugador(Jugador jugador) {
		this.jugador=jugador;
		this.jugador.setCampo(this);
	}

	public void eliminarMonstruo(CartaMonstruo carta) {
		this.zonaMonstruos.elminarCarta(carta);
		this.cementerio.add(carta);
	}

	public void eliminarCartaEspecial(CartaMagica cartaMagica) {
        this.zonaEspeciales.eliminarCarta(cartaMagica);
		this.cementerio.add(cartaMagica);
	}

    public void eliminarCartaEspecial(CartaTrampa cartaTrampa) {
        this.zonaEspeciales.eliminarCarta(cartaTrampa);
        this.cementerio.add(cartaTrampa);
    }
	public void atacarJugador(int danio) {
		this.jugador.recibirDaniosVitales(danio);
	}



	public Collection<Carta> cartasEnCementerio() {
		return this.cementerio;
	}


	public void realizarSacrificio(int cantSacrificios) {
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


	private void voltearCartaTrampa() { // Es privado porque el usuario no puede dar vuelta una carta trampa
	    // el juego/campo es quien se va a encargar de darla vuelta cuando ataquen
        zonaEspeciales.voltearCartaTrampa();
    }

    public void voltearCartaMagica(CartaMagica cartaMagica) { // ¿Tiene sentido esto?, ¿si ya me pasa la carta que quiere
	    // voltear porque no hago cartaMagica.voltear() ?
	    zonaEspeciales.voltearCartaMagica(cartaMagica);
    }

}


	

