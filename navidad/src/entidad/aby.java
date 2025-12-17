package entidad;

import Main.Panel_de_Juego;

public class aby extends entidad{
    public aby(Panel_de_Juego gp){
        super(gp);

        direccion= "down";
        getImage();
        setdialogo();
    }
    public void getImage(){
        down1 = setup("/amiwitos/aby-1");
        //down2 = setup("/amiwitos/ann-1");
    }
    public void setdialogo(){
        dialogos[0] = "para ti!!!";
    }
    public void hablar(){
        super.hablar();
    }
}
