package alGoOh;

import static org.junit.Assert.*;

import cartas.*;
import cartasConcretas.*;
import org.junit.Test;

public class CartaMonstruoTest {

	@Test
    public void test01LaCartaMonstruoNoRequiereDeSacrificiosParaSerInvocada() {
		
		CartaMonstruo monstruo = new AbismoReluciente();
		
		int sacrificiosEsperados = 0;
		
		assertEquals(sacrificiosEsperados, monstruo.requiereSacrificio());
	}
	
	@Test
    public void test02LaCartaMonstruoRequiereUnSacrificioParaSerInvocada() {
		
		CartaMonstruo monstruo = new Ansatsu();
		
		int sacrificiosEsperados = 1;
		
		assertEquals(sacrificiosEsperados, monstruo.requiereSacrificio());
	}
	
	@Test
    public void test03LaCartaMonstruoRequiereDosSacrificiosParaSerInvocada() {
		
		CartaMonstruo monstruo = new DragonBlancoDeOjosAzules();
		
		int sacrificiosEsperados = 2;
		
		assertEquals(sacrificiosEsperados, monstruo.requiereSacrificio());
	}
	
}
