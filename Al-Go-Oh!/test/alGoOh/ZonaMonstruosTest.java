package alGoOh;

import static org.junit.Assert.*;


import cartasConcretas.*;
import cartas.*;
import org.junit.Test;

public class ZonaMonstruosTest {

	@Test
	public void test01LaZonaDeMonstruosEmpiezaVacia() {
		
		ZonaMonstruos zona = new ZonaMonstruos(new Campo());
		
		assertEquals(0, zona.cantidadMonstruosEnZona());
	}
	
	@Test
	public void test02AlColocarUnMonstruoLaZonaYaNoEstaVacia() {
		
		ZonaMonstruos zona = new ZonaMonstruos(new Campo());
		CartaMonstruo monstruo = new HuevoMonstruoso();
		
		zona.colocarCarta(monstruo);
		
		assertEquals(1, zona.cantidadMonstruosEnZona());
	}
	
	@Test
	public void test03ColocarUnMonstruoEnLaZonaYVerQueEstaAhi() {
		
		ZonaMonstruos zona = new ZonaMonstruos(new Campo());
		CartaMonstruo monstruo = new HuevoMonstruoso();
		
		zona.colocarCarta(monstruo);
		
		assertTrue(zona.obtenerMonstruos().contains(monstruo));
	}
	
	@Test
	public void test04SeColocaUnMonstruoYLuegoEsEliminada() {
		
		ZonaMonstruos zona = new ZonaMonstruos(new Campo());
		CartaMonstruo monstruo = new HuevoMonstruoso();
		
		zona.colocarCarta(monstruo);
		zona.eliminarCarta(monstruo);
		
		assertEquals(0, zona.cantidadMonstruosEnZona());
	}
	
	@Test
	public void test05NoSePuedeEliminarUnMonstruoQueNoHaSidoColocadoEnLaZona() {
		
		ZonaMonstruos zona = new ZonaMonstruos(new Campo());
		CartaMonstruo monstruo1 = new HuevoMonstruoso();
		CartaMonstruo monstruo2 = new AbismoReluciente();
		
		zona.colocarCarta(monstruo1);

		boolean error = false;

		try{
			zona.eliminarCarta(monstruo2);
		}catch(CartaMonstruoNoExistenteException e){
			error = true;
		}

		assertTrue(error);

	}
	
}
