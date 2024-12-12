package com.ragdollcatstudio.mapper;

import com.ragdollcatstudio.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    @Delete("delete from db02_test.emp where id = #{id}")
    int delete(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into db02_test.emp(username, name, gender, image, job, entrydate, dept_id, create_time, " +
            "update_time) values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entryDate}, #{deptId}, " +
            "#{createTime}, #{updateTime})")
    int insert(Emp emp);

    @Update("update emp set username = #{username}, name = #{name}, gender = #{gender}, image = #{image}, " +
            "job = #{job}, entrydate = #{entryDate}, dept_id = #{deptId}, update_time = #{updateTime} where id = #{id}")
    int update(Emp emp);

    @Select("select id, username, password, name, gender, image, job, " +
            "entrydate, dept_id, create_time, update_time " +
            "from emp where id = #{id}")
    Emp selectById(Integer id);

    /*
    // 这是使用 @Select 注解进行 SQL 查询
    @Select("select * from emp" +
            "         where name like concat('%', #{name}, '%')" +
            "           and gender = #{gender}" +
            "           and entrydate between #{begin} and #{end}" +
            "         order by update_time desc")
     */

    // 这是使用 XML 进行动态 SQL 查询
    List<Emp> selectByList(String name, Short gender, LocalDate begin, LocalDate end);

    // 使用 XML 动态更新信息
    int newUpdate(Emp emp);

    void deleteByIdList(List<Integer> idList);
}
