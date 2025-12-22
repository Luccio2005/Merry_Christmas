package entidad;

import Main.Panel_de_Juego;

public class alexi extends entidad{
    public alexi(Panel_de_Juego gp){
        super(gp);
        direccion= "down";
        getImage();
        setdialogo();
    }
    public void getImage(){
        down1 = setup("/amiwitos/alexi-1");
        //down2 = setup("/amiwitos/ann-1");
    }
    public void setdialogo(){
        dialogos[0] = "para ti!!!";
        dialogos[1] = null;

    }
    public void hablar(){

        super.hablar();
        gp.estadodeljuego = gp.estadointercambio;
    }
}
