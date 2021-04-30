INSERT INTO addresses(Street, City, Country) VALUES('Rue du pont', 'Lyon', 'France');
INSERT INTO addresses(Street, City, Country) VALUES('Rue du bateau', 'Marseille', 'France');
INSERT INTO addresses(Street, City, Country) VALUES('Rue du moulin', 'Paris', 'France');

INSERT INTO clients(Balance, Email, First_Name, Last_Name, Id_Address) VALUES('247.81', 'vallaser@outlook.com', 'Valerian', 'Bal', '1');
INSERT INTO clients(Balance, Email, First_Name, Last_Name, Id_Address) VALUES('753', 'leo@gmail.com', 'Lionel', 'Messi', '2');
INSERT INTO clients(Balance, Email, First_Name, Last_Name, Id_Address) VALUES('156.82', 'colras.quentin@gmail.com', 'Quentin', 'Colras', '3');

INSERT INTO operations(Op, Old_Balance, Value_Op, Date_Op, Type, Id_Client) VALUES('-', '318', '17.2', '09/12/2016 22:52:16', 'Purchase Le Seigneur des Anneaux : La Guerre du Nord', 1);
INSERT INTO operations(Op, Old_Balance, Value_Op, Date_Op, Type, Id_Client) VALUES('-', '300.8', '14', '10/02/2017 14:32:29', 'Purchase Assassin s Creed IV : Black Flag', 1);
INSERT INTO operations(Op, Old_Balance, Value_Op, Date_Op, Type, Id_Client) VALUES('-', '286.8', '40', '01/03/2017 17:06:07', 'Purchase FIFA 17', 1);
INSERT INTO operations(Op, Old_Balance, Value_Op, Date_Op, Type, Id_Client) VALUES('+', '246.8', '40', '04/03/2017 11:27:07', 'Refund FIFA 17', 1);
INSERT INTO operations(Op, Old_Balance, Value_Op, Date_Op, Type, Id_Client) VALUES('-', '286.8', '24.99', '26/07/2018 15:27:48', 'Purchase Rocket League', 1);
INSERT INTO operations(Op, Old_Balance, Value_Op, Date_Op, Type, Id_Client) VALUES('-', '261.81', '14', '17/05/2019 13:08:59', 'Purchase Sea of Thieves', 1);

INSERT INTO operations(Op, Old_Balance, Value_Op, Date_Op, Type, Id_Client) VALUES('-', '831', '60', '30/09/2016 12:12:07', 'Purchase FIFA 17', 2);
INSERT INTO operations(Op, Old_Balance, Value_Op, Date_Op, Type, Id_Client) VALUES('-', '771', '18', '12/12/2017 08:21:09', 'Purchase The Elder Scrolls V : Skyrim', 2);
INSERT INTO operations(Op, Old_Balance, Value_Op, Date_Op, Type, Id_Client) VALUES('-', '753', '55', '17/04/2018 14:01:17', 'Purchase Just Dance 2018', 2);
INSERT INTO operations(Op, Old_Balance, Value_Op, Date_Op, Type, Id_Client) VALUES('+', '698', '55', '01/05/2018 19:42:49', 'Refund Just Dance 2018', 2);

INSERT INTO operations(Op, Old_Balance, Value_Op, Date_Op, Type, Id_Client) VALUES('-', '243', '60', '24/06/2016 17:55:20', 'Purchase Overwatch', 3);
INSERT INTO operations(Op, Old_Balance, Value_Op, Date_Op, Type, Id_Client) VALUES('-', '183', '20', '17/09/2016 19:14:48', 'Purchase Assassin s Creed IV : Black Flag', 3);
INSERT INTO operations(Op, Old_Balance, Value_Op, Date_Op, Type, Id_Client) VALUES('-', '163', '5.18', '12/01/2017 06:35:49', 'Purchase Fallout 4', 3);
INSERT INTO operations(Op, Old_Balance, Value_Op, Date_Op, Type, Id_Client) VALUES('+', '157.82', '5.18', '04/02/2017 16:31:14', 'Refund Fallout 4', 3);
INSERT INTO operations(Op, Old_Balance, Value_Op, Date_Op, Type, Id_Client) VALUES('-', '163', '6.18', '12/12/2019 19:04:27', 'Purchase Call of Duty : Black Ops II', 3);
INSERT INTO operations(Op, Old_Balance, Value_Op, Date_Op, Type, Id_Client) VALUES('-', '156.82', '29.99', '28/06/2020 05:37:11', 'Purchase The Legend of Zelda : Breath of the Wild', 3);
INSERT INTO operations(Op, Old_Balance, Value_Op, Date_Op, Type, Id_Client) VALUES('+', '126.83', '29.99', '09/07/2020 17:53:53', 'Refund The Legend of Zelda : Breath of the Wild', 3);

