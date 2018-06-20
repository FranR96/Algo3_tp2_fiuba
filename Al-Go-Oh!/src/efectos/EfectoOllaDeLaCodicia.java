package efectos;

import alGoOh.Jugador;

public class EfectoOllaDeLaCodicia extends Efecto {

    @Override
    public void aplicarEfectoSobreJugadorActivo(Jugador jugador) {

        for(int i=0; i<2; i++) {
            jugador.tomarCartaDelMazo();
        }
    }

}