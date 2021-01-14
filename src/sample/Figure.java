package sample;

import javafx.scene.canvas.GraphicsContext;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;

public interface Figure {
    void repaint (GraphicsContext gc,  List<pair> p ) ;
    boolean  contains(double x , double y ,  List<modified_rec> R, List<modiefied_cirlce> C );
}
