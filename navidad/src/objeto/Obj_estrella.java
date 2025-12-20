package objeto;

import entidad.entidad;
import Main.Panel_de_Juego;

public class Obj_estrella extends entidad{
    public Obj_estrella(Panel_de_Juego gp){
        super(gp);
        nombre = "estrella";
        down1 = setup("/objetos/estrella");
        descripcion = "["+nombre+"]\nIlumina en la oscurdad mas profunda";
    }
}
