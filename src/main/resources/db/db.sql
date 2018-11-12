drop user if exists station;
create user station with password 'station' ;
ALTER USER station WITH PASSWORD 'station';

create database station_dev with encoding='utf8' ;
create database station_prod with encoding='utf8' ;
create database station_test with encoding='utf8' ;

grant all privileges on database station_dev to station ;
grant all privileges on database station_test to station;
grant all privileges on database station_prod to station;

\connect station_dev;
create schema extensions;
create extension hstore schema extensions;
ALTER DATABASE station_dev SET search_path to "$user",public,extensions;
alter database station_dev owner to station;
alter schema public owner to station;
alter schema extensions owner to station;
GRANT USAGE ON SCHEMA public to station;

\connect station_prod;
create schema extensions;
create extension hstore schema extensions;
ALTER DATABASE station_prod SET search_path to "$user",public,extensions;
alter database station_prod owner to station;
alter schema public owner to station;
alter schema extensions owner to station;
grant usage on schema public to station;

\connect station_test;
create schema extensions;
create extension hstore schema extensions;
ALTER DATABASE station_test SET search_path to "$user",public,extensions;
alter database station_test owner to station;
alter schema public owner to station;
alter schema extensions owner to station;
grant usage on schema public to station;
