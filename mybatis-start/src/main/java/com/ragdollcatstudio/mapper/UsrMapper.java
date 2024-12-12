package com.ragdollcatstudio.mapper;

import com.ragdollcatstudio.pojo.Usr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UsrMapper {
    @Select("select * from user")
    List<Usr> list();
}
