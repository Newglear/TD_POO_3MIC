import java.util.Stack;

public class Logs {
    private Stack<LogLine> List = new Stack<LogLine>();
    public void add(String msg, Robot em, Robot tiers){
        List.push(new LogLine(msg,em,tiers));
    }
    public String toString(){
        String S="";
        for(LogLine L: List){
            S = S+ L.toString()+"\n";
        }
        return S;
    }
    public LogLine trouveLigne(Robot emetteur, Robot tiers) throws PasTrouve{
        for(LogLine L: List) {
            if (L.getEm() == emetteur && L.getTiers() == tiers || L.getEm() == tiers && L.getTiers() == emetteur) {
                return L;
            }
        }
        throw(new PasTrouve("First Encounter"));
    }
}
