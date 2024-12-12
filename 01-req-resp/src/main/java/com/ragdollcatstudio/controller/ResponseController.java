package com.ragdollcatstudio.controller;

import com.ragdollcatstudio.pojo.Address;
import com.ragdollcatstudio.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ResponseController {
    @RequestMapping("/hello")
    public Result hello() {
        return Result.success("Hello World");
    }

    @RequestMapping("/getAdd")
    public Result getAdd() {
        Address address = new Address("黑龙江", "哈尔滨");
        return Result.success(address);
    }

    @RequestMapping("/getAddList")
    public Result getAddList() {
        List<Address> list = new ArrayList<Address>();
        list.add(new Address("北京", "北京"));
        list.add(new Address("河南", "郑州"));
        return Result.success(list);
    }
}
