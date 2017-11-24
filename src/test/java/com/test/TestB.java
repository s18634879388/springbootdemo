package com.test;

import com.demo.config.JwtTokenUtil;
import com.demo.config.TokenGenerator;
import com.demo.domain.DemoUser;
import com.demo.domain.JWTUser;
import com.demo.domain.JwtUserFactory;
import com.demo.domain.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Administrator on 2017/11/17.
 */
public class TestB {

    @Test
    public void testToken(){
        Map<String,Object> map = new HashMap<>();
        map.put("aaa","asd");
        String token = TokenGenerator.generator(map);
        System.out.println(token);
    }

    @Test
    public void testGet(){
        Claims claims = Jwts.parser().setSigningKey("dashabi").parseClaimsJws("eyJhbGciOiJIUzUxMiJ9.eyJWEiOiJhc2QiLCJleHAiOjE1MTA4OTIwNDl9.r97DRdYwAWWvouMfVB7i5m1JtJ8RuohGP17v11kzVd5iuQdc69earZfpB4ua7ENkbY_MHLDC_tVAltgk_0HOuA")
                .getBody();
        String srt = (String) claims.get("aaa");
        System.out.println(srt);
    }

    @Test
    public void bcrypt(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("123456"));
        System.out.println("111");
    }
    @Test
    public void jwtToken(){
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        DemoUser demoUser = new DemoUser();
        demoUser.setUserName("aha");
        demoUser.setPassword("111");
        Role role = new Role();
        role.setRoleName("ROLE_ADMIN");
        ArrayList roles = new ArrayList();
        roles.add(role);
        demoUser.setRoles(roles);
        JWTUser jwtUser = JwtUserFactory.create(demoUser);

        String str = jwtTokenUtil.generateToken(jwtUser);
        System.out.println(str);

        Claims claims = jwtTokenUtil.getClaimsFromToken(str);
        System.out.println(claims.getSubject());
        System.out.println(claims.getExpiration());

    }

    @Test
    public void listTest(){
        List<String> list = new ArrayList<>();
        list.add("11111");
        list.add("22222");
        list.add("aaa");
        Stream<String> stream = list.stream();
        Set<String> set = stream.map(str->str.toUpperCase()).collect(Collectors.toSet());
        List<String> list1 = new ArrayList<>();
        set.forEach(s->list.add(s));
        list.forEach(s -> System.out.println(s));
        set.forEach(s -> System.out.println(s));
//        .forEach(str-> System.out.println(str));
    }
}
