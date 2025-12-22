package objeto;

import entidad.entidad;
import Main.Panel_de_Juego;

public class Obj_estrella extends entidad{
    Panel_de_Juego gp;

    public Obj_estrella(Panel_de_Juego gp){
        super(gp);
        this.gp = gp;
        tipo = tipo_consumible;
        nombre = "estrella";
        down1 = setup("/objetos/estrella");
        descripcion = "["+nombre+"]\nIlumina en la oscuridad\nmas profunda";
        // stackable = true;
    }
    /*public boolean usar(entidad entidad){
        gp.estadodeljuego = gp.dialogo;
        int indiceobj = getdetected(entidad, gp.obj, "puerta");
        if(indiceobj != 999){
            gp.ui.dialogoactual = "Abriste la puerta";
            gp.playSE(3);
            gp.obj[gp.actualmapa][indiceobj] = null;
            return true;
        }else{
            gp.ui.dialogoactual = "Que haces?";
            return false;
        }
    }*/
}
