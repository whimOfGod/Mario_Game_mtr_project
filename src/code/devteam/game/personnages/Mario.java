package code.devteam.game.personnages;

import java.awt.Image;
import java.util.Objects;

import javax.swing.ImageIcon;

public class Mario extends Personnage {
    //**** VARIABLES ****//
    private final Image imgMario;
    private final ImageIcon icoMario;

    //**** CONSTRUCTEUR	****//
    public Mario(int x, int y) {
        super(x, y, 28, 50);
        this.icoMario = new ImageIcon("src/images/marioMarcheDroite.png");
        this.imgMario = this.icoMario.getImage();
    }

    //**** GETTERS ****//
    public Image getImgMario() {return imgMario;}
}
