package Main;

import java.awt.*;

public class Eventos {
    Panel_de_Juego gp;
    EventoRect eventoRect[][];
    int anterioreventox, anterioreventoy;
    boolean cantouchevent = true;
    public Eventos(Panel_de_Juego gp){
        this.gp = gp;

        eventoRect = new EventoRect[gp.tamanoColumna][gp.tamanoFila];
        int col = 0;
        int fila = 0;
        while(col< gp.tamanoColumna && fila < gp.tamanoFila){
            eventoRect[col][fila] = new EventoRect();
            eventoRect[col][fila].x = 70;
            eventoRect[col][fila].y = 70;
            eventoRect[col][fila].width = 16;
            eventoRect[col][fila].height = 16;
            eventoRect[col][fila].eventRectDefaultX = eventoRect[col][fila].x;
            eventoRect[col][fila].eventRectDefaultY = eventoRect[col][fila].y;
            col++;
            if(col == gp.tamanoColumna){
                col = 0;
                fila++;
            }
        }
    }
    public void comprobarevento(){
        //comprobar si el jugador se mueve un suelo mas q en el ultimo evento
        int distanciax = Math.abs(gp.jugador.mundox - anterioreventox);
        int distanciay = Math.abs(gp.jugador.mundoy - anterioreventoy);
        int distancia = Math.max(distanciax, distanciay);
        if(distancia > gp.tileSize){
            cantouchevent = true;
        }
        if(cantouchevent == true){
        if(hit(3,2,"down") == true){
            dialogofinal(3,2,gp.dialogo);
        }}
    }
    public boolean hit(int col, int fila, String reqDireccion){
        boolean hit = false;
        //if(map == gp.actualmapa){
            gp.jugador.areadecolision.x = gp.jugador.mundox + gp.jugador.areadecolision.x;
            gp.jugador.areadecolision.y = gp.jugador.mundoy + gp.jugador.areadecolision.y;
            eventoRect[col][fila].x = col*gp.tileSize + eventoRect[col][fila].x;
            eventoRect[col][fila].y = fila*gp.tileSize + eventoRect[col][fila].y;
            if(gp.jugador.areadecolision.intersects(eventoRect[col][fila]) && eventoRect[col][fila].eventohecho == false){
                if(gp.jugador.direccion.contentEquals(reqDireccion) || reqDireccion.contentEquals("down")){
                    hit= true;
                    anterioreventox = gp.jugador.mundox;
                    anterioreventoy = gp.jugador.mundoy;
                }
            }
            gp.jugador.areadecolision.x = gp.jugador.areadecolisionx;
            gp.jugador.areadecolision.y = gp.jugador.areadecolisiony;
            eventoRect[col][fila].x = eventoRect[col][fila].eventRectDefaultX;
            eventoRect[col][fila].y = eventoRect[col][fila].eventRectDefaultY;
            return hit;
    }
    public void dialogofinal(int col, int fila, int estadodeljuego){
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
        //eventoRect[col][fila].eventohecho = true;
        cantouchevent = false;
    }
}
