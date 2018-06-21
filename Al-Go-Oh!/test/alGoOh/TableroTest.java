package alGoOh;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Collection;
import org.junit.jupiter.api.Test;
import cartas.*;
import cartasConcretas.*;

class TableroTest {

	@Test
	void test01ColocarUnaCartaEnPosicionAtaqueYElOponenteColocaOtraDeMayorAtaqueYEsteGanaAplicandoDanioAlOtroJugador() {
	
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		Jugador oponente = tablero.getOponente();
		
		CartaMonstruo monstruo1 = new HuevoMonstruoso();
		CartaMonstruo monstruo2 = new AbismoReluciente();
		activo.getCampo().colocarCarta(monstruo1,new PosicionAtaque(),new BocaArriba());
		oponente.getCampo().colocarCarta(monstruo2,new PosicionAtaque(),new BocaArriba());
		
		monstruo2.atacar(monstruo1);
		Collection<Carta> cementerio=activo.getCampo().cartasEnCementerio();
		
		assertTrue(cementerio.contains(monstruo1));
		
		int ptsDeVidaEsperados = 8000-(1600-600);
		
		assertEquals(ptsDeVidaEsperados,activo.getPtsVida());
	}
	
	@Test
	void test02ColocarCartaEnPosicionAtaqueDeMayorPuntajeQueLaQueColocaElOponenteYEsteRecibeElDanio() {
		
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		Jugador oponente = tablero.getOponente();
		
		CartaMonstruo monstruo2 = new HuevoMonstruoso();
		CartaMonstruo monstruo1 = new AbismoReluciente();
		activo.getCampo().colocarCarta(monstruo1,new PosicionAtaque(),new BocaArriba());
		oponente.getCampo().colocarCarta(monstruo2,new PosicionAtaque(),new BocaArriba());
		
		monstruo2.atacar(monstruo1);
		Collection<Carta> cementerio= oponente.getCampo().cartasEnCementerio();
		
		assertTrue(cementerio.contains(monstruo2));
		
		int ptsDeVidaEsperados = 8000 -(1600-600);
	
		assertEquals(ptsDeVidaEsperados,oponente.getPtsVida());
	}
	
	@Test
	void test03CadaJugadorColocaCartasConMismosPuntosYSeDestruyenLasDosPeroNoRecibenDanios() {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		Jugador oponente = tablero.getOponente();
		
		
		CartaMonstruo monstruo2 = new AbismoReluciente();
		CartaMonstruo monstruo1 = new AbismoReluciente();
		activo.getCampo().colocarCarta(monstruo1,new PosicionAtaque(),new BocaArriba());
		oponente.getCampo().colocarCarta(monstruo2,new PosicionAtaque(),new BocaArriba());
	
		monstruo2.atacar(monstruo1);
		Collection<Carta> cementerio2= oponente.getCampo().cartasEnCementerio();
		Collection<Carta> cementerio1= activo.getCampo().cartasEnCementerio();
		
		assertTrue(cementerio2.contains(monstruo2));
		assertTrue(cementerio1.contains(monstruo1));
		
		int ptsDeVidaEsperados = 8000;
		
		assertEquals(ptsDeVidaEsperados,activo.getPtsVida());
		assertEquals(ptsDeVidaEsperados,oponente.getPtsVida());

	}
	
	@Test 
	void test04ColocarCartaEnDefensaYOponenteColocaCartaEnPosicionAtaqueConMayorPuntajeYSeDestruyeElPrimerMonstruoSinRecibirDanioVital() {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		Jugador oponente = tablero.getOponente();
		
		CartaMonstruo monstruo1 = new HuevoMonstruoso();
		CartaMonstruo monstruo2 = new AbismoReluciente();
		activo.getCampo().colocarCarta(monstruo1,new PosicionDefensa(),new BocaArriba());
		oponente.getCampo().colocarCarta(monstruo2,new PosicionAtaque(),new BocaArriba());
		
		monstruo2.atacar(monstruo1);
		Collection<Carta> cementerioJugadorActivo =activo.getCampo().cartasEnCementerio();
		
		assertTrue(cementerioJugadorActivo.contains(monstruo1));
		
		int ptsDeVidaEsperados = 8000;
		
		assertEquals(ptsDeVidaEsperados,activo.getPtsVida());
		
	}
	
