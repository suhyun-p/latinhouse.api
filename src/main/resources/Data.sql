insert into member_main (nickname, sex, is_instructor) values ('브라우니', 'M', true);
insert into member_main (nickname, sex, is_instructor) values ('칼리', 'F', true);
insert into member_main (nickname, sex, is_instructor) values ('스칼렛', 'F', true);
insert into member_contact (member_no, contact_type, contact) values (3, 'K', 'ssg8364');
insert into member_contact (member_no, contact_type, contact) values (3, 'C', '010-2335-8364');
insert into member_main (nickname, sex, is_instructor) values ('에릭', 'M', true);
insert into member_main (nickname, sex, is_instructor) values ('남궁건', 'M', true);
insert into member_main (nickname, sex, is_instructor) values ('클레어', 'F', true);

insert into class_main (title, status, genre, region, instructor_no_1, instructor_no_2, start_date, end_date, date_desc, start_time, end_time, time_desc, location, price, account)
values ('소수 집중 티칭 - 스타일링 안무반 A', 'S2', 'B', 'HD', 3, null, '2021-01-23', '2021-02-20', '총 4주, 매주 토요일', '17:00', '18:20', '90분', '댄싱아일랜드', 120000, '우리_전신영 180-08-244668');
insert into class_notice (class_no, notice_type, notice) values (1, 'N', '정부 지침에 따라 각 3명 한정 1:1 체크 및 코칭');
insert into class_notice (class_no, notice_type, notice) values (1, 'N', '레벨 및 스케쥴에 따라 반편성');
insert into class_notice (class_no, notice_type, notice) values (1, 'N', '추후 사라레이디스 오피셜 정규반 편성시 할인');
insert into class_contact (class_no, member_no, contact_type, contact) values (1, 3, 'K', null);

insert into class_main (title, status, genre, region, instructor_no_1, instructor_no_2, start_date, end_date, date_desc, start_time, end_time, time_desc, location, price, account)
values ('소수 집중 티칭 - 스타일링 안무반 B', 'S2', 'B', 'HD', 3, null, '2021-01-23', '2021-02-20', '총 4주, 매주 토요일', '18:30', '19:50', '90분', '댄싱아일랜드', 120000, '우리_전신영 180-08-244668');
insert into class_notice (class_no, notice_type, notice) values (2, 'N', '정부 지침에 따라 각 3명 한정 1:1 체크 및 코칭');
insert into class_notice (class_no, notice_type, notice) values (2, 'N', '레벨 및 스케쥴에 따라 반편성');
insert into class_notice (class_no, notice_type, notice) values (2, 'N', '추후 사라레이디스 오피셜 정규반 편성시 할인');
insert into class_contact (class_no, member_no, contact_type, contact) values (2, 3, 'K', null);

insert into class_main (title, status, genre, region, instructor_no_1, instructor_no_2, start_date, end_date, date_desc, start_time, end_time, time_desc, location, price, account)
values ('센슈얼패턴 스킬 집중반', 'S2', 'B', 'HD', 3, 4, '2021-05-01', '2021-05-29', '총 5주, 매주 토요일', '18:00', '19:00', '60분', '세뇨리따홀(in 보니따)', 100000, '우리_전신영 180-08-244668');
insert into class_discount (class_no, discount_type, discount_text, discount_condition, discount_amount) values (3, 'E', '22일까지 신청 시 1만원 할인', '2021-05-22', 10000);
insert into class_discount (class_no, discount_type, discount_text, discount_condition, discount_amount) values (3, 'S', '타 과목과 동시 신청 시 1만원 할인', '4,5', 10000);
insert into class_notice (class_no, notice_type, notice) values (3, 'N', '코로나 방역수칙 준수');
insert into class_notice (class_no, notice_type, notice) values (3, 'N', '인원제한 진행');
insert into class_contact (class_no, member_no, contact_type, contact) values (3, 3, 'K', null);
insert into class_contact (class_no, member_no, contact_type, contact) values (3, 3, 'C', null);

insert into class_main (title, status, genre, region, instructor_no_1, instructor_no_2, start_date, end_date, date_desc, start_time, end_time, time_desc, location, price, account)
values ('센슈얼 토탈 기본기 끝장반', 'S2', 'B', 'HD', 3, 1, '2021-05-01', '2021-05-29', '총 5주, 매주 토요일', '17:00', '18:00', '60분', '세뇨리따홀(in 보니따)', 100000, '우리_전신영 180-08-244668');
insert into class_discount (class_no, discount_type, discount_text, discount_condition, discount_amount) values (4, 'E', '22일까지 신청 시 1만원 할인', '2021-05-22', 10000);
insert into class_discount (class_no, discount_type, discount_text, discount_condition, discount_amount) values (4, 'S', '타 과목과 동시 신청 시 1만원 할인', '3,5', 10000);
insert into class_notice (class_no, notice_type, notice) values (4, 'N', '코로나 방역수칙 준수');
insert into class_notice (class_no, notice_type, notice) values (4, 'N', '인원제한 진행');
insert into class_contact (class_no, member_no, contact_type, contact) values (4, 3, 'K', null);
insert into class_contact (class_no, member_no, contact_type, contact) values (4, 3, 'C', null);

insert into class_main (title, status, genre, region, instructor_no_1, instructor_no_2, start_date, end_date, date_desc, start_time, end_time, time_desc, location, price, account)
values ('홍대 클래스 주말반', 'S2', 'B', 'HD', 5, 6, '2021-05-01', '2021-05-29', '총 5주, 매주 토요일', '18:30', '19:30', '60분', '댄싱아일랜드', 100000, '우리_전신영 180-08-244668');
insert into class_discount (class_no, discount_type, discount_text, discount_condition, discount_amount) values (5, 'E', '22일까지 신청 시 1만원 할인', '2021-05-22', 10000);
insert into class_discount (class_no, discount_type, discount_text, discount_condition, discount_amount) values (5, 'S', '타 과목과 동시 신청 시 1만원 할인', '3,4', 10000);
insert into class_notice (class_no, notice_type, notice) values (5, 'N', '코로나 방역수칙 준수');
insert into class_notice (class_no, notice_type, notice) values (5, 'N', '인원제한 진행');
insert into class_contact (class_no, member_no, contact_type, contact) values (5, 3, 'K', null);
insert into class_contact (class_no, member_no, contact_type, contact) values (5, 3, 'C', null);

