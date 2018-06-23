package alGoOh;

import cartas.CartaMonstruo;
import cartas.CartaMonstruoNoExistenteException;

import java.util.ArrayList;

public class ZonaMonstruos {
    private ArrayList<CartaMonstruo> zonaMonstruos = new ArrayList<>();

    public void colocarCarta(CartaMonstruo cartaMonstruo) {
        if (zonaMonstruos.size() < 5) {
            zonaMonstruos.add(cartaMonstruo);
        }
    }

    public void eliminarCarta(CartaMonstruo cartaMonstruo) {
        if (!this.zonaMonstruos.remove(cartaMonstruo)) {
            throw new CartaMonstruoNoExistenteException();
        }
        cartaMonstruo.getCampo().agregarAlCementerio(cartaMonstruo);
    }

    public ArrayList<CartaMonstruo> obtenerMonstruos() {
        return zonaMonstruos;
    }

    public int cantidadMonstruosEnZona() {
        return this.zonaMonstruos.size();
    }

    public void realizarSacrificios(int sacrificiosNecesarios) {

    }
}
