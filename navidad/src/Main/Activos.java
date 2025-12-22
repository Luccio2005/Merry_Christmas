package Main;

import entidad.aby;
import entidad.alexi;
import entidad.ann;
import entidad.svent;
import objeto.Obj_estrella;

public class Activos {
    Panel_de_Juego gp;
    public Activos(Panel_de_Juego gp){
        this.gp = gp;
    }
    public void setObject(){
        int i =0;
        gp.obj[i] = new Obj_estrella(gp);
        gp.obj[i].mundox = gp.tileSize;
        gp.obj[i].mundoy = 3*gp.tileSize;
        i++;
        gp.obj[i] = new Obj_estrella(gp);
        gp.obj[i].mundox = 5*gp.tileSize;
        gp.obj[i].mundoy = 3*gp.tileSize;
        i++;
        gp.obj[i] = new Obj_estrella(gp);
        gp.obj[i].mundox = gp.tileSize;
        gp.obj[i].mundoy = 2*gp.tileSize;
        i++;
        gp.obj[i] = new Obj_estrella(gp);
        gp.obj[i].mundox = 5*gp.tileSize;
        gp.obj[i].mundoy = 2*gp.tileSize;
        i++;
    }
    public void setAmiwitos(){
        int i = 0;
        gp.amiwitos[i]= new ann(gp);
        gp.amiwitos[i].mundox = gp.tileSize;
        gp.amiwitos[i].mundoy = gp.tileSize;
        i++;
        gp.amiwitos[i]= new aby(gp);
        gp.amiwitos[i].mundox = 2*gp.tileSize;
        gp.amiwitos[i].mundoy = gp.tileSize;
        i++;
        gp.amiwitos[i]= new alexi(gp);
        gp.amiwitos[i].mundox = 4*gp.tileSize;
        gp.amiwitos[i].mundoy = gp.tileSize;
        i++;
        gp.amiwitos[i]= new svent(gp);
        gp.amiwitos[i].mundox = 5*gp.tileSize;
        gp.amiwitos[i].mundoy = gp.tileSize;
        i++;
    }
}