	@Test 
	void test05ColocarCartaEnDefensaYOponenteColocaCartaEnPosicionAtaqueConMenorPuntajeNoSeDestruyeElPrimerMonstruoNiRecibeDanioVital() {
		
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		Jugador oponente = tablero.getOponente();
		
		CartaMonstruo monstruo1 = new AbismoReluciente();
		CartaMonstruo monstruo2 = new HuevoMonstruoso();
		

		activo.getCampo().colocarCarta(monstruo1, new PosicionDefensa(), new BocaArriba());
		oponente.getCampo().colocarCarta(monstruo2, new PosicionAtaque(), new BocaArriba());
		
		monstruo2.atacar(monstruo1);
		Collection<Carta> cementerioJugadorActivo = activo.getCampo().cartasEnCementerio();
		
		assertFalse(cementerioJugadorActivo.contains(monstruo1));
		
		int ptsDeVidaEsperados = 8000;
		
		assertEquals(ptsDeVidaEsperados,activo.getPtsVida());
		
	}
	
	@Test
	void test06ColocoUnMonstruoPorCadaLadoYLuegoLaCartaAgujeroNegroBocaArribaTodosLosMonstruosFueronDestruidosPeroNadieRecibeDanioVital() {
		
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		Jugador oponente = tablero.getOponente();
		
		CartaMonstruo monstruo1 = new AbismoReluciente();
		CartaMonstruo monstruo2 = new HuevoMonstruoso();
		activo.getCampo().colocarCarta(monstruo1, new PosicionAtaque(), new BocaArriba());
		oponente.getCampo().colocarCarta(monstruo2, new PosicionDefensa(), new BocaArriba());
		
		CartaMagica agujeroNegro = new AgujeroNegro();
		activo.getCampo().colocarCarta(agujeroNegro,new BocaArriba());

		Collection<CartaMonstruo> zonaMonstruosActivo = activo.getCampo().monstruosInvocados();
		Collection<CartaMonstruo> zonaMonstruosOponente = oponente.getCampo().monstruosInvocados();

		assertEquals(0,zonaMonstruosActivo.size());
		assertEquals(0,zonaMonstruosOponente.size());
		
		int ptsDeVidaEsperados = 8000;
		
		assertEquals(ptsDeVidaEsperados,activo.getPtsVida());
		assertEquals(ptsDeVidaEsperados,oponente.getPtsVida());
	}
	
	@Test
	void test07ColocarCartaMagicaBocaAbajoYNoActiveNingunEfecto() {

		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		Jugador oponente = tablero.getOponente();
		
		CartaMonstruo monstruo1 = new AbismoReluciente();
		CartaMonstruo monstruo2 = new HuevoMonstruoso();
		activo.getCampo().colocarCarta(monstruo1, new PosicionAtaque(), new BocaArriba());
		oponente.getCampo().colocarCarta(monstruo2, new PosicionDefensa(), new BocaArriba());

		CartaMagica agujeroNegro = new AgujeroNegro();
		activo.getCampo().colocarCarta(agujeroNegro, new BocaAbajo());

		Collection<CartaMonstruo> zonaMonstruosActivo = activo.getCampo().monstruosInvocados();
		Collection<CartaMonstruo> zonaMonstruosOponente = oponente.getCampo().monstruosInvocados();
		
		assertEquals(1,zonaMonstruosActivo.size());
		assertEquals(1,zonaMonstruosOponente.size());
	}

	@Test
	void test08MandarCartaAlCementerio(){

		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		Jugador oponente = tablero.getOponente();
		
		CartaMonstruo monstruo1 = new AbismoReluciente();
		CartaMonstruo monstruo2 = new HuevoMonstruoso();
		activo.getCampo().colocarCarta(monstruo1, new PosicionAtaque(), new BocaArriba());
		oponente.getCampo().colocarCarta(monstruo2, new PosicionAtaque(), new BocaArriba());

		monstruo1.atacar(monstruo2);
		Collection<Carta> cementerioOponente = oponente.getCampo().cartasEnCementerio();

		assertTrue(cementerioOponente.contains(monstruo2));
	}
	
	@Test
	void test09ColocarDosCartasEnCampoEnemigoYCartaFisuraDestruyeAlDeMenorAtaque() {
	
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		Jugador oponente = tablero.getOponente();
		
		CartaMonstruo abismoReluciente = new AbismoReluciente();
		CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
		oponente.getCampo().colocarCarta(abismoReluciente, new PosicionAtaque(), new BocaArriba());
		oponente.getCampo().colocarCarta(huevoMonstruoso, new PosicionAtaque(), new BocaArriba());
	
		CartaTrampa fisura = new Fisura();
		activo.getCampo().colocarCarta(fisura, new BocaArriba());
		
		Collection<Carta> cementerioOponente = oponente.getCampo().cartasEnCementerio();

		assertTrue(cementerioOponente.contains(huevoMonstruoso));

	}
}
