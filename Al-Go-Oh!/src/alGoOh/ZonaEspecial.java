package alGoOh;

import cartas.*;

import java.util.ArrayList;


public class ZonaEspecial{
    private ArrayList<CartaMagica> zonaMagica = new ArrayList<>();
    private ArrayList<CartaTrampa> zonaTrampa = new ArrayList<>();
	private Campo campo;

    public ZonaEspecial(Campo campo) {
    	this.campo = campo;
 
    }

    public void colocarCarta(CartaMagica cartaMagica) {
        if(this.hayLugar()) {
            zonaMagica.add(cartaMagica);
        }
        else {
            throw new CapacidadMaximaEnZonaEspecialesException();
        }
    }

    public void colocarCarta(CartaTrampa cartaTrampa) {
        if(this.hayLugar()) {
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

    public CartaTrampa eliminarCarta() {
            return (zonaTrampa.remove(0));
    }

    public boolean hayCartaTrampa() {
        return !zonaTrampa.isEmpty();
    }

    public boolean hayLugar() {
        return zonaMagica.size() + zonaTrampa.size() < 5;
    }
}
