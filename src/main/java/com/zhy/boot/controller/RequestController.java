package com.zhy.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {
    @GetMapping("/goto")
    public String GoTo(HttpServletRequest request){
        request.setAttribute("ds","12");
        request.setAttribute("num",13);

        return "forward:success";
    }
    @GetMapping("params")
    public String GetParamsTest(Model model,Map map,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
        model.addAttribute("addAttribute","addAttribute");
        map.put("put","put");
        httpServletRequest.setAttribute("setAttribute","setAttribute");
        Cookie cookie = new Cookie("Cookie", "Cookie");
        httpServletResponse.addCookie(cookie);
        return "forward:success";
    }
    @ResponseBody
    @GetMapping("/success")
    public Map<String,Object> success(@RequestAttribute(value ="ds",required = false) String ds,
                                      @RequestAttribute(value = "num",required = false) Integer num,
                                      HttpServletRequest httpServletRequest){
        Object addAttribute = httpServletRequest.getAttribute("addAttribute");
        Object put = httpServletRequest.getAttribute("put");
        Object setAttribute = httpServletRequest.getAttribute("setAttribute");
        HashMap<String, Object> map = new HashMap<>();
        map.put("ds",ds);
        map.put("num",num);
        map.put("addAttribute",addAttribute);
        map.put("put",put);
        map.put("setAttribute",setAttribute);

        return map;
    }

    @PostMapping("/save")
    public String postMethod(@RequestParam("username") String username, @RequestParam("name") String name, HttpServletResponse response){
        Map<String, Object> map = new HashMap<>();
        Cookie username1 = new Cookie("username", username);
        Cookie username2 = new Cookie("name", name);
        response.addCookie(username1);
        response.addCookie(username2);
//        map.put("content",content);
        map.put("username",username);
        map.put("name",name);
        return "forward:cookie1";
    }
    @ResponseBody
    @PostMapping("/cookie1")
    public Map getCookie(@CookieValue("username")String username,@CookieValue("name") String name){

        HashMap<String, Object> map = new HashMap<>();
        map.put("username",username);
        map.put("name",name);
        return map;
    }
}
