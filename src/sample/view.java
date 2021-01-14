package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class view  extends VBox {
    boolean can_continue = true;
    double rad_len ;
    int miss_clk =0 ;
    int right_cl=0;
    int timy ;
    Text tim = new Text("Time left: ");
    Text clk = new Text("Missed clicks: " +miss_clk );
    Text plc_graphc = new Text ("Placed graphics: "+ right_cl);
    TextField tx = new TextField("70");
    Button btn = new Button("Start");
    List<modified_rec> R = new ArrayList<>();
    List<modiefied_cirlce> C = new ArrayList<>();
    List <pair> mypair = new ArrayList<>();
    Canvas canvas = new Canvas(500,500);
    GraphicsContext context =canvas.getGraphicsContext2D();


    view(){
       rad_len = Double.parseDouble(tx.getText());
       context.setFill(Color.LIGHTCYAN);
       context.fillRect(0,0,500,500);
       // context.fillRect(50,50,100,100);
        //canvas.setLayoutX(0);


this.getChildren().addAll(btn,tx,tim,clk, plc_graphc,canvas);
    }
    public List<modified_rec> get_rec(){
        return  R;
    }
    public List<modiefied_cirlce> get_cir(){
        return  C;
    }
    public void set_rec(modified_rec r){
        R.add(r);
    }
    public void set_cir (modiefied_cirlce c){
        C.add(c);
    }
    void addhandler(game g) {
        tx.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {

                System.out.println(" Text Changed to  " + newValue + ")\n");
                rad_len =Integer.parseInt(newValue);
            }
        });

        this.setOnMouseClicked(event -> {
            if (can_continue) {
                if (event.getButton() == MouseButton.PRIMARY) // right click
                { // Hier should the logic of already created Rectangle be impplmented'
                    if (g.c.contains(event.getSceneX(), event.getSceneY() - 100, this.get_rec(), this.get_cir())) {
                        sound ss = new sound();
                        clk.setText("Missed clicks: " + ++miss_clk);
                        ss.wrong();
                    } else {
                        R.add(new modified_rec(event.getSceneX(), event.getSceneY() - 100, rad_len));
                        mypair.add(new pair(new modified_rec (event.getSceneX(), event.getSceneY() - 100, rad_len),null));
                        g.c.repaint(context, mypair);
                 /* modified_rec rr = new modified_rec(event.getSceneX(),event.getSceneY()-100,rad_len);
                  context.setFill(Color.GREEN);
                  context.fillRect(rr.getX(),rr.getY(),rr.getHeight(),rr.getWidth());*/
                        plc_graphc.setText("Placed graphics: " + ++right_cl);
                    }


                } else if (event.getButton() == MouseButton.SECONDARY)  // left click
                {
                    // Hier should the logic of already created Rectangle be impplmented
                    if (g.c.contains(event.getSceneX(), event.getSceneY() - 100, this.get_rec(), this.get_cir())) {
                        sound ss = new sound();
                        clk.setText("Missed clicks: " + ++miss_clk);
                       ss.wrong();
                    } else {
                        C.add(new modiefied_cirlce(event.getSceneX(), event.getSceneY() - 100, rad_len));
                        mypair.add(new pair(null, new modiefied_cirlce( event.getSceneX(), event.getSceneY() - 100, rad_len)));

                        g.c.repaint(context, mypair);
                    /*modiefied_cirlce m = new modiefied_cirlce(event.getSceneX(),event.getSceneY()-100,rad_len);
                    context.setFill(Color.INDIANRED);
                    context.fillOval(m.getCenterX(),m.getCenterY(),rad_len,rad_len);*/

                        plc_graphc.setText("Placed graphics: " + ++right_cl);
                    }

                }
            }

        });
        btn.setOnAction(event1 -> {
            timy = 11;
            can_continue = true;
            context.clearRect(0,0,500,500);
            context.setFill(Color.LIGHTCYAN);
            context.fillRect(0,0,500,500);
            miss_clk = 0;
            clk.setText("Missed clicks: " +miss_clk );
            right_cl = 0;
            plc_graphc.setText("Placed graphics: "+ right_cl);
            R.clear();
            C.clear();
            mypair.clear();
            timeline.setCycleCount(11);
            timeline.play();
        });

    }
    public Text getTim(){
        return  tim;
    }
    public Text getClk(){
        return  clk;

    }
    public Text getPlc_graphc(){
        return  plc_graphc;
    }
    Timeline timeline = new Timeline (new KeyFrame( Duration. seconds ( 1 ) , event -> {
tim.setText("Time left: " +--timy);
if (timy ==0){
can_continue = false;
}
    }));

}
