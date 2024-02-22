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
    public String index(Model model) throws IOException{

        String url = "https://api.themoviedb.org/3/movie/top_rated?language=ko-KR&page=1";

        JsonNode rootNode = total_MainService.CallAPI(url);

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

        JsonNode rootNode = total_MainService.CallAPI(url);

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

        String url = "https://api.themoviedb.org/3/search/movie?query="+findString+"&include_adult=true&language=ko-KR&page=1";

        JsonNode rootNode = total_MainService.CallAPI(url);

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
    @PostMapping("/test")
    @ResponseBody
    public JsonNode test() throws IOException {

        String url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json?key=b0eaad9be154d293c5c38849e83705a7&targetDt=20240222";

        JsonNode result = total_MainService.CallAPI(url);

        return result;
    }
}