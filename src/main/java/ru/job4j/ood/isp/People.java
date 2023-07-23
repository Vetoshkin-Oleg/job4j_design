package ru.job4j.ood.isp;
/*В интерфейсе People реализованы четыре метода.
* Ошибка заключается в том, то не каждый рабочий обучается, и не каждый студент работает.
* Правильнее разбить эти 4 метода на три интерфейса: Work, Study, People (в этом интерфейсе оставить два метода
* - eat и sleep). */
public interface People {
    public void eat();

    public void work();

    public void study();

    public void sleep();
}
