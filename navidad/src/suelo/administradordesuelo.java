package suelo;

import Main.Herramientasdeutilidad;
import Main.Panel_de_Juego;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class administradordesuelo {
    Panel_de_Juego gp;
    public suelo[] suelo;
    public int mapNum[][];
    /*public int mapNum[][][];
    boolean dibujarcamino = false;
    ArrayList<String> nombredoc = new ArrayList<>();
    ArrayList<String> estatusdecolision = new ArrayList<>();
*/
    public administradordesuelo(Panel_de_Juego gp){
        this.gp = gp;
        suelo = new suelo[50];
        mapNum = new int[gp.tamanoColumna][gp.tamanoFila];
        getTileImage();
        cargarMapa();

        /*
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


        cargarMapa("/mapas/casa.txt",0);*/
    }
    public void getTileImage(){
            setup(01,"arbol1",true);
            setup(02,"arbol2",true);
            setup(03,"pared1",true);
            setup(04,"pared2",true);
            setup(05,"sillon1",true);
            setup(06,"suelo1",false);
            setup(07,"suelo2",false);
            setup(10,"maceta",false);
            setup(11,"pared3",true);
            setup(12,"sillon2",true);
            setup(13,"ventana",true);
        /*
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
        }*/
    }
    /*public void setup(int indice, String nombreimagen, boolean colision){
        Herramientasdeutilidad Herramienta = new Herramientasdeutilidad();

        try{
            suelo[indice] = new suelo();
            suelo[indice].imagen = ImageIO.read(getClass().getResourceAsStream("/suelo/"+nombreimagen));
            suelo[indice].imagen = Herramienta.Imagenescala(suelo[indice].imagen,gp.tileSize, gp.tileSize);
            suelo[indice].colision = colision;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    public void setup(int indice, String nombreimagen, boolean colision){
        Herramientasdeutilidad Herramienta = new Herramientasdeutilidad();

        try{
            suelo[indice] = new suelo();
            suelo[indice].imagen = ImageIO.read(getClass().getResourceAsStream("/suelo/"+nombreimagen+".png"));
            suelo[indice].imagen = Herramienta.Imagenescala(suelo[indice].imagen,gp.tileSize, gp.tileSize);
            suelo[indice].colision = colision;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void cargarMapa(/*String filePath, int map*/){
        try{
            InputStream is = getClass().getResourceAsStream("/mapas/beta.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int fila = 0;

            while (col < gp.tamanoColumna && fila < gp.tamanoFila){
                String linea = br.readLine();
                while(col < gp.tamanoColumna){
                    String numeros[] = linea.split(" ");
                    int num = Integer.parseInt(numeros[col]);
                    mapNum[col][fila] = num;
                    col++;
                }
                if(col == gp.tamanoColumna){
                    col=0;
                    fila++;
                }
            }
            br.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        /*try{
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            // 🟢 1. Crear matriz con el tamaño ACTUAL del mapa
            mapNum[map] = new int[gp.maxWorldCol][gp.maxWorldRow];

            int col = 0;
            int fila = 0;

            while (fila < gp.maxWorldRow){
                String linea = br.readLine();
                String numeros[] = linea.split(" ");

                for(col = 0; col < gp.maxWorldCol; col++){
                    mapNum[map][col][fila] = Integer.parseInt(numeros[col]);
                }
                fila++;
            }

            br.close();

        } catch (Exception e){
            e.printStackTrace();
        }*/
    }
    public void dibujar(Graphics2D  g2){
        int columnamundo = 0;
        int filamundo = 0;
        int x = 0;
        int y = 0;
        while(columnamundo < gp.tamanoColumna && filamundo < gp.tamanoFila){
            int tileNum = mapNum[columnamundo][filamundo];
            g2.drawImage(suelo[tileNum].imagen,x, y,null);
            columnamundo++;
            x += gp.tileSize;
            if(columnamundo == gp.tamanoColumna){
                columnamundo = 0;
                x=0;
                filamundo++;
                y += gp.tileSize;
            }
        }
        /*int columnammundo=0;
        int filamundo=0;

        while(columnammundo < gp.maxWorldCol  && filamundo < gp.maxWorldRow){
            int tileNum = mapNum[gp.actualmapa][columnammundo][filamundo];

            int mundox = columnammundo * gp.tileSize;
            int mundoy = filamundo * gp.tileSize;
            int pantallax= mundox - gp.jugador.mundox + gp.jugador.pantallax;
            int pantallay= mundoy - gp.jugador.mundoy + gp.jugador.pantallay;

            if(mundox + gp.tileSize > gp.jugador.mundox - gp.jugador.pantallax &&
                    mundox - gp.tileSize < gp.jugador.mundox + gp.jugador.pantallax &&
                    mundoy + gp.tileSize > gp.jugador.mundoy - gp.jugador.pantallay &&
                    mundoy - gp.tileSize < gp.jugador.mundoy + gp.jugador.pantallay){
                g2.drawImage(suelo[tileNum].imagen, pantallax, pantallay,null);
            }

            columnammundo++;

            if(columnammundo == gp.maxWorldCol){
                columnammundo=0;
                filamundo++;
            }
        }*/
    }
}
