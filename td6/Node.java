public abstract class Node {
    protected String path;
    protected String name ;
    protected long size;
    public Node(String P, long s){
        this.path = P;
        this.name= FileInfo.getName(P);
        this.size = s;
    }
    public abstract void afficher() ;
}
