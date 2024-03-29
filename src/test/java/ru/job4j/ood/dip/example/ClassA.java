package ru.job4j.ood.dip.example;

public class ClassA {
    ClassB classB;

    public ClassA(ClassB classB) {
        this.classB = classB;
    }

    /*ClassA имеет ссылку на ClassB.
    * ClassB - это класс, который в разных примерах может выполнять разные группы действий:
    * - в одном случае ClassB может вывести информацию на экран, на принтер и т.п.
    * В нашем случае ссылка на ClassB внутри класса ClassA может только вывести информацию на принтер,
    * и это является нарушением принципа DIP - ClassA жестко зависит от реализации деталей вывода информации:
    * если хотим вывести информацию на экран, то придется заново выполнять работу программирования,
    * чтобы возможность вывода на экран добавилась.
    *
    * Во втором варианте, мы жестко привязаны к отправке оповещений по SMS - а если хотим отправить оповещения
    * по Telegram, то требуется другая архитектура программы.
    *
    * Аналогично, в третьем варианте вместо classB нужно создать интерфейс StartEngine.
    * В классе classB выполнить реализацию методов данного интерфейса.
    * А уже класс ClassA в зависимости от контекста будет запускать двигатель автозапуском, либо вручную.
    *
    * Четвертый пример аналогичен вышеуказанным.*/
}