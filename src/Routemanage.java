public class Routemanage {
    private int Rtrafficid;
    private int Tid;
    private int Rid;
    private int Hid;
    private Rtraffic rtraffic;
    private TourSpot tourSpot;
    private Route route;
    private Hotel hotel;

    // Getters and Setters
    public int getRtrafficid() {
        return Rtrafficid;
    }

    public void setRtrafficid(int rtrafficid) {
        Rtrafficid = rtrafficid;
    }

    public int getTid() {
        return Tid;
    }

    public void setTid(int tid) {
        Tid = tid;
    }

    public int getRid() {
        return Rid;
    }

    public void setRid(int rid) {
        Rid = rid;
    }

    public int getHid() {
        return Hid;
    }

    public void setHid(int hid) {
        Hid = hid;
    }
    public Rtraffic getRtraffic() {
        return rtraffic;
    }

    public void setRtraffic(Rtraffic rtraffic) {
        this.rtraffic = rtraffic;
    }

    public TourSpot getTourSpot() {
        return tourSpot;
    }

    public void setTourSpot(TourSpot tourSpot) {
        this.tourSpot = tourSpot;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    @Override
    public String toString() {
        return "Routemanage{" +
                "Rtrafficid=" + Rtrafficid +
                ", Tid=" + Tid +
                ", Rid=" + Rid +
                ", Hid=" + Hid +'\n'+
                ", " + rtraffic +'\n'+
                ", " + tourSpot +'\n'+
                ", " + route +'\n'+
                ", " + hotel +
                '}';
    }
}

