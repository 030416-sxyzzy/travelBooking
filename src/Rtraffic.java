public class Rtraffic {
    private int Rtrafficid;
    private String Rtrafficway;

    // Constructor, Getters and Setters
    public Rtraffic() {
        this.Rtrafficid = Rtrafficid;
        this.Rtrafficway = Rtrafficway;
    }

    public int getRtrafficid() {
        return Rtrafficid;
    }

    public void setRtrafficid(int Rtrafficid) {
        this.Rtrafficid = Rtrafficid;
    }

    public String getRtrafficway() {
        return Rtrafficway;
    }

    public void setRtrafficway(String Rtrafficway) {
        this.Rtrafficway = Rtrafficway;
    }
    public String toString() {
        return "Rtraffic{"+"Rtrafficid: "+Rtrafficid + ", Rtrafficway: " + Rtrafficway+"}";
    }
}
