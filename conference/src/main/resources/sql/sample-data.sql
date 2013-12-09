
INSERT INTO demo (id, data) VALUES (1, 'Hello, world!');
INSERT INTO demo (id, data) VALUES (2, 'Hello, world again!');
INSERT INTO demo (id, data) VALUES (3, 'Hello, world for the third time!');

INSERT INTO conference (id, name, startDate, endDate) VALUES (1, 'NFQ Akademijos atidarymas. Įvadas į šiuolaikinio programuotojo darbą', '2013-09-30 17:00:00', '2013-09-30 18:00:00');
INSERT INTO conference (id, name, startDate, endDate) VALUES (2, 'Projekto valdymas ir Agile', '2013-10-02 17:00:00', '2013-10-02 18:00:00');
INSERT INTO conference (id, name, startDate, endDate) VALUES (3, 'J2EE programavimui naudojami įrankiai', '2013-10-07 17:00:00', '2013-10-07 18:00:00');
INSERT INTO conference (id, name, startDate, endDate) VALUES (4, 'Web puslapių vartotojo sąsajos kūrimas (1-a dalis)', '2013-10-09 17:00:00', '2013-10-09 18:00:00');
INSERT INTO conference (id, name, startDate, endDate, description) VALUES (5, 'Testas', '2013-10-09 17:00:00', '2013-10-09 18:00:00', 'Desk');


INSERT INTO conferenceCategory (id, name,  description) VALUES (1, 'Workshop', 'Practical ');
INSERT INTO conferenceCategory (id, name,  description) VALUES (2, 'Lecture', '');
INSERT INTO conferenceCategory (id, name,  description) VALUES (3, 'Seminar', '');
INSERT INTO conferenceCategory (id, name,  description) VALUES (4, 'Conference', '');
INSERT INTO conferenceCategory (id, name,  description) VALUES (5, 'Symposium', '');
INSERT INTO conferenceCategory (id, name,  description) VALUES (6, 'Colloquium', '');
INSERT INTO conferenceCategory (id, name,  description) VALUES (7, 'Roundtable', '');

COMMIT;