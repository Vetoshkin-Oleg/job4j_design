create table students_subjects(
    id serial primary key,
    mark float,
    student_id int references students(id),
    subject_id int references subjects(id)
);

insert into students_subjects(student_id, subject_id, mark)
values (1, 1, 5), (1, 2, 5), (1, 3, 5);
insert into students_subjects(student_id, subject_id, mark)
values (2, 1, 5), (2, 2, 4), (2, 3, 4);
insert into students_subjects(student_id, subject_id, mark)
values (3, 1, 3), (3, 2, 5), (3, 3, 3);