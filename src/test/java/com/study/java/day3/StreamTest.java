package com.study.java.day3;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class StreamTest {

    @Test
    public void supplier_test() {
        Supplier<String> s = () -> "hello";
        assertEquals("hello", s.get());
    }

    @Test
    public void consumer_test() {
        Consumer<Integer> consumer = it -> assertEquals(Integer.valueOf(100), it);
        consumer.andThen(it -> System.out.println("then:" + it))
                .accept(100);
    }

    @Test
    public void function_test() {
        Function<Integer, String> function = it -> it.toString() + "s";
        assertEquals("101si", function
                .andThen(it -> it + "i")
                .compose(it -> Integer.parseInt(it.toString()) + 1)
                .apply(100));
    }

    @Test
    public void predicate_test() {
        Predicate<Integer> predicate = it -> it == 100;
        assertTrue(predicate
                .and(it -> it % 10 == 0)
                .or(it -> it == 200)
                .test(100));

        assertTrue(predicate
                .negate().test(101));
    }

    @Test
    public void biconsumer_test() {
        BiConsumer<Integer, String> biConsumer = (it1, it2) ->
                assertEquals(Integer.valueOf(200), Integer.valueOf(it1 + Integer.valueOf(it2)));

        biConsumer.accept(100, "100");
    }

    @Test
    public void unary_operator_test() {
        UnaryOperator<Integer> unaryOperator = it -> it + 100;
        assertEquals(Integer.valueOf(200), unaryOperator.apply(100));
    }

    @Test
    public void binary_operator_test() {
        BinaryOperator<Integer> binaryOperator = (it1, it2) -> it1 + it2;
        assertEquals(Integer.valueOf(110), binaryOperator.apply(100, 10));
    }

    @Test
    public void bipredicate_test() {
        BiPredicate<Integer, Integer> biPredicate = (it1, it2) -> it1.equals(it2);
        assertTrue(biPredicate.test(100, 100));
    }


    @Test
    public void list_replace_all_test() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.replaceAll(it -> it + 1);
        list.stream().forEach(System.out::println);
        assertEquals(Integer.valueOf(2), list.get(0));
    }

    private Map<Integer, Integer> createIntMap() {
        return IntStream.rangeClosed(1, 5)
                .boxed()
                .collect(Collectors.toMap(it -> it * 10, it -> it * 100));
    }

    @Test
    public void map_compute_test() {
        Map<Integer, Integer> map = createIntMap();

        Integer result = map.compute(30, (key, value) -> (key + value) + 1000);
        assertEquals(Integer.valueOf(1330), map.get(30));
        assertEquals(Integer.valueOf(1330), result);
    }

    @Test(expected = NullPointerException.class)
    public void map_compute_exception() {
        Map<Integer, Integer> map = createIntMap();

        Integer result = map.compute(3, (key, value) -> (key + value) + 1000);
    }

    @Test
    public void map_computeIfAbsent_test() {
        Map<Integer, Integer> map = createIntMap();

        Integer result = map.computeIfAbsent(3, (key) -> key * 30);
        assertEquals(Integer.valueOf(90), result);
        assertTrue(map.containsKey(Integer.valueOf(3)));
    }

    @Test
    public void map_computeIfPresent_test() {
        Map<Integer, Integer> map = createIntMap();

        Integer result = map.computeIfPresent(30, (key, value) -> key * value);
        assertEquals(Integer.valueOf(9000), result);
        assertEquals(Integer.valueOf(9000), map.get(30));
    }

    @Test
    public void map_computeIfPresent_null_test() {
        Map<Integer, Integer> map = createIntMap();

        Integer result = map.computeIfPresent(3, (key, value) -> key * value);
        assertNull(result);
        assertEquals(Integer.valueOf(300), map.get(30));
    }

    @Test
    public void map_merge_test() {
        Map<Integer, Integer> map = createIntMap();

        map.merge(30, 100, (oldValue, newValue) -> oldValue + newValue);
        assertEquals(Integer.valueOf(400), map.get(30));
    }

    private Stream<String> createStringStream() {
        return Stream.of("a","b","c","a","A","B","C","A");
    }

    @Test
    public void stream_of() {
        Stream<String> stream = createStringStream();
        assertEquals(Long.valueOf(2),
                Long.valueOf(stream.filter(it -> "a".equals(it)).count()));

        stream = createStringStream();
        String s = stream.skip(1).limit(3).reduce((it1, it2) -> {
            System.out.println("<<<");
            System.out.println(it1);
            System.out.println(it2);
            return it1+it2;
        }).get();
        System.out.println(":::::" + s);
    }

    @Test
    public void stream_sorted() {
        Stream<String> stringStream = createStringStream();
        stringStream.sorted(Comparator.reverseOrder()).forEach(System.out::print);
        System.out.println("\n---");
        stringStream = createStringStream();
        stringStream.sorted(String.CASE_INSENSITIVE_ORDER).forEach(System.out::print);
        System.out.println("\n---");
        stringStream = createStringStream();
        stringStream.sorted(String.CASE_INSENSITIVE_ORDER.reversed()).forEach(System.out::print);
        System.out.println("\n---");
        stringStream = createStringStream();
        stringStream.sorted(Comparator.comparing(String::length)).forEach(System.out::print);
    }

}
