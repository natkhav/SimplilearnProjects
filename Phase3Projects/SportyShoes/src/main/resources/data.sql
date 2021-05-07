insert into admin(username, password) values('admin', 'admin');

insert into category(name) values('Lacross Shoes');
insert into category(name) values('Tennis Shoes');
insert into category(name) values('Running Shoes');
insert into category(name) values('Soccer Shoes');

insert into product(name, price, category_id) values('New Balance', 56.0, 1);
insert into product(name, price, category_id) values('Nike Alpha Pro', 80.0, 1);
insert into product(name, price, category_id) values('Asics Resolution', 139.0, 2);
insert into product(name, price, category_id) values('Adidas Stella', 149.0, 2);
insert into product(name, price, category_id) values('Brooks Caldera', 140.0, 3);
insert into product(name, price, category_id) values('Saucony Perigrine', 129.0, 3);
insert into product(name, price, category_id) values('PUMA Ultra', 199.0, 4);
insert into product(name, price, category_id) values('Adidas Predator', 79.0, 4);

insert into user(first_name, last_name, email, username, password) values('John', 'Smith', 'jsmith@mail.com', 'jsmith', 'jsmith');
insert into user(first_name, last_name, email, username, password) values('Barbara', 'Lee', 'blee@mail.com', 'blee', 'blee');
insert into user(first_name, last_name, email, username, password) values('Alex', 'Berg', 'aberg@mail.com', 'aberg', 'aberg');
insert into user(first_name, last_name, email, username, password) values('Miranda', 'Goff', 'mgoff@mail.com', 'mgoff', 'mgoff');

insert into purchase(date, total, user_id) values ('2021-05-05', 56.0,	1);
insert into purchase(date, total, user_id) values ('2021-02-24', 140.0, 4);
insert into purchase(date, total, user_id) values ('2021-04-30', 160.0, 3);
insert into purchase(date, total, user_id) values ('2021-01-11', 129.0, 2);
insert into purchase(date, total, user_id) values ('2021-04-30', 139.0, 3);
insert into purchase(date, total, user_id) values ('2021-03-12', 199.0, 4);
insert into purchase(date, total, user_id) values ('2021-04-02', 112.0, 1); 

insert into product_purchase(product_id, purchase_id, quantity) values (1, 1, 1);
insert into product_purchase(product_id, purchase_id, quantity) values (5, 2, 1);
insert into product_purchase(product_id, purchase_id, quantity) values (2, 3, 2);
insert into product_purchase(product_id, purchase_id, quantity) values (6, 4, 1);
insert into product_purchase(product_id, purchase_id, quantity) values (3, 5, 1);
insert into product_purchase(product_id, purchase_id, quantity) values (7, 6, 1);
insert into product_purchase(product_id, purchase_id, quantity) values (1, 7, 2);