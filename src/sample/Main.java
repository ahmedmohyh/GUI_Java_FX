package sample;

import javafx.application.Application;


import javafx.scene.Scene;
import javafx.stage.Stage;




public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{

           // sound s1 = new sound();


        view v= new view();
        game g = new game();
        Compositefigure c = new Compositefigure();
        g.link(v,c);
        Scene s = new Scene(v,500,600);
        primaryStage.setScene(s);
        primaryStage.setTitle("FigureGame");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    public void stop () {
    }
}

