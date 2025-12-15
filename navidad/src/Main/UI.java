package Main;

import java.awt.*;

public class UI {
    Panel_de_Juego gp;
    Graphics2D g2;
    Font arial_40;
    public boolean juegoterminado = false;

    public  UI(Panel_de_Juego gp){
        this.gp = gp;
        arial_40 = new Font("Arial",Font.PLAIN, 40);
    }
    public void dibujar(Graphics2D g2){
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        if(gp.estadodeljuego == gp.reanudar){

        }
    }
    public int getxforcenteredtext(String texto){
        int length = (int)g2.getFontMetrics().getStringBounds(texto,g2).getWidth();
        int x = gp.anchoPantalla/2 - length/2;
        return x;
    }
}
