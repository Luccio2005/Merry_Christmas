package Main;

import entidad.entidad;

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
    public int ranuracol = 0;
    public int ranurafila = 0;

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
        // estado de personaje
        if(gp.estadodeljuego == gp.estadodepersonaje){
            //dibujarpantalladepersonaje();
            dibujarinventario();
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
    public void dibujarinventario(/*entidad entidad, boolean cursor*/){
        int framex = gp.tileSize*4;
        int framey = gp.tileSize/2;
        int frameancho = (int)(gp.tileSize*2.2);
        int framealto = (int)(gp.tileSize*2.2);
        dibujarpestana(framex,framey,frameancho,framealto);
        // slot
        final int ranuraxstart = framex +20;
        final int ranuraystart = framey +20;
        int ranurax = ranuraxstart;
        int ranuray = ranuraystart;
        // dibujar items jugador
        for(int i = 0; i< gp.jugador.inventario.size();i++){
            g2.drawImage(gp.jugador.inventario.get(i).down1,ranurax,ranuray,null);
            ranurax += gp.tileSize;
            if(i==1){
                ranurax = ranuraxstart;
                ranuray += gp.tileSize;
            }
        }

        // cursor
        int cursorx = ranuraxstart + (gp.tileSize * ranuracol);
        int cursory = ranuraystart + (gp.tileSize * ranurafila);
        int anchocursor = gp.tileSize;
        int altocursor = gp.tileSize;
        // dibujar cursor
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(cursorx,cursory, anchocursor,altocursor, 10,10);
        // descripcion ventana
        int dframex = framex;
        int dframey = framey + framealto;
        int dframeancho = frameancho;
        int dframealto = gp.tileSize*4/5;
        dibujarpestana(dframex, dframey, dframeancho, dframealto);
        // dibujar teto descripcion
        int textox = dframex + 20;
        int textoy = dframey + 40;
        g2.setFont(g2.getFont().deriveFont(28F));
        int indiceitem = getitemindexonslot();
        if(indiceitem < gp.jugador.inventario.size()){
            for(String linea: gp.jugador.inventario.get(indiceitem).descripcion.split("\n")){
                g2.drawString(linea,textox,textoy);
                textoy += 32;
            }
        }
        /*int framex = 0;
        int framey = 0;
        int frameancho = 0;
        int framealto = 0;
        int ranuracol = 0;
        int ranurafila = 0;
        if(entidad == gp.jugador){
            framex = gp.tileSize * 12;
            framey = gp.tileSize;
            frameancho = gp.tileSize * 6;
            framealto = gp.tileSize * 5;
            ranuracol = jugadorranuracol;
            ranurafila = jugadorranurafila;
        }else{
            framex = gp.tileSize * 2;
            framey = gp.tileSize;
            frameancho = gp.tileSize * 6;
            framealto = gp.tileSize * 5;
            ranuracol = npcranuracol;
            ranurafila = npcranurafila;
        }
        //frame
        dibujarpestana(framex, framey, frameancho, framealto);

        int tamanoranura = gp.tileSize+3;
        // dibujar items
        for(int i = 0; i< entidad.inventario.size();i++){
            //equipar cursor
            if(entidad.inventario.get(i) == entidad.actualarma ||
                    entidad.inventario.get(i) == entidad.actualescudo ||
                    entidad.inventario.get(i) == entidad.actualluz){
                g2.setColor(new Color(240,190,90));
                g2.fillRoundRect(ranurax, ranuray, gp.tileSize, gp.tileSize, 10, 10);
            }
            g2.drawImage(entidad.inventario.get(i).down1,ranurax,ranuray,null);
            // display amount
            if(entidad == gp.jugador && entidad.inventario.get(i).amount > 1){
                g2.setFont(g2.getFont().deriveFont(32f));
                int amountx;
                int amounty;

                String s = "" + entidad.inventario.get(i).amount;
                amountx = getxforAligntorighttext(s, ranurax + 44);
                amounty = ranuray + gp.tileSize;
                // sombra
                g2.setColor(new Color(60,60,60));
                g2.drawString(s, amountx -3, amounty-3);
                //numero
                g2.setColor(Color.white);
                g2.drawString(s, amountx -3, amounty -3);
            }
            ranurax += tamanoranura;
            if(i==4 || i==9 || i==14){
                ranurax = ranuraxstart;
                ranuray += tamanoranura;
            }
        }
        //cursor
        if(cursor == true){

            //dibujar cursor
            g2.setColor(Color.white);
            g2.setStroke(new BasicStroke(3));
            g2.drawRoundRect(cursorx, cursory, anchocursor, altocursor,10, 10);
            // descripcion ventana
            int dframex = framex;
            int dframey = framey + framealto;
            int dframeancho = frameancho;
            int dframealto = gp.tileSize*3;
            // dibujar texto de descripcion
            int textox = dframex +20;
            int textoy = dframey +gp.tileSize;
            g2.setFont(g2.getFont().deriveFont(28F));
            int indiceitem = getitemindexonslot(ranuracol, ranurafila);

        }*/
    }
    public int getitemindexonslot(/*int ranuracol, int ranurafila*/){
        int indiceitem = ranuracol + (ranurafila*2);
        return indiceitem;
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
    public int getxforAligntorighttext(String texto, int tailx){
        int length = (int)g2.getFontMetrics().getStringBounds(texto,g2).getWidth();
        int x = tailx - length;
        return x;
    }
}
