package com.ragdollcatstudio.controller;

import com.ragdollcatstudio.pojo.Usr;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class RequestController {
    // 一、简单参数
    //
    // 1. 原始方法
    //
    @RequestMapping("/simpleParam1")
    public String simpleParam1(HttpServletRequest request) {
        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");
        int age = Integer.parseInt(ageStr);
        System.out.println(name + ':'  + age);
        return "success";
    }
    //
    // 2. SpringBoot 方法，可以接受 get 和 post 请求
    //
    @RequestMapping("/simpleParam2")
    public String simpleParam2(String name, Integer age) {
        System.out.println(name + ':'  + age);
        return "success";
    }
    //
    // 3. 防止传入参数名与方法参数名不一致
    // 例如 url 中的参数为 name ，而方法参数为 usrName
    //
    @RequestMapping("/simpleParam3")
    public String simpleParam3(
            @RequestParam(name = "name", required = false)String usrName,
            Integer age
    ) {
        System.out.println(usrName + ':'  + age);
        return "success";
    }

    // 二、数组参数
    // 1. 数组封装
    //
    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby) {
        System.out.println(Arrays.toString(hobby));
        return "success";
    }
    //
    // 2. 集合参数
    //
    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby) {
        System.out.println(hobby);
        return "success";
    }

    // 三、时间参数
    //
    @RequestMapping("/dateParam")
    public String dateParam(
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date
    ) {
        System.out.println(date);
        return "success";
    }

    // 四、Json参数
    //
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody Usr usr) {
        System.out.println(usr);
        return "success";
    }

    // 五、路径参数
    // 1. 单个参数
    //
    @RequestMapping("/pathParam/{page}")
    public String pathParam1(@PathVariable Integer page) {
        System.out.println("page:"+page);
        return "success";
    }
    //
    // 2. 多个参数
    //
    @RequestMapping("/path/{page}/{id}")
    public String pathParam2(@PathVariable Integer page , @PathVariable Integer id) {
        System.out.println("page:"+page);
        System.out.println("id:"+id);
        return "success";
    }
}
