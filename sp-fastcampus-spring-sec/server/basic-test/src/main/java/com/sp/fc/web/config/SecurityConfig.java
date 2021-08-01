package com.sp.fc.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//필터의 개수가 2개이상일때 , @order로 순서를 무조건 지정!

@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true) //권한체크모드
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //application.yaml에서는 사용자를 한명만 설정가능.. 나머지는 여기서처리


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser(User.builder().username("user2").password(passwordEncoder().encode("2222")).roles("USER"))
                .withUser(User.builder().username("admin").password(passwordEncoder().encode("3333")).roles("ADMIN"));
        //이렇게 처리하면 오류가 남... 사용자의 패스워드를 인코딩하지않아서
        //user1으로는 로그인 이제 못혀
    }

    //패스워드인코더를 빈으로 만들기
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //spring security는 모든페이지를 일단 다 막는데.. 이를 방지하려면? 홈페이지는 누구나 접근 할 수 있도록 하려면?
    //httpconfig
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.antMatcher("/api/**"); //특정 api아래는 체크하겟다
//        http.authorizeRequests((requests) ->
//                requests.antMatchers("/").permitAll()
//                        .anyRequest().authenticated()); //홈페이지는 열어두고 나머지는 인증!
//        http.formLogin();
//        http.httpBasic();
        http
                .headers().disable()
                .csrf().disable()
                .formLogin(login->
                        login.defaultSuccessUrl("/",false)) //보통은 이렇게 설정
                .logout().disable()
                .requestCache().disable();

    }


}
