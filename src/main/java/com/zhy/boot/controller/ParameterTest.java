package com.zhy.boot.controller;

import com.sun.deploy.net.HttpResponse;
import com.zhy.boot.entity.Pet;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTest {
    @GetMapping("/car/{id}/owner/{userName}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id
                                      , @PathVariable("userName") String userName
                                      , @PathVariable Map<String,String> pv
                                      , @RequestHeader("User-Agent") String userAgent
                                      , @RequestHeader Map<String,String> requestHeader
                                      , @RequestParam("age") Integer age
                                      , @RequestParam("hobby") List<String> hobby
                                      , @RequestParam Map<String,String> requestParam
//                                      , @CookieValue("_ga") String _ga
                                        ) {

        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("userName",userName);
        map.put("pv",pv);
        map.put("userAgent",userAgent);
        map.put("requestHeader",requestHeader);
        map.put("age",age);
        map.put("hobby",hobby);
        map.put("requestParam",requestParam);
//        map.put("_ga",_ga);
        return map;
    }
    //cars/sell;low=34;brand=byd,audi,yd
    @GetMapping("cars/{path}")
    public Map getCars(@MatrixVariable("low") Integer low,@MatrixVariable("brand") String brand,@PathVariable("path") String path){
        HashMap<String, Object> map = new HashMap<>();
        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);
        return map;
    }
    //boss/1;age=20/2;age=10
    @GetMapping("boss/{bossId}/{empId}")
    public Map getBOssId(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossId,
                         @MatrixVariable(value = "age",pathVar="empId") Integer empId){
        HashMap<String, Object> map = new HashMap<>();
        map.put("bossId",bossId);
        map.put("empId",empId);
        return map;
    }

    @GetMapping("/pet")
    public Map getPet(String pet){
        Map<String, Object> map = new HashMap<>();
        map.put("pet",pet);
        return map;
    }
    public String Hello(){
        return "heloo";
    }


}
