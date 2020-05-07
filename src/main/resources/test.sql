delete from trip where 1=1;
delete from crew_cadres where 1=1;
delete from cadre where 1=1;
delete from station where 1=1;
delete from city where 1=1;
delete from client where 1=1;
delete from country where 1=1;
delete from journey where 1=1;
delete from crew where 1=1;
delete from person where 1=1;
delete from position where 1=1;
delete from transport where 1=1;
delete from trip_client_list where 1=1;

insert into country(id, name)
VALUES (1, 'Ukraine');
insert into city (id, name, country_id)
VALUES (1, 'Kiev', 1);
insert into station (id, name, city_id)
VALUES (1, 'Station1', 1);;
insert into station (id, name, city_id)
VALUES (2, 'Station2', 1);;
insert into station (id, name, city_id)
VALUES (3, 'Station3', 1);;
insert into station (id, name, city_id)
VALUES (4, 'Station4', 1);;

insert into person (id, birthday, first_name, last_name)
VALUES (1, '2012-04-23', 'test1', 'test1');
insert into person (id, birthday, first_name, last_name)
VALUES (2, '2012-04-23', 'test2', 'test2');
insert into person (id, birthday, first_name, last_name)
VALUES (3, '2012-04-23', 'test3', 'test3');

insert into position (id, name)
VALUES (1, 'driver');

insert into cadre (id, person_id, position_id)
VALUES (1, 1, 1);

insert into crew (id, created_date, duration)
VALUES (1, '2012-04-23', 1000);

insert into crew_cadres (crew_id, cadres_id)
VALUES (1, 1);

insert into client(id, person_id)
VALUES (1, 2);

insert into transport(id, name, type)
values (1, 'M100', 'tank');

insert into journey(id, transport_id, crew_id)
VALUES (1, 1, 1);

insert into trip(id, date_of_departure, duration, name, from_id, journey_id, to_id)
VALUES (1, '2012-04-23', 10, 'trip1', 1, 1, 2);
insert into trip(id, date_of_departure, duration, name, from_id, journey_id, to_id)
VALUES (2, '2012-05-23', 10, 'trip2', 2, 1, 3);
insert into trip(id, date_of_departure, duration, name, from_id, journey_id, to_id)
VALUES (3, '2012-06-23', 10, 'trip3', 3, 1, 4);
