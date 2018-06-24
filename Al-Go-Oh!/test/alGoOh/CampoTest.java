package alGoOh;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import cartas.*;
import cartasConcretas.*;

import java.util.Collection;

class CampoTest {

	@Test
	void test01ColocarCartaMonstruoEnPoscicionAtaqueYPuedaAtacar() {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();

		
		CartaMonstruo abismoReluciente = new AbismoReluciente();
		activo.getCampo().colocarCarta(abismoReluciente, new PosicionAtaque(),new BocaArriba());

		assertTrue(abismoReluciente.enPosicionDeAtaque());
	}

	@Test
	void test02ColocarCartaMonstruoEnPosicionDefensaYNoPuedeAtacar() {
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
	void test03ColocarCartaTrampaBocaAbajo(){
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();

		CartaTrampa cilindroMagico = new CilindroMagico();

		activo.getCampo().colocarCarta(cilindroMagico, new BocaAbajo());

		assertTrue(cilindroMagico.estaBocaAbajo());
	}
	
	@Test
	void test04ColocoUnMonstruoYLuegoColocoUnMonstruoQueRequiereUnSacrificioElPrimeroNoEstaYElUltimoSi() {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		
		CartaMonstruo abismoReluciente = new AbismoReluciente();
		activo.getCampo().colocarCarta(abismoReluciente, new PosicionAtaque(), new BocaArriba());
		
		CartaMonstruo maldicionDeDragon = new MaldicionDeDragon();
		activo.getCampo().colocarCarta(maldicionDeDragon, new PosicionAtaque(), new BocaArriba());
		
		Collection<Carta> cementerio = activo.getCampo().cartasEnCementerio();
		
		assertTrue(cementerio.contains(abismoReluciente));
		
		Collection<CartaMonstruo> zonaMonstruosInvocados = activo.getCampo().monstruosInvocados();
		
		assertTrue(zonaMonstruosInvocados.contains(maldicionDeDragon));

	}
	
	@Test 
	void test05ColocoDosMonstruosYLuegoColocoUnMonstruoQueRequiereDosSacrificiosAmbosNoEstanYElUltimoSi() {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		
		CartaMonstruo abismoReluciente = new AbismoReluciente();
		activo.getCampo().colocarCarta(abismoReluciente, new PosicionAtaque(), new BocaArriba());
		
		CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
		activo.getCampo().colocarCarta(huevoMonstruoso,new PosicionAtaque(), new BocaArriba());
		
		CartaMonstruo dragonBlancoDeOjosAzules = new DragonBlancoDeOjosAzules();
		activo.getCampo().colocarCarta(dragonBlancoDeOjosAzules, new PosicionAtaque(), new BocaArriba());
		
		Collection<Carta> cementerio = activo.getCampo().cartasEnCementerio();
		
		assertTrue(cementerio.contains(abismoReluciente));
		assertTrue(cementerio.contains(huevoMonstruoso));
		
		Collection<CartaMonstruo> zonaMonstruosInvocados = activo.getCampo().monstruosInvocados();
		
		assertTrue(zonaMonstruosInvocados.contains(dragonBlancoDeOjosAzules));

	}

	
	@Test
	void test06ColocoMasDeCincoCartasEspecialesBocaAbajoYMeSaltaUnaExcepcion() {
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
	void test07ColocoMasDeCincoCartasMonstruosYMeSaltaUnaExcepcion() {

		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		
		for(int i = 0; i<5;i++) {
			CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
			activo.getCampo().colocarCarta(huevoMonstruoso,new PosicionAtaque(), new BocaAbajo());
		}
		assertThrows(CapacidadMaximaEnZonaMonstruosException.class,
				()->{
					CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
					activo.getCampo().colocarCarta(huevoMonstruoso,new PosicionAtaque(), new BocaAbajo());
				});
	}
	
	@Test
	void test08TengoLaZonaDeMonstruosCompletaPeroQuieroInvocarAUnMonstruoQueRequiereSacrificioYPuedo() {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		
		for(int i = 0; i<5;i++) {
			CartaMonstruo huevoMonstruoso = new HuevoMonstruoso();
			activo.getCampo().colocarCarta(huevoMonstruoso,new PosicionAtaque(), new BocaAbajo());
		}
		
		CartaMonstruo maldicionDeDragon = new MaldicionDeDragon();
		activo.getCampo().colocarCarta(maldicionDeDragon,new PosicionAtaque(),new BocaArriba());
		
		assertTrue(activo.getCampo().monstruosInvocados().contains(maldicionDeDragon));
	}


	@Test
	void test09ColocoOllaDeLaCodiciaBocaArribaYObtengoDosCartasDelMazo() {
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
						
		activo.getCampo().colocarCarta(new OllaDeLaCodicia(), new BocaArriba());
		
		assertEquals(activo.cartasEnLaMano().size(),2);
	}
	
	@Test
	void test10Invoco3DragonesBlancosYLuegoLosSacrificoParaInvocarAlDragonDefinitivo() {
		
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();
		
		
		activo.getCampo().getZonaMonstruos().colocarCarta(new DragonBlancoDeOjosAzules());
		activo.getCampo().getZonaMonstruos().colocarCarta(new DragonBlancoDeOjosAzules());
		activo.getCampo().getZonaMonstruos().colocarCarta(new DragonBlancoDeOjosAzules());
		System.out.println(activo.getCampo().monstruosInvocados().size());
		
		CartaMonstruo dragonDefinitivo = new DragonDefinitivoDeOjosAzules();
		activo.getCampo().colocarCarta(dragonDefinitivo, new PosicionAtaque(), new BocaArriba());
		
		assertEquals(activo.getCampo().monstruosInvocados().size(),1);
		
		assertTrue(activo.getCampo().monstruosInvocados().contains(dragonDefinitivo));
	}
	
	@Test
	void test11ExtraigoTodasLasCartasDelMazoYVerificoQueElJugadorPierde() {
		
		Tablero tablero = Tablero.getInstance();
		tablero.inicializarTablero(new Jugador(), new Jugador());
		Jugador activo = tablero.getJugadorActivo();		
		
		for(int i=0; i<40; i++)
			activo.tomarCartaDelMazo();
		
		//falta hacer el assert para chequear que el ganador es el oponente
	}
}


