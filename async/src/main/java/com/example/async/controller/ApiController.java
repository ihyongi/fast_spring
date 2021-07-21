package com.example.async.controller;

import com.example.async.service.AsyncService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    //@Autowired
    private final AsyncService asyncService;

   /* public ApiController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }*/

    @GetMapping("/hello")
    public CompletableFuture hello(){ //다른스레드 실행시키고 결과를 반환받는다
//        asyncService.hello();
//        log.info("method end");
        log.info("completable future init");
        return asyncService.run();
    }
}
