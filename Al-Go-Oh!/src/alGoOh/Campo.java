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
	private ArrayList<CartaMonstruo> monstruosQueAtacaron = new ArrayList<CartaMonstruo>();


	 public void colocarCarta(CartaMonstruo carta, PosicionCarta posicion, LadoCarta lado) {
			int sacrificiosNecesarios = carta.requiereSacrificio();
			if((this.zonaMonstruos.cantidadMonstruosEnZona() - sacrificiosNecesarios) < 5) {
				if(this.realizarSacrificioPara(sacrificiosNecesarios,carta)) {
					this.zonaMonstruos.colocarCarta(carta);
					carta.invocar(posicion, lado,this, tablero.getOponente().getCampo(), this.jugador, tablero.getOponente());
				}
				else
					throw new NoSePuedoInvocarElMonstruoException();
			}
			else {
				throw new CapacidadMaximaEnZonaMonstruosException();
			}

		}
	public void colocarCarta(CartaTrampa carta,LadoCarta lado) {
		this.zonaEspeciales.colocarCarta(carta);
		carta.invocar(lado, this, tablero.getOponente().getCampo(), this.jugador,  tablero.getOponente());
	}

	public void colocarCarta(CartaMagica carta, LadoCarta lado) {
	    this.zonaEspeciales.colocarCarta(carta);
        carta.invocar(lado, this, tablero.getOponente().getCampo(), this.jugador,  tablero.getOponente());
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

	public void eliminarCartaMagica(CartaMagica cartaMagica) {
        this.zonaEspeciales.eliminarCarta(cartaMagica);
		this.cementerio.add(cartaMagica);
	}

	
	public void atacarJugador(int danio) {
		this.jugador.recibirDaniosVitales(danio);
	}



	public Collection<Carta> cartasEnCementerio() {
		return this.cementerio;
	}

	public boolean realizarSacrificioPara(int cantSacrificios, CartaMonstruo carta) {
        if(this.zonaMonstruos.cantidadMonstruosEnZona() >= cantSacrificios) {
            ArrayList<CartaMonstruo> monstruosEnCampo = this.monstruosInvocados();
            ArrayList<CartaMonstruo> monstruosASacrificar = carta.elegirSacrificios(monstruosEnCampo);
            if(!monstruosASacrificar.isEmpty()) {
            	for(int i = 0; i<monstruosASacrificar.size();i++) {
            		this.eliminarMonstruo(monstruosASacrificar.get(i));
            	}
            }
        	return true;
        }
        return false;
	}
	public boolean voltearCartaTrampa() {
        if(zonaEspeciales.voltearCartaTrampa()) {
        	try {
        		CartaTrampa carta = zonaEspeciales.eliminarCarta();
        		carta.invocar(new BocaArriba(),this,tablero.getCampoOponente(),this.jugador,tablero.getOponente());
        		this.cementerio.add(carta);
        		}
        	catch (CartaTrampaNoExistenteException e){	
        	}
        }
        return false;
    }

    public void voltearCarta(CartaMagica cartaMagica) {
        zonaEspeciales.voltearCartaMagica(cartaMagica);
    }

    public void voltearCarta(CartaMonstruo cartaMonstruo) {
        zonaMonstruos.voltearMonstruo(cartaMonstruo);
    }

	public CartaMonstruo cartaAtacante() {
		int cantidadAtaques= monstruosQueAtacaron.size();
		return monstruosQueAtacaron.get(cantidadAtaques-1);
		

	}

	public void atacoEnTurno(CartaMonstruo cartaMonstruo) {
		if(!monstruosQueAtacaron.contains(cartaMonstruo))
			monstruosQueAtacaron.add(cartaMonstruo);
		else {
			throw  new EstaCartaYaAtacoException();
		}
		
	}

	public void reiniciarAtaques() {
		monstruosQueAtacaron.clear();
		
	}
	
	public ZonaMonstruos getZonaMonstruos(){
		return zonaMonstruos;
	}

}


	

