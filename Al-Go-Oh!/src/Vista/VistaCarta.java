package Vista;

import cartas.Carta;
import javafx.scene.image.ImageView;

public class VistaCarta extends ImageView {

    private Carta carta;

    public VistaCarta(Carta carta) {
        this.carta = carta;
    }

    public Carta getCarta() {
        return carta;
    }
}
