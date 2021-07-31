package com.learning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String name;
    private Integer id;
    private String department;
    private Date dateOfBirth;
    private Integer age;
}
