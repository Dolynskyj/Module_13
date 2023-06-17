package org.example.task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Task2 {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";
    private static final String BASE_URL_POST = "https://jsonplaceholder.typicode.com/posts";

    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();

    private int maxId(int id){
        URI uri = null;
        try {
            uri = new URI(BASE_URL + "/" + id + "/posts");
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
        int maxId = 0;
        List<Post> posts = GSON.fromJson(response.body(), new TypeToken<List<Post>>() {
        }.getType());
            for (Post post : posts){
                if (post.getId() > maxId){
                    maxId = post.getId();
                }
            }
            return maxId;
    }
    private List<Comments> getComments (int id){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL_POST  + "/" + maxId(id) + "/comments"))
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
        List<Comments> result = GSON.fromJson(response.body(), new TypeToken<List<Comments>>() {}.getType());

        return result;
    }
    public void writeJsonFile(int id) {
        String commentsJson ="src/main/java/org/example/resources/user-"
                                            + id + "-post-" + maxId(id) + "-comments.json";
        File file = new File(commentsJson);
        file.mkdirs();
        List<Comments> comments = getComments(id);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = "";
        try (FileWriter writer = new FileWriter(commentsJson)) {
            for(Comments comment : comments) {
                        json = gson.toJson(comment);
                        System.out.println(json);
                        writer.write(json);
                    };
            }
         catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
