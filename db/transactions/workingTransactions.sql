/* Пример COMMIT -- ROLLBACK
Транзакция 1 */
drop table COMPANY cascade;
CREATE TABLE COMPANY(
   ID INT PRIMARY KEY     NOT NULL,
   NAME           TEXT    NOT NULL,
   AGE            INT     NOT NULL,
   ADDRESS        CHAR(50),
   SALARY         REAL
);
INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY)
VALUES (1, 'Paul', 32, 'California', 20000.00 );
INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY)
VALUES (2, 'Allen', 25, 'Texas', 15000.00 );
INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY)
VALUES (3, 'Teddy', 23, 'Norway', 25000.00 );
select * from COMPANY;

begin transaction;
select * from COMPANY;

update COMPANY set SALARY = '45000.00' where SALARY = '25000.00';
select * from COMPANY;
commit transaction;
select * from COMPANY;

/* Транзакция 2 */
begin transaction;
select * from COMPANY;
drop table COMPANY cascade;
select * from COMPANY;
rollback transaction;
select * from COMPANY;


/* Пример ROLLBACK TO SAVEPOINT
Транзакция 1 */
drop table COMPANY cascade;
CREATE TABLE COMPANY(
   ID INT PRIMARY KEY     NOT NULL,
   NAME           TEXT    NOT NULL,
   AGE            INT     NOT NULL,
   ADDRESS        CHAR(50),
   SALARY         REAL
);
INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY)
VALUES (1, 'Paul', 32, 'California', 20000.00 );
INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY)
VALUES (2, 'Allen', 25, 'Texas', 15000.00 );
INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY)
VALUES (3, 'Teddy', 23, 'Norway', 25000.00 );
select * from COMPANY;

begin transaction;
select * from COMPANY;

/* Транзакция 2 */
select * from COMPANY;
begin transaction;
select * from COMPANY;
savepoint first_savepoint;
update COMPANY set SALARY = '45000.00' where SALARY = '25000.00';
select * from COMPANY;
rollback to first_savepoint;
select * from COMPANY;

/* Транзакция 3 */
select * from COMPANY;
begin transaction;
savepoint second_savepoint;
delete from COMPANY where SALARY = '25000.00';
select * from COMPANY;
rollback to second_savepoint;
select * from COMPANY;