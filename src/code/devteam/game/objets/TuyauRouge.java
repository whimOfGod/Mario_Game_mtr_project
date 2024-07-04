package code.devteam.game.objets;

import javax.swing.ImageIcon;
import java.awt.*;
import java.util.Objects;


public class TuyauRouge extends Objet{
    //**** VARIABLES ****//
    private Image imgTuyauRouge;
    private ImageIcon icoTuyauRouge;

    //**** CONSTRUCTEUR	****//
    public TuyauRouge(int x, int y) {
        super(x, y, 43, 65);
        this.icoTuyauRouge = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/tuyauRouge.png")));
        this.imgTuyauRouge = this.icoTuyauRouge.getImage();
    }


    //**** GETTERS ****//
    public Image getImgTuyauRouge() { return imgTuyauRouge; }

    //**** SETTERS ****//


    //**** METHODES ****//
}