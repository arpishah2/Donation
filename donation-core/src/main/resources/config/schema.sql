CREATE TABLE user (
  id int IDENTITY NOT NULL PRIMARY KEY,
  email varchar(32) NOT NULL
);

ALTER TABLE user ADD CONSTRAINT unique_email UNIQUE (email);

CREATE TABLE donation (
  id int IDENTITY NOT NULL PRIMARY KEY,
  userId int NOT NULL,
  description varchar(512) DEFAULT NULL,
  estimate float NOT NULL,
  tax_deductible float NOT NULL,
  year int NOT NULL
);

alter table donation add constraint user_fk foreign key (userId) references user(id);
