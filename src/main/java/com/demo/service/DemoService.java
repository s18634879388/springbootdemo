package com.demo.service;

import com.demo.domain.DemoUser;
import com.demo.mapper.DemoUserMapper;
import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.enmus.ExcelType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/11/24.
 */
@Service
@Transactional
public class DemoService {
    @Autowired
    private DemoUserMapper demoUserMapper;

    /**
     *  1.在启动类上添加@EnableTransactionManagement注解
     *  2.在要进行事务管理的类上添加@Transaction注解
     *
     */
    public List<DemoUser> getAllUser(){
        DemoUser demoUser = new DemoUser();
        demoUser.setUserName("lilei");
        demoUser.setPassword("123456");
        demoUser.setLastIp("127.0.0.1");
        demoUser.setLastVisit(new Date());
        demoUserMapper.addUser(demoUser);
        int i = 0;
        i = 10/0;
        List<DemoUser> demoUsers = demoUserMapper.getAllUser();
        for (DemoUser demouser:demoUsers
             ) {
            System.out.println(demouser.getUserName()+"---------------------------");
        }
        return demoUsers;
    }

    /**
     * 添加maven依赖
                <dependency>
                <groupId>com.mangofactory</groupId>
                <artifactId>swagger-springmvc</artifactId>
                <version>1.0.2</version>
            </dependency>
     *在启动类添加@EnableCaching注解
     * 在需要加入缓存的地方添加@Cacheable注解
     */
    @Cacheable(value = "cachetest",key = "'t1'")
    public List<DemoUser> getAllUser2() throws IOException {
        System.out.println("从数据库取出");

        List<DemoUser> demoUsers = demoUserMapper.getAllUser();

        ExportParams exportParams = new ExportParams("test","测试", ExcelType.XSSF);
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams,DemoUser.class,demoUsers);
        File save = new File("d:/TestExcel/");
        if (!save.exists()){
            save.mkdir();
        }
        FileOutputStream fileOutputStream = new FileOutputStream("d:/TestExcel/myTest.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        return demoUsers;
    }
    @Cacheable(value = "cachetest",key = "'t1'")
    public List<DemoUser> getAllUser3() {
        System.out.println("从数据库取出");
        List<DemoUser> demoUsers = demoUserMapper.getAllUser();
        return demoUsers;
    }
}
