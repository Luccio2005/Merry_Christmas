package entidad;

import Main.Herramientasdeutilidad;
import Main.Panel_de_Juego;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class entidad {
    public int mundox,mundoy;
    public int velocidad;
    Panel_de_Juego gp;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public BufferedImage imagen, imagen2, imagen3;
    public String direccion = "down";
    //contador
    public int contadorSprite=0;
    public int numeroSprite=1;
    public Rectangle areadecolision;
    public int areadecolisionx, areadecolisiony;
    public boolean colisioon = false;
    /*

    public boolean colisioon = false;
    String dialogos[]= new String[20];

    public int bloqueodeaccion =0;

    // estados
    public int mundox,mundoy;


    int indicededialogos = 0;

    public boolean onpath = false;



    //atributpos
    public String nombre;
    public int defaultspeed;
    public int velocidad;

    //atributos de los items
    public ArrayList<entidad> inventario = new ArrayList<>();
    public final int maxtamanoinventario = 20;
    public int valor;
    public String descripcion = "";
    public int usecost;
    public boolean stackable = false;
    public int amount = 1;

    //tipo
    public int tipo;
    public final int tipo_jugador = 0;
    public final int tipo_npc = 1;
    public final int tipo_consumible = 6;
    public final int tipo_agarrarsolo = 7;
    public final int tipo_obstaculo = 8;

    public entidad(Panel_de_Juego gp){
        this.gp = gp;
    }
    public int getizqx(){
        return mundox + areadecolision.x;
    }
    public int getderx(){
        return mundox + areadecolision.x + areadecolision.width;
    }
    public int gettopy(){
        return mundoy + areadecolision.y;
    }
    public int getbottomy(){
        return mundoy + areadecolision.y + areadecolision.height;
    }
    public int getcol(){
        return (mundox + areadecolision.x)/gp.tileSize;
    }
    public int getfila(){
        return (mundoy + areadecolision.y)/gp.tileSize;
    }
    public int getdistanciax(entidad target){
        int distanciax = Math.abs(mundox - target.mundox);
        return distanciax;
    }
    public int getdistanciay(entidad target){
        int distanciay = Math.abs(mundoy - target.mundoy);
        return distanciay;
    }
    public int gettitulodistancia(entidad target){
        int titulodistancia = (getdistanciax(target) + getdistanciay(target))/gp.tileSize;
        return titulodistancia;
    }
    public int getmetacol(entidad target){
        int metacol = (target.mundox + target.areadecolision.x)/gp.tileSize;
        return metacol;
    }
    public int getmetafila(entidad target){
        int metafila = (target.mundoy + target.areadecolision.y)/gp.tileSize;
        return metafila;
    }
    public void setaction(){
    }
    public void hablar(){
        if(dialogos[indicededialogos] == null){
            indicededialogos = 0;
        }
        gp.ui.dialogoactual = dialogos[indicededialogos];
        indicededialogos++;
        switch (gp.jugador.direccion){
            case "up":
                direccion = "down"; break;
            case "down":
                direccion = "up"; break;
            case "left":
                direccion = "right"; break;
            case "right":
                direccion = "left"; break;
        }
    }
    public void interactuar(){
    }
    public boolean usar(entidad entidad){
        return false;
    }
    public void comprobarcolision(){
        colisioon = false;
        gp.comprobar.comprobarsuelo(this);
        gp.comprobar.comprobarobjeto(this, false);
        gp.comprobar.comprobarentidad(this, gp.npc);
        gp.comprobar.comprobarentidad(this, gp.enemigos);
        gp.comprobar.comprobarentidad(this, gp.itile);
        boolean contactojugador = gp.comprobar.comprobarjugador(this);

        if(this.tipo == tipo_enemigos && contactojugador == true){
            damageplayer(atq);
        }
    }
    public void actualizar(){
    setaction();
    comprobarcolision();
            if(colisioon == false){
        switch (direccion){
            case "up":
                mundoy -= velocidad;
                break;
            case "down":
                mundoy += velocidad;
                break;
            case "left":
                mundox -= velocidad;
                break;
            case "right":
                mundox += velocidad;
                break;
        }
    }
    contadorSprite++;
            if(contadorSprite>24){
        if(numeroSprite ==1){
            numeroSprite = 2;}
        else if(numeroSprite ==2){
            numeroSprite=1;
        }
        contadorSprite=0;
    }
}
    public void dibujar(Graphics2D g2){
        BufferedImage imagen=null;
        int pantallax= mundox - gp.jugador.mundox + gp.jugador.pantallax;
        int pantallay= mundoy - gp.jugador.mundoy + gp.jugador.pantallay;

        if(mundox + gp.tileSize > gp.jugador.mundox - gp.jugador.pantallax &&
                mundox - gp.tileSize < gp.jugador.mundox + gp.jugador.pantallax &&
                mundoy + gp.tileSize > gp.jugador.mundoy - gp.jugador.pantallay &&
                mundoy - gp.tileSize < gp.jugador.mundoy + gp.jugador.pantallay){
            int temppantallax = pantallax;
            int temppantallay = pantallay;
            switch (direccion){
                case "up":
                    if(numeroSprite ==1){
                        imagen = up1;
                    }if(numeroSprite ==2){
                    imagen = up2;
                }
            }
    }*/
}
