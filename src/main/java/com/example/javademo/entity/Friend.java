package com.example.javademo.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Friend implements Serializable 
{
    /**
    * serialVersionUID:  [变量简单描述]
    */
    private static final long serialVersionUID = 1809492458587118325L;

    private String nickName;

    private String age;
}
