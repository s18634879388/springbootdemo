package com.test;

import com.demo.config.TokenGenerator;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
}
