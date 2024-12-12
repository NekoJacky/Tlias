package com.ragdollcatstudio;

import com.ragdollcatstudio.mapper.EmpMapper;
import com.ragdollcatstudio.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class MybatisLearnApplicationTests {
    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testSelectById() {
        Emp emp = empMapper.selectById(10);
        System.out.println(emp);
    }

    @Test
    public void testSelectByList() {
        List<Emp> emps = empMapper.selectByList("张", (short) 1,
                LocalDate.of(2010, 1, 1),
                LocalDate.of(2020, 1, 1));
        System.out.println(emps);
    }
}
