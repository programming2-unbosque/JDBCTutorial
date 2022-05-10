/* Creating users */

INSERT INTO UserApp (email, password, role) VALUES ('hugo@gmail.com', '123456', 'owner');
INSERT INTO UserApp (email, password, role) VALUES ('paco@gmail.com', '123456', 'owner');
INSERT INTO UserApp (email, password, role) VALUES ('luis@gmail.com', '123456', 'owner');
INSERT INTO UserApp (email, password, role) VALUES ('miscachorritos@gmail.com', '123456', 'vet');
INSERT INTO UserApp (email, password, role) VALUES ('official1@cuatropatas.gov.co', '123456', 'official');

INSERT INTO Owner (idNumber, email, fullName) VALUES (6697, 'hugo@gmail.com', 'Hugo');
INSERT INTO Owner (idNumber, email, fullName) VALUES (6698, 'paco@gmail.com', 'Paco');
INSERT INTO Owner (idNumber, email, fullName) VALUES (6699, 'luis@gmail.com', 'Luis');

INSERT INTO Vet (nit, email, name) VALUES (6578, 'miscachorritos@gmail.com', 'Mis Cachorritos');

INSERT INTO Official (email, name) VALUES ('official1@cuatropatas.gov.co', 'Marco');

/* Creating pets */

INSERT INTO Pet (name, species, ownerId) VALUES ('Max', 'dog', 6697);
INSERT INTO Pet (name, species, ownerId) VALUES ('Snowball', 'cat', 6698);
INSERT INTO Pet (name, species, ownerId) VALUES ('Logan', 'dog', 6699);