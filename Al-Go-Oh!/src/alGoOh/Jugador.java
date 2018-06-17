package alGoOh;

public class Jugador {

	private int puntosVida = 8000;
	private Campo campo;


	public void recibirDaniosVitales(int danio) {
		if(puntosVida <= 0) {
			throw new PartidaFinalizadaException();
		}
		puntosVida -=danio;
	}

	public int getPtsVida() {
		return puntosVida;
	}

	public void setCampo(Campo campo) {
		this.campo =campo ;
		
	}
	
}
