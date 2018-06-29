package alGoOh;

import static org.junit.Assert.*;
import java.util.Collection;


import cartas.*;
import cartasConcretas.*;

import org.junit.Test;


public class EfectoTest {
	
	@Test
	public void test01ColocoUnMonstruoPorCadaLadoYLuegoLaCartaAgujeroNegroBocaArribaTodosLosMonstruosFueronDestruidosPeroNadieRecibeDanioVital() {
		
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
	public void test02ColocarCartaMagicaBocaAbajoYNoActiveNingunEfecto() {

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
	public void test03ColocarDosCartasEnCampoEnemigoYCartaFisuraDestruyeAlDeMenorAtaque() {
	
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		Jugador oponente = tablero.getOponente();
		
		CartaMonstruo abismoReluciente = new AbismoReluciente();
		CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
		oponente.getCampo().colocarCarta(abismoReluciente, new PosicionAtaque(), new BocaArriba());
		
		tablero.terminarTurno();
		tablero.terminarTurno();
		
		oponente.getCampo().colocarCarta(huevoMonstruoso, new PosicionAtaque(), new BocaArriba());
	
		CartaMagica fisura = new Fisura();
		activo.getCampo().colocarCarta(fisura, new BocaArriba());
		
		Collection<Carta> cementerioOponente = oponente.getCampo().cartasEnCementerio();

		assertTrue(cementerioOponente.contains(huevoMonstruoso));

	}
	
	@Test
	public void test04ColocarJinzo7YUnMonstruoEnCampoOponenteAtacarYVerificarQueSeDanioAlJugadorOponente() {
		
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		Jugador oponente = tablero.getOponente();
		
		CartaMonstruo jinzo7 = new Jinzo7();
		CartaMonstruo abismoReluciente = new AbismoReluciente();
		activo.getCampo().colocarCarta(jinzo7, new PosicionAtaque(), new BocaArriba());
		oponente.getCampo().colocarCarta(abismoReluciente, new PosicionAtaque(), new BocaArriba());
		
		jinzo7.atacar(abismoReluciente);
		
		int ptsDeVidaEsperados = 8000 - 500;
		
		assertEquals(ptsDeVidaEsperados, oponente.getPtsVida());
	}
	
	@Test
	public void test05ColocoInsectoComeHombresBocaAbajoYLuegoDeSerAtacadoDestruyeElMonstruoEnemigo() {
		
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		Jugador oponente = tablero.getOponente();
		
		CartaMonstruo insectoComeHombres = new InsectoComeHombres();
		CartaMonstruo abismoReluciente = new AbismoReluciente();
		activo.getCampo().colocarCarta(insectoComeHombres, new PosicionDefensa(), new BocaAbajo());
		oponente.getCampo().colocarCarta(abismoReluciente, new PosicionAtaque(), new BocaArriba());
		
		abismoReluciente.atacar(insectoComeHombres);
		
		Collection<Carta> cementerioOponente = oponente.getCampo().cartasEnCementerio();

		assertTrue(cementerioOponente.contains(abismoReluciente));
	}
	
	@Test
	public void test06ColocoInsectoComeHombreBocaArribaYLuegoDeSerAtacadoNoAplicaSuEfecto() {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		Jugador oponente = tablero.getOponente();
		
		CartaMonstruo insectoComeHombres = new InsectoComeHombres();
		CartaMonstruo abismoReluciente = new AbismoReluciente();
		activo.getCampo().colocarCarta(insectoComeHombres, new PosicionDefensa(), new BocaArriba());
		oponente.getCampo().colocarCarta(abismoReluciente, new PosicionAtaque(), new BocaArriba());
		
		abismoReluciente.atacar(insectoComeHombres);
		
		Collection<Carta> cementerioOponente = oponente.getCampo().cartasEnCementerio();

		assertFalse(cementerioOponente.contains(abismoReluciente));

	}
	
	@Test
	public void test07ColocoUnMonstruoEnCadaCampoYLuegoLaCartaReinforcementsCuandoElEnemigoAtacaSeActivaLaTrampaYVerQueAplicaElEfecto() {
		
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		Jugador oponente = tablero.getOponente();
		
		CartaMonstruo monstruo1 = new AbismoReluciente();
		CartaMonstruo monstruo2 = new DragonDeAlexandrita();
		activo.getCampo().colocarCarta(monstruo1, new PosicionAtaque(), new BocaArriba());
		oponente.getCampo().colocarCarta(monstruo2, new PosicionAtaque(), new BocaArriba());
		
		CartaTrampa reinforcements = new Reinforcements();
		activo.getCampo().colocarCarta(reinforcements, new BocaAbajo());
		
		monstruo2.atacar(monstruo1);
		
		int ptsDeVidaEsperados = 8000 - 100;
		
		assertEquals(ptsDeVidaEsperados, oponente.getPtsVida());
		tablero.terminarTurno();
		
		assertEquals(monstruo1.getPtsAtaque(),1600);
		
	}
	
	@Test
	public void test08ColocoUnMonstruoEnemigoYColocoCilindroMagicoEnMiCampoLuegoElMonstruoEnemigoAtacaYVerQueSeAplicaElEfecto() {

		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		Jugador oponente = tablero.getOponente();
		
		CartaMonstruo abismoReluciente = new AbismoReluciente();
		oponente.getCampo().colocarCarta(abismoReluciente, new PosicionAtaque(), new BocaArriba());
		
		CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
		CartaTrampa cilindroMagico = new CilindroMagico();
		activo.getCampo().colocarCarta(cilindroMagico, new BocaAbajo());
		activo.getCampo().colocarCarta(huevoMonstruoso, new PosicionAtaque(), new BocaAbajo());
	
		abismoReluciente.atacar(huevoMonstruoso);
		
		int ptsDeVidaEsperados = 8000-1600;
		
		assertEquals(ptsDeVidaEsperados,oponente.getPtsVida());

		Collection<CartaMonstruo> zonaMonstruosActivo = oponente.getCampo().monstruosInvocados();

		assertEquals(1, zonaMonstruosActivo.size());

	}
	
	@Test
	public void test09ColocoOllaDeLaCodiciaBocaArribaYObtengoDosCartasDelMazo() {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
						
		activo.getCampo().colocarCarta(new OllaDeLaCodicia(), new BocaArriba());
		
		assertEquals(activo.cartasEnLaMano().size(),7);
	}
	
	@Test
	public void test10ColocoDianKetoLaCuranderaYLosPuntosDeVidaAumentan1000() {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
						
		activo.getCampo().colocarCarta(new DianKetoLaCurandera(), new BocaArriba());
		
		assertEquals(activo.getPtsVida(),9000);
	}
	
	@Test
	public void test11ColocoJustDessertsBocaAbajoYElOponenteRecibe500DeDanioVitalPorCadaMonstruoInvocado() {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		Jugador oponente = tablero.getOponente();
		
		CartaMonstruo abismoReluciente = new AbismoReluciente();
		oponente.getCampo().colocarCarta(abismoReluciente, new PosicionAtaque(), new BocaArriba());
		
		CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
		CartaTrampa justDesserts = new JustDesserts();
		activo.getCampo().colocarCarta(justDesserts, new BocaAbajo());
		
		tablero.terminarTurno();
		tablero.terminarTurno();
		
		activo.getCampo().colocarCarta(huevoMonstruoso, new PosicionAtaque(), new BocaAbajo());
	
		CartaMonstruo abismoReluciente2 = new AbismoReluciente();
		oponente.getCampo().colocarCarta(abismoReluciente2, new PosicionAtaque(), new BocaArriba());
		abismoReluciente.atacar(huevoMonstruoso);
		
		int ptsDeVidaEsperados =8000-1000;
		assertEquals(ptsDeVidaEsperados, oponente.getPtsVida());
	}
	@Test
	public void test12JugadorActivoAgarraTodasLasPartesDeExodiaEnLaManoYGanaElJuego() {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		
		activo.cartasEnLaMano().add(new Exodia());
		activo.cartasEnLaMano().add(new BrazoDerechoExodia());
		activo.cartasEnLaMano().add(new BrazoIzquierdoExodia());
		activo.cartasEnLaMano().add(new PiernaDerechaExodia());
		activo.cartasEnLaMano().add(new PiernaIzquierdaExodia());
				
		tablero.terminarTurno();
		assertEquals(activo,tablero.hayGanador());
	}
}
