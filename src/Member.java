import java.util.Date;

public class Member {
    private int Mid;
    private String Mname;
    private String Mphone;
    private String Mlevel;
    private Date Mdate;

    // Constructor, Getters and Setters
    public Member(int Mid, String Mname, String Mphone, String Mlevel, Date Mdate) {
        this.Mid = Mid;
        this.Mname = Mname;
        this.Mphone = Mphone;
        this.Mlevel = Mlevel;
        this.Mdate = Mdate;
    }

    public int getMid() {
        return Mid;
    }

    public void setMid(int Mid) {
        this.Mid = Mid;
    }

    public String getMname() {
        return Mname;
    }

    public void setMname(String Mname) {
        this.Mname = Mname;
    }

    public String getMphone() {
        return Mphone;
    }

    public void setMphone(String Mphone) {
        this.Mphone = Mphone;
    }

    public String getMlevel() {
        return Mlevel;
    }

    public void setMlevel(String Mlevel) {
        this.Mlevel = Mlevel;
    }

    public Date getMdate() {
        return Mdate;
    }

    public void setMdate(Date Mdate) {
        this.Mdate = Mdate;
    }
    public String toString() {
        return "Member{" +
                "Mid=" + Mid +
                ", Mname=" + Mname +
                ", Mphone=" + Mphone +
                ", Mlevel=" + Mlevel +
                ", Mdate=" + Mdate +
                '}';
    }
}
