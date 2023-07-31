package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return findMaxMin(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return findMaxMin(value, comparator);
    }

    public static <T> T findMaxMin(List<T> list, Comparator<T> comparator) {
        T result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (comparator.compare(list.get(i), result) > 0) {
                result = list.get(i);
            }
        }
        return result;
    }
}