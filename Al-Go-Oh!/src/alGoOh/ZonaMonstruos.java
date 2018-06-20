package alGoOh;

import cartas.CartaMonstruo;
import cartas.CartaMonstruoNoExistenteException;

import java.util.ArrayList;

public class ZonaMonstruos {
    private ArrayList<CartaMonstruo> zonaMonstruos = new ArrayList<>();

    public void colocarCarta(CartaMonstruo cartaMonstruo) {
        if (zonaMonstruos.size() < 5) { // Falta chequear lo de los sacrificios e invocar
            zonaMonstruos.add(cartaMonstruo);
        }
    }

    public void elminarCarta(CartaMonstruo cartaMonstruo) {
        if (!this.zonaMonstruos.remove(cartaMonstruo)) {
            throw new CartaMonstruoNoExistenteException();
        }
    }

	public int size() {
		return zonaMonstruos.size();
	}
}
