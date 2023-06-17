package org.example.task1.user;

public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private AddressUser address;

    public User(int id, String name, String username, String email, AddressUser address) {
        this.name = name;
        this.id = id;
        this.username = username;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{\n" +
                "\t" + "\"" + "id"+ "\""+":" + "\"" + id + "\"" + "\n" +
                "\t" + "\"" + "name"+ "\""+":" + "\"" + name + "\"" + "\n" +
                "\t" + "\"" + "username"+ "\""+":" + "\"" + username + "\"" + "\n" +
                "\t" + "\"" + "email"+ "\""+":" + "\"" + email + "\"" + "\n" +
                "\t" + "\"" + "address" + "\""+ ":" + address + "\n" +
                '}';
    }
}
