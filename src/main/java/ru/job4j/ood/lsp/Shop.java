package ru.job4j.ood.lsp;
/*Ошибка в данном случае заключается в том, что метод начисления бонуса основного класса устанавливает бонус,
* только при условии, что затраченная в магазине сумма превышает 1000.
* У класса-наследника это требование исчезает - бонус начисляется всегда.*/

public class Shop {
    public double money;
    public double bonus = 0;
    public void loyalty (double money) {
        if (money > 1000) {
            bonus = 100;
        }
    }
}
