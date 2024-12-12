package com.ragdollcatstudio.controller;

import com.ragdollcatstudio.pojo.Dept;
import com.ragdollcatstudio.pojo.Result;
import com.ragdollcatstudio.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    // @RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping
    public Result getDeptList() {
        log.info("getDeptList");
        List<Dept> list = deptService.getDeptList();
        return Result.success(list);
    }

    @DeleteMapping("/{id}")
    public Result deleteDept(@PathVariable int id) {
        log.info("deleteDeptById: {}", id);
        deptService.deleteDeptById(id);
        return Result.success();
    }

    @PostMapping
    public Result addDept(@RequestBody Dept dept) {
        log.info("addDept: {}", dept);
        deptService.addDept(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getDeptById(@PathVariable int id) {
        log.info("getDeptById");
        Dept dept = deptService.getDeptById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result updateDept(@RequestBody Dept dept) {
        log.info("updateDept: {}", dept);
        deptService.updateDept(dept);
        return Result.success();
    }
}
