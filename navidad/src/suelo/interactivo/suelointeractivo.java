/*package suelo.interactivo;

import Main.Panel_de_Juego;
import entidad.entidad;
import java.awt.*;

public class suelointeractivo extends entidad {

    Panel_de_Juego gp;

    public suelointeractivo(Panel_de_Juego gp, int col, int fila) {
        super(gp);
        this.gp = gp;

        this.mundox = col * gp.tileSize;
        this.mundoy = fila * gp.tileSize;

        // IMPORTANTE: no se puede recoger
        pickable = false;
    }

    public void actualizar() {
        // por ahora nada
    }

    public void dibujar(Graphics2D g2) {

        int pantallax = mundox - gp.jugador.mundox + gp.jugador.pantallax;
        int pantallay = mundoy - gp.jugador.mundoy + gp.jugador.pantallay;

        if (mundox + gp.tileSize > gp.jugador.mundox - gp.jugador.pantallax &&
                mundox - gp.tileSize < gp.jugador.mundox + gp.jugador.pantallax &&
                mundoy + gp.tileSize > gp.jugador.mundoy - gp.jugador.pantallay &&
                mundoy - gp.tileSize < gp.jugador.mundoy + gp.jugador.pantallay) {

            g2.drawImage(down1, pantallax, pantallay, null);
        }
    }
}*/


