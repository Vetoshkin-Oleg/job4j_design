package ru.job4j.kiss;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

class MaxMinTest {

    @Test
    void maxWhen1642533Then6() {
        List<Integer> list = List.of(
                1, 6, 4, 2, 5, 3, 3
        );
        Comparator<Integer> comparator = Integer::compareTo;
        MaxMin maxMin = new MaxMin();
        int result = maxMin.max(list, comparator);
        int expect = 6;
        Assertions.assertEquals(expect, result);
    }

    @Test
    void minWhen1642533Then1() {
        List<Integer> list = List.of(
                1, 6, 4, 2, 5, 3, 3
        );
        Comparator<Integer> comparator = Comparator.reverseOrder();
        MaxMin maxMin = new MaxMin();
        int result = maxMin.min(list, comparator);
        int expect = 1;
        Assertions.assertEquals(expect, result);
    }

    @Test
    void maxWhen3a4b5c6dThen6d() {
        List<String> strings = List.of(
                "aaa", "bbbb", "ccccc", "dddddd"
        );
        Comparator<String> comparator = Comparator.comparingInt(String::length);
        MaxMin maxMin = new MaxMin();
        String result = maxMin.max(strings, comparator);
        String expect = "dddddd";
        Assertions.assertEquals(expect, result);
    }

    @Test
    void maxWhen6a5b4c3dThen6a() {
        List<String> strings = List.of(
                "aaaaaa", "bbbbb", "cccc", "ddd"
        );
        Comparator<String> comparator = Comparator.comparingInt(String::length);
        MaxMin maxMin = new MaxMin();
        String result = maxMin.max(strings, comparator);
        String expect = "aaaaaa";
        Assertions.assertEquals(expect, result);
    }

    @Test
    void minWhen3a4b5c6dThen3a() {
        List<String> strings = List.of(
                "aaa", "bbbb", "ccccc", "dddddd"
        );
        Comparator<String> comparator = (o1, o2) -> o2.length() - o1.length();
        MaxMin maxMin = new MaxMin();
        String result = maxMin.min(strings, comparator);
        String expect = "aaa";
        Assertions.assertEquals(expect, result);
    }

    @Test
    void minWhen6a5b4c3dThen3d() {
        List<String> strings = List.of(
                "aaaaaa", "bbbbb", "cccc", "ddd"
        );
        Comparator<String> comparator = (o1, o2) -> o2.length() - o1.length();
        MaxMin maxMin = new MaxMin();
        String result = maxMin.min(strings, comparator);
        String expect = "ddd";
        Assertions.assertEquals(expect, result);
    }
}
