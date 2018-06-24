package cartas;

import alGoOh.*;
import efectos.Efecto;

public abstract class CartaMonstruo extends Carta{
	
	private int ptsAtaque;
	private int ptsDefensa;
	private int estrellas;
	private PosicionCarta posicion;
	
	
	public CartaMonstruo(int ataque,int defensa, int estrellas,Efecto efecto) {
		this.ptsAtaque= ataque;
		this.ptsDefensa= defensa;
		this.estrellas = estrellas;
		this.efecto = efecto;
	}

    public int requiereSacrificio(){
        if(this.estrellas >= 5 && this.estrellas<10) { //Requiere sacrificio
            return ((this.estrellas-1)/3);
        }
        if(this.estrellas >= 10) {
        	return 2;
        }
        return 0;
    }

    public void invocar(PosicionCarta posicion,LadoCarta lado,Campo campo, Campo campoEnemigo, Jugador activo, Jugador oponente) {
        this.posicion= posicion;
        this.lado = lado;
        this.posicion.setCarta(this);
        this.lado.setCarta(this);
        this.campo= campo;
        this.lado.invocar(campo, campoEnemigo, activo, oponente);
    }
	
	public void atacar(CartaMonstruo monstruo) {
		this.voltear();
		campo.atacoEnTurno(this);
		this.posicion.atacar(this,monstruo);
	}
	
	public int recibirDanio(int danio) {
		this.voltear();
		return (this.posicion.recibirDanio(danio));
	}

	public int getPtsAtaque() {
		return this.ptsAtaque;
	}
	
	public int getPtsDefensa() {
		return this.ptsDefensa;
	}
	
	public int getEstrellas() {
		return this.estrellas;
	}
	
	public boolean enPosicionDeAtaque(){
		return this.posicion instanceof PosicionAtaque;
	}
	
	public void setPtsAtaque(int ptsAtaque) {
		this.ptsAtaque = ptsAtaque;
	}
	
	public void setPtsDefensa(int ptsDefensa) {
		this.ptsDefensa = ptsDefensa;
	}


}
