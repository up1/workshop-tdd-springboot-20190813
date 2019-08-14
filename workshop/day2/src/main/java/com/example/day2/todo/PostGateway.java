package com.example.day2.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class PostGateway {

    private final RestTemplate restTemplate;
    private final String postUrl;

    @Autowired
    public PostGateway(
            final RestTemplate restTemplate,
            @Value("${post.url}") final String postUrl) {

        this.restTemplate = restTemplate;
        this.postUrl = postUrl;
    }

    public Optional<PostResponse> getPostBy(int id) {
        String url = String.format("%s/%d", postUrl, id);
        try {
            return Optional.ofNullable(restTemplate.getForObject(url, PostResponse.class));
        } catch (RestClientException e) {
            return Optional.empty();
        }
    }
}
