package org.example.task3;

public class Todos {
    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        return "{\n" +
                "\t" + "\"" + "userId"+ "\""+":" + "\"" + userId + "\"" + "\n" +
                "\t" + "\"" + "id"+ "\""+":" + "\"" + id + "\"" + "\n" +
                "\t" + "\"" + "title"+ "\""+":" + "\"" + title + "\"" + "\n" +
                "\t" + "\"" + "completed"+ "\""+":" + "\"" + completed + "\"" + "\n" +
                '}';
    }
}
