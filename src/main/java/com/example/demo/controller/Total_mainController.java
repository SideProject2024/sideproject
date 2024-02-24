package com.example.demo.controller;

import com.example.demo.service.Total_mainService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
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
public class Total_mainController {

    private final Total_mainService total_mainService;

    @GetMapping("/")
    public String index(Model model) throws IOException {

        String url = "https://api.themoviedb.org/3/movie/top_rated?language=ko-KR&page=1";

        JsonNode rootNode = total_mainService.CallAPI(url);

        JsonNode resultsNode = rootNode.get("results");

        List<Map<String,Object>> movie = new ArrayList<>();

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

        String url = "https://api.themoviedb.org/3/movie/now_playing?language=ko-KR&page=1";

        JsonNode rootNode = total_mainService.CallAPI(url);

        JsonNode resultsNode = rootNode.get("results");

        List<Map<String,Object>> movie = new ArrayList<>();

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
    public String movieDetail(@PathVariable("movie_id")String movie_id, Model model) throws IOException {

        Map<String,Object> movie_detail = total_mainService.MovieDetail(movie_id);

        model.addAttribute("movie",movie_detail);
        model.addAttribute("movie_id",movie_id);

        return "detail";
    }

    @PostMapping("/ActorList")
    @ResponseBody
    public List<Map<String,Object>> ActorList(String movie_id) throws IOException {

        String url = "https://api.themoviedb.org/3/movie/"+movie_id+"/credits?language=ko-KR";

        JsonNode rootNode = total_mainService.CallAPI(url);

        JsonNode resultsNode = rootNode.get("cast");

        List<Map<String,Object>> actors = new ArrayList<>();
        if (resultsNode.isArray()) {
            for (JsonNode actorNode : resultsNode) {
                String name = total_mainService.EntoKo(actorNode.get("name").asText());
                String character = total_mainService.EntoKo(actorNode.get("character").asText());
                String profile_path = actorNode.get("profile_path").asText();
                Map<String,Object> map = new HashMap<>();

                map.put("actor_name",name);
                map.put("character",character);
                map.put("profile_path","https://image.tmdb.org/t/p/w500"+profile_path);

                actors.add(map);
            }
        }
        return actors;
    }

    @GetMapping("/search")
    public String searchMovie(){
        return "search";
    }

    @PostMapping("/find/{findString}")
    @ResponseBody
    public List<Map<String,Object>> find_movie(@PathVariable("findString")String findString) throws IOException {

        String url = "https://api.themoviedb.org/3/search/movie?query="+findString+"&include_adult=true&language=ko-KR&page=1";

        JsonNode rootNode = total_mainService.CallAPI(url);

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
    @GetMapping("/test")
    @ResponseBody
    public JsonNode test() throws IOException {

        String url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json?key=b0eaad9be154d293c5c38849e83705a7&targetDt=20240222";

        JsonNode result = total_mainService.CallAPI(url);

        return result;
    }
}
