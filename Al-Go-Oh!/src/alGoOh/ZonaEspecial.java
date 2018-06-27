package alGoOh;

import cartas.CartaMagica;
import cartas.CartaMagicaNoExistenteException;
import cartas.CartaTrampa;

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
            notifyObservers();
            zonaMagica.add(cartaMagica);

        }
        else {
            throw new CapacidadMaximaEnZonaEspecialesException();
        }
    }

    public void colocarCarta(CartaTrampa cartaTrampa) {
        if(this.hayLugar()) {
            notifyObservers();
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
}
