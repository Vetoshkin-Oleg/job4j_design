package ru.job4j.ood.lsp;
/*Нарушение заключается в том, что в классе-наследнике происходит усиление предусловия.
* А именно: изначально происходил перевод денежных средств всегда при вызове метода,
* а у класса-наследника - только в том случае, когда сумма перевода меньше 600 тысяч.*/

public class Transfer {
    public void transfer() {
        System.out.println("перевод денежных средств выполнен");
    }
}