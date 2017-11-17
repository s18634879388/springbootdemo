package com.demo.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2017/11/17.
 */
public class JwtUserFactory {
    private JwtUserFactory() {

    }

    public static JWTUser create(DemoUser demoUser){
        List<Role> roles = demoUser.getRoles();
        List<String> rs = new ArrayList<>();
        for (Role r:roles
             ) {
            rs.add(r.getRoleName());
        }
        return new JWTUser(demoUser.getUserName(),demoUser.getPassword(),demoUser.getUserId(),mapToGrantedAuthority(rs));
    }

    private static List<GrantedAuthority> mapToGrantedAuthority(List<String> authorities){
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
