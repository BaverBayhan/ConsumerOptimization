package com.GDSC.ConsumerOptimization.Utils;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class HttpFormContentUtils {
    public static String getFromSheetApi(String path,String username) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("http://localhost:8000/%s/%s",path,username)))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static List<String> stringResponseToList(String response)
    {
        Gson gson = new Gson();
        List<String> responseList = gson.fromJson(response, List.class);
        return responseList;
    }
}
