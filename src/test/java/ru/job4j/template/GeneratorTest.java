package ru.job4j.template;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorTest {

    @Test
    void whenKeyIsValidThenTestPassed() {
        GeneratorClass generatorClass = new GeneratorClass();
        String input = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        String expect = "I am a Petr Arsentev, Who are you? ";
        assertEquals(expect, generatorClass.produce(input, args));
    }

    @Test
    void whenNoKeyInMapThenTestCrash() {
        GeneratorClass generatorClass = new GeneratorClass();
        String input = "I am a ${name}. My phone is ${number}. Who are ${subject}? ";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        Throwable thrown =
                assertThrows(IllegalArgumentException.class,
                        () -> generatorClass.produce(input, args));
    }

    @Test
    void whenHaveExtraKeysInMapThenTestCrash() {
        GeneratorClass generatorClass = new GeneratorClass();
        String input = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        args.put("phone", "number");
        Throwable thrown =
                assertThrows(IllegalArgumentException.class,
                        () -> generatorClass.produce(input, args));
    }
}