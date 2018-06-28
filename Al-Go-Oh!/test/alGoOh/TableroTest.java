package alGoOh;

import alGoOh.cartas.LogicaCartas.*;
import alGoOh.cartas.cartasConcretas.AbismoReluciente;
import alGoOh.cartas.cartasConcretas.HuevoMonstruoso;
import alGoOh.cartas.cartasConcretas.Sogen;
import alGoOh.cartas.cartasConcretas.Wasteland;
import alGoOh.componentes.EstaCartaYaAtacoException;
import alGoOh.componentes.Jugador;
import alGoOh.componentes.Tablero;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

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
	
		@Test
	void test11ColocarUnMonstruoEnCadaCampoYVerificarQueUnMonstruoNoPuedeAtacarDosVecesEnUnMismoTurno() {
		
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		Jugador oponente = tablero.getOponente();
		
		CartaMonstruo monstruo1 = new AbismoReluciente();
		CartaMonstruo monstruo2 = new HuevoMonstruoso();
		activo.getCampo().colocarCarta(monstruo1, new PosicionAtaque(), new BocaArriba());
		oponente.getCampo().colocarCarta(monstruo2, new PosicionAtaque(), new BocaArriba());
		
		monstruo1.atacar(monstruo2);
		
		assertThrows(EstaCartaYaAtacoException.class,
				()-> monstruo1.atacar(monstruo2) );
		
	}
	
	@Test
	void test12AlIniciarElJuegoCadaJugadorObtiene5CartasEnSuMano() {
		
		Tablero tablero = Tablero.getInstance();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		tablero.inicializarTablero(jugador1, jugador2);
		
		assertEquals(5, jugador1.cartasEnLaMano().size());
		assertEquals(5, jugador2.cartasEnLaMano().size());
	}
	
	@Test
	void test13AlFinalizarTurnoElJugadorActivoPasaASerElOponenteYViceversa() {
		
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador jugador1 = tablero.getJugadorActivo();
		Jugador jugador2 = tablero.getOponente();
		
		tablero.terminarTurno();
		
		assertEquals(jugador2, tablero.getJugadorActivo());
		assertEquals(jugador1, tablero.getOponente());
	}
}
