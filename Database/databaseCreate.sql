Create table User_data(
	id int primary key auto_increment,
    email varchar(30),
    first_name varchar(30),
    last_name varchar(30),
    city varchar(30),
    postal_code varchar(30),
    street varchar(30),
    home_number varchar(10)    
);
Create table Book (
	id int primary key auto_increment,
    title varchar(30),
    author varchar(30),
    pages_count int,
    id_user int,
    foreign key (id_user) references User_data(id),
	price float,
    count int
);
Create table Order_data(
	id int primary key auto_increment,
    order_date date,
    pay_method varchar(8) check (pay_method in ('card', 'cash', 'online', 'blik', 'transfer')),
	delivery_method varchar(13) check (delivery_method in ('own_pickup', 'delivery', 'parcel_locker')), 
	id_user int,
    foreign key (id_user) references User_data(id)
);
Create table User_order(
	id int auto_increment,
	id_book int,
    id_order int,
    foreign key (id_book) references Book(id),
    foreign key (id_order) references Order_data(id),
    count int,
    PRIMARY KEY (id, id_book, id_order)
);
