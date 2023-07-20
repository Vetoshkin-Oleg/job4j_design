package ru.job4j.io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnalysisTest {

    @Test
    void whenOneInterval() {
        Analysis analysis = new Analysis();
        String result = analysis.unavailable("data/server_1.log");
        String expect = "10:57:01;11:02:02;";
        assertEquals(expect, result);
    }

    @Test
    void whenTwoIntervals() {
        Analysis analysis = new Analysis();
        String result = analysis.unavailable("data/server_2.log");
        String expect = "10:57:01;10:59:01;" + System.lineSeparator() + "11:01:02;11:02:02;";
        assertEquals(expect, result);
    }

    @Test
    void whenThreeIntervals() {
        Analysis analysis = new Analysis();
        String result = analysis.unavailable("data/server_3.log");
        String expect = "10:57:01;10:59:01;" + System.lineSeparator() + "11:01:02;11:02:02;"
                + System.lineSeparator() + "11:57:01;12:03:02;";
        assertEquals(expect, result);
    }
}