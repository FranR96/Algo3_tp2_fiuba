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
		Campo campo1 = tablero.getCampo1();
		Campo campo2  = tablero.getCampo2();
		
		CartaMonstruo monstruo1 = new HuevoMonstruoso();
		CartaMonstruo monstruo2 = new AbismoReluciente();
		campo1.colocarCarta(monstruo1,new PosicionAtaque(),new BocaArriba());
		campo2.colocarCarta(monstruo2,new PosicionAtaque(),new BocaArriba());
		
		monstruo2.atacar(monstruo1);
		Collection<Carta> cementerio=campo1.cartasEnCementerio();
		
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
		Campo campo1 = tablero.getCampo1();
		Campo campo2  = tablero.getCampo2();
		
		CartaMonstruo monstruo2 = new HuevoMonstruoso();
		CartaMonstruo monstruo1 = new AbismoReluciente();
		campo1.colocarCarta(monstruo1,new PosicionAtaque(),new BocaArriba());
		campo2.colocarCarta(monstruo2,new PosicionAtaque(),new BocaArriba());
		
		monstruo2.atacar(monstruo1);
		Collection<Carta> cementerio= campo2.cartasEnCementerio();
		
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
		Campo campo1 = tablero.getCampo1();
		Campo campo2  = tablero.getCampo2();
		
		
		CartaMonstruo monstruo2 = new AbismoReluciente();
		CartaMonstruo monstruo1 = new AbismoReluciente();
		campo1.colocarCarta(monstruo1,new PosicionAtaque(),new BocaArriba());
		campo2.colocarCarta(monstruo2,new PosicionAtaque(),new BocaArriba());
	
		monstruo2.atacar(monstruo1);
		Collection<Carta> cementerio2= campo2.cartasEnCementerio();
		Collection<Carta> cementerio1= campo1.cartasEnCementerio();
		
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
		Campo campo1 = tablero.getCampo1();
		Campo campo2  = tablero.getCampo2();
		
		
		CartaMonstruo monstruo1 = new HuevoMonstruoso();
		CartaMonstruo monstruo2 = new AbismoReluciente();
		campo1.colocarCarta(monstruo1,new PosicionDefensa(),new BocaArriba());
		campo2.colocarCarta(monstruo2,new PosicionAtaque(),new BocaArriba());
		
		monstruo2.atacar(monstruo1);
		Collection<Carta> cementerioJugador1 =campo1.cartasEnCementerio();
		
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
		
		Campo campo1= tablero.getCampo1();
		Campo campo2= tablero.getCampo2();
		campo1.colocarCarta(monstruo1, new PosicionDefensa(), new BocaArriba());
		campo2.colocarCarta(monstruo2, new PosicionAtaque(), new BocaArriba());
		
		monstruo2.atacar(monstruo1);
		Collection<Carta> cementerioJugador1 = campo1.cartasEnCementerio();
		
		assertFalse(cementerioJugador1.contains(monstruo1));
		
		int ptsDeVidaEsperados = 8000;
		
		assertEquals(ptsDeVidaEsperados,jugador1.getPtsVida());
		
	}
	
	@Test
	void test06ColocoUnMonstruoPorCadaLadoYLuegoLaCartaAgujeroNegroBocaArribaTodosLosMonstruosFueronDestruidosPeroNadieRecibeDanioVital() {
		Tablero tablero = Tablero.getInstance();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		tablero.inicializarTablero(jugador1, jugador2);
		Campo campo1= tablero.getCampo1();
		Campo campo2= tablero.getCampo2();
		
		CartaMonstruo monstruo1 = new AbismoReluciente();
		CartaMonstruo monstruo2 = new HuevoMonstruoso();
		campo1.colocarCarta(monstruo1, new PosicionAtaque(), new BocaArriba());
		campo2.colocarCarta(monstruo2, new PosicionDefensa(), new BocaArriba());
		
		CartaMagica agujeroNegro = new AgujeroNegro();
		campo1.colocarCarta(agujeroNegro, new BocaArriba());

		Collection<CartaMonstruo> zonaMonstruosJugador1 = campo1.monstruosInvocados();
		Collection<CartaMonstruo> zonaMonstruosJugador2 = campo2.monstruosInvocados();

		assertEquals(0,zonaMonstruosJugador1.size());
		assertEquals(0,zonaMonstruosJugador2.size());
		
		int ptsDeVidaEsperados = 8000;
		
		assertEquals(ptsDeVidaEsperados,jugador1.getPtsVida());
		assertEquals(ptsDeVidaEsperados,jugador2.getPtsVida());
	}
	
	@Test
	void test07ColocarCartaMagicaBocaAbajoYNoActiveNingunEfecto() {
		Tablero tablero = Tablero.getInstance();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		tablero.inicializarTablero(jugador1, jugador2);
		Campo campo1 = tablero.getCampo1();
		Campo campo2= tablero.getCampo2();

		CartaMonstruo monstruo1 = new AbismoReluciente();
		CartaMonstruo monstruo2 = new HuevoMonstruoso();
		campo1.colocarCarta(monstruo1, new PosicionAtaque(), new BocaArriba());
		campo2.colocarCarta(monstruo2, new PosicionDefensa(), new BocaArriba());

		CartaMagica agujeroNegro = new AgujeroNegro();
		campo1.colocarCarta(agujeroNegro, new BocaAbajo());

		Collection<CartaMonstruo> zonaMonstruosJugador1 = tablero.getCampo1().monstruosInvocados();
		Collection<CartaMonstruo> zonaMonstruosJugador2 = tablero.getCampo2().monstruosInvocados();

		assertEquals(1,zonaMonstruosJugador1.size());
		assertEquals(1,zonaMonstruosJugador2.size());
	}

	@Test
	void test08MandarCartaAlCementerio(){
		Tablero tablero = Tablero.getInstance();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		tablero.inicializarTablero(jugador1, jugador2);
		Campo campo1= tablero.getCampo1();
		Campo campo2 = tablero.getCampo2();
		
		CartaMonstruo monstruo1 = new AbismoReluciente();
		CartaMonstruo monstruo2 = new HuevoMonstruoso();
		campo1.colocarCarta(monstruo1, new PosicionAtaque(), new BocaArriba());
		campo2.colocarCarta(monstruo2, new PosicionAtaque(), new BocaArriba());

		monstruo1.atacar(monstruo2);
		Collection<Carta> cementerioJugador2 = tablero.getCampo2().cartasEnCementerio();

		assertTrue(cementerioJugador2.contains(monstruo2));
	}
	
	@Test
	void test09ColocarDosCartasEnCampoEnemigoYCartaFisuraDestruyeAlDeMenorAtaque() {
		Tablero tablero = Tablero.getInstance();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		tablero.inicializarTablero(jugador1, jugador2);
		Campo campo1= tablero.getCampo1();
		Campo campo2 = tablero.getCampo2();
		
		CartaMonstruo abismoReluciente = new AbismoReluciente();
		CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
		campo1.colocarCarta(abismoReluciente, new PosicionAtaque(), new BocaArriba());
		campo1.colocarCarta(huevoMonstruoso, new PosicionAtaque(), new BocaArriba());
	
		CartaEspecial fisura = new Fisura();
		campo2.colocarCarta(fisura, new BocaArriba());
		
		Collection<Carta> cementerioJugador1 = campo1.cartasEnCementerio();

		assertTrue(cementerioJugador1.contains(huevoMonstruoso));

	}
}
