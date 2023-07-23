package ru.job4j.ood.ocp;
/*Здесь класс Message реализует функцию отправки сообщений по электронной почте.
* И если изменятся требования, то класс Message придется дорабатывать,
*  таким образом класс Message не закрыт для изменений.*/

public class Message {
    private static class Send {
        public void send() {
            System.out.println("отправка по электронной почте");
        }
    }
}
