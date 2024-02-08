package com.example.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class Total_mainService {

    public Map<String,Object> MovieDetail(String movie_id) throws IOException {

        //1a4fdfbb72ca9489d8eb9487d7a4ccff4434ec32
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/movie/"+movie_id+"?language=ko-KR")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhYTdkZDg2MGJkYzJmNzAwNDI2NjcwNmQ4ZGJhYzI1NSIsInN1YiI6IjY1OWJlMzI3YmQ1ODhiMjA5OThkNDI3MCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.TydEZPf9nrIucJSP8WIfQszoJzX9hXJXv2nNTaTIJo4")
                .build();

        Response response = client.newCall(request).execute();

        String jsonData = response.body().string();

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode result = objectMapper.readTree(jsonData);


        String poster_path = result.get("poster_path").asText();
        String backdrop_path = result.get("backdrop_path").asText();
        String title = result.get("title").asText();
        String tagline = result.get("tagline").asText();
        String overview = result.get("overview").asText();

        Map<String,Object> map = new HashMap<>();

        map.put("poster_path","https://image.tmdb.org/t/p/w500"+poster_path);
        map.put("backdrop_path","https://image.tmdb.org/t/p/original"+backdrop_path);
        map.put("title",title);
        map.put("tagline",tagline);
        map.put("overview",overview);

        return map;
    }

    public List<Map<String,Object>> MovieCredits(String movie_id) throws IOException {
        //1a4fdfbb72ca9489d8eb9487d7a4ccff4434ec32
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/movie/"+movie_id+"/credits?language=ko-KR")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhYTdkZDg2MGJkYzJmNzAwNDI2NjcwNmQ4ZGJhYzI1NSIsInN1YiI6IjY1OWJlMzI3YmQ1ODhiMjA5OThkNDI3MCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.TydEZPf9nrIucJSP8WIfQszoJzX9hXJXv2nNTaTIJo4")
                .build();

        Response response = client.newCall(request).execute();

        String jsonData = response.body().string();

        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String,Object>> actors = new ArrayList<>();

        JsonNode rootNode = objectMapper.readTree(jsonData);
        JsonNode resultsNode = rootNode.get("cast");

        if (resultsNode.isArray()) {
            for (JsonNode movieNode : resultsNode) {
                String name = movieNode.get("name").asText();
                String character = movieNode.get("character").asText();
                String profile_path = movieNode.get("profile_path").asText();
                Map<String,Object> map = new HashMap<>();

                map.put("name",name);
                map.put("character",character);
                map.put("profile_path","https://image.tmdb.org/t/p/w500"+profile_path);

                actors.add(map);
            }
        }

        return actors;
    }
}
