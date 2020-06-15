package com.xlp.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author xianglianpeng@sunseaaiot.com
 * @Date 2020/6/12 16:47
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeChatController {
    @GetMapping("auth")
    private void auth(@RequestParam("code") String code){
        log.info("进入微信权限校验auth方法");
        log.info("code={}",code);
    }
}
