package objeto;

import Main.Panel_de_Juego;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Superobjeto {
    public BufferedImage imagen;
    public String nombre;
    public boolean colision = false;
    public int mundox, mundoy;
    public Rectangle areadecolision = new Rectangle(0,0,165,165);
    public int areadecolisionx = 0;
    public int areadecolisiony = 0;

    public void dibujar(Graphics2D g2, Panel_de_Juego gp){
        g2.drawImage(imagen,mundox, mundoy, gp.tileSize, gp.tileSize, null);
    }
}
