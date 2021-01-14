package sample;

public class game {// Hier should the logic of the game implemented
    private static game mygame;
    view v;
    Compositefigure c ;
    game (){

    }
    public  void link (view v , Compositefigure c){
        this.v = v;
        this.c = c;
        v.addhandler(this);
    }
    public static game getInstance(){
if (mygame==null){
    synchronized (game.class){
        if (mygame==null){
            mygame = new game();
        }
    }
}
return mygame;
    }
}
