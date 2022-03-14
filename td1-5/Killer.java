import java.awt.*;
public class Killer extends Robot{
    public int x;
    public int[] tab;
    public void collision(Robot autre) {
        tab[autre.getSerie()]+=1;
        this.vx = this.randomV() ;
        this.vy = this.randomV() ;
        if(tab[autre.getSerie()]>=x) {
            autre.explose();
            expLog.add("Explosion détectée",this,autre);
            System.out.println("Journal de collision: \n"+colLog.toString() + "Journal d'explosion: " + expLog.toString()+"\n");
        }
    }

    public Killer(String Nom,String nomImage, int init_x, int init_y, Plateau pt, Color col){
        super(Nom,nomImage,init_x,init_y,pt,col);
    }
    public Killer(String Nom,String nomImage, int init_x, int init_y, Plateau pt, Color col,int x,int nbRobot){
        super(Nom,nomImage,init_x,init_y,pt,col);
        this.x = x;
        this.tab= new int[nbRobot];
    }
    public String toString (){
        return "Moi "+this.nom+"vais tuer en "+this.x+" "+this.y+" de la série"+super.Serie;
    }
}
