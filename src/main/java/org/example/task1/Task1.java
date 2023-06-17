package org.example.task1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.task1.user.User;;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;


public class Task1 {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();

    public User postUser(User user) {
        URI uri = null;
        try {
            uri = new URI(BASE_URL);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        String requestBody = GSON.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        HttpResponse<String> response = null;
        try {
            response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        User result = GSON.fromJson(response.body(), User.class);
        return result;
    }

    public User getIdUser(int id) {
        URI uri = null;
        try {
            uri = new URI(BASE_URL + "/" + id);
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
        User result = GSON.fromJson(response.body(), User.class);
        return result;
    }

    public List<User> getUsers() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
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
        List<User> result = GSON.fromJson(response.body(), new TypeToken<List<User>>() {
        }.getType());
        return result;
    }

    public User getUserName(String name) {
        List<User> users = getUsers();
            for (User user : users){
                if(user.getName().equals(name)){
                    return user;
                }
            }
            return null;
    }
    public User putUser(User user, int id){
        URI uri = null;
        try {
            uri = new URI(BASE_URL + "/" + id);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        String requestBody = GSON.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        HttpResponse<String> response = null;
        try {
            response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        User result = GSON.fromJson(response.body(), User.class);
        return result;
    }

    public String deleteUser(int id) {
        URI uri = null;
        try {
            uri = new URI(BASE_URL + "/" + id);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

//        String requestBody = GSON.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-type", "application/json")
                .DELETE()
//                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        HttpResponse<String> response = null;
        try {
            response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Cтатус відповіді сервера = " + response.statusCode();
    }
}
