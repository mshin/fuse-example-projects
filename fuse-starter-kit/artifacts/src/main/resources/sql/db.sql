create table dbtable (id integer primary key, number varchar(12));
insert into dbtable values (0, 'cero');
insert into dbtable values (1, 'uno');
insert into dbtable values (2, 'dos');
insert into dbtable values (3, 'tres');
insert into dbtable values (4, 'cuatro');
insert into dbtable values (5, 'cinco');
insert into dbtable values (6, 'seis');
insert into dbtable values (7, 'siete');
insert into dbtable values (8, 'ocho');
insert into dbtable values (9, 'nueve');

DROP USER postgres;
CREATE USER postgres LOGIN PASSWORD 'postgres' SUPERUSER INHERIT CREATEDB CREATEROLE REPLICATION;