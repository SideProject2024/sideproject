package com.example.demo.controller;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class HelloController {

    @GetMapping("/")
    public String index(Model model) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/movie/top_rated?language=ko-KR&page=2")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhYTdkZDg2MGJkYzJmNzAwNDI2NjcwNmQ4ZGJhYzI1NSIsInN1YiI6IjY1OWJlMzI3YmQ1ODhiMjA5OThkNDI3MCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.TydEZPf9nrIucJSP8WIfQszoJzX9hXJXv2nNTaTIJo4")
                .build();

        Response response = client.newCall(request).execute();

        String responseBody = response.body().string();

        model.addAttribute("response", responseBody);

        return "index";
    }

}