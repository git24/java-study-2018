package com.study.java.day1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberTest {

    /*
     * Number class 는 왜 abstract class 인가
     */

    public static void main(String[] args) {
        System.out.println("java study 2018");

        List<Number> numbers = Stream.<Number>builder()
                .add(Byte.valueOf(Byte.MAX_VALUE))
                .add(Short.valueOf(Short.MAX_VALUE))
                .add(Integer.valueOf(Integer.MAX_VALUE))
                .add(Long.valueOf(Long.MAX_VALUE))
                .add(Float.valueOf(Float.MAX_VALUE))
                .add(Double.valueOf(Double.MAX_VALUE))
                .build().collect(Collectors.toList());

        numbers.forEach(c -> System.out.println(c.getClass().getName() + ":" + c));
        System.out.println("--byte--------------------");
        numbers.forEach(c -> System.out.println(c.getClass().getName() + ":" + c.byteValue()));
        System.out.println("--short--------------------");
        numbers.forEach(c -> System.out.println(c.getClass().getName() + ":" + c.shortValue()));
        System.out.println("--long--------------------");
        numbers.forEach(c -> System.out.println(c.getClass().getName() + ":" + c.longValue()));
        System.out.println("--float--------------------");
        numbers.forEach(c -> System.out.println(c.getClass().getName() + ":" + c.floatValue()));
        System.out.println("--double--------------------");
        numbers.forEach(c -> System.out.println(c.getClass().getName() + ":" + c.doubleValue()));
    }
}
