package suelo;

import Main.Panel_de_Juego;

import javax.imageio.ImageIO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class administradordesuelo {
    Panel_de_Juego gp;
    public suelo[] suelo;
    public int mapNum[][][];
    boolean dibujarcamino = false;
    ArrayList<String> nombredoc = new ArrayList<>();
    ArrayList<String> estatusdecolision = new ArrayList<>();

    public administradordesuelo(Panel_de_Juego gp){
        this.gp = gp;
        // leer tile data
        InputStream is = getClass().getResourceAsStream("/mapas/datos.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        // obtener tile names and colission info
        String linea;
        try{
            while((linea = br.readLine()) != null){
                nombredoc.add(linea);
                estatusdecolision.add(br.readLine());
            }
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        // iniciar el tile array
        suelo = new suelo[nombredoc.size()];
        getTileImage();

        is = getClass().getResourceAsStream("/mapas/casa.txt");
        br = new BufferedReader(new InputStreamReader(is));

        try{
            String linea2 = br.readLine();
            String maxsuelo[] = linea2.split(" ");
            gp.maxWorldCol = maxsuelo.length;
            gp.maxWorldRow = maxsuelo.length;
            mapNum = new int[gp.maxmap][gp.maxWorldCol][gp.maxWorldRow];
            br.close();
        }catch(IOException e){
            System.out.println("Exception!");
        }


        cargarMapa("/mapas/casa.txt",0);
    }
    public void getTileImage(){
        for(int i=0; i<nombredoc.size();i++){
            String nombredoc1;
            boolean colision;
            nombredoc1 = nombredoc.get(i);
            if(estatusdecolision.get(i).equals("true")){
                colision = true;
            }else{
                colision = false;
            }
            setup(i, nombredoc1, colision);
        }
    }
    public void setup(int indice, String nombreimagen, boolean colision){
        Herramientasdeutilidad Herramienta = new Herramientasdeutilidad();

        try{
            suelo[indice] = new suelo();
            suelo[indice].imagen = ImageIO.read(getClass().getResourceAsStream("/suelo/"+nombreimagen));
            suelo[indice].imagen = Herramienta.Imagenescala(suelo[indice].imagen,gp.tileSize, gp.tileSize);
            suelo[indice].colision = colision;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
