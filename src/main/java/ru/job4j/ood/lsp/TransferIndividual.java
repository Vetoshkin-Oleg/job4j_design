package ru.job4j.ood.lsp;

public class TransferIndividual extends Transfer {
    public double money;

    public void transfer() {
        if (money < 600000) {
            System.out.println("перевод денежных средств выполнен");
        }
    }
}