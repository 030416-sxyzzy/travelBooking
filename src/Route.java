public class Route {
    private int Rid;
    private String Rname;

    // Constructor, Getters and Setters
    public Route() {
        this.Rid = Rid;
        this.Rname = Rname;
    }

    public int getRid() {
        return Rid;
    }

    public void setRid(int Rid) {
        this.Rid = Rid;
    }

    public String getRname() {
        return Rname;
    }

    public void setRname(String Rname) {
        this.Rname = Rname;
    }
    public String toString() {
        return "Route{"+"Rid: " + Rid + ", Rname: " + Rname+"}";
    }
}
