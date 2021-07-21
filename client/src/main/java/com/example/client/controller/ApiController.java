package com.example.client.controller;

import com.example.client.dto.Req;
import com.example.client.dto.UserResponse;
import com.example.client.service.RestTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ApiController {

    private final RestTemplateService restTemplateService;

    /*public ApiController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }*/

    @GetMapping("/hello")
    public Req<UserResponse> getHello() {
        return restTemplateService.genericExchange();
    }



}
