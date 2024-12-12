package com.ragdollcatstudio.service.impl;

import com.ragdollcatstudio.mapper.DeptMapper;
import com.ragdollcatstudio.mapper.EmpMapper;
import com.ragdollcatstudio.pojo.Dept;
import com.ragdollcatstudio.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Dept> getDeptList() {
        return deptMapper.getDeptList();
    }

    // @Transactional 注解用于将事务交给Spring进行管理，一般在业务 (service) 层使用
    // 不仅可以用在方法上，也可以用在类和接口上（一般不加在类和接口上）
    // 默认只有 RuntimeException 才会回滚，需要配置 rollbackFor 属性
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteDeptById(int id) {
        deptMapper.deleteDeptById(id);
        empMapper.deleteEmpById(id);
    }

    @Override
    public void addDept(Dept dept) {
        LocalDateTime now = LocalDateTime.now();
        dept.setCreateTime(now);
        dept.setUpdateTime(now);
        deptMapper.insertDept(dept);
    }

    @Override
    public Dept getDeptById(int id) {
        return deptMapper.getDeptById(id);
    }

    @Override
    public void updateDept(Dept dept) {
        LocalDateTime now = LocalDateTime.now();
        dept.setUpdateTime(now);
        deptMapper.updateDept(dept);
    }
}
