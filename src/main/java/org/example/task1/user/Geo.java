package org.example.task1.user;

public class Geo {
   private double lat;
   private double lng;

    public Geo(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "{\n" +
                "\t\t\t" + "\""+"lat"+ "\""+":" + "\"" + lat + "\"" + "\n" +
                "\t\t\t" + "\""+"lng"+ "\""+":" + "\"" + lng;
    }
}
