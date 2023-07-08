/* one-to-one
 Client (Клиент)
 InternetBank (приложение интернет-банка)
 В приложение интернет-банка клиент может зайти,
 только используя свои уникальные данные (логин, пароль).
 В приложении хранится вся информация по счетам.
 Связь двунаправленная
 (можно получить информацию о банковских счетах по данным клиента банка,
  и наоборот – можно получить информацию о клиенте банка,
  зная, например, банковский счет).*/

create table client(
    id serial primary key,
    nameClient varchar(255),
    phone varchar(255),
	login varchar(255),
	password varchar(255)
);

create table internetBank(
    id serial primary key,
    accountCurrency varchar(255),
	availableBalance money
);

create table client_bank(
    id serial primary key,
    client_id int references client(id) unique,
    internetBank_id int references internetBank(id) unique
);