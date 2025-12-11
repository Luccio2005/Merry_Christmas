package Main;

import entidad.jugador;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Panel_de_Juego extends JPanel implements Runnable{
    final int originalTileSize = 55;   //64x64
    final int escala = 3;  //escala en la pantalla

    public final int tileSize = originalTileSize * escala;
    public final int tamanoColumna = 20;
    public final int tamanoFila = 12;
    public final int anchoPantalla = tileSize * tamanoColumna;
    public final int altoPantalla = tileSize * tamanoFila;

    public int maxWorldCol;
    public int maxWorldRow;
    public final int maxmap = 10;
    public int actualmapa = 0;

    int FPS = 60;

    Teclado keyH = new Teclado();
    Thread gameThread;
    jugador jugador = new jugador(this, keyH);
    
    //estados de juego
    public int estadodeljuego;
    public final int pantalladeinicio =0;
    public final int reanudar = 1;
    public final int pausar = 2;
    public final int dialogo = 3;
    public final int estadodepersonaje = 4;
    public final int estadodeopciones = 5;
    public final int estadogameover = 6;
    public final int estadotransicion = 7;
    public final int estadointercambio = 8;
    public final int estadodormir = 9;
    public final int estadomapa = 10;

    public Panel_de_Juego() {
        this.setPreferredSize(new Dimension(anchoPantalla, altoPantalla));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    public void setupGame(){
    }
    public void retry(){
    }
    public void restart(){
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        double dibujarIntervalo = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + dibujarIntervalo;

        while(gameThread != null){

            actualizar();
            dibujartemppantalla();
            dibujarpantalla();
            repaint();

            try{
                double tiempoRestante = nextDrawTime - System.nanoTime();
                tiempoRestante = tiempoRestante/1000000;

                if(tiempoRestante <0){
                    tiempoRestante = 0;
                }
                Thread.sleep((long) tiempoRestante);

                nextDrawTime += dibujarIntervalo;
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public void actualizar(){
        jugador.actualizar();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        jugador.dibujar(g2);
        g2.dispose();
    }
    public void dibujartemppantalla(){

    }
    public void dibujarpantalla(){

    }
    public void playMusic(int i){
    }
    public void stopMusic(){

    }
    public void playSE(int i){

    }
}
