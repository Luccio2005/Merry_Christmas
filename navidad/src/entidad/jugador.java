package entidad;

import Main.Herramientasdeutilidad;
import Main.Panel_de_Juego;
import Main.Teclado;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class jugador extends entidad{
    Teclado keyH;
    //public int tenerllave =0;

    //public final int pantallax;
    //public final int pantallay;

    public jugador(Panel_de_Juego gp, Teclado keyH){
        super(gp);
        this.keyH = keyH;

        areadecolision = new Rectangle(0,0);
        areadecolision.x = 45;
        areadecolision.y = 120;
        areadecolisionx = areadecolision.x;
        areadecolisiony = areadecolision.y;
        areadecolision.width = 75;
        areadecolision.height = 10;
        valorespredeterminados();
        getPlayerImage();

        /*pantallax = gp.anchoPantalla/2 - (gp.tileSize/2);
        pantallay = gp.altoPantalla/2 - (gp.tileSize/2);

        */
    }
    public void valorespredeterminados(){
        mundox=gp.tileSize * 3;
        mundoy=gp.tileSize * 3;
        velocidad=6;
        direccion= "up";
        /*mundox= gp.tileSize * 0;
        mundoy= gp.tileSize * 49;
        velocidad=6;
        */
    }
    public void getPlayerImage(){
        up1 = setup("/jugador/player-3");
        up2 = setup("/jugador/player-4");
        down1 = setup("/jugador/player-1");
        down2 = setup("/jugador/player-2");
        left1 = setup("/jugador/player-5");
        left2 = setup("/jugador/player-6");
        right1 = setup("/jugador/player-7");
        right2 = setup("/jugador/player-8");
    }
    public void actualizar(){
        if(keyH.arribap == true || keyH.abajop == true ||
        keyH.izquierdap == true || keyH.derechap == true || keyH.enterp == true){
            if(keyH.arribap == true){
                direccion = "up";
            }else if(keyH.abajop == true){
                direccion = "down";
            }else if(keyH.izquierdap == true){
                direccion = "left";
            }else if(keyH.derechap == true){
                direccion = "right";
            }

            colisioon= false;
            gp.comprobar.comprobarsuelo(this);

            int objindice = gp.comprobar.comprobarobjeto(this,true);
            recogerobjeto(objindice);
            //check awimitos colision
            int amiwitosindice = gp.comprobar.comprobarentidad(this,gp.amiwitos);
            interactuaramiwitos(amiwitosindice);
            // COMPROBBAR EVENTO
            gp.evento.comprobarevento();

            if(colisioon == false && keyH.enterp == false){
                switch (direccion){
                    case "up": mundoy -= velocidad; break;
                    case "down": mundoy += velocidad; break;
                    case "left": mundox -= velocidad; break;
                    case "right": mundox += velocidad; break;
                }
            }
            gp.keyH.enterp = false;
            contadorSprite++;
            if(contadorSprite > 12){
                if(numeroSprite == 1){
                    numeroSprite = 2;
                }else if(numeroSprite == 2){
                    numeroSprite = 1;
                }
                contadorSprite = 0;
            }
        }

    }
    public void recogerobjeto(int i){
        if(i != 999){
            /*String nombreobj = gp.obj[i].nombre;
            switch (nombreobj){
                case "estrella":
                    gp.playSE(1);
                    tenerllave++;
                    gp.obj[i] = null;
                    break;
            }*/
        }
    }
    public void interactuaramiwitos(int i ){
        if (i != 999) {
            if(gp.keyH.enterp == true){
                gp.estadodeljuego = gp.dialogo;
                gp.entidadDialogoactual = gp.amiwitos[i];
                gp.amiwitos[i].indicededialogos = 0;
                gp.amiwitos[i].hablar();
            }
        }
    }
    public void dibujar(Graphics2D g2){
        BufferedImage imagen=null;
        switch (direccion){
            case "up":
                if(numeroSprite ==1){
                    imagen = up1;
                }if(numeroSprite ==2){
                imagen = up2;
            }
                break;
            case "down":
                if(numeroSprite ==1){
                    imagen = down1;
                }if(numeroSprite ==2) {
                imagen = down2;
            }
                break;
            case "left":
                if(numeroSprite ==1){
                    imagen = left1;
                }if(numeroSprite ==2){
                imagen = left2;
            }
                break;
            case "right":
                if(numeroSprite ==1){
                    imagen = right1;
                }if(numeroSprite ==2){
                imagen = right2;
            }
                break;
        }
        g2.drawImage(imagen, mundox, mundoy, null);
    }
}
