
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
CREATE  TABLE users (
  user_id  SERIAL PRIMARY KEY,
  user_name VARCHAR(45) NOT NULL,
  email VARCHAR(255) NOT NULL,
  password VARCHAR(60) NOT NULL ,
  enabled smallint NOT NULL DEFAULT 1);
  
CREATE TABLE user_roles (
  user_role_id SERIAL,
  user_id integer NOT NULL,
  role varchar(45) NOT NULL,
  CONSTRAINT user_roles_pkey PRIMARY KEY (user_role_id),
  CONSTRAINT uni_userid_role UNIQUE (role,user_id),    
  CONSTRAINT fk_userid FOREIGN KEY (user_id)
      REFERENCES public.users (user_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION);

INSERT INTO users(user_name,email,password,enabled)
VALUES ('priya','abc@abc.com','$2a$04$CO93CT2ObgMiSnMAWwoBkeFObJlMYi/wzzOnPlsTP44r7qVq0Jln2', 1);
INSERT INTO users(user_name,email,password,enabled)
VALUES ('naveen','def@def.com','$2a$04$j3JpPUp6CTAe.kMWmdRNC.Wie58xDNPfcYz0DBJxWkucJ6ekJuiJm', 1);

INSERT INTO user_roles (user_id, role)
VALUES (001, 'ROLE_USER');
INSERT INTO user_roles (user_id, role)
VALUES (002, 'ROLE_ADMIN');
INSERT INTO user_roles (user_id, role)
VALUES (002, 'ROLE_USER');