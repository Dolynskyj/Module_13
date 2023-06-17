package org.example.task1;

import org.example.task1.user.AddressUser;
import org.example.task1.user.Geo;
import org.example.task1.user.User;

import java.io.IOException;

public class Task1Test {
    public static void main(String[] args) throws IOException, InterruptedException {
        Geo geo = new Geo(-31.8129, 62.5342);
        AddressUser addressUser = new AddressUser("1 Street", "125", "Lviv", "123-325", geo);
        User user = new User(1,"Pavlo", "Pasha", "pavlo@gmail.com", addressUser);
        Task1 task1 = new Task1();
        System.out.println(task1.postUser(user));
        System.out.println(task1.getIdUser(5));
        System.out.println(task1.getUsers());
        System.out.println(task1.getUserName("Leanne Graham"));
        System.out.println(task1.putUser(user, 5));
        System.out.println(task1.deleteUser(5));
    }
}
