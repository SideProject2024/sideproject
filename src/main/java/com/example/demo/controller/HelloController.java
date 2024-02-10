package com.example.demo.controller;

import com.example.demo.service.Total_mainService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class HelloController {

    private final Total_mainService total_MainService;

    @GetMapping("/")
    public String index(Model model) throws IOException {
        //1a4fdfbb72ca9489d8eb9487d7a4ccff4434ec32
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/movie/top_rated?language=ko-KR&page=1")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhYTdkZDg2MGJkYzJmNzAwNDI2NjcwNmQ4ZGJhYzI1NSIsInN1YiI6IjY1OWJlMzI3YmQ1ODhiMjA5OThkNDI3MCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.TydEZPf9nrIucJSP8WIfQszoJzX9hXJXv2nNTaTIJo4")
                .build();

        Response response = client.newCall(request).execute();

        String jsonData = response.body().string();

        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String,Object>> movie = new ArrayList<>();

        JsonNode rootNode = objectMapper.readTree(jsonData);
        JsonNode resultsNode = rootNode.get("results");

        if (resultsNode.isArray()) {
            for (JsonNode movieNode : resultsNode) {
                String title = movieNode.get("title").asText();
                String overview = movieNode.get("overview").asText();
                String id = movieNode.get("id").asText();
                String poster_path = movieNode.get("poster_path").asText();
                Map<String,Object> map = new HashMap<>();

                map.put("title",title);
                map.put("id",id);
                map.put("overview",overview);
                map.put("poster_path","https://image.tmdb.org/t/p/w500"+poster_path);

                movie.add(map);
            }
        }
        model.addAttribute("movie", movie);

        return "index";
    }

    @GetMapping("/nowPlaying")
    public String list1 (Model model) throws IOException {
        //1a4fdfbb72ca9489d8eb9487d7a4ccff4434ec32
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/movie/now_playing?language=ko-KR&page=1")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhYTdkZDg2MGJkYzJmNzAwNDI2NjcwNmQ4ZGJhYzI1NSIsInN1YiI6IjY1OWJlMzI3YmQ1ODhiMjA5OThkNDI3MCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.TydEZPf9nrIucJSP8WIfQszoJzX9hXJXv2nNTaTIJo4")
                .build();

        Response response = client.newCall(request).execute();

        String jsonData = response.body().string();

        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String,Object>> movie = new ArrayList<>();

        JsonNode rootNode = objectMapper.readTree(jsonData);
        JsonNode resultsNode = rootNode.get("results");

        if (resultsNode.isArray()) {
            for (JsonNode movieNode : resultsNode) {
                String title = movieNode.get("title").asText();
                String id = movieNode.get("id").asText();
                String overview = movieNode.get("overview").asText();
                String poster_path = movieNode.get("poster_path").asText();
                Map<String,Object> map = new HashMap<>();

                map.put("title",title);
                map.put("id",id);
                map.put("overview",overview);
                map.put("poster_path","https://image.tmdb.org/t/p/w500"+poster_path);

                movie.add(map);
            }
        }
        model.addAttribute("movie", movie);

        return "list1";
    }

    @GetMapping("/content/{movie_id}")
    public String movieDetail(@PathVariable("movie_id")String movie_id,Model model) throws IOException {

        Map<String,Object> movie_detail = total_MainService.MovieDetail(movie_id);

        List<Map<String,Object>> actor_list = total_MainService.MovieCredits(movie_id);

        model.addAttribute("movie",movie_detail);
        model.addAttribute("actor_list",actor_list);

        return "detail";
    }

    @GetMapping("/search")
    public String searchMovie(){
        return "search";
    }

    @PostMapping("/find/{findString}")
    @ResponseBody
    public List<Map<String,Object>> find_movie(@PathVariable("findString")String findString) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/search/movie?query="+findString+"&include_adult=true&language=ko-KR&page=1")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhYTdkZDg2MGJkYzJmNzAwNDI2NjcwNmQ4ZGJhYzI1NSIsInN1YiI6IjY1OWJlMzI3YmQ1ODhiMjA5OThkNDI3MCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.TydEZPf9nrIucJSP8WIfQszoJzX9hXJXv2nNTaTIJo4")
                .build();

        Response response = client.newCall(request).execute();

        String jsonData = response.body().string();

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode rootNode = objectMapper.readTree(jsonData);

        JsonNode resultsNode = rootNode.get("results");

        List<Map<String,Object>> findList = new ArrayList<>();

        if (resultsNode.isArray()) {
            for (JsonNode movieNode : resultsNode) {
                String title = movieNode.get("title").asText();
                String poster_path = movieNode.get("poster_path").asText();
                Map<String,Object> map = new HashMap<>();

                map.put("title",title);
                map.put("poster_path","https://image.tmdb.org/t/p/w500"+poster_path);

                findList.add(map);
            }
        }

        return findList;
    }
}