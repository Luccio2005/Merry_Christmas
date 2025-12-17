package entidad;

import Main.Herramientasdeutilidad;
import Main.Panel_de_Juego;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ann extends entidad{
    public ann(Panel_de_Juego gp){
        super(gp);

        direccion= "down";
        getImage();
        setdialogo();
    }
    public void getImage(){
        down1 = setup("/amiwitos/ann-1");
        //down2 = setup("/amiwitos/ann-1");
    }
    public void setdialogo(){
        dialogos[0] = "para ti";
    }
}
