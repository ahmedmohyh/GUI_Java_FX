package sample;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import javax.sound.sampled.*;

public class sound {
    sound (){

    }
   public void wrong() {
        try
        {
            Path path = FileSystems.getDefault().getPath("D:\\Rects and cirles\\src\\sample\\wr.wav").toAbsolutePath();
            File file = new File(String.valueOf(path));

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);

            AudioFormat format = audioInputStream.getFormat();

            long audioFileLength = file.length();
            int frameSize = format.getFrameSize();
            float frameRate = format.getFrameRate();
            float durationInSeconds = (audioFileLength / (frameSize * frameRate));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex)
        {
            ex.printStackTrace();
        }
       // AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("wrong.wav"));

    }
    public void right(){
        try
        {
            Path path = FileSystems.getDefault().getPath("D:\\Rects and cirles\\src\\sample\\rg.wav").toAbsolutePath();
            File file = new File(String.valueOf(path));

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);

            AudioFormat format = audioInputStream.getFormat();

            long audioFileLength = file.length();
            int frameSize = format.getFrameSize();
            float frameRate = format.getFrameRate();
            float durationInSeconds = (audioFileLength / (frameSize * frameRate));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex)
        {
            ex.printStackTrace();
        }

    }
}

