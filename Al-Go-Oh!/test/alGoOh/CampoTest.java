package alGoOh;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import cartas.*;

import java.util.Collection;

class CampoTest {

	@Test
	void test01ColocarCartaMonstruoEnPoscicionAtaqueYPuedaAtacar() {
		
		Campo campo = new Campo();
		CartaMonstruo abismoReluciente = new AbismoReluciente();
		campo.colocarCarta(abismoReluciente, new PosicionAtaque(),new BocaArriba());

		assertTrue(abismoReluciente.enPosicionDeAtaque());
	}

	@Test
	void test02ColocarCartaMonstruoEnPosicionDefensaYNoPuedeAtacar() {
		Campo campo = new Campo();

		CartaMonstruo abismoReluciente = new AbismoReluciente();
		CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();

		campo.colocarCarta(abismoReluciente, new PosicionDefensa(), new BocaArriba());

		assertThrows(MonstruoNoPuedeAtacarEstaEnPosicionDefensaException.class,
				()-> abismoReluciente.atacar(huevoMonstruoso));

	}

	@Test
	void test03ColocarCartaTrampaBocaAbajo(){
		Campo campo = new Campo();
		CartaTrampa cilindroMagico = new CilindroMagico();

		campo.colocarCarta(cilindroMagico, new BocaAbajo());

		assertTrue(cilindroMagico.estaBocaAbajo());
	}
	
	@Test
	void test04ColocoUnMonstruoYLuegoColocoUnMonstruoQueRequiereUnSacrificioElPrimeroNoEstaYElUltimoSi() {
		Campo campo = new Campo();
		
		CartaMonstruo abismoReluciente = new AbismoReluciente();
		campo.colocarCarta(abismoReluciente, new PosicionAtaque(), new BocaArriba());
		
		CartaMonstruo maldicionDeDragon = new MaldicionDeDragon();
		campo.colocarCarta(maldicionDeDragon, new PosicionAtaque(), new BocaArriba());
		
		Collection<Carta> cementerio = campo.cartasEnCementerio();
		
		assertTrue(cementerio.contains(abismoReluciente));
		
		Collection<CartaMonstruo> zonaMonstruosInvocados = campo.monstruosInvocados();
		
		assertTrue(zonaMonstruosInvocados.contains(maldicionDeDragon));

	}
	
	@Test 
	void test05ColocoDosMonstruosYLuegoColocoUnMonstruoQueRequiereDosSacrificiosAmbosNoEstanYElUltimoSi() {
		Campo campo = new Campo();
		
		CartaMonstruo abismoReluciente = new AbismoReluciente();
		campo.colocarCarta(abismoReluciente, new PosicionAtaque(), new BocaArriba());
		
		CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
		campo.colocarCarta(huevoMonstruoso,new PosicionAtaque(), new BocaArriba());
		
		CartaMonstruo dragonBlancoDeOjosAzules = new DragonBlancoDeOjosAzules();
		campo.colocarCarta(dragonBlancoDeOjosAzules, new PosicionAtaque(), new BocaArriba());
		
		Collection<Carta> cementerio = campo.cartasEnCementerio();
		
		assertTrue(cementerio.contains(abismoReluciente));
		assertTrue(cementerio.contains(huevoMonstruoso));
		
		Collection<CartaMonstruo> zonaMonstruosInvocados = campo.monstruosInvocados();
		
		assertTrue(zonaMonstruosInvocados.contains(dragonBlancoDeOjosAzules));

	}

	
	@Test
	void test06ColocoMasDeCincoCartasEspecialesBocaAbajoYMeSaltaUnaExcepcion() {
		Campo campo = new Campo();
		
		for(int i = 0; i<5;i++) {
			CartaMagica agujeroNegro = new AgujeroNegro();
			campo.colocarCarta(agujeroNegro, new BocaAbajo());
		}
		assertThrows(CapacidadMaximaEnZonaEspecialesException.class,
				()->{
					CartaMagica agujeroNegro = new AgujeroNegro();
					campo.colocarCarta(agujeroNegro, new BocaAbajo());
				});
		
	}
	
	@Test
	void test07ColocoMasDeCincoCartasMonstruosYMeSaltaUnaExcepcion() {

		Campo campo = new Campo();
		
		for(int i = 0; i<5;i++) {
			CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
			campo.colocarCarta(huevoMonstruoso,new PosicionAtaque(), new BocaAbajo());
		}
		assertThrows(CapacidadMaximaEnZonaMonstruosException.class,
				()->{
					CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
					campo.colocarCarta(huevoMonstruoso,new PosicionAtaque(), new BocaAbajo());
				});
	}
	
	@Test
	void test08TengoLaZonaDeMonstruosCompletaPeroQuieroInvocarAUnMonstruoQueRequiereSacrificioYPuedo() {
		Campo campo = new Campo();
		
		for(int i = 0; i<5;i++) {
			CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
			campo.colocarCarta(huevoMonstruoso,new PosicionAtaque(), new BocaAbajo());
		}
		
		CartaMonstruo maldicionDeDragon = new MaldicionDeDragon();
		campo.colocarCarta(maldicionDeDragon,new PosicionAtaque(),new BocaArriba());
		
		assertTrue(campo.monstruosInvocados().contains(maldicionDeDragon));
	}


	@Test
	void test09ColocoOllaDeLaCodiciaBocaArribaYObtengoDosCartasDelMazo() {
		Campo campo = new Campo();
		
		Jugador jugador = new Jugador();
		
		campo.setJugador(jugador);
		
		campo.colocarCarta(new OllaDeLaCodicia(), new BocaArriba());
		
		assertEquals(jugador.cartasEnLaMano().size(),2);
	}
	
	@Test
	void test10Invoco3DragonesBlancosYLuegoLosSacrificoParaInvocarAlDragonDefinitivo() {
		
		Campo campo = new Campo();
				
		//cada dragon requiere otros dos sacrificios para invocarlos
		campo.colocarCarta(new DragonBlancoDeOjosAzules(), new PosicionAtaque(), new BocaArriba());
		campo.colocarCarta(new DragonBlancoDeOjosAzules(), new PosicionAtaque(), new BocaArriba());
		campo.colocarCarta(new DragonBlancoDeOjosAzules(), new PosicionAtaque(), new BocaArriba());
		
		CartaMonstruo dragonDefinitivo = new DragonDefinitivoDeOjosAzules();
		campo.colocarCarta(dragonDefinitivo, new PosicionAtaque(), new BocaArriba());
		
		assertEquals(campo.monstruosInvocados().size(),1);
		
		assertTrue(campo.monstruosInvocados().contains(dragonDefinitivo));
	}
	
	@Test
	void test11ExtraigoTodasLasCartasDelMazoYVerificoQueElJugadorPierde() {
		
		Campo campo = new Campo();
		
		Jugador jugador = new Jugador();
		
		campo.setJugador(jugador);
		
		for(int i=0; i<40; i++)
			jugador.tomarCartaDelMazo();
		
		//
	}
}


