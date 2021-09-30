package no.hvl.dat110.rest.counters;

import okhttp3.*;

import java.io.IOException;

// For the post request I have copied the code from the put request, but here we are using post for the request.
public class PostRequest {

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public static void main(String[] args) {

        Todo todo = new Todo("2","post", "post");

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(JSON, todo.toJson());

        Request request = new Request.Builder().url("http://localhost:8080/todolist").post(body).build();

        System.out.println(request.toString());

        try (Response response = client.newCall(request).execute()) {
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
