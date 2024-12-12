package com.ragdollcatstudio.controller;

import com.ragdollcatstudio.pojo.Emp;
import com.ragdollcatstudio.pojo.JwtUtils;
import com.ragdollcatstudio.pojo.Result;
import com.ragdollcatstudio.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequestMapping("/login")
@RestController
public class LoginController {
    @Autowired
    private EmpService empService;
    @PostMapping
    public Result login(@RequestBody Emp emp) {
        log.info("login");
        Emp e = empService.login(emp);
        if(e != null) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", e.getId());
            map.put("name", e.getName());
            map.put("username", e.getUsername());
            String jwt = JwtUtils.generateJwt(map);
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }
}
