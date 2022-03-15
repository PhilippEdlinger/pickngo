insert into person(username, firstname, lastname, password)
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
      ('Beilage');

insert into product(name, price, categoryet_id, imagepath, allergies)
values('Wiener Schnitzel', 8.50, 2, null, 'ACG'),
      ('Vegetarischer Salat', 4.50, 1, null, 'ACG'),
      ('Mohr im Hemd', 3.90, 3, null, 'ACG'),
      ('Gebaeck', 2.50, 4, null, 'ACG');


insert into orderet(customer_id, employee_id, msg, timeOfOrder, isready, readytopicktime)
values (2, 1, 'Bisschen Scharf', '2022-03-03T10:15:30', false,'2022-03-03T10:15:30'),
(3, 1, 'Bitte ohne Zitronensaft', '2022-01-03T10:15:30', true, '2022-03-03T10:15:30'),
(4, 1, 'Bitte ohne Tomaten', '2022-02-03T10:15:30', false, '2022-03-03T10:15:30'),
(3, 1, null, '2022-01-03T10:15:30', true, '2022-03-03T10:15:30');


insert into orderItem(orderposition, product_id, orderet_id, quantity)
values (1, 1, 1, 5),
       (2, 1, 2, 2),
       (3, 2, 3, 7),
       (4, 3, 4, 1);