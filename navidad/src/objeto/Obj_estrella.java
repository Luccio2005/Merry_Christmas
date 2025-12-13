package objeto;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Obj_estrella extends Superobjeto{
    public Obj_estrella(){
        nombre = "estrella";
        try{
            imagen = ImageIO.read(getClass().getResourceAsStream("/objetos/estrella.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
