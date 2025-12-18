package objeto;

import Main.Panel_de_Juego;
import entidad.entidad;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Obj_arbolnav extends entidad{
    public Obj_arbolnav(Panel_de_Juego gp){
        super(gp);
        nombre = "arbolnav";
        down1 = setup("/objetos/arbolnav");
        colision = true;
    }
}
