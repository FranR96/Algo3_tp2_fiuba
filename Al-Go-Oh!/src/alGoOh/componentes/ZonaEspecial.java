package alGoOh.componentes;

import alGoOh.cartas.LogicaCartas.CartaEspecial;
import alGoOh.cartas.LogicaCartas.CartaMagica;
import alGoOh.cartas.LogicaCartas.CartaMagicaNoExistenteException;
import alGoOh.cartas.LogicaCartas.CartaTrampa;

import java.util.ArrayList;
import java.util.Observer;


public class ZonaEspecial{
    private ArrayList<CartaMagica> zonaMagica = new ArrayList<>();
    private ArrayList<CartaTrampa> zonaTrampa = new ArrayList<>();
	private Campo campo;
	private ArrayList<Observer> observers;

    public ZonaEspecial(Campo campo) {
    	this.campo = campo;
    	observers = new ArrayList<>();
 
    }

    public void colocarCarta(CartaMagica cartaMagica) {
        if(this.hayLugar()) {
            zonaMagica.add(cartaMagica);
            notifyObservers();

        }
        else {
            throw new CapacidadMaximaEnZonaEspecialesException();
        }
    }

    public void colocarCarta(CartaTrampa cartaTrampa) {
        if(this.hayLugar()) {
            zonaTrampa.add(cartaTrampa);
            notifyObservers();
        }
        else {
            throw new CapacidadMaximaEnZonaEspecialesException();
        }
    }

    public void eliminarCarta(CartaMagica cartaMagica) {
        if (!this.zonaMagica.remove(cartaMagica)) {
            throw new CartaMagicaNoExistenteException();
        }
        notifyObservers();
    }

    public CartaTrampa eliminarCarta() {
            notifyObservers();
            return (zonaTrampa.remove(0));
    }

    public void agregarObserver(Observer observador) {
        observers.add(observador);
    }

    private void notifyObservers() {
        for (Observer observador: observers) {
            observador.update(null, this);
        }
    }

    public boolean hayCartaTrampa() {
        return !zonaTrampa.isEmpty();
    }

    public boolean hayLugar() {
        return zonaMagica.size() + zonaTrampa.size() < 5;
    }

    public ArrayList<CartaEspecial> getCartasColocadas() {
        ArrayList<CartaEspecial> cartasColocadas = new ArrayList<>();
        cartasColocadas.addAll(zonaMagica);
        cartasColocadas.addAll(zonaTrampa);

        return cartasColocadas;
    }
}
