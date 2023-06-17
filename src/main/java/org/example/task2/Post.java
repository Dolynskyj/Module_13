package org.example.task2;

public class Post {
    private int userId;
    private int id;
    private String title;
    private String body;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "{\n" +
                "\t" + "\"" + "userId"+ "\""+":" + "\"" + userId + "\"" + "\n" +
                "\t" + "\"" + "id"+ "\""+":" + "\"" + id + "\"" + "\n" +
                "\t" + "\"" + "title"+ "\""+":" + "\"" + title + "\"" + "\n" +
                "\t" + "\"" + "body"+ "\""+":" + "\"" + body + "\"" + "\n" +
                '}';
    }
}
