create table fc_user (
	id integer primary key, 
	username varchar(12) NOT NULL, 
	password varchar(12) NOT NULL, 
	email varchar(20) NOT NULL, 
	phoneNumber varchar(14), 
	challengeQ1 varchar(50) NOT NULL, 
	challengeAns1 varchar(20) NOT NULL, 
	createdDate timestamp NULL default CURRENT_TIMESTAMP, 
	lastUpdated timestamp NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP, 
	active boolean NOT NULL, 
	verified boolean NOT NULL, 
	walletId varchar(12) NULL, 
	merchantId varchar(12) NULL, 
	investorId varchar(12) NULL,
	UNIQUE (username)
);

DROP USER postgres;
CREATE USER postgres LOGIN PASSWORD 'postgres' SUPERUSER INHERIT CREATEDB CREATEROLE REPLICATION;