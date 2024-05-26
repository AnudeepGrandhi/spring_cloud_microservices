insert into user_details (id, birth_date, name) values(10001, current_date(), 'Nick');
insert into user_details (id, birth_date, name) values(10002, current_date(), 'Teja');
insert into user_details (id, birth_date, name) values(10003, current_date(), 'Kondati');

insert into post (id, description, user_id) values(20001, 'I want to learn AWS', 10001);
insert into post (id, description, user_id) values(20002, 'I want to learn Microservices', 10001);
insert into post (id, description, user_id) values(20003, 'I want to give interviews in Europe', 10002);
insert into post (id, description, user_id) values(20004, 'I want to get hired in Europe', 10002);
insert into post (id, description, user_id) values(20005, 'I want to work in Europe', 10003);
insert into post (id, description, user_id) values(20006, 'I want to live in Europe', 10003);