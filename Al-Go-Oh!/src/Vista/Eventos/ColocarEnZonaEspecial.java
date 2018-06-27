package Vista.Eventos;

import alGoOh.Jugador;
import cartas.CartaEspecial;

public class ColocarEnZonaEspecial {

    private CartaEspecial cartaEspecial;
    private Jugador jugadorActivo;
    public ColocarEnZonaEspecial(CartaEspecial cartaEspecial, Jugador jugador) {
        this.cartaEspecial = cartaEspecial;
        this.jugadorActivo = jugador;
    }

}
