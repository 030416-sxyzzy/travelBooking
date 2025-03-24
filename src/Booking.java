import java.util.Date;

public class Booking {
    private int Mid;
    private int Tid;
    private int Rid;
    private int Hid;
    private Date Bdate;

    // Constructor, Getters and Setters
    public Booking(int Mid, int Tid, int Rid, int Hid, Date Bdate) {
        this.Mid = Mid;
        this.Tid = Tid;
        this.Rid = Rid;
        this.Hid = Hid;
        this.Bdate = Bdate;
    }

    public int getMid() {
        return Mid;
    }

    public void setMid(int Mid) {
        this.Mid = Mid;
    }

    public int getTid() {
        return Tid;
    }

    public void setTid(int Tid) {
        this.Tid = Tid;
    }

    public int getRid() {
        return Rid;
    }

    public void setRid(int Rid) {
        this.Rid = Rid;
    }

    public int getHid() {
        return Hid;
    }

    public void setHid(int Hid) {
        this.Hid = Hid;
    }

    public Date getBdate() {
        return Bdate;
    }

    public void setBdate(Date Bdate) {
        this.Bdate = Bdate;
    }
    @Override
    public String toString() {
        return "Booking{" +
                "Mid=" + Mid +
                ", Tid=" + Tid +
                ", Rid=" + Rid +
                ", Hid=" + Hid +
                ", Bdate=" + Bdate +
                '}';
    }
}
