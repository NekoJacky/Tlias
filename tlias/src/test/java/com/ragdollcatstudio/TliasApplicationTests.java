package com.ragdollcatstudio;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TliasApplicationTests {
    @Test
    void testJwtBuilder() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "ragdollcatstudio");
        map.put("age", 18);
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "ragdollcatstudio")
                .addClaims(map)
                .setExpiration(new Date(System.currentTimeMillis() + 1000))
                .compact();
        System.out.println(jwt);
    }
}
