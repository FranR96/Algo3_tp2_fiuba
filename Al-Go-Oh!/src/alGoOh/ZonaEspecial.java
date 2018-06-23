package alGoOh;

import cartas.*;

import java.util.ArrayList;


public class ZonaEspecial{
    private ArrayList<CartaMagica> zonaMagica = new ArrayList<>();
    private ArrayList<CartaTrampa> zonaTrampa = new ArrayList<>();


    public void colocarCarta(CartaMagica cartaMagica) {
        if(zonaMagica.size() + zonaTrampa.size() < 5) {
            zonaMagica.add(cartaMagica);
        }
        else {
            throw new CapacidadMaximaEnZonaEspecialesException();
        }
    }

    public void colocarCarta(CartaTrampa cartaTrampa) {
        if(zonaMagica.size() + zonaTrampa.size() < 5) {
            zonaTrampa.add(cartaTrampa);
        }
        else {
            throw new CapacidadMaximaEnZonaEspecialesException();
        }
    }

    public void eliminarCarta(CartaMagica cartaMagica) {
        if (!this.zonaMagica.remove(cartaMagica)) {
            throw new CartaMagicaNoExistenteException();
        }
        cartaMagica.getCampo().agregarAlCementerio(cartaMagica);

    }

    public void eliminarCarta(CartaTrampa cartaTrampa) {
        if(!this.zonaTrampa.remove(cartaTrampa)){
            throw new CartaTrampaNoExistenteException();
        }
        cartaTrampa.getCampo().agregarAlCementerio(cartaTrampa);
    }

    public void voltearCartaTrampa() {
        if (!zonaTrampa.isEmpty()) {
            CartaTrampa carta = zonaTrampa.remove(0);
            carta.getCampo().colocarCarta(carta, new BocaArriba());
        }
    }

    public void voltearCartaMagica(CartaMagica cartaMagica) {
    	zonaMagica.get(zonaMagica.indexOf(cartaMagica)).getCampo().colocarCarta(cartaMagica, new BocaArriba());
    }
}
