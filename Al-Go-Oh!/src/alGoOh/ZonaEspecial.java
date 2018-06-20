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

    }

    public void eliminarCarta(CartaTrampa cartaTrampa) {
        if (!zonaTrampa.isEmpty()) {
            zonaTrampa.remove(0); // Las cartas trampa se activan de izq a der
        }
        else {
            throw new CartaTrampaNoExistenteException();
        }
    }

    public void voltearCartaTrampa() {
        if (!zonaTrampa.isEmpty()) {
            zonaTrampa.get(0).Voltear();
        }
    }

    public void voltearCartaMagica(CartaMagica cartaMagica) {
        if (zonaMagica.contains(cartaMagica)) {
            zonaMagica.get(zonaMagica.indexOf(cartaMagica)).Voltear();
        }
        else {
            throw new CartaMagicaNoExistenteException(); // Tiene sentido esta excepcion?, en que escenario se puede lanzar?
        }
    }
}
