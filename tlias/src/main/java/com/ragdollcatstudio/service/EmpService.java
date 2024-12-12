package com.ragdollcatstudio.service;

import com.ragdollcatstudio.pojo.Emp;
import com.ragdollcatstudio.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    PageBean getEmpsByPage(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void deleteEmpsbyIds(List<Integer> ids);

    void addEmp(Emp emp);

    Emp getEmpById(Integer id);

    void updateEmp(Emp emp);

    Emp login(Emp emp);
}
