package no.hvl.dat110.rest.counters;

import okhttp3.*;

import java.io.IOException;

public class DeleteRequest {

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public static void main(String[] args) {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url("http://localhost:8080/todolist:2").delete().build();

        System.out.println(request.toString());

        try (Response response = client.newCall(request).execute()) {
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
