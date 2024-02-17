package com.example.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
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
                String name = EntoKo(movieNode.get("name").asText());
                String character = EntoKo(movieNode.get("character").asText());
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

    public String EntoKo(String text){
        String clientId = "h_WrQMXqqQ3vNQvmdOCr";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "gS8vECFbLi";//애플리케이션 클라이언트 시크릿값";

        String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
        try {
            text = URLEncoder.encode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("인코딩 실패", e);
        }

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);

        String responseBody = post(apiURL, requestHeaders, text);

        String translatedText = "";
        try {
            // Parse JSON string
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(responseBody);

            // Extract the value of the "translatedText" field
            translatedText = jsonNode.path("message").path("result").path("translatedText").asText();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return translatedText;
    }

    private static String post(String apiUrl, Map<String, String> requestHeaders, String text){
        HttpURLConnection con = connect(apiUrl);
        String postParams = "source=en&target=ko&text=" + text; //원본언어: 한국어 (ko) -> 목적언어: 영어 (en)
        try {
            con.setRequestMethod("POST");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            con.setDoOutput(true);
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(postParams.getBytes());
                wr.flush();
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 응답
                return readBody(con.getInputStream());
            } else {  // 에러 응답
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }

    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

    private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }
}
