package objeto;

import Main.Panel_de_Juego;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Superobjeto {
    public BufferedImage imagen;
    public String nombre;
    public boolean colision = false;
    public int mundox, mundoy;

    public void dibujar(Graphics2D g2, Panel_de_Juego gp){
        g2.drawImage(imagen,mundox, mundoy, gp.tileSize, gp.tileSize, null);
    }
}
