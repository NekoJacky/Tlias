package com.ragdollcatstudio.service;

import com.ragdollcatstudio.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> getDeptList();
    void deleteDeptById(int id);
    void addDept(Dept dept);
    Dept getDeptById(int id);
    void updateDept(Dept dept);
}
