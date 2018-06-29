package alGoOh.efectos;

import alGoOh.Jugador;

public class EfectoDianKetoLaCuranderas extends Efecto {

	
	 @Override
	    public void aplicarEfectoSobreJugadorActivo(Jugador jugador) {
		 jugador.recibirDaniosVitales(-1000);//Suma 1000 puntos a la vida del jugador que la invoca
	 }
}
