package com.ragdollcatstudio.pojo;

public class Usr {
    private String name;
    private Integer age;
    private Address address;

    public Usr() {}
    public Usr(String name, Integer age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public String getName() {return name;}
    public Integer getAge() {return age;}
    public Address getAddress() {return address;}
    public void setName(String name) {this.name = name;}
    public void setAge(Integer age) {this.age = age;}
    public void setAddress(Address address) {this.address = address;}
}
