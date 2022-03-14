import java.io.IOException;

public class main {
    public static void main(String[] args) {
        System.out.println("Exploration de "+args[0]);
        try{
            if(FileInfo.isFile(args[0])){
                Fichier f = new Fichier(args[0]);
                f.afficher();
            }
            else{
                Dossier d  = new Dossier(args[0]);
                d.afficher();
            }
        }catch(IOException IO) {
            System.out.println("Chemin incorrect " + IO);
        }
    }
}