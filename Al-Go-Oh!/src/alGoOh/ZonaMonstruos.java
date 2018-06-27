package alGoOh;

import cartas.CartaMonstruo;
import cartas.CartaMonstruoNoExistenteException;

import java.util.ArrayList;

public class ZonaMonstruos {
    private ArrayList<CartaMonstruo> zonaMonstruos = new ArrayList<>();
	private Campo campo;
    
    
    public ZonaMonstruos(Campo campo) {
    	this.campo = campo;
    }

    public boolean colocarCarta(CartaMonstruo cartaMonstruo) {
        int sacrificiosNecesarios = cartaMonstruo.requiereSacrificio();
    	if((this.cantidadMonstruosEnZona() - sacrificiosNecesarios) < 5) {
    		if(this.realizarSacrificioPara(sacrificiosNecesarios,cartaMonstruo))
    			this.agregarCarta(cartaMonstruo);
    		return true;
        }
		else
			return false;
    }

	public void agregarCarta(CartaMonstruo cartaMonstruo) {
		this.zonaMonstruos.add(cartaMonstruo);
	}

	public boolean realizarSacrificioPara(int cantSacrificios, CartaMonstruo carta) {
        if(this.cantidadMonstruosEnZona() >= cantSacrificios) {
            ArrayList<CartaMonstruo> monstruosEnCampo = this.zonaMonstruos;
            ArrayList<CartaMonstruo> monstruosASacrificar = carta.elegirSacrificios(monstruosEnCampo);
            if(!monstruosASacrificar.isEmpty()) {
				for (CartaMonstruo aMonstruosASacrificar : monstruosASacrificar)
					this.campo.eliminarMonstruo(aMonstruosASacrificar);
            }
        	return true;
        }
        return false;
	}

	
    public void eliminarCarta(CartaMonstruo cartaMonstruo) {
        if (!this.zonaMonstruos.remove(cartaMonstruo)) {
            throw new CartaMonstruoNoExistenteException();
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
}
