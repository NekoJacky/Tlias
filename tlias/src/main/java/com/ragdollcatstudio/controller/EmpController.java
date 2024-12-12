package com.ragdollcatstudio.controller;

import com.ragdollcatstudio.pojo.Emp;
import com.ragdollcatstudio.pojo.PageBean;
import com.ragdollcatstudio.pojo.Result;
import com.ragdollcatstudio.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping
    public Result getEmpsByPage(@RequestParam(defaultValue = "1") Integer page,
                                @RequestParam(defaultValue = "10") Integer pageSize,
                                String name, Short gender,
                                @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                                @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("getEmpsByPage");
        PageBean emps = empService.getEmpsByPage(page, pageSize, name, gender, begin, end);
        return Result.success(emps);
    }

    @DeleteMapping("{ids}")
    public Result deleteEmpsByIds(@PathVariable List<Integer> ids) {
        log.info("deleteEmpsByIds");
        empService.deleteEmpsbyIds(ids);
        return Result.success();
    }

    @PostMapping
    public Result addEmp(@RequestBody Emp emp) {
        log.info("addEmp");
        empService.addEmp(emp);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getEmpById(@PathVariable Integer id) {
        log.info("getEmpById");
        Emp emp = empService.getEmpById(id);
        return Result.success(emp);
    }

    @PutMapping
    public Result updateEmp(@RequestBody Emp emp) {
        log.info("updateEmp");
        empService.updateEmp(emp);
        return Result.success();
    }
}
