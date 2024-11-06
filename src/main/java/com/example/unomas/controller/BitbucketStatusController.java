package com.example.unomas.controller;

import com.example.unomas.dto.StatusResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bitbucket")
public class BitbucketStatusController {

    @GetMapping("/")
    public String index() {
        return "Bitbucket";
    }

    @GetMapping("api/summary")
    public String summary() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://bitbucket.status.atlassian.com/api/v2/summary.json", String.class);
    }

    @GetMapping("api/status")
    public String status() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String jsonResponse = restTemplate.getForObject("https://bitbucket.status.atlassian.com/api/v2/status.json", String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        StatusResponse response = objectMapper.readValue(jsonResponse, StatusResponse.class);

        // Access fields in the response object
        System.out.println(response.getPage().getName());
        return restTemplate.getForObject("https://bitbucket.status.atlassian.com/api/v2/status.json", String.class);
    }

    @GetMapping("api/components")
    public String components() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://bitbucket.status.atlassian.com/api/v2/components.json", String.class);
    }

}
