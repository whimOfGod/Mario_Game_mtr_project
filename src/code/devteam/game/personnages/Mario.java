package code.devteam.game.personnages;

import code.devteam.game.Main;
import code.devteam.game.objets.Objet;

import java.awt.Image;
import java.util.Objects;

import javax.swing.ImageIcon;

public class Mario extends Personnage {
    //**** VARIABLES ****//
    private final Image imgMario;
    private final ImageIcon icoMario;
    private boolean saut; // vrai quand mario saute
    private int compteurSaut; // gère la durée et la hauteur du saut de mario quand il saute


    //**** CONSTRUCTEUR	****//
    public Mario(int x, int y) {
        super(x, y, 28, 50);
        super.setVersDroite(true);
        super.setMarche(false);
        this.icoMario = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/marioArretDroite.png")));
        this.imgMario = icoMario.getImage();
        this.saut = false;
        this.compteurSaut = 0;

    }


    //**** GETTERS ****//
    public Image getImgMario() {return imgMario;}
    public boolean isSaut() {return saut;}

    //**** SETTERS ****//
    public void setSaut(boolean saut) {this.saut = saut;}

    //**** METHODES ****//
    public Image saute(){
        String str;
        ImageIcon ico;
        Image img;

        this.compteurSaut++;
        // Montée du saut
        if(this.compteurSaut <= 40){
            if(this.getY() > Main.scene.getHautPlafond()){this.setY(this.getY() - 4);}
            else{this.compteurSaut = 41;}
            if(this.isVersDroite() == true){str = "/images/marioSautDroite.png";}
            else{str = "/images/marioSautGauche.png";}
            // Retombée du saut
        }else if(this.getY() + this.getHauteur() < Main.scene.getySol()){this.setY(this.getY() + 1);
            if(this.isVersDroite() == true){str = "/images/marioSautDroite.png";}
            else{str = "/images/marioSautGauche.png";}
            // Saut terminé
        }else{
            if(this.isVersDroite() == true){str = "/images/marioArretDroite.png";}
            else{str = "/images/marioArretGauche.png";}
            this.saut = false;
            this.compteurSaut = 0;
        }
        // Affichage de l'image de mario
        ico = new ImageIcon(getClass().getResource(str));
        img = ico.getImage();
        return img;
    }

    public void contact(Objet objet) {
        if((super.contactAvant(objet) == true && this.isVersDroite() == true) || (super.contactArriere(objet) == true && this.isVersDroite() == false)){
            Main.scene.setDx(0);
            this.setMarche(false);
        }
        if(super.contactDessous(objet) == true && this.saut == true){
            Main.scene.setySol(objet.getY());
        }else if(super.contactDessous(objet) == false){
            Main.scene.setySol(293); // altitude du sol initial
            if(this.saut == false){this.setY(243);}
        }
        if(super.contactDessus(objet) == true){
            Main.scene.setHautPlafond(objet.getY() + objet.getHauteur()); // le plafond devient le dessous de l'objet
        }else if(super.contactDessus(objet) == false && this.saut == false){
            Main.scene.setHautPlafond(0);
        }
    }
}
