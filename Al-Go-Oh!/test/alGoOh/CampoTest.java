package alGoOh;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cartas.*;

class CampoTest {

	@Test
	void test01ColocarCartaMonstruoEnPoscicionAtaqueYPuedaAtacar() {
		
		Campo campo = new Campo();
		
		CartaMonstruo abismoReluciente = new AbismoReluciente();
		
		CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
		
		campo.colocarCarta(abismoReluciente,new PosicionAtaque(),new BocaArriba());
		huevoMonstruoso.invocar(new PosicionAtaque(),new BocaArriba(),campo);
		
	}
	
	@Test
	void test02ColocarCartaMonstruoEnPosicionDefensaYNoPuedeAtacar() {
		Campo campo = new Campo();
		
		CartaMonstruo abismoReluciente = new AbismoReluciente();
		
		CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
		
		campo.colocarCarta(abismoReluciente,new PosicionDefensa(),new BocaArriba());
		huevoMonstruoso.invocar(new PosicionAtaque(),new BocaArriba(),campo);
		

	}

	@Test 
	void test03ColocarCartaMagicaBocaAbajoYNoActiveNingunEfecto() {
		Campo campo = new Campo();
		
		CartaEspecial agujeroNegro = new AgujeroNegro();
		CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
		
		campo.colocarCarta(huevoMonstruoso, new PosicionAtaque(), new BocaArriba());
		campo.colocarCarta(agujeroNegro, new BocaAbajo());
		
		assertEquals(1,campo.getZonaMonstruos().size());
		
		
	}
}


