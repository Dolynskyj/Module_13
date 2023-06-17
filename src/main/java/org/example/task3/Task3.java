package org.example.task3;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.task2.Post;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Task3 {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";

    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();
    public void printTodos(int id){
        URI uri = null;
        try {
            uri = new URI(BASE_URL + "/" + id + "/todos");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        HttpResponse<String> response = null;
        try {
            response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<Todos> todos = GSON.fromJson(response.body(), new TypeToken<List<Todos>>() {
        }.getType());
        for (Todos todo : todos){
            if (todo.isCompleted() == false){
                System.out.println(todo);
            }
        }
    }
}
