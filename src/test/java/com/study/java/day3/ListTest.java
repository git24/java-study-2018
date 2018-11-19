package com.study.java.day3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class ListTest {
//    Collection<Integer> collection;
//
//    List<Integer> list = makeList();     // 순서, 중복허용
//    ArrayList<Integer> arrayList;
//    LinkedList<Integer> linkedList;
//
//    Map<String, Integer> map;   // 순서x, 키에 대한 중복 금지
//    HashMap<String,Integer> hashMap;
//    LinkedHashMap<String, Integer> linkedHashMap;
//    TreeMap<String, Integer> treeMap;
//
//    Set<Integer> set;           // 순서x, 중복 금지
//    HashSet<Integer> hashSet;
//    TreeSet<Integer> treeSet;
//    LinkedHashSet<Integer> linkedHashSet;
//
//    Vector<Integer> vector; // 가변길이, synchronized
//
//    Stack<Integer> stack;
//    Queue<Integer> queue;
//    SynchronousQueue<Integer> synchronousQueue;
//
//
//    // guava
//    ImmutableList<Integer> immutableList;

    private Collection<Integer> collection;

    @Before
    public void createCollection() {
        collection = IntStream
                .range(1, 101)
                .boxed()
                .collect(Collectors.toList());
    }

    @Test
    public void List_sort_Test() {
        List<Integer> list = collection.stream()
                .collect(Collectors.toList());

        list.sort( (left, right) -> {
            if (left > right) return -1;
            if (left < right) return 1;
            return 0;
        });

        System.out.println(list.get(0));

        assertEquals(100, list.get(0).intValue());
    }

    @Test
    public void List_subList_Test() {
        List<Integer> list = collection.stream()
                .collect(Collectors.toList()).subList(0, 10);

        System.out.println(list.size() + "/" + list.get(9));

        assertEquals(10, list.get(9).intValue());
    }
}
