package alGoOh;

import java.util.ArrayList;
import java.util.Collection;

import cartas.*;

public class Campo {
	private ZonaMonstruos zonaMonstruos = new ZonaMonstruos();
	private ZonaEspecial zonaEspeciales = new ZonaEspecial();
	private CartaCampo cartaCampo = null;
	private Jugador jugador;
	private Tablero tablero;
	private ArrayList<Carta> cementerio= new ArrayList<Carta>();
	private ArrayList<CartaMonstruo> monstruosQueAtacaron = new ArrayList<CartaMonstruo>();


	// Hay que borrar esto y reemplazar con los metodos de ZonaMonstruo
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

    public void colocarCarta(CartaCampo carta, LadoCarta lado){
    	this.cartaCampo = carta;
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

 /*   public void eliminarCartaTrampa() {
        CartaTrampa cartaTrampa= this.zonaEspeciales.eliminarCarta();
        this.cementerio.add(cartaTrampa);
    }*/ // Me parece que no se utiliza en ningún lado. Se usa solo el eliminar CartaTrampa de Zona Especiales
	
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
                for (CartaMonstruo aMonstruosASacrificar : monstruosASacrificar) {
                    this.eliminarMonstruo(aMonstruosASacrificar);
                }
            	return true;
            }
        }
        return false;
	}

	public void voltearCartaTrampa() {
        if(zonaEspeciales.hayCartaTrampa()) {
        	CartaTrampa carta = zonaEspeciales.eliminarCarta();
        	carta.invocar(new BocaArriba(),this,tablero.getCampoOponente(),this.jugador,tablero.getOponente());
        	this.cementerio.add(carta);
        }
	}


	//No se usa nunca
    public void voltearCarta(CartaMagica cartaMagica) {
        zonaEspeciales.voltearCartaMagica(cartaMagica);
    }

	//No se usa nunca
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

	public int obtenerAdicionalAtkAtacante(){
		if(cartaCampo != null){
			return cartaCampo.getPtsAdicionalAtkAtacante();
		}
		return 0;
	}

	public int obtenerAdicionalAtkAtacado(){
		if(cartaCampo != null){
			return cartaCampo.getPtsAdicionalAtkAtacado();
		}
		return 0;
	}

	public int obtenerAdicionalDefAtacante(){
		if(cartaCampo != null){
			return cartaCampo.getPtsAdicionalDefAtacante();
		}
		return 0;
	}

	public int obtenerAdicionalDefAtacado(){
		if(cartaCampo != null){
			return cartaCampo.getPtsAdicionalDefAtacado();
		}
		return 0;
	}
}


	

