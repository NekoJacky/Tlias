package com.ragdollcatstudio.mapper;

import com.ragdollcatstudio.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    @Select("select count(*) from emp")
    Long count();

    // @Select("select * from emp limit #{start}, #{pageSize}")
    List<Emp> getEmpsByPage(Integer start, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void deleteEmpsByIds(List<Integer> ids);

    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "VALUES (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    void addEmp(Emp emp);

    @Select("select * from emp where id = #{id}")
    Emp getEmpById(Integer id);

    void updateEmp(Emp emp);

    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getEmpByUsernameAndPassword(Emp emp);

    @Delete("delete from Emp where dept_id = #{deptId}")
    void deleteEmpById(Integer deptId);
}
