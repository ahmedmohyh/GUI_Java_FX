package sample;

public class pair {
    private modified_rec myrec = null;
    private modiefied_cirlce myc = null ;
    pair (modified_rec m , modiefied_cirlce c){
        if(m== null){
            myc = c;
        }
        else if (c==null){
            myrec = m;
        }
    }

    public modiefied_cirlce getMyc() {
        return myc;
    }  

    public modified_rec getMyrec() {
        return myrec;
    }
}
