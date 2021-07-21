package com.example.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Req<T> {

    private Header header;
    private T resBody; //body는 계속해서 변경되기때문에

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Header {
        private String responseCode;
    }
}
