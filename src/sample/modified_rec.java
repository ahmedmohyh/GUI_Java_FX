package sample;

import javafx.scene.shape.Rectangle;

public class modified_rec extends Rectangle {
    double center_x;
    double center_y;
    modified_rec(){

    }
    modified_rec(double val1 , double val2 , double len){

        center_x = val1;
        center_y = val2;
        double side = ((double) len /2);
        super.setX(center_x-side);
        super.setY(center_y-side);
        super.setWidth((double)len);
        super.setHeight((double) len);


    }

    public double getCenter_x() {
        return center_x;
    }

    public double getCenter_y() {
        return center_y;
    }

}
