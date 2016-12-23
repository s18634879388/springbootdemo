package com.demo.controller;

import org.springframework.stereotype.Controller;

import java.awt.image.BufferedImage;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/12/23.
 */
@Controller
public class WXPayController {
    public BufferedImage getWXpayImage(){
        HashMap<String,String> paramMap = new HashMap<>();
        paramMap.put("appid","xxxxxxxx");
        paramMap.put("mch_id","1111111111");
//        paramMap.put()
//  http://javatech.wang/index.php/archives/84/

        return null;
    }
}
