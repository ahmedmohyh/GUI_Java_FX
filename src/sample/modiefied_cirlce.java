package sample;

import javafx.scene.shape.Circle;

public class modiefied_cirlce extends Circle {
    double center_x;
    double center_y;
    modiefied_cirlce(){

    }
    modiefied_cirlce(double val1 , double val2 , double len){

        center_x = val1;
        center_y = val2;
        double side = ((double) len /2);
        super.setCenterX(center_x-side);
        super.setCenterY(center_y-side);
        super.setRadius(len);


    }

    public double getCenter_y() {
        return center_y;
    }

    public double getCenter_x() {
        return center_x;
    }
}
