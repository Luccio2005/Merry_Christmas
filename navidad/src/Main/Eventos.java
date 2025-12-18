package Main;

import java.awt.*;

public class Eventos {
    Panel_de_Juego gp;
    Rectangle eventoRect;
    int eventRectDefaultX, eventRectDefaultY;
    public Eventos(Panel_de_Juego gp){
        this.gp = gp;

        eventoRect = new Rectangle();
        eventoRect.x = 70;
        eventoRect.y = 70;
        eventoRect.width = 16;
        eventoRect.height = 16;
        eventRectDefaultX = eventoRect.x;
        eventRectDefaultY = eventoRect.y;
    }
    public void comprobarevento(){
        if(hit(3,2,"down") == true){
            dialogofinal(gp.dialogo);
        }
        //comprobar si el jugador se mueve un suelo mas q en el ultimo evento
        /*int distanciax = Math.abs(gp.jugador.mundox - anterioreventox);
        int distanciay = Math.abs(gp.jugador.mundoy - anterioreventoy);
        int distancia = Math.max(distanciax, distanciay);
        if(distancia > gp.tileSize){
            cantouchevent = true;
        }
        if(cantouchevent == true){
            if(hit(0,27,16,"right") == true){
                damagepit(gp.dialogo);
            }
            else if(hit(0,23,12,"up") == true){
                healingpool(gp.dialogo);
            }
            else if (hit(0, 10, 39, "any") == true){
                teleport(1,12,13);
            }
            else if (hit(1, 12, 13, "any") == true){
                teleport(0,10,39);
            }
            else if(hit(1, 12, 9, "up") == true){
                hablar(gp.npc[1][0]);
            }
            else if(hit(0,12,9,"any")==true){
                teleport(2,5,10);
            }
        }*/
    }
    public boolean hit(int col, int fila, String reqDireccion){
        boolean hit = false;
        //if(map == gp.actualmapa){
            gp.jugador.areadecolision.x = gp.jugador.mundox + gp.jugador.areadecolision.x;
            gp.jugador.areadecolision.y = gp.jugador.mundoy + gp.jugador.areadecolision.y;
            eventoRect.x = col*gp.tileSize + eventoRect.x;
            eventoRect.y = fila*gp.tileSize + eventoRect.y;
            if(gp.jugador.areadecolision.intersects(eventoRect)/* && eventoRect[map][col][fila].eventohecho == false*/){
                if(gp.jugador.direccion.contentEquals(reqDireccion) || reqDireccion.contentEquals("down")){
                    hit= true;
                   // anterioreventox = gp.jugador.mundox;
                   // anterioreventoy = gp.jugador.mundoy;
                }
            }
            gp.jugador.areadecolision.x = gp.jugador.areadecolisionx;
            gp.jugador.areadecolision.y = gp.jugador.areadecolisiony;
            eventoRect.x = eventRectDefaultX;
            eventoRect.y = eventRectDefaultY;
            return hit;
    }
    public void dialogofinal(int estadodeljuego){
        gp.estadodeljuego = estadodeljuego;
        gp.entidadDialogoactual = gp.jugador;
        gp.jugador.dialogos[0] = "Jueliz Navidad TONOTOS!!!";
        gp.jugador.dialogos[1] = ".....";
        gp.jugador.dialogos[2] = "******";
        gp.jugador.dialogos[3] = "......";
        gp.jugador.dialogos[4] = "******";
        gp.jugador.dialogos[5] = null;

        gp.jugador.indicededialogos =0;
        gp.jugador.hablar();
    }
}
