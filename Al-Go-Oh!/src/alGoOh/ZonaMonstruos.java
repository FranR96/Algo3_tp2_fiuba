package alGoOh;

import cartas.Carta;
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

    public void eliminarCarta(CartaMonstruo cartaMonstruo) {
        if (!this.zonaMonstruos.remove(cartaMonstruo)) {
            throw new CartaMonstruoNoExistenteException();
        }
    }

    public ArrayList<CartaMonstruo> obtenerMonstruos() {
        return (ArrayList<CartaMonstruo>) zonaMonstruos.clone();
    }

    public int cantidadMonstruosEnZona() {
        return this.zonaMonstruos.size();
    }

    public void voltearMonstruo(CartaMonstruo cartaMonstruo) {
        cartaMonstruo.voltear();
    }

    public void realizarSacrificios(int sacrificiosNecesarios) {

    }
}
