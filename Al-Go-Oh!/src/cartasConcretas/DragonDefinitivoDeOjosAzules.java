package cartasConcretas;

import cartas.CartaMonstruo;
import alGoOh.efectos.EfectoNulo;

import java.util.ArrayList;

public class DragonDefinitivoDeOjosAzules extends CartaMonstruo {

	private ArrayList<CartaMonstruo> sacrificios = new ArrayList<CartaMonstruo>();

	
	public DragonDefinitivoDeOjosAzules() {
		
		super(4500,3800,12,new EfectoNulo());
	}
	
	@Override
	public int requiereSacrificio() {
		return 3;
	}
	
	@Override
	public ArrayList<CartaMonstruo> elegirSacrificios(ArrayList<CartaMonstruo> monstruosEnCampo) {
		int cantidadDeDragonBlancoOjosAzules = 0;
		for(int i= 0 ; i<monstruosEnCampo.size();i++) {
			if(monstruosEnCampo.get(i) instanceof DragonBlancoDeOjosAzules)
				sacrificios.add(monstruosEnCampo.get(i));
				cantidadDeDragonBlancoOjosAzules++;
		}
		if(cantidadDeDragonBlancoOjosAzules>=3) {
			return sacrificios;
		}
		sacrificios.clear();
		return sacrificios;
	}

	public int resetPtsAtaque() {
		return 4500;
	}
	
	public int resetPtsDefensa() {
		return 3800;
	}
}
