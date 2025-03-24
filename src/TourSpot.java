import java.sql.Date;

public class TourSpot {
    private int Tid;
    private String Tname;
    private short Tprice;
    private String Tlocation;
    private Date Tdate;
    private int Total_tickets;

    public TourSpot() {
        this.Tid = Tid;
        this.Tname = Tname;
        this.Tprice = Tprice;
        this.Tlocation = Tlocation;
        this.Tdate = Tdate;
    }
    // Constructor, Getters and Setters
    public TourSpot(int Tid, String Tname, short Tprice, String Tlocation, Date Tdate) {
        this.Tid = Tid;
        this.Tname = Tname;
        this.Tprice = Tprice;
        this.Tlocation = Tlocation;
        this.Tdate = Tdate;
    }

    public int getTid() {
        return Tid;
    }

    public void setTid(int Tid) {
        this.Tid = Tid;
    }

    public String getTname() {
        return Tname;
    }

    public void setTname(String Tname) {
        this.Tname = Tname;
    }

    public short getTprice() {
        return Tprice;
    }

    public void setTprice(short Tprice) {
        this.Tprice = Tprice;
    }

    public String getTlocation() {
        return Tlocation;
    }

    public void setTlocation(String Tlocation) {
        this.Tlocation = Tlocation;
    }

    public Date getTdate() {
        return Tdate;
    }

    public void setTdate(Date Tdate) {
        this.Tdate = Tdate;
    }
    public int getTotal_tickets() {
        return Total_tickets;
    }
    public void setTotal_tickets(int Total_tickets) {
        this.Total_tickets = Total_tickets;
    }
    @Override
    public String toString() {
        return "TourSpot{" +
                "Tid=" + Tid +
                ", Tname='" + Tname + '\'' +
                ", Tprice=" + Tprice +
                ", Tlocation='" + Tlocation + '\'' +
                ", Tdate=" + Tdate +
                '}';
    }
}

