package com.aaron.restclient.services;

import com.aaron.restclient.json.GitHubUserInfoResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GitHubService {
    private static final String BASE = "https://api.github.com/users/";

    private RestTemplate template;

    public GitHubService(RestTemplateBuilder builder){
        this.template = builder.build();
    }

    public String getHtmlUrl(String name){
        String url = String.format("%s%s",BASE,name);
        GitHubUserInfoResponse response = template.getForObject(url, GitHubUserInfoResponse.class);
        String output = "";
        if(response!=null){
            output = response.getHtml_url();
        }
        return output;
    }


}
