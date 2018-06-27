package alGoOh;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Collection;
import org.junit.jupiter.api.Test;
import cartas.*;
import cartasConcretas.*;

public class TableroTest {

	@Test
	void test01ColocarUnaCartaEnPosicionAtaqueYElOponenteColocaOtraDeMayorAtaqueYEsteGanaAplicandoDanioAlPrimerJugador() {
	
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
	void test02ColocarCartaEnPosicionAtaqueDeMayorPuntajeQueLaQueColocaElOponenteYEsteRecibeElDanioDelAtaque() {
		
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
	void test03CadaJugadorColocaCartasConMismosPuntosDeAtaqueYSeDestruyenLasDosPeroNoRecibenDanios() {
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
		Collection<Carta> cementerioOponente= oponente.getCampo().cartasEnCementerio();
		
		assertFalse(cementerioJugadorActivo.contains(monstruo1));
		assertTrue(cementerioOponente.contains(monstruo2));
		
		int ptsDeVidaEsperados = 8000;
		
		assertEquals(ptsDeVidaEsperados,activo.getPtsVida());
		
		ptsDeVidaEsperados = 8000 - 1200;
				
		assertEquals(ptsDeVidaEsperados,oponente.getPtsVida());
		
	}

	@Test
	void test06MandarCartaAlCementerio(){

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
	void test07ColocarUnaCartaMonstruoEnCadaCampoYLuegoCartaWastelandYVerificarQueSeRealizanLosIncrementos() {
		
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		Jugador oponente = tablero.getOponente();
		
		CartaMonstruo abismoReluciente = new AbismoReluciente();
		CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
		activo.getCampo().colocarCarta(huevoMonstruoso, new PosicionAtaque(), new BocaArriba());
		oponente.getCampo().colocarCarta(abismoReluciente, new PosicionDefensa(), new BocaArriba());
		
		CartaCampo wasteland = new Wasteland();
		activo.getCampo().colocarCarta(wasteland, new BocaArriba());

		huevoMonstruoso.atacar(abismoReluciente);
		int ptsDeVidaEsperados = 8000 - (1800-600);

		assertEquals(ptsDeVidaEsperados, activo.getPtsVida());
	}
	
	@Test 
	void test08ColocarUnaCartaMonstruoEnCadaLadoElOponenteColocaWastelandYVerificoLosIncrementos() {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		Jugador oponente = tablero.getOponente();
		
		CartaMonstruo abismoReluciente = new AbismoReluciente();
		CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
		activo.getCampo().colocarCarta(huevoMonstruoso, new PosicionAtaque(), new BocaArriba());
		oponente.getCampo().colocarCarta(abismoReluciente, new PosicionDefensa(), new BocaArriba());
		
		CartaCampo wasteland = new Wasteland();
		oponente.getCampo().colocarCarta(wasteland, new BocaArriba());

		huevoMonstruoso.atacar(abismoReluciente);
		int ptsDeVidaEsperados = 8000 - ((1800+300)-(600+200));

		assertEquals(ptsDeVidaEsperados, activo.getPtsVida());
	}
	
	@Test
	void test09ColocarUnaCartaMonstruoEnCadaCampoYLuegoCartaSogenYVerificarQueSeRealizanLosIncrementos() {
		
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		Jugador oponente = tablero.getOponente();
		
		CartaMonstruo abismoReluciente = new AbismoReluciente();
		CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
		activo.getCampo().colocarCarta(abismoReluciente, new PosicionAtaque(), new BocaArriba());
		oponente.getCampo().colocarCarta(huevoMonstruoso, new PosicionAtaque(), new BocaArriba());
		
		CartaCampo sogen = new Sogen();
		activo.getCampo().colocarCarta(sogen, new BocaArriba());
		abismoReluciente.atacar(huevoMonstruoso);

		int ptsDeVidaEsperados = 8000 - ((1600+500) - (600));

		assertEquals(ptsDeVidaEsperados, oponente.getPtsVida());
	}
	
	@Test
	void test10ColocarUnaCartaMonstruoEnCadaCampoYLuegoElOponentePoneLaCartaSogenYVerificarQueSeRealizanLosIncrementos() {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		Jugador oponente = tablero.getOponente();
		
		CartaMonstruo abismoReluciente = new AbismoReluciente();
		CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
		activo.getCampo().colocarCarta(abismoReluciente, new PosicionDefensa(), new BocaArriba());
		oponente.getCampo().colocarCarta(huevoMonstruoso, new PosicionAtaque(), new BocaArriba());
		
		CartaCampo sogen = new Sogen();
		oponente.getCampo().colocarCarta(sogen, new BocaArriba());
		huevoMonstruoso.atacar(abismoReluciente);

		int ptsDeVidaEsperados = 8000 - ((1800+200) - (600+500));

		assertEquals(ptsDeVidaEsperados, oponente.getPtsVida());
	}
}
