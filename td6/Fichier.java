import java.io.IOException;

public class Fichier extends Node {

    public Fichier(String P) throws IOException {
        super(P,FileInfo.size(P));
    }
    public void afficher(){
        System.out.println("Nom: "+ this.name+"["+this.size+" octets]\n");
    }
}
