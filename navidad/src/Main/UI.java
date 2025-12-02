package Main;

import entidad.entidad;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class UI {
    Panel_de_Juego gp;
    Graphics2D g2;
    public Font arial_40, arial_80B;
    BufferedImage heart_full, heart_half, heart_blank, crystal_full,crystal_blank, coin;
    public boolean mensajeOn= false;
    //public String mensaje = "";
    //int mensajeContador = 0;
    ArrayList<String> mensaje = new ArrayList<>();
    ArrayList<Integer> contadormensaje = new ArrayList<>();
    public boolean juegoterminado = false;
    public String dialogoactual = "";
    public int numerodecomando = 0;
    public int jugadorranuracol = 0;
    public int jugadorranurafila = 0;
    public int npcranuracol = 0;
    public int npcranurafila = 0;
    int substate = 0;
    int contador = 0;
    public entidad npc;
}
