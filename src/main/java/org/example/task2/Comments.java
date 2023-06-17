package org.example.task2;

public class Comments {
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;

    @Override
    public String toString() {
        return "{\n" +
                "\t" + "\"" + "postId"+ "\""+":" + "\"" + postId + "\"" + "\n" +
                "\t" + "\"" + "id"+ "\""+":" + "\"" + id + "\"" + "\n" +
                "\t" + "\"" + "name"+ "\""+":" + "\"" + name + "\"" + "\n" +
                "\t" + "\"" + "email"+ "\""+":" + "\"" + email + "\"" + "\n" +
                "\t" + "\"" + "body"+ "\""+":" + "\"" + body + "\"" + "\n" +
                '}';
    }
}
