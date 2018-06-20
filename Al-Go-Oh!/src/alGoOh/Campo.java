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
    public void colocarCarta(CartaMonstruo carta, PosicionCarta posicion, LadoCarta lado, Campo campoEnemigo, Jugador oponente) {
		int sacrificiosNecesarios = carta.requiereSacrificio();
		if((this.zonaMonstruos.cantidadMonstruosEnZona() - sacrificiosNecesarios) < 5) {
			this.realizarSacrificio(sacrificiosNecesarios);
			this.zonaMonstruos.colocarCarta(carta);
			carta.invocar(posicion, lado,this, campoEnemigo, this.jugador, oponente);
		}
		else {
			throw new CapacidadMaximaEnZonaMonstruosException();
		}

	}
	
	public void colocarCarta(CartaTrampa carta,LadoCarta lado, Campo campoEnemigo, Jugador oponente) {
		this.zonaEspeciales.colocarCarta(carta);
		carta.invocar(lado, this, campoEnemigo, this.jugador, oponente);
	}

	public void colocarCarta(CartaMagica carta, LadoCarta lado, Campo campoEnemigo, Jugador oponente) {
	    this.zonaEspeciales.colocarCarta(carta);
        carta.invocar(lado, this, campoEnemigo, this.jugador, oponente);
    }

    public void setTablero(Tablero tablero) {

        this.tablero=tablero;
    }

	public void setJugador(Jugador jugador) {
		this.jugador=jugador;
		this.jugador.setCampo(this);
	}

	public ArrayList<CartaMonstruo> monstruosInvocados() {
        return this.zonaMonstruos.obtenerMonstruos();
    }

	public void eliminarMonstruo(CartaMonstruo carta) {
		this.zonaMonstruos.eliminarCarta(carta);
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
        if(this.zonaMonstruos.cantidadMonstruosEnZona() >= cantSacrificios) {
            ArrayList<CartaMonstruo> monstruosEnCampo = monstruosInvocados();
            for(int i = 0; i<cantSacrificios; i++) {
                this.eliminarMonstruo(monstruosEnCampo.get(i));
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

    public void voltearCarta(CartaMagica cartaMagica) {
        zonaEspeciales.voltearCartaMagica(cartaMagica);
    }

    public void voltearCarta(CartaMonstruo cartaMonstruo) {
        zonaMonstruos.voltearMonstruo(cartaMonstruo);
    }

}


	

