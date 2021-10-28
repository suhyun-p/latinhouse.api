insert into member_main (nickname, sex, is_instructor) values ('브라우니', 'M', true);
insert into member_main (nickname, sex, is_instructor) values ('칼리', 'F', true);
insert into member_main (nickname, sex, is_instructor) values ('스칼렛', 'F', true);

insert into class_main (title, status, genre, region, instructor_no_1, instructor_no_2, location, price)
values ('소수집중티칭 - 스타일링 안무반', 'S2', 'B', 'HD', 3, 1, '진심 스튜디오', 100000);

insert into class_schedule (class_no, start_date, end_date)
values (1, '2021-10-21 20:00:00', '2021-10-21 21:00:00');

insert into class_schedule (class_no, start_date, end_date)
values (1, '2021-10-28 20:00:00', '2021-10-28 21:00:00');


insert into class_main (title, status, genre, region, instructor_no_1, instructor_no_2, location, price)
values ('소수집중티칭 - 스타일링 안무반', 'S2', 'B', 'HD', 3, null, '진심 스튜디오', 100000);