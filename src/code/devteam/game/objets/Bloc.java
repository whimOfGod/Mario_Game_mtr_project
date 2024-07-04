package code.devteam.game.objets;

import javax.swing.ImageIcon;
import java.awt.*;
import java.util.Objects;

public class Bloc extends Objet{
    //**** VARIABLES ****//
    private Image imgBloc;
    private ImageIcon icoBloc;

    //**** CONSTRUCTEUR	****//
    public Bloc(int x, int y){
        super(x, y, 30, 30);
        this.icoBloc = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/bloc.png")));
        this.imgBloc = this.icoBloc.getImage();
    }


    //**** GETTERS ****//
    public Image getImgBloc(){ return this.imgBloc; }


    //**** SETTERS ****//


    //**** METHODES ****//
}
