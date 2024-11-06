package com.example.unomas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/github")
public class GitHubStatusController {

    @GetMapping("/")
    public String index() {
        return "Github";
    }

    @GetMapping("api/GitHubStatusTest/Summary")
    public String gitStatusTestSummary() {
        //return "Git Status Test";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://www.githubstatus.com/api/v2/summary.json", String.class);
    }

    @GetMapping("api/GitHubStatusTest/Status")
    public String gitStatusTestStatus() {
        //return "Git Status Test";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://www.githubstatus.com/api/v2/status.json", String.class);
    }

    @GetMapping("api/GitHubStatusTest/Components")
    public String gitStatusTestComponents() {
        //return "Git Status Test";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://www.githubstatus.com/api/v2/components.json", String.class);
    }

}
