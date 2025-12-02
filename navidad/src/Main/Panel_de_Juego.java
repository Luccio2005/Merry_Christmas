package Main;

import javax.swing.*;
import java.awt.*;

public class Panel_de_Juego extends JPanel {
    final int originalTileSize = 16;   //64x64
    final int escala = 3;  //escala en la pantalla

    public final int tileSize = originalTileSize * escala;
    public final int tamanoColumna = 20;
    public final int tamanoFila = 12;
    public final int anchoPantalla = tileSize * tamanoColumna;
    public final int altoPantalla = tileSize * tamanoFila;

    public Panel_de_Juego() {
        this.setPreferredSize(new Dimension(anchoPantalla, altoPantalla));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }
}
