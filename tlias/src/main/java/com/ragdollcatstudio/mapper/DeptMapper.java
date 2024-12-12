package com.ragdollcatstudio.mapper;

import com.ragdollcatstudio.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select * from dept")
    List<Dept> getDeptList();

    @Delete("delete from dept where id = #{id}")
    void deleteDeptById(int id);

    @Insert("insert into dept (name, create_time, update_time) VALUES (#{name}, #{createTime}, #{updateTime})")
    void insertDept(Dept dept);

    @Select("select * from dept where id = #{id}")
    Dept getDeptById(int id);

    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void updateDept(Dept dept);
}
