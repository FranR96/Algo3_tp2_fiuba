package efectos;

import alGoOh.Campo;
import alGoOh.Jugador;
import cartasConcretas.ExodiaCompleto;

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
