package Main;

import java.awt.*;

public class UI {
    Panel_de_Juego gp;
    Graphics2D g2;
    Font arial_40;
    public boolean juegoterminado = false;
    public String dialogoactual="";

    public  UI(Panel_de_Juego gp){
        this.gp = gp;
        arial_40 = new Font("Arial",Font.PLAIN, 40);
    }
    public void dibujar(Graphics2D g2){
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        // reanudar
        if(gp.estadodeljuego == gp.reanudar){

        }
        // dialogo
        if(gp.estadodeljuego == gp.dialogo){
            dibujarpantalladedialogo();
        }
    }
    public void dibujarpantalladedialogo(){
        //pestana
        int x = gp.jugador.mundox - gp.tileSize;
        int y = gp.jugador.mundoy - gp.tileSize;
        int ancho = gp.tileSize * 3;
        int alto = gp.tileSize;
        dibujarpestana(x,y,ancho,alto);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,28F));
        int textox = x+40;
        int textoy = y+60;
        g2.drawString(dialogoactual, textox, textoy);
        /*

        for(String line: dialogoactual.split("\n")){
            g2.drawString(line,x,y);
            y+= 40;
        }*/
    }
    public void dibujarpestana(int x, int y, int ancho, int alto){
        Color c = new Color(0,0,0, 210);
        g2.setColor(c);
        g2.fillRoundRect(x,y,ancho,alto,35,35);
        c = new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5,y+5,ancho-10,alto-10,25,25);
    }
    public int getxforcenteredtext(String texto){
        int length = (int)g2.getFontMetrics().getStringBounds(texto,g2).getWidth();
        int x = gp.anchoPantalla/2 - length/2;
        return x;
    }
}
