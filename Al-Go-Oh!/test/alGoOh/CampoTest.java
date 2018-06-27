package alGoOh;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import cartas.*;
import cartasConcretas.*;

import java.util.Collection;

class CampoTest {
	
	@Test
	void test01ColocarCartaMonstruoEnPosicionDefensaYNoPuedeAtacar() {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		
		CartaMonstruo abismoReluciente = new AbismoReluciente();
		CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();

		activo.getCampo().colocarCarta(abismoReluciente, new PosicionDefensa(), new BocaArriba());

		assertThrows(MonstruoNoPuedeAtacarEstaEnPosicionDefensaException.class,
				()-> abismoReluciente.atacar(huevoMonstruoso));

	}

	@Test
	void test02ColocarCartaTrampaBocaAbajo(){
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();

		CartaTrampa cilindroMagico = new CilindroMagico();

		activo.getCampo().colocarCarta(cilindroMagico, new BocaAbajo());

		assertTrue(cilindroMagico.estaBocaAbajo());
	}
	
	@Test
	void test03ColocoUnMonstruoYLuegoColocoMaldicionDeDragonQueRequiereUnSacrificioElPrimeroNoEstaYElUltimoSi() {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		
		CartaMonstruo abismoReluciente = new AbismoReluciente();
		activo.getCampo().colocarCarta(abismoReluciente, new PosicionAtaque(), new BocaArriba());
		
		tablero.terminarTurno();
		tablero.terminarTurno();
		
		CartaMonstruo maldicionDeDragon = new MaldicionDeDragon();
		activo.getCampo().colocarCarta(maldicionDeDragon, new PosicionAtaque(), new BocaArriba());
		
		Collection<Carta> cementerio = activo.getCampo().cartasEnCementerio();
		
		assertTrue(cementerio.contains(abismoReluciente));
		
		Collection<CartaMonstruo> zonaMonstruosInvocados = activo.getCampo().monstruosInvocados();
		
		assertTrue(zonaMonstruosInvocados.contains(maldicionDeDragon));

	}
	
	@Test 
	void test04ColocoDosMonstruosYLuegoColocoDragonBlancoDeOjosAzulesQueRequiereDosSacrificiosAmbosNoEstanYElUltimoSi() {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		
		CartaMonstruo abismoReluciente = new AbismoReluciente();
		activo.getCampo().colocarCarta(abismoReluciente, new PosicionAtaque(), new BocaArriba());
		
		tablero.terminarTurno();
		tablero.terminarTurno();
		
		CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
		activo.getCampo().colocarCarta(huevoMonstruoso,new PosicionAtaque(), new BocaArriba());
		
		tablero.terminarTurno();
		tablero.terminarTurno();
		
		CartaMonstruo dragonBlancoDeOjosAzules = new DragonBlancoDeOjosAzules();
		activo.getCampo().colocarCarta(dragonBlancoDeOjosAzules, new PosicionAtaque(), new BocaArriba());
		
		Collection<Carta> cementerio = activo.getCampo().cartasEnCementerio();
		
		assertTrue(cementerio.contains(abismoReluciente));
		assertTrue(cementerio.contains(huevoMonstruoso));
		
		Collection<CartaMonstruo> zonaMonstruosInvocados = activo.getCampo().monstruosInvocados();
		
		assertTrue(zonaMonstruosInvocados.contains(dragonBlancoDeOjosAzules));

	}
	

	
	@Test
	void test05ColocoMasDeCincoCartasEspecialesBocaAbajoYMeSaltaUnaExcepcion() {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		
		for(int i = 0; i<5;i++) {
			CartaMagica agujeroNegro = new AgujeroNegro();
			activo.getCampo().colocarCarta(agujeroNegro, new BocaAbajo());
		}
		assertThrows(CapacidadMaximaEnZonaEspecialesException.class,
				()->{
					CartaMagica agujeroNegro = new AgujeroNegro();
					activo.getCampo().colocarCarta(agujeroNegro, new BocaAbajo());
				});
		
	}
	
