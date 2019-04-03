package com.backend.restclient.services;

import com.backend.restclient.json.Joke;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JokeService {

    private final static String BASE = "http://api.icndb.com/jokes/random?limitTo=[nerdy]";
    private RestTemplate restTemplate;


    public JokeService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    public String getJoke(String first, String last){
        String url = String.format("%s&firstName=%s&lastName=%s",BASE,first,last);
        Joke joke = restTemplate.getForObject(url, Joke.class);
        return joke.getValue().getJoke();
    }

    public String getJokeWithHeaders(String first, String last){
        String url = String.format("%s&firstName=%s&lastName=%s",BASE,first,last);
        ResponseEntity<Joke> entity = restTemplate.getForEntity(url,Joke.class);
        Joke joke = entity.getBody();
        return joke.getValue().getJoke();
    }
}
