package com.study.java.day1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntegerTest {

    public static void main(String[] args) {
        System.out.println("java study 2018");

        System.out.println(Integer.toString(11, 16));
        System.out.println(Integer.toHexString(255));
        System.out.println(Integer.parseInt("ff", 16));

        System.out.println("-- auto boxing --------------------");

        Integer a = 127, b = 127;
        Integer c = 128, d = 128;

        System.out.println("integer cache:" + (a == b));
        System.out.println("integer cache:" + (c == d));
        System.out.println("integer equals:" + (c.equals(d)));

        System.out.println("----------------------");

        Integer a1 = new Integer(127), a2 = new Integer(127);
        Integer b1 = Integer.valueOf(127), b2 = Integer.valueOf(127);
        System.out.println("integer cache:" + (a1 == a2));
        System.out.println("integer cache:" + (b1 == b2));

        System.out.println("----------------------");

        Integer c1 = Integer.valueOf(128), c2 = Integer.valueOf(128);
        System.out.println("integer cache:" + (c1 == c2));

        System.out.println("--warnning--------------------");
        Integer carId = 2301, paramCarID = 2301;
        System.out.println("euqals : " + (carId == paramCarID));

        System.out.println("----------------------");
        System.out.println("getInteger: " + Integer.getInteger("100"));
        System.out.println("getInteger: " + Integer.getInteger("100", 10));
        System.out.println("valueOf: " + Integer.valueOf("100"));
        System.out.println("parseInt: " + Integer.parseInt("100"));   // primitive

        System.out.println("----------------------");
        System.out.println("decode: " + Integer.decode("100"));
        System.out.println("decode: " + Integer.decode("011"));     // 8
        System.out.println("decode: " + Integer.decode("0xff"));    // hex
    }
}
