drop table if exists db_irs.movie_details;

create table db_irs.movie_details(
id varchar(20) primary key,
name varchar(30),
description varchar(30),
rating numeric(2,1));

insert into db_irs.movie_details values("M001","Avengers: Endgame","Avengers fourth part",8.4);
insert into db_irs.movie_details values("M002","Avengers: Infinity War","Avengers third part", 8.4);
insert into db_irs.movie_details values("M003","Avengers: Age of Ultron ","Avengers second part", 7.3);
insert into db_irs.movie_details values("M004","The Avengers","Avengers first part", 8);

select * from db_irs.movie_details;
