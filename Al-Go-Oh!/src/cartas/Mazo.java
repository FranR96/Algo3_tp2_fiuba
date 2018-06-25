package cartas;

import cartasConcretas.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Mazo {

	private ArrayList<Carta> mazo = new ArrayList<Carta>();
	
	public Mazo() {
		this.inicializarMazo(mazo);
	}
	
	public void inicializarMazo(Collection<Carta> mazo) {
		//Obligatorias (11)
		this.mazo.add(new Wasteland());
		this.mazo.add(new Sogen());
		this.mazo.add(new BrazoDerechoExodia());
		this.mazo.add(new BrazoIzquierdoExodia());
		this.mazo.add(new PiernaDerechaExodia());
		this.mazo.add(new PiernaIzquierdaExodia());
		this.mazo.add(new Exodia());
		this.mazo.add(new DragonBlancoDeOjosAzules());
		this.mazo.add(new DragonBlancoDeOjosAzules());
		this.mazo.add(new DragonBlancoDeOjosAzules());
		this.mazo.add(new DragonDefinitivoDeOjosAzules());

		//Magicas (8)
		this.mazo.add(new AgujeroNegro());
		this.mazo.add(new AgujeroNegro());
		this.mazo.add(new Fisura());
		this.mazo.add(new Fisura());
		this.mazo.add(new DianKetoLaCurandera());
		this.mazo.add(new DianKetoLaCurandera());
		this.mazo.add(new OllaDeLaCodicia());
		this.mazo.add(new OllaDeLaCodicia());

		//Trampa (6)
		this.mazo.add(new CilindroMagico());
		this.mazo.add(new CilindroMagico());
		this.mazo.add(new JustDesserts());
		this.mazo.add(new JustDesserts());
		this.mazo.add(new Reinforcements());
		this.mazo.add(new Reinforcements());

		//Mostro (15)
		this.mazo.add(new HuevoMonstruoso());
		this.mazo.add(new InsectoComeHombres());
		this.mazo.add(new Jinzo7());
		this.mazo.add(new AbismoReluciente());
		this.mazo.add(new AbismoReluciente());
		this.mazo.add(new Ansatsu());
		this.mazo.add(new Ansatsu());
		this.mazo.add(new DragonDeAlexandrita());
		this.mazo.add(new HombreFrijolJerry());
		this.mazo.add(new KappaPsiquico());
		this.mazo.add(new KappaPsiquico());
		this.mazo.add(new LoboGigaTecnologico());
		this.mazo.add(new MagoOscuro());
		this.mazo.add(new MaldicionDeDragon());
		this.mazo.add(new PetitMoth());

		//Se mezcla el mazo.
		Collections.shuffle(this.mazo);
	}
	
	public Carta tomarCartaDelMazo() {
		if(!this.estaVacio())
			return mazo.remove(0);
		return null;
	}

	public boolean estaVacio() {
		return mazo.isEmpty();
	}	
}
