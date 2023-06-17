package org.example.task1.user;

public class AddressUser {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;

    public AddressUser(String street, String suite, String city, String zipcode, Geo geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }

    @Override
    public String toString() {
        return "{\n" +
                "\t\t" + "\""+"street"+ "\""+":" + "\"" + street + "\"" + "\n" +
                "\t\t" + "\""+"suite"+ "\""+":" + "\"" + suite + "\"" + "\n" +
                "\t\t" + "\""+"city"+ "\""+":" + "\"" + city + "\"" + "\n" +
                "\t\t" + "\""+"zipcode"+ "\""+":" + "\"" + zipcode + "\"" + "\n" +
                "\t\t" + "\"" + "geo"+ "\""+":" + geo + "\n" +
                "\t\t}";
    }
}

