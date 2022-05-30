insert into person(firstname, lastname, password, username)
values('peter', 'Peter', 'Griffin', 'password'),
      ('bart', 'Bart', 'Simpson',  'password'),
      ('david', 'David', 'Altenhofer',  'password'),
      ('sami', 'Sami', 'Abbas Ali',  'password');

insert into customer(id, email, phonenr)
values(2, 'bart@gmx.jo', ''),
      (3, 'david.altenhofer@gmail.com', '067761174680'),
(4, 'samisaadat04@gmail.com', '068864449662');

insert into employee(id)
values (1);

insert into categoryET(name)
values('Vorspeise'),
      ('Hauptspeise'),
      ('Desert'),
      ('Beilage'),
      ('Getränke');

insert into tag(name)
values ('Kalt'),
      ('Warm');



insert into product(name, price, categoryet_id, imagepath, allergies, preparationtime)
values('Wiener Schnitzel', 8.50, 2, null, 'ACG',20),
      ('Vegetarischer Salat', 4.50, 1, null, 'ACG', 10),
      ('Mohr im Hemd', 3.90, 3, null, 'ACG', 5),
      ('Gebaeck', 2.50, 4, null, 'ACG',1),
      ('Altwiener Backfleisch', 17.00, 2, null, null, 25),
      ('Cordon Bleu', 14.00, 2,null, null, 10),
      ('Coca Cola', 2.50, 5, null, null, 0),
      ('Gekochtes Rindfleisch', 15.00, 2, null, null, 15),
      ('Fanta', 2.99, 5, null, null, 0);

insert into fooditem(id, isdishoftheday, isvegan, isvegetarian)
values (1, false, false, false),
      (2, true, true, true),
      (3, false, false, true),
      (4, false, true, true), 
      (5, false, false, false),
      (6, false, false, false),
      (8, true, false, false);

insert into drinkitem(id, volume, warm)
values (7, 330, false),
      (9, 500, false);


insert into orderet(id, orderposition, customer_id, employee_id, msg, timeOfOrder, orderstatus, planedtopicktime, readytopicktime)
values (1, 1, 2, 1, 'Bisschen Scharf', '2022-03-03T10:15:30', 1,'2022-03-03T10:15:30', '2022-03-03T10:15:30'),
(2 , 2, 3, 1, 'Bitte ohne Zitronensaft', '2022-01-03T10:15:30', 1, '2022-03-03T10:15:30', '2022-03-03T10:15:30'),
(3 , 3, 4, 1, 'Bitte ohne Tomaten', '2022-02-03T10:15:30', 2, '2022-03-03T10:15:30', '2022-03-03T10:15:30'),
(4, 4, 3, 1, null, '2022-01-03T10:15:30', 3, '2022-03-03T10:15:30', '2022-03-03T10:15:30');


insert into orderItem(orderet_orderposition, product_id, orderet_id, quantity, message)
values (1, 1, 1, 5, null),
       (2, 1, 2, 2, null),
       (3, 2, 3, 7, null),
       (4, 3, 4, 1, null);