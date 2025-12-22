package Main;


import entidad.entidad;
import suelo.administradordesuelo;

import entidad.jugador;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Panel_de_Juego extends JPanel implements Runnable{
    final int originalTileSize = 55;   //55x55
    final int escala = 3;  //escala en la pantalla

    public int estrellasrecogidas = 0;
    public int estrellasentregadas = 0;
    public final int tileSize = originalTileSize * escala;
    public final int tamanoColumna = 7;
    public final int tamanoFila = 4;
    public final int anchoPantalla = tileSize * tamanoColumna;
    public final int altoPantalla = tileSize * tamanoFila;

    int FPS = 60;
    //system
    public administradordesuelo sueloM = new administradordesuelo(this);
    public Teclado keyH = new Teclado(this);
    sonido musica = new sonido();
    sonido se = new sonido();
    public comprobar_colisiones comprobar = new comprobar_colisiones(this);
    public Activos asetter = new Activos(this);
    public UI ui= new UI(this);
    public Eventos evento = new Eventos(this);
    Thread gameThread;
    //entidad y objeto
    public jugador jugador = new jugador(this, keyH);
    public entidad obj[] = new entidad[10];
    public entidad amiwitos[] = new entidad[10];
    public entidad entidadDialogoactual;
    ArrayList<entidad> listaentidad = new ArrayList<>();
    // estado del juego
    public int estadodeljuego;
    public final int pantalladeinicio =0;
    public final int reanudar = 1;
    public final int pausar = 2;
    public final int dialogo = 3;
    public final int estadodepersonaje = 4;
    public final int estadointercambio = 5;





    /*public int maxWorldCol;
    public int maxWorldRow;
    public final int maxmap = 10;
    public int actualmapa = 0;




    public final int estadodepersonaje = 4;
    public final int estadodeopciones = 5;
    public final int estadogameover = 6;
    public final int estadotransicion = 7;
    public final int estadointercambio = 8;
    public final int estadodormir = 9;
    public final int estadomapa = 10;
*/
    public Panel_de_Juego() {
        this.setPreferredSize(new Dimension(anchoPantalla, altoPantalla));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    public void setupGame(){
        asetter.setObject();
        asetter.setAmiwitos();
        //playMusic(0);
        estadodeljuego = pantalladeinicio;
    }/*
    public void retry(){
    }
    public void restart(){
    }*/
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
            //dibujartemppantalla();
            //dibujarpantalla();
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
       if(estadodeljuego == reanudar){
           jugador.actualizar();
       }
        // CONTROL DE DIALOGOS
        if(estadodeljuego == dialogo && keyH.enterp){
            // avanzar dialogo
            entidadDialogoactual.hablar();

            // si ya no hay dialogos → salir
            if(entidadDialogoactual.dialogos[entidadDialogoactual.indicededialogos] == null){
                estadodeljuego = reanudar;
                entidadDialogoactual.indicededialogos = 0;
            }

            keyH.enterp = false;
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if(estadodeljuego == pantalladeinicio){
            ui.dibujar(g2);
        }else{
            // suelo
            sueloM.dibujar(g2);
            // jugador
            listaentidad.add(jugador);

            for(int i = 0; i< amiwitos.length; i++){
                if(amiwitos[i] != null){
                    listaentidad.add(amiwitos[i]);
                }
            }
            for(int i = 0; i< obj.length; i++){
                if(obj[i] != null){
                    listaentidad.add(obj[i]);
                }
            }
            //sort
            Collections.sort(listaentidad, new Comparator<entidad>() {
                @Override
                public int compare(entidad e1, entidad e2) {
                    int result = Integer.compare(e1.mundoy, e2.mundoy);
                    return result;
                }
            });
            // dibujar entidades
            for(int i = 0; i< listaentidad.size();i++){
                listaentidad.get(i).dibujar(g2);
            }
            //vaciar lista entidad
            listaentidad.clear();
            ui.dibujar(g2);
        }

        g2.dispose();
    }/*
    public void dibujartemppantalla(){

    }
    public void dibujarpantalla(){

    }*/
    public void playMusic(int i){
        musica.setFile(i);
        musica.play();
        musica.loop();
    }
    public void stopMusic(){
        musica.stop();
    }
    public void playSE(int i){
        se.setFile(i);
        se.play();
    }
}
