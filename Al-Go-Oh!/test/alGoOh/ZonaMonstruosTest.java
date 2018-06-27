package alGoOh;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import cartasConcretas.*;
import cartas.*;

public class ZonaMonstruosTest {

	@Test
	void test01LaZonaDeMonstruosEmpiezaVacia() {
		
		ZonaMonstruos zona = new ZonaMonstruos(new Campo());
		
		assertEquals(0, zona.cantidadMonstruosEnZona());
	}
	
	@Test
	void test02AlColocarUnMonstruoLaZonaYaNoEstaVacia() {
		
		ZonaMonstruos zona = new ZonaMonstruos(new Campo());
		CartaMonstruo monstruo = new HuevoMonstruoso();
		
		zona.colocarCarta(monstruo);
		
		assertEquals(1, zona.cantidadMonstruosEnZona());
	}
	
	@Test
	void test03ColocarUnMonstruoEnLaZonaYVerQueEstaAhi() {
		
		ZonaMonstruos zona = new ZonaMonstruos(new Campo());
		CartaMonstruo monstruo = new HuevoMonstruoso();
		
		zona.colocarCarta(monstruo);
		
		assertTrue(zona.obtenerMonstruos().contains(monstruo));
	}
	
	@Test
	void test04SeColocaUnMonstruoYLuegoEsEliminada() {
		
		ZonaMonstruos zona = new ZonaMonstruos(new Campo());
		CartaMonstruo monstruo = new HuevoMonstruoso();
		
		zona.colocarCarta(monstruo);
		zona.eliminarCarta(monstruo);
		
		assertEquals(0, zona.cantidadMonstruosEnZona());
	}
	
	@Test
	void test05NoSePuedeEliminarUnMonstruoQueNoHaSidoColocadoEnLaZona() {
		
		ZonaMonstruos zona = new ZonaMonstruos(new Campo());
		CartaMonstruo monstruo1 = new HuevoMonstruoso();
		CartaMonstruo monstruo2 = new AbismoReluciente();
		
		zona.colocarCarta(monstruo1);
		
		assertThrows(CartaMonstruoNoExistenteException.class,
				()-> zona.eliminarCarta(monstruo2) );	
	}
	
}
