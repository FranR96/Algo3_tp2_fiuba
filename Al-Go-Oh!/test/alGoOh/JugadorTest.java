package alGoOh;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class JugadorTest {
	
	@Test
	void test01ElJugadorEmpiezaCon8000DeVida() {
		
		Jugador jugador = new Jugador();
		
		assertEquals(8000, jugador.getPtsVida());
	}
	
	@Test
	void test02ElJugadorAlIniciarElJuegoTomaCincoCartasDelMazo() {
		
		Jugador jugador = new Jugador();
		
		jugador.obtenerManoInicial();
		
		assertEquals(5, jugador.cartasEnLaMano().size());
	}
	
	@Test
	void test03ElJugadorAlAgarrarUnaCartaDelMazoLuegoDeObtenerLaManoInicialTieneUnaMasEnMano() {
		
		Jugador jugador = new Jugador();
		
		jugador.obtenerManoInicial();
		jugador.tomarCartaDelMazo();
		
		assertEquals(6, jugador.cartasEnLaMano().size());
	}
		
}
