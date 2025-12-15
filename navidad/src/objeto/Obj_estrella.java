package objeto;

import Main.Panel_de_Juego;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Obj_estrella extends Superobjeto{
    Panel_de_Juego gp;
    public Obj_estrella(Panel_de_Juego gp){
        this.gp = gp;
        nombre = "estrella";
        try{
            imagen = ImageIO.read(getClass().getResourceAsStream("/objetos/estrella.png"));
            Herramienta.Imagenescala(imagen, gp.tileSize, gp.tileSize);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
