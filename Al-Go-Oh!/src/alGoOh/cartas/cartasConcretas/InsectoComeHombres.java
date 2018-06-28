package alGoOh.cartas.cartasConcretas;

import alGoOh.cartas.LogicaCartas.BocaArriba;
import alGoOh.cartas.LogicaCartas.CartaMonstruo;
import alGoOh.componentes.Campo;
import alGoOh.componentes.Jugador;
import alGoOh.efectos.EfectoInsectoComeHombres;

public class InsectoComeHombres extends CartaMonstruo {
	
	private Campo campoEnemigo;
	
	public InsectoComeHombres() {
		super(450,600,2, new EfectoInsectoComeHombres());
	}
	
	@Override
	public void voltear() {
		if(this.estaBocaAbajo()) {
			campoEnemigo= this.getCampoEnemigo();
			this.lado = new BocaArriba();
			this.efecto.aplicarEfectoSobreCampoOponente(campoEnemigo);
		}
	}
	
	@Override
	public void aplicarEfecto(Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente){
		this.campoEnemigo = campoEnemigo;
		this.voltear();
		
	}
	
	public int resetPtsAtaque() {
		return 450;
	}
	
	public int resetPtsDefensa() {
		return 600;
	}
}
