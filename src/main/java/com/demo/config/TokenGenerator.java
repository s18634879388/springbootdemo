package com.demo.config;

import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/17.
 */
public class TokenGenerator {
    private static String secret = "dashabi";

    public static String generator(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(setExpirDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();

    }

    public static Date setExpirDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime()+1000*60*3);
        return calendar.getTime();
    }


}