	@Test
	void test06ColocoMasDeCincoCartasMonstruosYMeSaltaUnaExcepcion() {

		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();

		
		for(int i = 0; i<5;i++) {
			CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
			activo.getCampo().colocarCarta(huevoMonstruoso,new PosicionAtaque(), new BocaAbajo());
			tablero.terminarTurno();
			tablero.terminarTurno();
		}
		assertThrows(NoSePudoInvocarElMonstruoException.class,
				()->{
					CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
					activo.getCampo().colocarCarta(huevoMonstruoso,new PosicionAtaque(), new BocaAbajo());
				});
	}
	
	@Test
	void test07TengoLaZonaDeMonstruosCompletaPeroQuieroInvocarAUnMonstruoQueRequiereSacrificioYPuedo() {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();

		
		for(int i = 0; i<5;i++) {
			CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
			activo.getCampo().colocarCarta(huevoMonstruoso,new PosicionAtaque(), new BocaAbajo());
			tablero.terminarTurno();
			tablero.terminarTurno();
		}
		
		CartaMonstruo maldicionDeDragon = new MaldicionDeDragon();
		activo.getCampo().colocarCarta(maldicionDeDragon,new PosicionAtaque(),new BocaArriba());
		
		assertTrue(activo.getCampo().monstruosInvocados().contains(maldicionDeDragon));
	}
	
	@Test
	void test08Invoco3DragonesBlancosYLuegoLosSacrificoParaInvocarAlDragonDefinitivo() {
		
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		
		
		activo.getCampo().getZonaMonstruos().agregarCarta(new DragonBlancoDeOjosAzules());
		activo.getCampo().getZonaMonstruos().agregarCarta(new DragonBlancoDeOjosAzules());
		activo.getCampo().getZonaMonstruos().agregarCarta(new DragonBlancoDeOjosAzules());

		CartaMonstruo dragonDefinitivo = new DragonDefinitivoDeOjosAzules();
		activo.getCampo().colocarCarta(dragonDefinitivo, new PosicionAtaque(), new BocaArriba());
		
		assertEquals(activo.getCampo().monstruosInvocados().size(),1);
		
		assertTrue(activo.getCampo().monstruosInvocados().contains(dragonDefinitivo));
	}
	
	@Test
	void test09ExtraigoTodasLasCartasDelMazoYVerificoQueElJugadorPierde() {
		
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();		
		Jugador oponente = tablero.getOponente();
		
		while(activo.tieneCartasEnMazo()) {
			activo.tomarCartaDelMazo();
			activo.cartasEnLaMano().clear();
		}
		
		assertEquals(oponente,tablero.hayGanador());
	}
	
	@Test
	void test10SoloSePuedeInvocarUnMonstruoPorTurno() {
		
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		
		activo.getCampo().colocarCarta(new HuevoMonstruoso(),new PosicionAtaque(), new BocaAbajo());
		
		assertThrows(YaSeHaInvocadoMonstruoEnTurnoException.class,
				()->{ 
					activo.getCampo().colocarCarta(new AbismoReluciente(),new PosicionAtaque(), new BocaAbajo());
				});
	}
	
	@Test
	void test11NoSePuedeCambiarLaPosicionDelMonstruoRecienColocado() {
		
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		
		CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
		activo.getCampo().colocarCarta(huevoMonstruoso,new PosicionAtaque(), new BocaArriba());
		
		assertThrows(NoSePuedeCambiarPosicionMonstruoException.class,
				()-> activo.getCampo().cambiarPosicionDeMonstruo(huevoMonstruoso) );
	}
	
	@Test
	void test12ColocarUnMonstruoEnAtaqueLuegoCambiarSuPosicionYVerificarQueNoPuedoAtacar() {
		
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		Jugador oponente = tablero.getOponente();
		
		CartaMonstruo monstruo1 = new AbismoReluciente();
		CartaMonstruo monstruo2 = new HuevoMonstruoso();
		activo.getCampo().colocarCarta(monstruo1, new PosicionAtaque(), new BocaArriba());
		oponente.getCampo().colocarCarta(monstruo2, new PosicionDefensa(), new BocaArriba());
		
		tablero.terminarTurno();
		
		oponente.getCampo().cambiarPosicionDeMonstruo(monstruo1);
		
		assertThrows(MonstruoNoPuedeAtacarEstaEnPosicionDefensaException.class,
			()-> monstruo1.atacar(monstruo2));
	}
}


