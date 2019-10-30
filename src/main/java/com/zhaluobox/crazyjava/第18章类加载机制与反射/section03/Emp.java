package com.zhaluobox.crazyjava.第18章类加载机制与反射.section03;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Emp {

    private String  id;
    private String  name;
    private String  address;
    private Integer  age;
    private String  email;

    public Emp() {
    }

    public Emp(String id, String name, String address, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
        this.email = email;
    }

    public Emp(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Emp(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String  append(String name, Integer age){

        return name+age;

    }

    private void say(String  name){
        System.out.println(name+"hahahhaha");
    }
}
