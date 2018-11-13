package com.study.java.day1;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ObjectTest {

    public static class NonTest {
        private int a;
        public NonTest(int a) { this.a = a; }

        @Override
        public String toString() {
            return "non:" + a;
        }
    }

    public static class EqualsTest {
        private int a;

        public EqualsTest(int a) { this.a = a; }

        @Override
        public boolean equals(Object obj) {
            if (EqualsTest.class.isInstance(obj)) {
                return Integer.valueOf(a).equals(EqualsTest.class.cast(obj).a);
            }
            return super.equals(obj);
        }

        @Override
        public String toString() {
            return "eq:" + a;
        }
    }

    public static class HashCodeTest {
        private int a;

        public HashCodeTest(int a) { this.a = a; }

        @Override
        public int hashCode() {
            return Integer.hashCode(a);
        }

        @Override
        public String toString() {
            return "hash:" + a;
        }
    }

    public static class EqualsHashCodeTest {
        private int a;

        public EqualsHashCodeTest(int a) { this.a = a; }

        @Override
        public boolean equals(Object obj) {
            if (EqualsHashCodeTest.class.isInstance(obj)) {
                return Integer.valueOf(a).equals(EqualsHashCodeTest.class.cast(obj).a);
            }
            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(a);
        }

        @Override
        public String toString() {
            return "eq-hash:" + a;
        }
    }

    public static Stream<NonTest> getNonTestStream() {
        return Stream.<NonTest>builder()
                .add(new NonTest(1))
                .add(new NonTest(1))
                .add(new NonTest(1))
                .build();
    }

    public static Stream<EqualsTest> getEqualsTestStream() {
        return Stream.<EqualsTest>builder()
                .add(new EqualsTest(1))
                .add(new EqualsTest(1))
                .add(new EqualsTest(1))
                .build();
    }

    public static Stream<HashCodeTest> getHashCodeTestStream() {
        return Stream.<HashCodeTest>builder()
                .add(new HashCodeTest(1))
                .add(new HashCodeTest(1))
                .add(new HashCodeTest(1))
                .build();
    }

    public static Stream<EqualsHashCodeTest> getEqualsHashCodeTestStream() {
        return Stream.<EqualsHashCodeTest>builder()
                .add(new EqualsHashCodeTest(1))
                .add(new EqualsHashCodeTest(1))
                .add(new EqualsHashCodeTest(1))
                .build();
    }

    public static void main(String[] args) {
        System.out.println("java study 2018");

        String a = new String("1111"), b = new String("1111");
        System.out.println(a == b);

        System.out.println("--list remove : non--------------------");
        List<NonTest> list1 = getNonTestStream().collect(Collectors.toList());
        System.out.println("contains: " + list1.contains(new NonTest(1)));
        list1.remove(new NonTest(1));
        list1.stream().forEach(System.out::println);

        System.out.println("--list remove : eq--------------------");
        List<EqualsTest> list2 = getEqualsTestStream().collect(Collectors.toList());
        System.out.println("contains: " + list2.contains(new EqualsTest(1)));
        list2.remove(new EqualsTest(1));
        list2.stream().forEach(System.out::println);

        System.out.println("--list remove : hash--------------------");
        List<HashCodeTest> list3 = getHashCodeTestStream().collect(Collectors.toList());
        System.out.println("contains: " + list3.contains(new HashCodeTest(1)));
        list3.remove(new HashCodeTest(1));
        list3.stream().forEach(System.out::println);

        System.out.println("--list remove : eq hash--------------------");
        List<EqualsHashCodeTest> list4 = getEqualsHashCodeTestStream().collect(Collectors.toList());
        System.out.println("contains: " + list4.contains(new EqualsHashCodeTest(1)));
        list4.remove(new EqualsHashCodeTest(1));
        list4.stream().forEach(System.out::println);

        System.out.println("=================================================================");
        System.out.println("--set remove : non--------------------");
        Set<NonTest> set1 = getNonTestStream().collect(Collectors.toSet());
        System.out.println("contains: " + set1.contains(new NonTest(1)));
        set1.remove(new NonTest(1));
        set1.stream().forEach(System.out::println);

        System.out.println("--set remove : eq--------------------");
        Set<EqualsTest> set2 = getEqualsTestStream().collect(Collectors.toSet());
        System.out.println("contains: " + set2.contains(new EqualsTest(1)));
        set2.remove(new EqualsTest(1));
        set2.stream().forEach(System.out::println);

        System.out.println("--set remove : hash--------------------");
        Set<HashCodeTest> set3 = getHashCodeTestStream().collect(Collectors.toSet());
        System.out.println("contains: " + set3.contains(new HashCodeTest(1)));
        set3.remove(new HashCodeTest(1));
        set3.stream().forEach(System.out::println);

        System.out.println("--set remove : eq hash--------------------");
        Set<EqualsHashCodeTest> set4 = getEqualsHashCodeTestStream().collect(Collectors.toSet());
        System.out.println("--set remove : eq hash-----111---------------");
        set4.stream().forEach(System.out::println);
        System.out.println("contains: " + set4.contains(new EqualsHashCodeTest(1)));
        set4.remove(new EqualsHashCodeTest(1));
        set4.stream().forEach(System.out::println);

        System.out.println("=================================================================");
        System.out.println("--set add : non--------------------");
        Set<NonTest> set11 = getNonTestStream().collect(Collectors.toSet());
        set11.add(new NonTest(1));
        set11.stream().forEach(System.out::println);

        System.out.println("--set add : eq--------------------");
        Set<EqualsTest> set12 = getEqualsTestStream().collect(Collectors.toSet());
        set12.add(new EqualsTest(1));
        set12.stream().forEach(System.out::println);

        System.out.println("--set add : hash--------------------");
        Set<HashCodeTest> set13 = getHashCodeTestStream().collect(Collectors.toSet());
        set13.add(new HashCodeTest(1));
        set13.stream().forEach(System.out::println);

        System.out.println("--set add : eq hash--------------------");
        Set<EqualsHashCodeTest> set14 = getEqualsHashCodeTestStream().collect(Collectors.toSet());
        set14.add(new EqualsHashCodeTest(1));
        set14.stream().forEach(System.out::println);



        System.out.println("=================================================================");
        System.out.println("--map get : non--------------------");
        HashMap<NonTest, Integer> map1 = new HashMap<>();
        map1.put(new NonTest(1), 1000);
        System.out.println("map : " + map1.get(new NonTest(1)));

        System.out.println("--map get : eq--------------------");
        HashMap<EqualsTest, Integer> map2 = new HashMap<>();
        map2.put(new EqualsTest(1), 1000);
        System.out.println("map : " + map2.get(new EqualsTest(1)));

        System.out.println("--map get : hash--------------------");
        HashMap<HashCodeTest, Integer> map3 = new HashMap<>();
        map3.put(new HashCodeTest(1), 1000);
        System.out.println("map : " + map3.get(new HashCodeTest(1)));

        System.out.println("--map get : eq hash--------------------");
        HashMap<EqualsHashCodeTest, Integer> map4 = new HashMap<>();
        map4.put(new EqualsHashCodeTest(1), 1000);
        System.out.println("map : " + map4.get(new EqualsHashCodeTest(1)));

        System.out.println("=================================================================");
        System.out.println("equals:" + Objects.isNull(null));
        System.out.println("equals:" + Objects.nonNull(1));
        System.out.println("equals:" + Objects.equals(null, 1));
        System.out.println("equals:" + Objects.equals(Integer.valueOf(128), Integer.valueOf(128)));
    }
}
