package com.example.client.service;

import com.example.client.dto.Req;
import com.example.client.dto.UserRequest;
import com.example.client.dto.UserResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateService {

    //http://localhost:9090/api/server/hello
    //response
    public UserResponse hello(){

        //오 서버를 호출시킨다
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090")
                .path("/api/server/hello")
                .queryParam("name","ihyongi")
                .queryParam("age",29)
                .encode()
                .build()
                .toUri();
        System.out.println("uri = " + uri.toString());
        //uri = http://localhost:9090/api/server/hello?name=ihyongi&age=29

        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<UserResponse> result = restTemplate.getForEntity(uri, UserResponse.class);
        //getForEntity --가져온다가 아니라 엔티티로 가져오겠다

        System.out.println("result.getStatusCode() = " + result.getStatusCode());
        System.out.println("result.getBody() = " + result.getBody());//내용보기

        return result.getBody();
    }

    public UserResponse post(){
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100, "ihyongi") //{userId},{userName}
                .toUri();
        System.out.println("uri = " + uri);

        //http body->object->object mapper->json->rest template->http body json
        UserRequest req = new UserRequest();
        req.setName("ihyongi");
        req.setAge(29);

        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<UserResponse> response =  restTemplate.postForEntity(uri, req, UserResponse.class);

        System.out.println("response.getStatusCode() = " + response.getStatusCode());
        System.out.println("response.getHeaders() = " + response.getHeaders());
        System.out.println("response.getBody() = " + response.getBody());

        return response.getBody();
    }

    /*
    uri = http://localhost:9090/api/server/user/100/name/ihyongi
    response.getStatusCode() = 200 OK
    response.getHeaders() = [Content-Type:"application/json", Transfer-Encoding:"chunked", Date:"Wed, 21 Jul 2021 15:31:23 GMT", Keep-Alive:"timeout=60", Connection:"keep-alive"]
    response.getBody() = UserResponse{name='ihyongi', age=29}
     */

    public UserResponse exchange(){
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100, "ihyongi") //{userId},{userName}
                .toUri();
        System.out.println("uri = " + uri);

        //http body->object->object mapper->json->rest template->http body json
        UserRequest req = new UserRequest();
        req.setName("ihyongi");
        req.setAge(29);

        //requestEntity
        RequestEntity<UserRequest> requestEntity= RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization", "abcd")
                .header("custom-header","ffffff")
                .body(req);

        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<UserResponse> response =restTemplate.exchange(requestEntity, UserResponse.class);
        return response.getBody();
    }

    public Req<UserResponse> genericExchange(){
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100, "ihyongi") //{userId},{userName}
                .toUri();
        System.out.println("uri = " + uri);

        //http body->object->object mapper->json->rest template->http body json

        //++
        UserRequest userRequest = new UserRequest();
        userRequest.setName("ihyongi");
        userRequest.setAge(29);

        Req<UserRequest> req=new Req();
        req.setHeader(
            new Req.Header()
        );

        req.setResBody(
                userRequest
        );

        //requestEntity
        RequestEntity<Req<UserRequest>> requestEntity= RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization", "abcd")
                .header("custom-header","ffffff")
                .body(req);

        //Req<UserResponse>.class X
        //new ParameterizedTypeReference<Req<UserResponse>>(){};


        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<Req<UserResponse>> response = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<Req<UserResponse>>(){});

        return response.getBody(); //먼저는 Req<UserResponse>이거, T body;두번째
    }
}
