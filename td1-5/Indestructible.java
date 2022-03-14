import java.awt.*;

public class Indestructible extends Robot{
    public void explose(){
        System.out.println("JE SUIS IMMUABLE!");
    }
    public void collision(Robot autre) {
        System.out.println("VOUS NE M'ARRETEREZ PAS!");
    }

    public Indestructible(String Nom,String nomImage, int init_x, int init_y, Plateau pt, Color col){
        super(Nom,nomImage,init_x,init_y,pt,col);
    }
    public String toString (){
        return "Je suis invincible";
    }
}
