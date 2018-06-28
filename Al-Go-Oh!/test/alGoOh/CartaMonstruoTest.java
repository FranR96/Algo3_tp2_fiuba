package alGoOh;

import alGoOh.cartas.LogicaCartas.CartaMonstruo;
import alGoOh.cartas.cartasConcretas.AbismoReluciente;
import alGoOh.cartas.cartasConcretas.Ansatsu;
import alGoOh.cartas.cartasConcretas.DragonBlancoDeOjosAzules;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartaMonstruoTest {

	@Test
	void test01LaCartaMonstruoNoRequiereDeSacrificiosParaSerInvocada() {
		
		CartaMonstruo monstruo = new AbismoReluciente();
		
		int sacrificiosEsperados = 0;
		
		assertEquals(sacrificiosEsperados, monstruo.requiereSacrificio());
	}
	
	@Test
	void test02LaCartaMonstruoRequiereUnSacrificioParaSerInvocada() {
		
		CartaMonstruo monstruo = new Ansatsu();
		
		int sacrificiosEsperados = 1;
		
		assertEquals(sacrificiosEsperados, monstruo.requiereSacrificio());
	}
	
	@Test
	void test03LaCartaMonstruoRequiereDosSacrificiosParaSerInvocada() {
		
		CartaMonstruo monstruo = new DragonBlancoDeOjosAzules();
		
		int sacrificiosEsperados = 2;
		
		assertEquals(sacrificiosEsperados, monstruo.requiereSacrificio());
	}
	
}
