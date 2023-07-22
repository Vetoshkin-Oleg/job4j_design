package ru.job4j.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ConfigTest {

    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenPairWithCommentAndEmptyLines() {
        String path = "./data/pair_with_comment_and_emptylines.properties";
        Config config = new Config(path);
        config.load();
        Assertions.assertEquals(3, config.getSize());
        assertThat(config.value("hibernate.connection.url")).
                isEqualTo("jdbc:postgresql://127.0.0.1:5432/trackstudio");
        assertThat(config.value("hibernate.connection.username")).
                isEqualTo("postgres");
        assertThat(config.value("hibernate.connection.password")).
                isEqualTo("password");
    }

    @Test
    void whenTwoEqualSigns() {
        String path = "./data/two_equal_signs.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("key0")).isEqualTo("value1=2");
        assertThat(config.value("key3")).isEqualTo("value4=");
    }

    @Test
    void whenThrowsNoEqualSign() {
        String path = "./data/throws_no_equal_sign.properties";
        Config config = new Config(path);
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class,
                config::load);
        Assertions.assertEquals("No equal sign!", thrown.getMessage());
    }

    @Test
    void whenThrowsNoKey() {
        String path = "./data/throws_no_key.properties";
        Config config = new Config(path);
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class,
                config::load);
        Assertions.assertEquals("No key!", thrown.getMessage());
    }

    @Test
    void whenThrowsNoValue() {
        String path = "./data/throws_no_value.properties";
        Config config = new Config(path);
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class,
                config::load);
        Assertions.assertEquals("No value!", thrown.getMessage());
    }

    @Test
    void whenThrowsNoKeyNoValue() {
        String path = "./data/throws_no_key_no_value.properties";
        Config config = new Config(path);
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class,
                config::load);
        Assertions.assertEquals("No key and value!", thrown.getMessage());
    }
}