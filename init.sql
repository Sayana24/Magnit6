drop table if exists product;
create table product(
                        id int primary key generated always as identity,
                        name varchar(255) not null,
                        description varchar(255),
                        price double precision not null
);
insert into product(name, description, price) VALUES ('Молоко','Молоко 2,5%', 59.99),
                                                     ('Кефир','Кефир 1%', 79.99),
                                                     ('Сметана','Сметана 10%', 74.99),
                                                     ('Хлеб','Хлеб украинский', 55.00),
                                                     ('Баунти','Батончик Баунти', 66.00),
                                                     ('Яблоки','Яблоки Ред', 159.99);
select * from product;

drop table if exists orders;
create table orders(
                       id int primary key generated always as identity,
                       date Date
);
insert into orders(date) values ('2024-03-12'), ('2024-03-12'),('2024-03-12'),('2024-03-12'),
                                ('2024-03-12'), ('2024-03-12');
select * from orders;

drop table if exists orderProduct;
create table orderProduct(
                             id int primary key generated always as identity,
                             orderId int not null,
                             productId int not null,
                             amount int not null,
                             foreign key (orderId) references orders(id),
                             foreign key (productId) references product(id) on delete cascade
);
insert into orderProduct(orderId, productId, amount) values (1, 1, 1), (1, 2, 1), (1, 3, 1),
                                                            (2, 1, 2), (2, 2, 3), (2, 3, 1), (2, 5, 5),
                                                            (3, 4, 2), (3, 1, 3),
                                                            (4, 5, 6),
                                                            (5, 1, 2), (5, 6, 3),
                                                            (6, 3, 2), (6, 4, 2), (6, 5, 2), (6, 6, 1);
select * from orderProduct;