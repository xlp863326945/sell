package com.xlp.sell.utils;

import java.util.Random;

/**
 * @Description TODO
 * @Author xianglianpeng@sunseaaiot.com
 * @Date 2020/6/10 16:53
 */
public class KeyUtil {
    /**
     * 生成唯一主键
     * 格式：时间+随机数
     * @return
     */
    public static synchronized String genUniqueKey(){
        Random random=new Random();
        long l = System.currentTimeMillis();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis()+String.valueOf(number);
    }
}
