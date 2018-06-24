package cartasConcretas;

import java.util.ArrayList;

import cartas.CartaMonstruo;
import efectos.EfectoNulo;

public class DragonDefinitivoDeOjosAzules extends CartaMonstruo {

	public DragonDefinitivoDeOjosAzules() {
		
		super(4500,3800,12,new EfectoNulo());
	}
	private ArrayList<CartaMonstruo> sacrificios = new ArrayList<CartaMonstruo>();
	
	@Override
	public int requiereSacrificio() {
		return 3;
	}
	
	@Override
	public ArrayList<CartaMonstruo> elegirSacrificios(ArrayList<CartaMonstruo> monstruosEnCampo) {
		int cantidadDeDragonBlancoOjosAzules = 0;
		for(int i= 0 ; i<monstruosEnCampo.size();i++) {
			if(monstruosEnCampo.get(i) instanceof DragonBlancoDeOjosAzules)
				sacrificios.add((DragonBlancoDeOjosAzules) monstruosEnCampo.get(i));
				cantidadDeDragonBlancoOjosAzules++;
		}
		if(cantidadDeDragonBlancoOjosAzules>=3) {
			return sacrificios;
		}
		sacrificios.clear();
		return sacrificios;
	}
}
