package com.study.java.day2;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class CollectionTest {

    private static String getThreadNanoString(Long fromNano) {
        return "[" + Thread.currentThread().getName() + "]" + (System.nanoTime() - fromNano) + "ns:";
    }

    private static String getThreadMilliString(Long fromMilli) {
        return "[" + Thread.currentThread().getName() + "]" + (System.currentTimeMillis() - fromMilli) + "ms:";
    }

    public static void test_forEach() {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        Collection<Long> list = LongStream.range(1, 100000).boxed().collect(Collectors.toList());

        Long milli1 = System.currentTimeMillis();
        list.stream().forEach(Long::valueOf);
        System.out.println(getThreadMilliString(milli1) + " stream foreach ");

        Long milli2 = System.currentTimeMillis();
        for(Long it : list) {
            Long.valueOf(it);
        }
        System.out.println(getThreadMilliString(milli2) + " foreach ");
    }

    public static void test_stream() {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        Collection<Integer> list = IntStream.range(1, 10).boxed().collect(Collectors.toList());

        Long nano1 = System.nanoTime();
        list.stream().forEach(it -> System.out.println(getThreadNanoString(nano1) + " stream: " + it));

        Long nano2 = System.nanoTime();
        list.parallelStream().forEach(it -> System.out.println(getThreadNanoString(nano2) + " parallel stream: " + it));
    }

    public static void test_removeIf() {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        Collection<Integer> list = IntStream.builder()
                .add(1).add(2).add(10).add(12)
                .build().boxed().collect(Collectors.toList());

        list.removeIf(it -> it < 5);
        list.stream().forEach(it -> System.out.println("++ remove if: " + it));
    }

    public static void test_containsAll() {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        Collection<Integer> list = IntStream.builder().add(1).add(2).build().boxed().collect(Collectors.toList());
        Collection<Integer> set = IntStream.builder().add(1).add(2).build().boxed().collect(Collectors.toSet());
        System.out.println("++ contains all: " + list.containsAll(set));

        for (Integer item : list) {
            System.out.println("++ foreach: " + item);
        }
        set.stream().forEach(it -> System.out.println("++ stream foreach: " + it));
    }

    // 동일한 요소만 남긴다
    public static void test_retainAll() {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        Collection<Integer> list1 = IntStream.builder().add(1).add(2).add(3).build().boxed().collect(Collectors.toList());
        Collection<Integer> set1 = IntStream.builder().add(1).add(2).add(4).build().boxed().collect(Collectors.toSet());
        list1.retainAll(set1);
        System.out.println("++ retain all: list1");
        list1.stream().forEach(System.out::println);
        set1.stream().forEach(System.out::println);

        Collection<Integer> list2 = IntStream.builder().add(4).add(5).add(3).build().boxed().collect(Collectors.toList());
        Collection<Integer> set2 = IntStream.builder().add(1).add(2).build().boxed().collect(Collectors.toSet());
        list2.retainAll(set2);
        System.out.println("++ retain all: list2");
        list2.stream().forEach(System.out::println);
        set2.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        test_containsAll();
        test_retainAll();
        test_removeIf();
        test_stream();
        test_forEach();
        Iterable<Integer> iterable;


        List<Integer> list1 = IntStream.builder().add(1).add(2).add(3).build().boxed().collect(Collectors.toList());
//        for (int i = 0; i < list1.size(); i++) {
//            System.out.println(i + ":" + list1.get(i));
//            if (i == 0)
//            list1.remove(list1.get(i));
//
//        }
        int idx = 0;
        for (Integer it : list1) {
            System.out.println(idx + ":" + it);
            if (idx++ == 0);
            list1.remove(it);
        }
    }
}
