package alGoOh;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Collection;
import org.junit.jupiter.api.Test;
import cartas.*;

class TableroTest {

	@Test
	void test01ColocarUnaCartaEnPosicionAtaqueYElOponenteColoqueOtraDeMayorAtaqueYEsteGanaAplicandoDanioAlOtroJugador() {
	
		Tablero tablero = Tablero.getInstance();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		tablero.inicializarTablero(jugador1, jugador2);
		
		CartaMonstruo monstruo1 = new HuevoMonstruoso();
		CartaMonstruo monstruo2 = new AbismoReluciente();
		tablero.colocarCartaEnCampoJugador1(monstruo1,new PosicionAtaque(),new BocaArriba());
		tablero.colocarCartaEnCampoJugador2(monstruo2,new PosicionAtaque(),new BocaArriba());
		
		tablero.atacarACon(monstruo1, monstruo2);
		Collection<Carta> cementerio= tablero.getCampo1().cartasEnCementerio();
		
		assertTrue(cementerio.contains(monstruo1));
		
		int ptsDeVidaEsperados = 8000-(1600-600);
		
		assertEquals(ptsDeVidaEsperados,jugador1.getPtsVida());
	}
	
	@Test
	void test02ColocarCartaEnPosicionAtaqueDeMayorPuntajeQueLaQueColocaElOponenteYEsteRecibeElDanio() {
		
		Tablero tablero = Tablero.getInstance();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		tablero.inicializarTablero(jugador1, jugador2);
		
		CartaMonstruo monstruo2 = new HuevoMonstruoso();
		CartaMonstruo monstruo1 = new AbismoReluciente();
		tablero.colocarCartaEnCampoJugador1(monstruo1,new PosicionAtaque(),new BocaArriba());
		tablero.colocarCartaEnCampoJugador2(monstruo2,new PosicionAtaque(),new BocaArriba());
		
		tablero.atacarACon(monstruo1, monstruo2);
		Collection<Carta> cementerio= tablero.getCampo2().cartasEnCementerio();
		
		assertTrue(cementerio.contains(monstruo2));
		
		int ptsDeVidaEsperados = 8000 -(1600-600);
	
		assertEquals(ptsDeVidaEsperados,jugador2.getPtsVida());
	}
	
	@Test
	void test03CadaJugadorColocaCartasConMismosPuntosYSeDestruyenLasDosPeroNoRecibenDanios() {
		Tablero tablero = Tablero.getInstance();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		tablero.inicializarTablero(jugador1, jugador2);
		
		CartaMonstruo monstruo2 = new AbismoReluciente();
		CartaMonstruo monstruo1 = new AbismoReluciente();
		tablero.colocarCartaEnCampoJugador1(monstruo1,new PosicionAtaque(),new BocaArriba());
		tablero.colocarCartaEnCampoJugador2(monstruo2,new PosicionAtaque(),new BocaArriba());
	
		tablero.atacarACon(monstruo1, monstruo2);
		Collection<Carta> cementerio2= tablero.getCampo2().cartasEnCementerio();
		Collection<Carta> cementerio1= tablero.getCampo1().cartasEnCementerio();
		
		assertTrue(cementerio2.contains(monstruo2));
		assertTrue(cementerio1.contains(monstruo1));
		
		int ptsDeVidaEsperados = 8000;
		
		assertEquals(ptsDeVidaEsperados,jugador2.getPtsVida());
		assertEquals(ptsDeVidaEsperados,jugador1.getPtsVida());

	}
	
	@Test 
	void test04ColocarCartaEnDefensaYRivalColocaCartaEnPosicionAtaqueConMayorPuntajeYSeDestruyeElPrimerMonstruoSinRecibirDanioVital() {
		Tablero tablero = Tablero.getInstance();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		tablero.inicializarTablero(jugador1, jugador2);
		
		CartaMonstruo monstruo1 = new HuevoMonstruoso();
		CartaMonstruo monstruo2 = new AbismoReluciente();
		tablero.colocarCartaEnCampoJugador1(monstruo1, new PosicionDefensa(), new BocaArriba());
		tablero.colocarCartaEnCampoJugador2(monstruo2, new PosicionAtaque(), new BocaArriba());
		
		tablero.atacarACon(monstruo1, monstruo2);
		Collection<Carta> cementerioJugador1 = tablero.getCampo1().cartasEnCementerio();
		
		assertTrue(cementerioJugador1.contains(monstruo1));
		
		int ptsDeVidaEsperados = 8000;
		
		assertEquals(ptsDeVidaEsperados,jugador1.getPtsVida());
		
	}
	
	@Test 
	void test05ColocarCartaEnDefensaYRivalColocaCartaEnPosicionAtaqueConMenorPuntajeNoSeDestruyeElPrimerMonstruoNiRecibeDanioVital() {
		Tablero tablero = Tablero.getInstance();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		tablero.inicializarTablero(jugador1, jugador2);
		
		CartaMonstruo monstruo1 = new AbismoReluciente();
		CartaMonstruo monstruo2 = new HuevoMonstruoso();
		tablero.colocarCartaEnCampoJugador1(monstruo1, new PosicionDefensa(), new BocaArriba());
		tablero.colocarCartaEnCampoJugador2(monstruo2, new PosicionAtaque(), new BocaArriba());
		
		tablero.atacarACon(monstruo1, monstruo2);
		Collection<Carta> cementerioJugador1 = tablero.getCampo1().cartasEnCementerio();
		
		assertFalse(cementerioJugador1.contains(monstruo1));
		
		int ptsDeVidaEsperados = 8000;
		
		assertEquals(ptsDeVidaEsperados,jugador1.getPtsVida());
		
	}
	
	@Test //Este test va a Campo Test
	void test0ColocoUnMonstruoYLuegoColocoUnMonstruoQueRequiereUnSacrificioElPrimeroNoEstaYElUltimoSi() {
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
	
	@Test //Este test va a Campo Test
	void test0ColocoDosMonstruosYLuegoColocoUnMonstruoQueRequiereDosSacrificiosAmbosNoEstanYElUltimoSi() {
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
	void test06ColocoUnMonstruoPorCadaLadoYLuegoLaCartaAgujeroNegroBocaArribaTodosLosMonstruosFueronDestruidosPeroNadieRecibeDanioVital() {
		Tablero tablero = Tablero.getInstance();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		tablero.inicializarTablero(jugador1, jugador2);
		
		CartaMonstruo monstruo1 = new AbismoReluciente();
		CartaMonstruo monstruo2 = new HuevoMonstruoso();
		tablero.colocarCartaEnCampoJugador1(monstruo1, new PosicionAtaque(), new BocaArriba());
		tablero.colocarCartaEnCampoJugador2(monstruo2, new PosicionDefensa(), new BocaArriba());
		
		CartaMagica agujeroNegro = new AgujeroNegro();
		tablero.colocarCartaEnCampoJugador1(agujeroNegro, new BocaArriba());

		Collection<CartaMonstruo> zonaMonstruosJugador1 = tablero.getCampo1().monstruosInvocados();
		Collection<CartaMonstruo> zonaMonstruosJugador2 = tablero.getCampo2().monstruosInvocados();

		
		assertEquals(0,zonaMonstruosJugador1.size());
		assertEquals(0,zonaMonstruosJugador2.size());
		
		int ptsDeVidaEsperados = 8000;
		
		assertEquals(ptsDeVidaEsperados,jugador1.getPtsVida());
		assertEquals(ptsDeVidaEsperados,jugador2.getPtsVida());
	}
	
}
