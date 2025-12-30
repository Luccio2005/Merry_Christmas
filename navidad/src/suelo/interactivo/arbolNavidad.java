/*package suelo.interactivo;

import Main.Panel_de_Juego;
import entidad.entidad;

public class arbolNavidad extends suelointeractivo {

    Panel_de_Juego gp;
    boolean brilloactivado = false;

    public arbolNavidad(Panel_de_Juego gp,int col, int fila) {
        super(gp, col, fila);
        this.gp = gp;
        nombre = "ArbolNavidad";
        colision = true;

        this.mundox = gp.tileSize * col;
        this.mundoy = gp.tileSize * fila;

        down1 = setup("/interactivo/arbolnav",gp.tileSize,gp.tileSize);
    }

    @Override
    public void actualizar() {

        if (!brilloactivado && gp.estrellasentregadas >= 4) {
            down1 = setup("/objetos/arbol_brillante");
            brilloactivado = true;

        }
    }
}*/
