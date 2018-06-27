package alGoOh;

import java.util.ArrayList;
import java.util.Collection;

import cartas.*;

public class Campo {
	private ZonaMonstruos zonaMonstruos = new ZonaMonstruos(this);
	private ZonaEspecial zonaEspeciales = new ZonaEspecial(this);
	private CartaCampo cartaCampo = null;
	private Jugador jugador;
	private Tablero tablero;
	private ArrayList<Carta> cementerio= new ArrayList<>();
	private ArrayList<CartaMonstruo> monstruosQueAtacaron = new ArrayList<>();
	private CartaMonstruo ultimoMonstruoAtacado;
	private FiltroDeAtaque filtroDeAtaque = new FiltroDeAtaque();


     public void colocarCarta(CartaMonstruo carta, PosicionCarta posicion, LadoCarta lado) {
    	if (this.jugador.coloqueMonstruo()) {
    		throw new YaSeHaInvocadoMonstruoEnTurnoException();
    	} 
    	else {
    		if(this.zonaMonstruos.colocarCarta(carta)) {
    			this.jugador.setMonstruoColocadoEnTurno(carta);
    			carta.invocar(posicion, lado,this, tablero.getOponente().getCampo(), this.jugador, tablero.getOponente());
    			this.jugador.eliminarDeLaMano(carta);
    		}
    		else {
    			throw new NoSePudoInvocarElMonstruoException();    		}
    	}
    }
	
	public void colocarCarta(CartaTrampa carta,LadoCarta lado) {
		this.zonaEspeciales.colocarCarta(carta);
		carta.invocar(lado, this, tablero.getOponente().getCampo(), this.jugador,  tablero.getOponente());
		this.jugador.eliminarDeLaMano(carta);
	}

	public void colocarCarta(CartaMagica carta, LadoCarta lado) {
	    this.zonaEspeciales.colocarCarta(carta);
        carta.invocar(lado, this, tablero.getOponente().getCampo(), this.jugador,  tablero.getOponente());
		this.jugador.eliminarDeLaMano(carta);
    }

    public void colocarCarta(CartaCampo carta, LadoCarta lado){
    	this.cartaCampo = carta;
		this.jugador.eliminarDeLaMano(carta);
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

    public boolean puedoColocarCartaEspecial() {
         return zonaEspeciales.hayLugar();
    }

    public boolean puedoColocarMonstruo() {
         return zonaMonstruos.hayLugar();
    }

	public void eliminarCarta(CartaMonstruo carta) {
		this.zonaMonstruos.eliminarCarta(carta);
		this.cementerio.add(carta);
	}

	public void eliminarCarta(CartaMagica carta) {
        this.zonaEspeciales.eliminarCarta(carta);
		this.cementerio.add(carta);
	}

	public void atacarJugador(int danio) {
		this.jugador.recibirDaniosVitales(danio);
	}

	public Collection<Carta> cartasEnCementerio() {
		return this.cementerio;
	}

	public void voltearCartaTrampa() {
        if(zonaEspeciales.hayCartaTrampa()) {
        	CartaTrampa carta = zonaEspeciales.eliminarCarta();
        	//carta.invocar(new BocaArriba(),this,tablero.getCampoOponente(),this.jugador,tablero.getOponente());
        	carta.voltear();
        	this.cementerio.add(carta);
        }
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

	public int obtenerAdicionalAtkPropio(){
		if(cartaCampo != null){
			return cartaCampo.getPtsAdicionalAtkPropio();
		}
		return 0;
	}

	public int obtenerAdicionalAtkEnemigo(){
		if(cartaCampo != null){
			return cartaCampo.getPtsAdicionalAtkEnemigo();
		}
		return 0;
	}

	public int obtenerAdicionalDefPropio(){
		if(cartaCampo != null){
			return cartaCampo.getPtsAdicionalDefPropio();
		}
		return 0;
	}

	public int obtenerAdicionalDefEnemigo(){
		if(cartaCampo != null){
			return cartaCampo.getPtsAdicionalDefEnemigo();
		}
		return 0;
	}
	
	public void cambiarPosicionDeMonstruo(CartaMonstruo monstruo) {
		
		if (this.jugador.colocoEsteMonstruoEnEsteTurno(monstruo)) {        //si el monstruo fue recien colocado entonces
			throw new NoSePuedeCambiarPosicionMonstruoException();    //no se le puede cambiar la posicion
		} else {
			monstruo.cambiarPosicion();
		}
	}
	
	public void terminarTurno() {
		this.zonaMonstruos.terminarTurno();
		this.reiniciarAtaques();
		this.jugador.terminarTurno();
	}

	public CartaMonstruo obtenerUltimoMonstruoAtacado() {
		return this.ultimoMonstruoAtacado;
	}

	public void ultimoMonstruoAtacado(CartaMonstruo cartaMonstruo) {
		this.ultimoMonstruoAtacado=cartaMonstruo;
		
	}

	public boolean verificarFiltro(){
     	return this.filtroDeAtaque.estaActivo();
	}

	public void activarFiltroDeAtaque(){
     	this.filtroDeAtaque.activarFiltro();
	}

	public void desactivarFiltroDeAtaque(){
     	this.filtroDeAtaque.desactivarFiltro();
	}



}


	

