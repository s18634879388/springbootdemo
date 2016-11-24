package com.demo.mapper;

import com.demo.domain.DemoUser;

import java.util.List;

/**
 * Created by Administrator on 2016/11/24.
 */
public interface DemoUserMapper {
    List<DemoUser> getAllUser();
    void addUser(DemoUser demoUser);
}
