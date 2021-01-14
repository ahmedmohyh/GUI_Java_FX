package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.List;
import javax.sound.sampled.*;

public class Compositefigure implements  Figure {
    @Override
    public void repaint(GraphicsContext gc ,List<pair> p)  {
sound ss  = new sound();
        gc.clearRect(0,0,500,500);
        gc.setFill(Color.LIGHTCYAN);
        gc.fillRect(0,0,500,500);
        for (pair r :p) {
            if (r.getMyc() == null) {

                gc.setFill(Color.GREEN);
                    gc.setStroke(Color.BLACK);
                gc.strokeRect(r.getMyrec().getX(),r.getMyrec().getY(),r.getMyrec().getHeight(),r.getMyrec().getWidth());
                gc.fillRect(r.getMyrec().getX(),r.getMyrec().getY(),r.getMyrec().getHeight(),r.getMyrec().getWidth());
                gc.setFill(Color.BLACK);
                gc.fillRect(r.getMyrec().getCenter_x(),r.getMyrec().getCenter_y(),2,2);



            } else if(r.getMyrec()==null){

                gc.setFill(Color.INDIANRED);
                gc.setStroke(Color.BLACK);
                gc.strokeOval(r.getMyc().getCenterX(),r.getMyc().getCenterY(),r.getMyc().getRadius(),r.getMyc().getRadius());
                gc.fillOval(r.getMyc().getCenterX(),r.getMyc().getCenterY(),r.getMyc().getRadius(),r.getMyc().getRadius());
                gc.setFill(Color.BLACK);
                gc.fillOval(r.getMyc().getCenter_x(),r.getMyc().getCenter_y(),2,2);

            }


        }
        ss.right();


    }

    @Override
    public boolean contains(double x, double y ,  List<modified_rec> R , List<modiefied_cirlce> C) {
        if (R.size()==0 && C.size() ==0) return  false;
        boolean found_rec = false;
        boolean found_cir = false;
// First check if it's inside a rectangle
        for (modified_rec r:R){
            if (x<=r.getX()+r.getWidth() && x>=r.getX() && y>= r.getY() && y<=r.getHeight()+r.getY() ){
                found_rec = true;
                System.out.println("Detected here in Rec");
                break;
            }
        }
        if (found_rec){
            System.out.println("Reterned here in Rec");
            return true;
        }
        System.out.println("passed here in Rec");
// Second check if it's inside a circle
        for (modiefied_cirlce c: C){
            double cox = c.getCenter_x();
            double coy = c.getCenter_y();
            double pw = Math.pow(Math.abs(cox-x),2) + Math.pow(Math.abs(coy -y),2);
            double rot = Math.sqrt(pw);
            if (rot<=c.getRadius()-36) {
                found_cir = true;
                System.out.println("Detected here in Cir");
                break;
            }
        }
      if (found_cir){
          System.out.println("Reterned here in Cir");
          return true;

      }
        System.out.println("passed here in Cir");
            return false;


    }

}
