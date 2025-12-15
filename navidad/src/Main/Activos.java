package Main;

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
}
