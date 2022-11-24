package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 6);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 12);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube");
    }

    @Test
    void isThisUnknownObjectByVertex() {
        Box box = new Box(7, 12);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object");
    }

    @Test
    void isThisUnknownObjectByEdgeMinus1() {
        Box box = new Box(4, -1);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object");
    }

    @Test
    void isThisUnknownObjectByEdgeZero() {
        Box box = new Box(0, 0);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object");
    }

    @Test
    void getAreaSphere() {
        Box box = new Box(0, 10);
        double result = box.getArea();
        assertThat(result).isEqualTo(1256.637_061_4359d, withPrecision(0.000_000_0001d))
                .isGreaterThan(1256.637_061_43591d)
                .isLessThan(1256.637_061_43592d);
    }

    @Test
    void getAreaTetrahedron() {
        Box box = new Box(4, 6);
        double result = box.getArea();
        assertThat(result).isEqualTo(62.353_8290d, withPrecision(0.000_0001d))
                .isGreaterThan(62.353_8290d)
                .isLessThan(62.353_8291d);
    }

    @Test
    void getAreaCube() {
        Box box = new Box(8, 12);
        double result = box.getArea();
        assertThat(result).isEqualTo(864d, withPrecision(0.000_0001d))
                .isLessThan(864.000_001d);
    }

    @Test
    void isExistTrue() {
        Box box = new Box(8, 12);
        boolean result = box.isExist();
        assertThat(result).isTrue();
    }

    @Test
    void isExistFalse() {
        Box box = new Box(7, 12);
        boolean result = box.isExist();
        assertThat(result).isFalse();
    }

    @Test
    void getNumberOfVerticesSphere() {
        Box box = new Box(0, 10);
        int result = box.getNumberOfVertices();
        assertThat(result).isEqualTo(0);
    }

    @Test
    void getNumberOfVerticesTetrahedron() {
        Box box = new Box(4, 6);
        int result = box.getNumberOfVertices();
        assertThat(result).isEqualTo(4);
    }
}