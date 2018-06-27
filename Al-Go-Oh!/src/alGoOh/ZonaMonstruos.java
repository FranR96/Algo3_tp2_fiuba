package alGoOh;

import cartas.CartaMonstruo;
import cartas.CartaMonstruoNoExistenteException;

import java.util.ArrayList;
import java.util.Observer;

public class ZonaMonstruos {
    private ArrayList<CartaMonstruo> zonaMonstruos = new ArrayList<>();
	private Campo campo;
    private ArrayList<Observer> observers;
    
    public ZonaMonstruos(Campo campo) {
    	this.campo = campo;
    	this.observers = new ArrayList<>();
    }

    public boolean colocarCarta(CartaMonstruo cartaMonstruo) {
        int sacrificiosNecesarios = cartaMonstruo.requiereSacrificio();
    	if((this.cantidadMonstruosEnZona() - sacrificiosNecesarios) < 5) {
    		if(this.realizarSacrificioPara(sacrificiosNecesarios,cartaMonstruo))
    			this.agregarCarta(cartaMonstruo);
    		    notifyObservers();
    		return true;
        }
		else
			return false;
    }

	public void agregarCarta(CartaMonstruo cartaMonstruo) {
		this.zonaMonstruos.add(cartaMonstruo);
		notifyObservers();
	}

	public boolean realizarSacrificioPara(int cantSacrificios, CartaMonstruo carta) {
        if(this.cantidadMonstruosEnZona() >= cantSacrificios) {
            ArrayList<CartaMonstruo> monstruosEnCampo = this.zonaMonstruos;
            ArrayList<CartaMonstruo> monstruosASacrificar = carta.elegirSacrificios(monstruosEnCampo);
            if(!monstruosASacrificar.isEmpty()) {
				for (CartaMonstruo aMonstruosASacrificar : monstruosASacrificar)
					this.campo.eliminarCarta(aMonstruosASacrificar);
            }
        	return true;
        }
        return false;
	}

	
    public void eliminarCarta(CartaMonstruo cartaMonstruo) {
        if (!this.zonaMonstruos.remove(cartaMonstruo)) {
            throw new CartaMonstruoNoExistenteException();
        }
        notifyObservers();
    }

    public void agregarObserver(Observer observador) {
        observers.add(observador);
    }

    private void notifyObservers() {
        for (Observer observador: observers) {
            observador.update(null, this);
        }
    }

    public ArrayList<CartaMonstruo> obtenerMonstruos() {
        return zonaMonstruos;
    }

    public int cantidadMonstruosEnZona() {
        return this.zonaMonstruos.size();
    }

	public void voltearMonstruo(CartaMonstruo cartaMonstruo) {
		zonaMonstruos.get(zonaMonstruos.indexOf(cartaMonstruo)).voltear();
	}

	public boolean hayLugar() {
        return zonaMonstruos.size() < 5;
    }

	public void terminarTurno() {
		for(CartaMonstruo monstruo : zonaMonstruos) {
			monstruo.terminarTurno();
		}
		
	}
}
