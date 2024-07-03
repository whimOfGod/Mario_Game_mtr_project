package code.devteam.game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Scene extends JPanel {

    private ImageIcon icoFond;
    private Image imgFond1;

    private ImageIcon icoMario; //* code provisoire
    private Image imgMario; //* code provisoire

    private int xFond1;
    private int dx;


    //**** CONSTRUCTEUR ****//
    public Scene(){

        super();

        this.xFond1 = -50;
        this.dx = 0 ;

        icoFond = new ImageIcon(getClass().getResource("/images/fondEcran.png"));
        this.imgFond1 = this.icoFond.getImage();
        icoMario = new ImageIcon(getClass().getResource("/images/marioMarcheDroite.png"));
        this.imgMario = this.icoMario.getImage();

        this.setFocusable(true);
        this.addKeyListener(new Clavier());

        // Mettre   la fin du constructeur
        Thread chronoEcran = new Thread(new Chrono()); // Ajout d'un chronom tre   PanJeu
        chronoEcran.start(); // D marrage du chronom tre (appel de la m thode run() de la classe Chrono)
    }

    //**** GETTERS ****//
    public int getDx() { return dx; }

    //**** SETTERS ****//


    public void setDx(int dx) { this.dx = dx; }

    //**** METHODES ****//
    public void deplacementFond() { // D placement du fond lorsque mario se d place
            this.xFond1 = this.xFond1 - this.dx;
            // Remise à zero des abscisses pour rotation des images de fond

    }


    //**** METHODES ****//
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics g2 = (Graphics2D)g;

        this.deplacementFond();

        g2.drawImage(this.imgFond1, this.xFond1, 0, null); // Dessin de l'image de fond
        g2.drawImage(imgMario, 300, 245, null); //*** code provisoire
    }
}
