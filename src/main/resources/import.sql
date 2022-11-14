-- Prepare Customer records
insert into customers(name) values('Ram');
insert into customers(name) values('Sam');
insert into customers(name) values('Cam');

-- Prepare transaction records

-- Ram Transactions
--  November
insert into transactions(date, price, customer_id) values('2022-11-01',100,1);
insert into transactions(date, price, customer_id) values('2022-11-05',50 ,1);
insert into transactions(date, price, customer_id) values('2022-11-10',120,1);
--  October
insert into transactions(date, price, customer_id) values('2022-10-10',80,1);
insert into transactions(date, price, customer_id) values('2022-10-20',90 ,1);
--  September
insert into transactions(date, price, customer_id) values('2022-09-14',500,1);

-- Sam Transactions
--  November
insert into transactions(date, price, customer_id) values('2022-11-11',20,2);
insert into transactions(date, price, customer_id) values('2022-11-03',300 ,2);
--  September
insert into transactions(date, price, customer_id) values('2022-09-14',1000,2);

-- cam Transactions
--  November
insert into transactions(date, price, customer_id) values('2022-11-01',10,3);
insert into transactions(date, price, customer_id) values('2022-11-05',5 ,3);
insert into transactions(date, price, customer_id) values('2022-11-10',12,3);
--  October
insert into transactions(date, price, customer_id) values('2022-10-10',8,3);
insert into transactions(date, price, customer_id) values('2022-10-20',90 ,3);
--  September
insert into transactions(date, price, customer_id) values('2022-09-14',52,3);