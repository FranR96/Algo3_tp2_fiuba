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
	void test03ColocarCartaMagicaBocaAbajoYNoActiveNingunEfecto() {
		Tablero tablero = Tablero.getInstance();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		tablero.inicializarTablero(jugador1, jugador2);

		CartaMonstruo monstruo1 = new AbismoReluciente();
		CartaMonstruo monstruo2 = new HuevoMonstruoso();
		tablero.colocarCartaEnCampoJugador1(monstruo1, new PosicionAtaque(), new BocaArriba());
		tablero.colocarCartaEnCampoJugador2(monstruo2, new PosicionDefensa(), new BocaArriba());

		CartaMagica agujeroNegro = new AgujeroNegro();
		tablero.colocarCartaEnCampoJugador1(agujeroNegro, new BocaAbajo());

		Collection<CartaMonstruo> zonaMonstruosJugador1 = tablero.getCampo1().monstruosInvocados();
		Collection<CartaMonstruo> zonaMonstruosJugador2 = tablero.getCampo2().monstruosInvocados();
		tablero.aplicarEfecto(agujeroNegro);  /* Esto esta hardcodeado, se supone que el campo le dice al tablero
												que active el efecto de una carta magica inmediatamente cuando se activa
												una boca arriba.*/

		assertEquals(1,zonaMonstruosJugador1.size());
		assertEquals(1,zonaMonstruosJugador2.size());
	}

	@Test
	void test04ColocarCartaTrampaBocaAbajo(){
		Campo campo = new Campo();
		CartaTrampa cilindroMagico = new CilindroMagico();

		campo.colocarCarta(cilindroMagico, new BocaAbajo());

		assertTrue(cilindroMagico.estaBocaAbajo());
	}

	@Test
	void test05MandarCartaAlCementerio(){
		Tablero tablero = Tablero.getInstance();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		tablero.inicializarTablero(jugador1, jugador2);

		CartaMonstruo monstruo1 = new AbismoReluciente();
		CartaMonstruo monstruo2 = new HuevoMonstruoso();
		tablero.colocarCartaEnCampoJugador1(monstruo1, new PosicionAtaque(), new BocaArriba());
		tablero.colocarCartaEnCampoJugador2(monstruo2, new PosicionAtaque(), new BocaArriba());

		tablero.atacarACon(monstruo2, monstruo1);
		Collection<Carta> cementerioJugador2 = tablero.getCampo2().cartasEnCementerio();

		assertTrue(cementerioJugador2.contains(monstruo2));
	}

}


