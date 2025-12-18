package Main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class UI {
    Panel_de_Juego gp;
    Graphics2D g2;
    Font arial_40;
    public boolean juegoterminado = false;
    public String dialogoactual="";
    public int numerodecomando = 0;

    public  UI(Panel_de_Juego gp){
        this.gp = gp;
        arial_40 = new Font("Arial",Font.PLAIN, 40);
    }
    public void dibujar(Graphics2D g2){
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        //pantalla de inico
        if(gp.estadodeljuego == gp.pantalladeinicio){
            dibujarpantalladeinicio();
        }
        // reanudar
        if(gp.estadodeljuego == gp.reanudar){

        }
        // dialogo
        if(gp.estadodeljuego == gp.dialogo){
            dibujarpantalladedialogo();
        }
    }
    public void dibujarpantalladeinicio(){
        g2.setColor(new Color(70,120,80));
        g2.fillRect(0,0,gp.anchoPantalla,gp.altoPantalla);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String texto = "MERRY CHRISTMAS!!!";
        int x= getxforcenteredtext(texto);
        int y= gp.tileSize;

        g2.setColor(Color.black);
        g2.drawString(texto,x+5,y+5);

        g2.setColor(Color.red);
        g2.drawString(texto,x,y);

        x= (gp.tileSize*3)-80;
        y= gp.tileSize -80;
        try{
            BufferedImage imagen = ImageIO.read(getClass().getResourceAsStream("/objetos/estrella.png"));
            g2.drawImage(imagen,x,y,gp.tileSize*2, gp.tileSize*2,null);
        }catch(IOException e){
            e.printStackTrace();
        }

        //menu
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));
        g2.setColor(Color.black);
        texto="Iniciar";
        x= getxforcenteredtext(texto);
        y=gp.tileSize + 200;
        g2.drawString(texto, x, y);
        if(numerodecomando == 0){
            g2.drawString(">",x- 60,y);
        }

        texto="Continuar";
        x= getxforcenteredtext(texto);
        y+= 80;
        g2.drawString(texto, x, y);
        if(numerodecomando == 1){
            g2.drawString(">",x- 60,y);
        }

        texto="Salir";
        x= getxforcenteredtext(texto);
        y+= 80;
        g2.drawString(texto, x, y);
        if(numerodecomando == 2){
            g2.drawString(">",x- 60,y);
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
        for(String line: dialogoactual.split("\n")){
            g2.drawString(dialogoactual, textox, textoy);
            y+= 40;
        }
        /*

        for(String line: dialogoactual.split("\n")){
            g2.drawString(line,x,y);

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
