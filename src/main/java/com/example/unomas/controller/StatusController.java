package com.example.unomas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StatusController {

    @GetMapping("/")
    public String index() {
        return "Fucking Dev Ops";
    }

    @GetMapping("api/GitStatusTest/Summary")
    public String gitStatusTestSummary() {
        //return "Git Status Test";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://www.githubstatus.com/api/v2/summary.json", String.class);
    }

    @GetMapping("api/GitStatusTest/Status")
    public String gitStatusTestStatus() {
        //return "Git Status Test";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://www.githubstatus.com/api/v2/status.json", String.class);
    }

    @GetMapping("api/GitStatusTest/Components")
    public String gitStatusTestComponents() {
        //return "Git Status Test";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://www.githubstatus.com/api/v2/components.json", String.class);
    }

}
