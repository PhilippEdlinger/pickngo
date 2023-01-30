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
      ('Beilage'),
      ('Getränke'),
      ('Aperitif');

insert into tag(name)
values ('Kalt'),
      ('Warm');

insert into menu(isdishoftheday, price)
values (true, 20),
       (true, 30);

insert into product(name, price, description, categoryet_id, imageName, allergies, preparationtime)
values
      ('Coca Cola', 2.50,'hallo', 5, 'coke.jpg', null, 0),
      ('Fanta', 2.99,'hallo', 5, 'fanta.jpg', null, 0),
      ('Mineralwasser', 2.99,'', 5, 'Voeslauer-prickelnd.jpg', null, 0),
      ('Hausgemachter Hollundersaft', 2.50,'', 5, 'hollundersaft.jpg', null, 0),
      ('Gegrillter Schafkäse', 10,'mit Kürbis im Speckmantel auf Blattsalat', 1, 'schafkaese.jpg', null, 0),
      ('Beef Tatar', 13,'mit gebackenem Ei / Kürbishumus', 1, 'beef-tatar.jpg', null, 0),
      ('Rindsuppe', 4.50,'mit Frittaten oder Leberknödel', 1, 'frittatensuppe.jpg', null, 0),
      ('Kürbiscremesuppe', 5.50,'', 1, 'kuerbiscremesuppe.jpg', null, 0),
      ('Steirischer Hendlsalat', 10,'', 1, 'hendlsalat.jpg', null, 0),
      ('Rutzinger Bauernsalat', 11,'', 1, 'bauernsalat.jpg', null, 0),
      ('Rehbraten in Rotweinsauce', 22,'mit Cranberry Kürbiskernrolle /Preiselbeeren/Rotkraut', 2, 'rehbraten.jpg', null, 0),
      ('Wildschweinknödel', 17,'mit Semmelknödel/Preiselbeeren/Rotkraut', 2, 'wildschweinknoedel.jpg', null, 0),
      ('Gebackener Karpfen', 15, 'mit Erdäpfel / Erdäpfel Rettichsalat', 2, 'karpfen.jpg', null, 0),
      ('Gegrilltes Putenschnitzel', 16, 'mit Kürbis und Speck überbacken', 2, 'schnitzel-ueberbacken.jpg', null, 0),
      ('Cordon Bleu', 15, 'mit Kürbis und Speck überbacken', 2, 'Cordonbleu.jpg', null, 0),
      ('Wiener Schnitzel', 14, 'mit Preiselbeeren / Erdäpfel / Salat', 2, 'wienerschnitzel.jpg', null, 0),
      ('Backhendl', 15, 'mit Erdäpfel / Salat ', 2, 'backhendl.jpg', null, 0),
      ('Schweinsbraten', 14, 'mit Semmelknödel / Krautsalat ', 2, 'schweinsbraten.jpg', null, 0),
      ('Wildragout', 17,'mit Rotweinsauce / Rotkraut', 2, 'wildragout.jpg', null, 0),
      ('Steinpilzrisotto', 13,'mit gebackenem Kürbis', 2, 'steinpilzrisotto.jpg', null, 0),
      ('Gemüselaibchen', 10,'mit Kräuterdip / Erdäpfel', 2, 'gemueselaibchen.jpg', null, 0),
      ('0,25 l Aperol Sprizz', 4.80,'', 6, 'aperol.jpg', null, 0),
      ('0,25 l Hugo', 4.40,'', 6, 'hugo.jpg', null, 0),
      ('0,1 l Prosecco Canella', 3.40,'', 6, 'prosecco-canella.jpg', null, 0),
      ('0,33 l Pago', 2.90,'', 5, 'pago.jpg', null, 0);

insert into menu_product(product_id, menu_id)
values (8, 1),
       (18,1),
       (7,2),
       (5,2);

insert into fooditem(id, isdishoftheday, isvegan, isvegetarian)
values (1, false, false, false),
      (2, true, true, true),
      (3, false, false, true),
      (4, false, true, true),
      (5, false, false, false),
      (6, false, false, false),
      (8, true, false, false);

insert into drinkitem(id, volume, warm)
values (1, 500, false),
      (2, 500, false),
      (3, 500, false),
      (4, 500, false),
      (25, 330, false);

insert into klimabox (product_id, discount, fromDate, toDate, quantity)
values (10, 50, '022-03-03T10:15:30', '022-03-03T10:15:30', 20),
       (14, 50, '022-03-03T10:15:30', '022-03-03T10:15:30', 20),
       (21, 50, '022-03-03T10:15:30', '022-03-03T10:15:30', 20),
       (12, 50,'022-03-03T10:15:30', '022-03-03T10:15:30', 20);

insert into orderet(orderposition, customer_id, employee_id, msg, timeOfOrder, orderstatus, planedtopicktime, readytopicktime)
values (1, 2, 1, 'Bisschen Scharf', '2022-03-03T10:15:30', 0,'2022-03-03T10:15:30', '2022-03-03T10:15:30'),
( 2, 3, 1, 'Bitte ohne Zitronensaft', '2022-01-03T10:15:30', 0, '2022-03-03T10:15:30', '2022-03-03T10:15:30'),
(3, 4, 1, 'Bitte ohne Tomaten', '2022-02-03T10:15:30', 2, '2022-03-03T10:15:30', '2022-03-03T10:15:30'),
(4, 3, 1, null, '2022-01-03T10:15:30', 3, '2022-03-03T10:15:30', '2022-03-03T10:15:30');


insert into orderItem(product_id, orderet_id, quantity, message)
values (1, 1, 5, null),
       (2, 1, 2, null),
       (2, 3, 7, null),
       (3, 4, 1, null),
       (4, 2, 4, null),
       (6, 2, 8, null);
