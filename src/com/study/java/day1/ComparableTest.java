package com.study.java.day1;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ComparableTest {

    public static class CompareObject implements Comparable<CompareObject> {

        private int amount;
        private String name;

        public String getName() { return this.name; }

        public CompareObject(int amount, String name) {
            this.amount = amount;
            this.name = name;
        }

        @Override
        public int compareTo(CompareObject o) {
            return new Integer(amount).compareTo(new Integer(o.amount));
        }
    }

    /*
     * 비교할 수 있다
     *
     */

    public static void main(String[] args) {
        System.out.println("java study 2018");

        System.out.println("1 compare to 2 : " + new Integer(1).compareTo(new Integer(2)));
        System.out.println("2 compare to 1 : " + new Integer(2).compareTo(new Integer(1)));
        System.out.println("2 compare to 2 : " + new Integer(1).compareTo(new Integer(1)));

        System.out.println("a compare to b : " + "a".compareTo("b"));
        System.out.println("b compare to a : " + "b".compareTo("a"));
        System.out.println("a compare to b : " + "a".compareTo("a"));

        List<CompareObject> objects = Stream.<CompareObject>builder()
                .add(new CompareObject(100, "A"))
                .add(new CompareObject(500, "B"))
                .add(new CompareObject(300, "C"))
                .add(new CompareObject(200, "D"))
                .add(new CompareObject(400, "E"))
                .build()
                .collect(Collectors.toList());

        objects.stream().sorted().forEach(c -> {
            System.out.println("sort " + c.amount + " : " + c.name);
        });

        System.out.println("----------------------");

        objects.stream().sorted(Comparator.reverseOrder()).forEach(c -> {
            System.out.println("sort " + c.amount + " : " + c.name);
        });

        System.out.println("----------------------");

        objects.stream().sorted(Comparator.comparing(CompareObject::getName)).forEach(c -> {
            System.out.println("sort " + c.amount + " : " + c.name);
        });
    }

}
