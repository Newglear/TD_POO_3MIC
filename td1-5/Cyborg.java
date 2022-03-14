import java.awt.*;

public class Cyborg extends Robot {
    private int nbCol = 0;
    private int maxCol;
    public void collision(Robot autre) {
        this.vx = this.randomV() ;
        this.vy = this.randomV() ;
        this.nbCol++;
        if(this.nbCol >= this.maxCol){
            this.explose();
            expLog.add("Explosion détectée",this,autre);
        }
    }
    public Cyborg (String Nom,String nomImage, int init_x, int init_y, Plateau pt, Color col,int maxCol) {
        super(Nom,nomImage,init_x,init_y,pt,col);
        this.maxCol = maxCol;
    }
    public Cyborg (String Nom,String nomImage, int init_x, int init_y, Plateau pt, Color col) {
        super(Nom,nomImage,init_x,init_y,pt,col);
    }
    public String toString (){
        return "Je sais pas a quoi je sers mais je suis "+this.nom+" en "+this.x+" "+this.y+" de la série"+super.Serie;
    }
}
