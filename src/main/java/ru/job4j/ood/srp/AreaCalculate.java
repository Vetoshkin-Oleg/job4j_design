package ru.job4j.ood.srp;
/*Класс AreaCalculate выполняет три несвязанные задачи:
* вычисление площади (в зависимости от переданной фигуры), вывод на носитель (экран, принтер и т.д.),
* сохранение результата вычисления в базу данных.
* Три отличающиеся задачи для класса - это нарушение SRP*/

public class AreaCalculate {
    public double calculate(Shape shape) {
        return 0;
    }

    public void print() {
        System.out.println("print");
    }

    public void saveDB() {
        System.out.println("Save");
    }
}
