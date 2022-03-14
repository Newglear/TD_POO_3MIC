import java.util.Date;

public class LogLine {
    private Date date;
    private String mess;
    private Robot emRob;
    private Robot tiersRob;

    public LogLine (String mess, Robot emRob, Robot tiersRob){
        this.date = new Date();
        this.mess = mess;
        this.emRob = emRob;
        this.tiersRob = tiersRob;
    }
    public String toString(){
        return "Date: "+ this.date + " | Message: " +this.mess+ " | De :"+ this.emRob.toString() +" à " + this.tiersRob.toString() +"\n";
    }
    public Robot getEm(){
        return this.emRob;
    }
    public Robot getTiers(){
        return this.tiersRob;
    }
    public Date getDate(){
        return this.date;
    }
    public String getMessage(){
        return this.mess;
    }


}
