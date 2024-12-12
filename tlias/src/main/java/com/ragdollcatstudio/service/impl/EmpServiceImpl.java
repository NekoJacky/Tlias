package com.ragdollcatstudio.service.impl;

import com.ragdollcatstudio.mapper.EmpMapper;
import com.ragdollcatstudio.pojo.Emp;
import com.ragdollcatstudio.pojo.PageBean;
import com.ragdollcatstudio.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean getEmpsByPage(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        Long cnt = empMapper.count();
        List<Emp> list = empMapper.getEmpsByPage((page-1)*pageSize, pageSize, name, gender, begin, end);
        return new PageBean(cnt, list);
    }

    @Override
    public void deleteEmpsbyIds(List<Integer> ids) {
        empMapper.deleteEmpsByIds(ids);
    }

    @Override
    public void addEmp(Emp emp) {
        LocalDateTime now = LocalDateTime.now();
        emp.setCreateTime(now);
        emp.setUpdateTime(now);
        empMapper.addEmp(emp);
    }

    @Override
    public Emp getEmpById(Integer id) {
        return empMapper.getEmpById(id);
    }

    @Override
    public void updateEmp(Emp emp) {
        LocalDateTime now = LocalDateTime.now();
        emp.setUpdateTime(now);
        empMapper.updateEmp(emp);
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.getEmpByUsernameAndPassword(emp);
    }
}
