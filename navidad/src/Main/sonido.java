package Main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.net.URL;

public class sonido {
    Clip clip;
    URL Urlsonido[] = new URL[30];

    public sonido(){
        Urlsonido[0]= getClass().getResource("/sonido/Exo.wav");
        Urlsonido[1]= getClass().getResource("/sonido/star.wav");
        Urlsonido[2]= getClass().getResource("/sonido/cursor.wav");
    }
    public void setFile(int i){
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(Urlsonido[i]);
            clip= AudioSystem.getClip();
            clip.open(ais);
            //fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
            //comprobarvolumen();
        } catch (Exception e) {
        }
    }
    public void play(){
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }
}
