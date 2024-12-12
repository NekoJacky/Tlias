package com.ragdollcatstudio;

import com.ragdollcatstudio.mapper.UsrMapper;
import com.ragdollcatstudio.pojo.Usr;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisStartApplicationTests {
    @Autowired
    private UsrMapper usrMapper;

    @Test
    void testUsrMapper() {
        List<Usr> list = usrMapper.list();
        list.forEach(System.out::println);
    }
}
