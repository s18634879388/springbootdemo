//package com.test;
//
//import com.demo.Application;
//import com.demo.domain.LoginLog;
//import com.demo.domain.TUser;
//import com.demo.mapper.LoginLogMapper;
//import com.demo.mapper.TUserMapper;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import java.util.List;
//
///**
// * Created by Administrator on 2016/12/20.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
//@WebAppConfiguration
//@MapperScan(basePackages = "com.demo.mapper")
//public class TestA {
//    @Autowired
//    private TUserMapper tUserMapper;
////    @Autowired
////    private LoginLogMapper loginLogMapper;
//
//
//    @Test
//    public void testSelectAll(){
//        List<TUser> tusers = tUserMapper.selectAll();
//        for (TUser t: tusers
//                ) {
//            System.out.println(t.getUserName()+"=====");
//        }
//    }
//
//    @Test
//    public void testSelectOne(){
//        TUser tUser = new TUser();
//        tUser.setUserName("wang");
//        TUser tUser1 =tUserMapper.selectOne(tUser);
//
//        TUser tUser2 =tUserMapper.selectByPrimaryKey(2);
//        System.out.println("-----"+tUser1.getId()+"----"+tUser1.getUserName());
//        System.out.println("-----"+tUser2.getUserName());
//    }
//
//    @Test
//    public void insert(){
//        TUser tUser2 = new TUser();
//        tUser2.setUserName("history");
//        tUserMapper.insert(tUser2);
//        System.out.println("id----"+tUser2.getId());
//    }
//
//
////    @Test
////    public void testSelect(){
////        LoginLog loginLog = loginLogMapper.getIsdelete();
////        System.out.println(loginLog.getId()+"-------");
////
////    }
//
//
//
//
//}
