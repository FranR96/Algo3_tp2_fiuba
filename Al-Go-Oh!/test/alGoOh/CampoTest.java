package alGoOh;

import static org.junit.Assert.*;
import java.util.Collection;


import cartas.*;
import cartasConcretas.*;

import org.junit.Test;

public class CampoTest {
	
	@Test
	public void test01ColocarCartaMonstruoEnPosicionDefensaYNoPuedeAtacar() {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		
		CartaMonstruo abismoReluciente = new AbismoReluciente();
		CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();

		activo.getCampo().colocarCarta(abismoReluciente, new PosicionDefensa(), new BocaArriba());

		boolean error = false;

		try{
			abismoReluciente.atacar(huevoMonstruoso);
		}catch(MonstruoNoPuedeAtacarEstaEnPosicionDefensaException e){
			error = true;
		}

		assertTrue(error);

	}

	@Test
	public void test02ColocarCartaTrampaBocaAbajo(){
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();

		CartaTrampa cilindroMagico = new CilindroMagico();

		activo.getCampo().colocarCarta(cilindroMagico, new BocaAbajo());

		assertTrue(cilindroMagico.estaBocaAbajo());
	}
	
	@Test
	public void test03ColocoUnMonstruoYLuegoColocoMaldicionDeDragonQueRequiereUnSacrificioElPrimeroNoEstaYElUltimoSi() {
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
	public void test04ColocoDosMonstruosYLuegoColocoDragonBlancoDeOjosAzulesQueRequiereDosSacrificiosAmbosNoEstanYElUltimoSi() {
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
	public void test05ColocoMasDeCincoCartasEspecialesBocaAbajoYMeSaltaUnaExcepcion() {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		
		for(int i = 0; i<5;i++) {
			CartaMagica agujeroNegro = new AgujeroNegro();
			activo.getCampo().colocarCarta(agujeroNegro, new BocaAbajo());
		}

		boolean error = false;

		try{
			CartaMagica agujeroNegro = new AgujeroNegro();
			activo.getCampo().colocarCarta(agujeroNegro, new BocaAbajo());
		}catch(CapacidadMaximaEnZonaEspecialesException e){
			error = true;
		}

		assertTrue(error);
		
	}
	
	@Test
	public void test06ColocoMasDeCincoCartasMonstruosYMeSaltaUnaExcepcion() {

		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();

		
		for(int i = 0; i<5;i++) {
			CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
			activo.getCampo().colocarCarta(huevoMonstruoso,new PosicionAtaque(), new BocaAbajo());
			tablero.terminarTurno();
			tablero.terminarTurno();
		}

		boolean error = false;

		try{
			CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
			activo.getCampo().colocarCarta(huevoMonstruoso,new PosicionAtaque(), new BocaAbajo());
		}catch(NoSePudoInvocarElMonstruoException e){
			error = true;
		}

		assertTrue(error);

	}
	
	@Test
	public void test07TengoLaZonaDeMonstruosCompletaPeroQuieroInvocarAUnMonstruoQueRequiereSacrificioYPuedo() {
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
	public void test08Invoco3DragonesBlancosYSoloSeSacrificanEstosParaInvocarAlDragonDefinitivo() {
		
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		CartaMonstruo huevoMonstruoso1 = new HuevoMonstruoso();
		CartaMonstruo huevoMonstruoso2 = new HuevoMonstruoso();
		
		activo.getCampo().getZonaMonstruos().agregarCarta(huevoMonstruoso1);
		activo.getCampo().getZonaMonstruos().agregarCarta(new DragonBlancoDeOjosAzules());
		activo.getCampo().getZonaMonstruos().agregarCarta(huevoMonstruoso2);
		activo.getCampo().getZonaMonstruos().agregarCarta(new DragonBlancoDeOjosAzules());
		activo.getCampo().getZonaMonstruos().agregarCarta(new DragonBlancoDeOjosAzules());

		CartaMonstruo dragonDefinitivo = new DragonDefinitivoDeOjosAzules();
		activo.getCampo().colocarCarta(dragonDefinitivo, new PosicionAtaque(), new BocaArriba());
		
		assertEquals(activo.getCampo().monstruosInvocados().size(),3);
		
		assertTrue(activo.getCampo().monstruosInvocados().contains(dragonDefinitivo));
		assertTrue(activo.getCampo().monstruosInvocados().contains(huevoMonstruoso2));
		assertTrue(activo.getCampo().monstruosInvocados().contains(huevoMonstruoso1));
	}
	
	@Test
	public void test09ExtraigoTodasLasCartasDelMazoYVerificoQueElJugadorPierde() {
		
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
	public void test10SoloSePuedeInvocarUnMonstruoPorTurno() {
		
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		
		activo.getCampo().colocarCarta(new HuevoMonstruoso(),new PosicionAtaque(), new BocaAbajo());

		boolean error = false;

		try{
			activo.getCampo().colocarCarta(new AbismoReluciente(),new PosicionAtaque(), new BocaAbajo());
		}catch(YaSeHaInvocadoMonstruoEnTurnoException e){
			error = true;
		}

		assertTrue(error);

	}
	
	@Test
	public void test11NoSePuedeCambiarLaPosicionDelMonstruoRecienColocado() {
		
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		
		CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
		activo.getCampo().colocarCarta(huevoMonstruoso,new PosicionAtaque(), new BocaArriba());

		boolean error = false;

		try{
			activo.getCampo().cambiarPosicionDeMonstruo(huevoMonstruoso);
		}catch(NoSePuedeCambiarPosicionMonstruoException e){
			error = true;
		}

		assertTrue(error);

	}
	
	@Test
	public void test12ColocarUnMonstruoEnAtaqueLuegoCambiarSuPosicionYVerificarQueNoPuedoAtacar() {
		
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

		boolean error = false;

		try{
			monstruo1.atacar(monstruo2);
		}catch(MonstruoNoPuedeAtacarEstaEnPosicionDefensaException e){
			error = true;
		}

		assertTrue(error);

	}
}


