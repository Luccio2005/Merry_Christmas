package entidad;

import Main.Panel_de_Juego;
import Main.Teclado;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class jugador extends entidad{
    Panel_de_Juego gp;
    Teclado keyH;
    public int tenerllave =0;

    //public final int pantallax;
    //public final int pantallay;

    public jugador(Panel_de_Juego gp, Teclado keyH){
        this.gp = gp;
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
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/jugador/player-3.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/jugador/player-4.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/jugador/player-1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/jugador/player-2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/jugador/player-5.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/jugador/player-6.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/jugador/player-7.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/jugador/player-8.png"));
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public void actualizar(){
        if(keyH.arribap == true || keyH.abajop == true ||
        keyH.izquierdap == true || keyH.derechap == true){
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
            if(colisioon == false){
                switch (direccion){
                    case "up": mundoy -= velocidad; break;
                    case "down": mundoy += velocidad; break;
                    case "left": mundox -= velocidad; break;
                    case "right": mundox += velocidad; break;
                }
            }
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
            String nombreobj = gp.obj[i].nombre;
            switch (nombreobj){
                case "estrella":
                    gp.playSE(1);
                    tenerllave++;
                    gp.obj[i] = null;
                    System.out.println("estrella: "+tenerllave);
                    break;
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
        g2.drawImage(imagen, mundox, mundoy, gp.tileSize, gp.tileSize, null);
    }
}
