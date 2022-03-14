import java.io.File;
import java.io.IOException;
import java.util.*;

public class Dossier extends Node {
    private ArrayList<Node> elements = new ArrayList<Node>();
    public Dossier(String P) throws IOException {
        super(P,0);
        this.name=FileInfo.getName(P);
        for (Iterator<String> it = FileInfo.getElements(P); it.hasNext() ; ) {
            //System.out.println("??");
            String str = it.next();
            //System.out.println(str);
            if(FileInfo.isFile(str)){
                //System.out.println("heu");
                elements.add(new Fichier(str));
                this.size += FileInfo.size(str);
                //System.out.println("GG");
            }else if(FileInfo.isDirectory(str)) {
                Dossier d = new Dossier(str);
                elements.add(d);
                this.size += d.size;
            }
        }
    }
    public void afficher(){
        System.out.println(this.name+" [total = "+this.size+"octets]\n");
        for (Iterator<Node> it = elements.iterator(); it.hasNext() ; ) {
            Node N = it.next();
            System.out.print("   ");
            if (FileInfo.isFile(N.path)){
                System.out.print("   |");
                N.afficher();
            }else{
                System.out.print("+   (DIR)");
                N.afficher();
            }
        }
    }
}
