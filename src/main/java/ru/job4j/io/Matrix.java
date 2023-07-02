package ru.job4j.io;

public class Matrix {
    static int[][] array;
    
    public static int[][] multiple(int size) {
        array = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int cell = 0; cell < size; cell++) {
                array[row][cell] = (row + 1) * (cell + 1);
            }
        }
        return array;
    }

    public static String arrayToString(int[][] array) {
        StringBuilder result = new StringBuilder();
        for (int[] ints : array) {
            for (int cell = 0; cell < array.length; cell++) {
                result.append(ints[cell]);
                result.append("\t");
            }
            result.append(System.lineSeparator());
        }
        return result.toString();
    }
}