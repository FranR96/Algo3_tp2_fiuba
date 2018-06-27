package alGoOh;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import cartas.*;
import cartasConcretas.*;

public class CartaMonstruoTest {

	@Test
	void test01LaCartaMonstruoRecienCreadaTienePtsDeAtaqueDefensaYEstrellas() {
		
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		
		CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
		activo.getCampo().colocarCarta(huevoMonstruoso, new PosicionAtaque(), new BocaArriba());
		
		assertEquals(600, huevoMonstruoso.getPtsAtaque());
		assertEquals(900, huevoMonstruoso.getPtsDefensa());
		assertEquals(3, huevoMonstruoso.getEstrellas());
	}
	
	@Test
	void test02LaCartaMonstruoNoRequiereDeSacrificiosParaSerInvocada() {
		
		CartaMonstruo monstruo = new AbismoReluciente();
		
		int sacrificiosEsperados = 0;
		
		assertEquals(sacrificiosEsperados, monstruo.requiereSacrificio());
	}
	
	@Test
	void test03LaCartaMonstruoRequiereUnSacrificioParaSerInvocada() {
		
		CartaMonstruo monstruo = new Ansatsu();
		
		int sacrificiosEsperados = 1;
		
		assertEquals(sacrificiosEsperados, monstruo.requiereSacrificio());
	}
	
	@Test
	void test04LaCartaMonstruoRequiereDosSacrificiosParaSerInvocada() {
		
		CartaMonstruo monstruo = new DragonBlancoDeOjosAzules();
		
		int sacrificiosEsperados = 2;
		
		assertEquals(sacrificiosEsperados, monstruo.requiereSacrificio());
	}
	
}
