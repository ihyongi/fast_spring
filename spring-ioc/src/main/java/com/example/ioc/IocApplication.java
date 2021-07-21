package com.example.ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class IocApplication {

    public static void main(String[] args) {
        SpringApplication.run(IocApplication.class, args);
        ApplicationContext context=ApplicationContextProvider.getContext();

        //빈등록(이름을 찾거나..)
        //Base64Encoder base64Encoder=context.getBean(Base64Encoder.class);
        //UrlEncoder urlEncoder=context.getBean(UrlEncoder.class);

        //encoder생성
        Encoder encoder = context.getBean("base64Encode",Encoder.class); //이제 new 안쓴다
        String url="www.naver.com/books/it?page=10&size=20&name=spring-boot";
        String result= encoder.encode(url);
        System.out.println("result = " + result);
        //result = d3d3Lm5hdmVyLmNvbS9ib29rcy9pdD9wYWdlPTEwJnNpemU9MjAmbmFtZT1zcHJpbmctYm9vdA==
        //result = www.naver.com%2Fbooks%2Fit%3Fpage%3D10%26size%3D20%26name%3Dspring-boot


        /*//와 세줄로 가능 setter생성
        encoder.setIEncoder(urlEncoder);
        result= encoder.encode(url);
        System.out.println("result2 = " + result);*/
    }

}

@Configuration //한개의 클래스에서 여러개의 빈을 등록할 거야~
class AppConfig{

    //이름으로 구별
    @Bean("base64Encode")
    public Encoder encoder(Base64Encoder base64Encoder){
        return new Encoder(base64Encoder);
    }

    @Bean("urlEncode")
    public Encoder encoder(UrlEncoder urlEncoder){
        return new Encoder(urlEncoder);
    }
}