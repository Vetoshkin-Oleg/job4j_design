package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private final int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return isEvenNumber();
    }

    @Override
    public Integer next() {
        if (isEvenNumber()) {
            return data[index++];
        } else {
            throw new NoSuchElementException();
        }
    }

    public boolean isEvenNumber() {
        while (index != data.length) {
            if (data[index] % 2 == 0) {
                return true;
            }
            index++;
        }
        return false;
    }

}