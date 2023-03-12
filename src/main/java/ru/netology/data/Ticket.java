package ru.netology.data;

public class Ticket implements Comparable<Ticket> {

    protected int id;
    protected int price;
    protected String fromAirport;
    protected String toAirport;

    protected int travelTime;

    public Ticket(int id, int price, String fromAirport, String toAirport, int travelTime) {
        this.id = id;
        this.price = price;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.travelTime = travelTime;
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }

    public String getFromAirport() {
        return fromAirport;
    }

//    public void setFromAirport(String fromAirport) {
//        this.fromAirport = fromAirport;
//    }

    public String getToAirport() {
        return toAirport;
    }

//    public void setToAirport(String toAirport) {
//        this.toAirport = toAirport;
//    }

    public int getTravelTime() {
        return travelTime;
    }

//    public void setTravelTime(int travelTime) {
//        this.travelTime = travelTime;
//    }

    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        } else {
            return 0;
        }
    }
}
