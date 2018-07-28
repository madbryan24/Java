/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapterpattern;

/**
 *
 * @author asus
 */
public class AdapterPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         AudioPlayer ap= new AudioPlayer();

         ap.play("mp3", "yesterday.mp3");
         ap.play("mp4", "jump.mp4");      
   }   
}

interface MediaPlayer {
   public void play(String audioType,String fileName);
}

interface AdvancedMediaPlayer {	
   public void playMp4(String fileName);
}

interface Advanced2MediaPlayer {	
   public void playMp3(String fileName);
}

class mp3Player implements Advanced2MediaPlayer{

    @Override
    public void playMp3(String fileName) {
        System.out.println("Playing MP3: "+fileName);
    }

}

class mp4Player implements AdvancedMediaPlayer{

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing MP4: "+fileName);
    }
}

class MediaAdapter implements MediaPlayer{

    AdvancedMediaPlayer advancedMusicPlayer;
    Advanced2MediaPlayer advanced2MediaPlayer;
    public MediaAdapter(String audioType){
   
        if (audioType.equalsIgnoreCase("mp4")){
            advancedMusicPlayer = new mp4Player();
        }
        else if(audioType.equalsIgnoreCase("mp3")){
            advanced2MediaPlayer = new mp3Player();
        }
    }

   @Override
    public void play(String audioType, String fileName) {
   
        if(audioType.equalsIgnoreCase("mp4")){
            advancedMusicPlayer.playMp4(fileName);
        }
        else if(audioType.equalsIgnoreCase("mp3")){
            advanced2MediaPlayer.playMp3(fileName);
        }
    }
}

class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter; 

    @Override
    public void play(String audioType, String fileName) { 
        if(audioType.equalsIgnoreCase("mp3") || audioType.equalsIgnoreCase("mp4")){ 
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }else{
            System.out.println("Khong hop le. " + audioType + " dinh dang khong duoc ho tro");
        }
    } 
}
