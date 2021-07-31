package com.learning;

import com.github.javafaker.Faker;
import com.learning.model.Employee;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println("Hello World!!!");

        Faker faker = new Faker();
        List<Employee> employees = new ArrayList<>();
        IntStream.range(0, 20).forEach(value -> {
            Date date = faker.date().birthday();
            long age = TimeUnit.DAYS.convert(System.currentTimeMillis() - date.getTime(), TimeUnit.MILLISECONDS);
            age/=365;
            employees.add(new Employee(faker.name().fullName(), faker.number().randomDigit(), faker.company().industry(), faker.date().birthday(20, 40), (int)age));
        });

        employees.stream().forEach(System.out::println);


        System.out.println(Thread.currentThread().getName());
    }
}
