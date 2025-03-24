public class Hotel {
    private int Hid;
    private String Hname;
    private short Hprice;
    private String Hstyle;
    private short Hstarrating;
    private String Hlocation;

    // Constructor, Getters and Setters
    public Hotel(){
        this.Hid = Hid;
        this.Hname = Hname;
        this.Hprice = Hprice;
        this.Hstyle = Hstyle;
        this.Hstarrating = Hstarrating;
        this.Hlocation = Hlocation;
    }
    public Hotel(int Hid, String Hname, short Hprice, String Hstyle, short Hstarrating, String Hlocation) {
        this.Hid = Hid;
        this.Hname = Hname;
        this.Hprice = Hprice;
        this.Hstyle = Hstyle;
        this.Hstarrating = Hstarrating;
        this.Hlocation = Hlocation;
    }

    public int getHid() {
        return Hid;
    }

    public void setHid(int Hid) {
        this.Hid = Hid;
    }

    public String getHname() {
        return Hname;
    }

    public void setHname(String Hname) {
        this.Hname = Hname;
    }

    public short getHprice() {
        return Hprice;
    }

    public void setHprice(short Hprice) {
        this.Hprice = Hprice;
    }

    public String getHstyle() {
        return Hstyle;
    }

    public void setHstyle(String Hstyle) {
        this.Hstyle = Hstyle;
    }

    public short getHstarrating() {
        return Hstarrating;
    }

    public void setHstarrating(short Hstarrating) {
        this.Hstarrating = Hstarrating;
    }

    public String getHlocation() {
        return Hlocation;
    }

    public void setHlocation(String Hlocation) {
        this.Hlocation = Hlocation;
    }
    public String toString() {
        return "Hotel{" +
                "Hid=" + Hid +
                ", Hname='" + Hname + '\'' +
                ", Hprice=" + Hprice +
                ", Hstyle='" + Hstyle + '\'' +
                ", Hstarrating=" + Hstarrating +
                ", Hlocation=" + Hlocation +
                '}';
    }
}
