package code.devteam.game;

import javax.swing.JFrame;

public class Main {

    public static Scene scene;

    public static void main(String[] args) {

        // Création de la fenetre de l'application
        JFrame fenetre = new JFrame("simulator Mario Game");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(700, 360);
        fenetre.setLocationRelativeTo(null);
        fenetre.setResizable(false);
        fenetre.setAlwaysOnTop(true);

        // Instanciation de l'objet scene
        scene = new Scene();

        // On associe la scene à la fenêtre de l'application
        fenetre.setContentPane(scene);
        fenetre.setVisible(true);
    }

}