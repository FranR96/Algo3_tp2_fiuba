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
		huevoMonstruoso.invocar(new PosicionAtaque(),new BocaArriba());
		
		assertThrows(MonstruoEstaMuertoException.class,
				()->{
					abismoReluciente.atacar(huevoMonstruoso);
				});
	}
	
	@Test
	void test02ColocarCartaMonstruoEnPosicionDefensaYNoPuedeAtacar() {
		Campo campo = new Campo();
		
		CartaMonstruo abismoReluciente = new AbismoReluciente();
		
		CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
		
		campo.colocarCarta(abismoReluciente,new PosicionDefensa(),new BocaArriba());
		huevoMonstruoso.invocar(new PosicionAtaque(),new BocaArriba());
		
		assertThrows(MonstruoNoPuedeAtacarEstaEnPosicionDefensaException.class,
				()->{
					abismoReluciente.atacar(huevoMonstruoso);
				});
		
	}

	@Test 
	void test03ColocarCartaMagicaBocaAbajoYNoActiveNingunEfecto() {
		
	}
}


