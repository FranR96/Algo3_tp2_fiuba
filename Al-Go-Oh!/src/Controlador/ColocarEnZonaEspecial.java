package Controlador;

import alGoOh.cartas.LogicaCartas.CartaEspecial;
import alGoOh.componentes.Jugador;

public class ColocarEnZonaEspecial {

    private CartaEspecial cartaEspecial;
    private Jugador jugadorActivo;
    public ColocarEnZonaEspecial(CartaEspecial cartaEspecial, Jugador jugador) {
        this.cartaEspecial = cartaEspecial;
        this.jugadorActivo = jugador;
    }

}
