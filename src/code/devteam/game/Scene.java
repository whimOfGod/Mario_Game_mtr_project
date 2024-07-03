package code.devteam.game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import code.devteam.game.personnages.Mario;

@SuppressWarnings("serial")
public class Scene extends JPanel {

    //**** VARIABLES ****//
    private ImageIcon icoFond;
    private ImageIcon icoChateau1;
    private Image imgChateau1;
    private ImageIcon icoDepart;
    private Image imgDepart;
    private ImageIcon icoDrapeau;
    private Image imgDrapeau;
    private ImageIcon icoChateauFin;
    private Image imgChateauFin;

    private Image imgFond1;
    private Image imgFond2;


    private int xFond1;
    private int xFond2;
    private int dx;
    private int xPos; // position de mario relative au jeu

    public Mario mario;

    private int ySol; // altitude courante (utile seulement pour mario)
    private int hautPlafond; // hauteur maximale courante (utile seulement pour mario)
    private boolean ok;



    //**** CONSTRUCTEUR ****//
    public Scene(){

        super();

        this.xFond1 = -50;
        this.xFond2 = 750;
        this.dx = 0 ;
        this.xPos = -1;

        icoFond = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/fondEcran.png")));
        this.imgFond1 = this.icoFond.getImage();
        this.imgFond2 = this.icoFond.getImage();

        icoChateau1 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/chateau1.png")));
        imgChateau1 = icoChateau1.getImage();
        icoDepart = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/depart.png")));
        imgDepart = icoDepart.getImage();

        mario = new Mario(300,245);

        icoDrapeau = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/drapeau.png")));
        imgDrapeau = icoDrapeau.getImage();
        icoChateauFin = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/chateauFin.png")));
        imgChateauFin = icoChateauFin.getImage();


        this.setFocusable(true);
        this.addKeyListener(new Clavier());

        // Mettre   la fin du constructeur
        Thread chronoEcran = new Thread(new Chrono()); // Ajout d'un chronom tre   PanJeu
        chronoEcran.start(); // D marrage du chronom tre (appel de la m thode run() de la classe Chrono)
    }

    //**** GETTERS ****//
    public int getDx() {return dx;}

    public int getxPos() {return xPos;}

    public int getxFond1() {return xFond1;}

    public int getxFond2() {return xFond2;}

    public int getHautPlafond() {return hautPlafond;}

    public int getySol() {return ySol;}

    //**** SETTERS ****//

    public void setDx(int dx) {this.dx = dx;}

    public void setxPos(int xPos) {this.xPos = xPos;}

    public void setxFond1(int xFond1) {this.xFond1 = xFond1;}

    public void setxFond2(int xFond2) {this.xFond2 = xFond2;}

    public void setySol(int ySol) {this.ySol = ySol;}

    public void setHautPlafond(int hautPlafond) {this.hautPlafond = hautPlafond;}

    //**** METHODES ****//
    public void deplacementFond() { // D placement du fond lorsque mario se d place
        if (this.xPos >= 0 && this.xPos <= 4430) {
            this.xPos = this.xPos + this.dx;
            this.xFond1 = this.xFond1 - this.dx;
            this.xFond2 = this.xFond2 - this.dx;

            // Remise   z ro des abscisses pour rotation des images de fond
            if (this.xFond1 == -800) {this.xFond1 = 800;}
            else if (this.xFond2 == -800) {this.xFond2 = 800;}
            else if (this.xFond1 == 800) {this.xFond1 = -800;}
            else if (this.xFond2 == 800) {this.xFond2 = -800;}
        }
        if (this.xFond1 == -800) {this.xFond1 = 800;}
        else if (this.xFond2 == -800) {this.xFond2 = 800;}
        else if (this.xFond1 == 800) {this.xFond1 = -800;}
        else if (this.xFond2 == 800) {this.xFond2 = -800;}
    }


    //**** METHODES ****//
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics g2 = (Graphics2D)g;

        this.deplacementFond();

        g2.drawImage(this.imgFond1, this.xFond1, 0, null); // Dessin de l'image de fond
        g2.drawImage(this.imgFond2, this.xFond2, 0, null);
        g2.drawImage(this.mario.getImgMario(),300, 245, null); //*** code provisoire
        // Image du ch teau du d part
        g2.drawImage(imgChateau1, 10 - this.xPos, 95, null);
        // Image du panneau de d part
        g2.drawImage(imgDepart, 220 - this.xPos, 234, null);
        // Image du drapeau d'arriv e
        g2.drawImage(imgDrapeau, 4650 - this.xPos, 115, null);
        // Image du ch teau d'arriv e
        g2.drawImage(imgChateauFin, 5000 - this.xPos, 145, null);
    }
}
