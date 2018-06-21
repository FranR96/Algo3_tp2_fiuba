package cartasConcretas;

import cartas.CartaTrampa;
import efectos.EfectoFisura;

public class Fisura extends CartaTrampa{

	public Fisura() {
		this.efecto= new EfectoFisura();
	}
}
