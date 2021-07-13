package com.zhy.boot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Person {
    private String name;
    private Integer age;
    private Date birth;
}
