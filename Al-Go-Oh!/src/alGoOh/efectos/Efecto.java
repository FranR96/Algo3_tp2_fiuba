package alGoOh.efectos;

import alGoOh.cartas.cartasConcretas.ExodiaCompleto;
import alGoOh.componentes.Campo;
import alGoOh.componentes.Jugador;

public abstract class Efecto {

    public void aplicarEfectoSobreCampoActivo(Campo campo){
    }

    public void aplicarEfectoSobreJugadorActivo(Jugador jugador){
    }

    public void aplicarEfectoSobreCampoOponente(Campo campo){
    }

    public void aplicarEfectoSobreJugadorOponente(Jugador jugador){
    }

    public void aplicarEfectoExodia(ExodiaCompleto exodia) {
    }
}
