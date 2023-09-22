package com.study.intro_spring.controller;

import com.study.intro_spring.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private RedisService redisService;

    @PostMapping("/set")
    public String setData(@RequestParam String key, @RequestParam String value) {
        redisService.setData(key, value);
        return "Data set successfully";
    }

    @GetMapping("/get")
    public String getData(@RequestParam String key) {
        return redisService.getData(key);
    }
}
