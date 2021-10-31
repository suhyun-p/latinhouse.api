insert into member_main (nickname, sex, is_instructor) values ('브라우니', 'M', true);
insert into member_main (nickname, sex, is_instructor) values ('칼리', 'F', true);
insert into member_main (nickname, sex, is_instructor) values ('스칼렛', 'F', true);
insert into member_contact (member_no, contact_type, contact) values (3, 'K', 'ssg8364');

insert into class_main (title, status, genre, region, instructor_no_1, instructor_no_2, start_date, end_date, date_desc, start_time, end_time, time_desc, location, price, account)
values ('소수 집중 티칭 - 스타일링 안무반 A', 'S2', 'B', 'HD', 3, null, '2021-01-23', '2021-02-20', '총 5주, 매주 토요일', '17:00', '18:30', '90분', '댄싱아일랜드', 120000, '우리_전신영 180-08-244668');

insert into class_notice (class_no, notice_type, notice) values (1, 'N', '정부 지침에 따라 각 3명 한정 1:1 체크 및 코칭');
insert into class_notice (class_no, notice_type, notice) values (1, 'N', '레벨 및 스케쥴에 따라 반편성');
insert into class_notice (class_no, notice_type, notice) values (1, 'N', '추후 사라레이디스 오피셜 정규반 편성시 할인');

insert into class_contact (class_no, member_no, contact_type, contact) values (1, 3, 'K', null);

