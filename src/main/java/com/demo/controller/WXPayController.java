package com.demo.controller;

import org.springframework.stereotype.Controller;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Administrator on 2016/12/23.
 */
@Controller
public class WXPayController {
    public BufferedImage getWXpayImage(){
        HashMap<String,String> paramMap = new HashMap<>();
        paramMap.put("appid","xxxxxxxx");
        paramMap.put("mch_id","1111111111");
        paramMap.put("nonce_str", String.valueOf(new Random(10).nextInt()));
        paramMap.put("body","ipad");
        paramMap.put("out_trade_no", String.valueOf(new Random(10).nextInt()));
        paramMap.put("total_fee", 1000+"");
        paramMap.put("spbill_create_ip", "127.0.0.1");
//        paramMap.put("notify_url", this.notifyUrl);
        paramMap.put("trade_type", "NATIVE"); //交易类型
        paramMap.put("product_id", "100001");
        //根据微信签名规则，生成签名。随机参数可以在商户后台管理系统中进行设置。
//        paramMap.put("sign", PaymentUtil.getSignature(paramMap, "beGPax3F1EtxxxxxxofcerMRqNvt9XJ2"));



//  http://javatech.wang/index.php/archives/84/   http://blog.csdn.net/wangqiuyun/article/details/51241064

        return null;
    }
}
