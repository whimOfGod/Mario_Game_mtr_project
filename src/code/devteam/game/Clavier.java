package code.devteam.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Clavier implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            // Annule le décalage de 1 créé par deplacementFond (PanJeu)
            if (Main.scene.getxPos() == -1) {
                Main.scene.setxPos(0);
                Main.scene.setxFond1(-50);
                Main.scene.setxFond2(750);
            }
            Main.scene.mario.setMarche(true);
            Main.scene.mario.setVersDroite(true);
            Main.scene.setDx(1);

        }else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            Main.scene.mario.setMarche(true);
            Main.scene.mario.setVersDroite(false);
            Main.scene.setDx(-1);
        }
        // mario saute
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            Main.scene.mario.setSaut(true);
        }
    }

   @Override
   public void keyReleased(KeyEvent e) {
        Main.scene.mario.setMarche(false);
        Main.scene.setDx(0); }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
