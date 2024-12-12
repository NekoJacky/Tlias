package com.ragdollcatstudio.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usr {
    private Integer id;
    private String name;
    private short age;
    private short gender;
    private String phone;
}
