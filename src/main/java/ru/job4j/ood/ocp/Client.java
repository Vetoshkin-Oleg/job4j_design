package ru.job4j.ood.ocp;
/*В данном примере Client и Server взаимодействуют напрямую, и если прозойдет изменение кода класса Server,
* то придется менять класс Client.
* Для решения проблемы Client должен взаимодействовать с абстрактным классом AbstractServer,
* в этом случае придется добавить только новую реализацию Server, без изменения класса Client*/

public class Client {

    public static void main(String[] args) {
        Server server = new Server();
        int a = server.calculate(7, 12);
    }
}
