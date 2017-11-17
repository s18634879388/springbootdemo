package com.demo.service;

import com.demo.domain.DemoUser;
import com.demo.domain.JwtUserFactory;
import com.demo.mapper.DemoUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/11/17.
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    DemoUserMapper demoUserMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        DemoUser demoUser = demoUserMapper.getDemoUserByName(userName);
        if (demoUser==null){
            throw new UsernameNotFoundException(String.format("'%s'用户不存在",userName));
        } else {
            return JwtUserFactory.create(demoUser);

        }
    }
}
