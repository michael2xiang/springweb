create table t_coffee (
                            id bigint not null auto_increment,
                            name varchar(255),
                            price bigint not null,
                            create_time timestamp,
                            update_time timestamp,
                            primary key (id)
  );


insert into t_coffee (name, price, create_time, update_time) values ('espresso', 2000, now(), now());
insert into t_coffee (name, price, create_time, update_time) values ('latte', 2500, now(), now());
insert into t_coffee (name, price, create_time, update_time) values ('capuccino', 2500, now(), now());
insert into t_coffee (name, price, create_time, update_time) values ('mocha', 3000, now(), now());
insert into t_coffee (name, price, create_time, update_time) values ('macchiato', 3000, now(), now());

select name, price, create_time, update_time from t_coffee