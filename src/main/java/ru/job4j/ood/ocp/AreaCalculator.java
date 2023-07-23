package ru.job4j.ood.ocp;
/*Ошибка заключается в том, реализация зависит от конкретного класса,
* при добавлении классов понадобится изменять код программы.*/

public class AreaCalculator {
    public void sum() {
        if (this.equals(new Rectangle())) {
            System.out.println("rectangle");
        } else {
            System.out.println("else");
        }
    }
}