package objeto;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Obj_arbolnav extends Superobjeto{
    public Obj_arbolnav(){
        nombre = "arbolnav";
        try{
            imagen = ImageIO.read(getClass().getResourceAsStream("/objetos/arbolnav.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        colision = true;
    }
}
