package com.hello.world.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FrontendController {
//    @RequestMapping(value = {"/admin/**", "/apps/**", "/instances/**", "/login"}, method = RequestMethod.GET)
//    public String frontend() {
//        return "forward:/index.html";
//    }

    @RequestMapping(value = {"/_book/*/", "/_book/*/*/", "/_book/*/*/*/"})
    public String docs(HttpServletRequest request) {
        return "forward:" + request.getRequestURI() + "index.html";
    }

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request){
        request.setAttribute("msg", "goToPage");
        request.setAttribute("code", 200);
        return "forward:/success";
    }

    @ResponseBody
    @GetMapping("/success")
    public Map success(@RequestAttribute("msg") String msg,
                          @RequestAttribute("code") Integer code,
                          HttpServletRequest request){

        Object msg1 = request.getAttribute("msg");

        Map<String, Object> map = new HashMap<>();
        map.put("msg" , msg1);
        map.put("ammotation", msg);

        return map;
    }

    //cars/sell;low=34;brand=byd,audi,yd
    @ResponseBody
    @GetMapping("/cars/{path}")
    public Map carsSell( @PathVariable("path")  String path,
                         @MatrixVariable(name="low", pathVar = "path") Integer low,
                        @MatrixVariable(name="brand", pathVar = "path") List<String> brand
                        ){
        Map<String, Object> map = new HashMap<>();
        map.put("path", path);
        map.put("low", low);
        map.put("brand", brand);
        return map;
    }



}
