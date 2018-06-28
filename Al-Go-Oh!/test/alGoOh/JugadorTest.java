package alGoOh;

import org.junit.Test;

import static org.junit.Assert.*;


public class JugadorTest {
	
	@Test
	public void test01ElJugadorEmpiezaCon8000DeVida() {
		
		Jugador jugador = new Jugador();
		
		assertEquals(8000, jugador.getPtsVida());
	}
	
	@Test
	public void test02ElJugadorAlIniciarElJuegoTomaCincoCartasDelMazo() {
		
		Jugador jugador = new Jugador();
		
		jugador.obtenerManoInicial();
		
		assertEquals(5, jugador.cartasEnLaMano().size());
	}
	
	@Test
	public void test03ElJugadorAlAgarrarUnaCartaDelMazoLuegoDeObtenerLaManoInicialTieneUnaMasEnMano() {
		
		Jugador jugador = new Jugador();
		
		jugador.obtenerManoInicial();
		jugador.tomarCartaDelMazo();
		
		assertEquals(6, jugador.cartasEnLaMano().size());
	}
		
}
