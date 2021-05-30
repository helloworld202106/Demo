package com.hello.world.demo.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username") String name,
                                     @PathVariable Map<String, String> pv,
                                     @RequestHeader("User-Agent") String userAgent,
                                     @RequestHeader Map<String,String> headers,
                                     @RequestParam("age") Integer age,
                                     @RequestParam("inters") List<String> inters,
                                     @RequestParam Map<String,String> params,
                                     @CookieValue("_ga") String _ga,
                                     @CookieValue("_ga") Cookie cookie){
        Map<String, Object> map = new HashMap<>();
        //http://localhost:8080/car/9/owner/hello
//        map.put("id", id);
//        map.put("name", name);
//        map.put("map", pv);
//        map.put("userAgent",userAgent);
//
        //http://localhost:8080/car/9/owner/hello?age=188&inters=computerGames&inters=lol
        map.put("age", age);
        map.put("inters", inters);
        map.put("params", params);
        map.put("_ga", _ga);
        System.out.println(cookie);
        return map;
    }

    @PostMapping("/save")
    public Map postMethod(@RequestBody String content ){
        Map<String, Object> map = new HashMap<>();
        map.put("content", content);
        return map;
    }

}
