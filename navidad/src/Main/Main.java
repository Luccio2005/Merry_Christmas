package Main;

import javax.swing.*;

public class Main {
    public  static JFrame window;
    public static void main(String[] args) {

        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("MERRY CHRISTMAS");

        Panel_de_Juego paneldejuego = new Panel_de_Juego();
        window.add(paneldejuego);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        paneldejuego.setupGame();
        paneldejuego.startGameThread();
    }
}