CREATE TABLE UserApp (
	email VARCHAR NOT NULL,
	password VARCHAR NOT NULL,
	role VARCHAR NOT NULL,
	PRIMARY KEY (email)
);

CREATE TABLE Owner (
	idNumber INT NOT NULL,
	email VARCHAR NOT NULL,
	fullName VARCHAR NOT NULL,
	PRIMARY KEY (idNumber),
	FOREIGN KEY (email)
		REFERENCES UserApp (email)
);

CREATE TABLE Vet (
	nit INT NOT NULL,
	email VARCHAR NOT NULL,
	name VARCHAR NOT NULL,
	PRIMARY KEY (nit),
	FOREIGN KEY (email)
		REFERENCES UserApp (email)
);

CREATE TABLE Official (
	officialId SERIAL NOT NULL, /* Integer data type to generate a surrogate key */
	email VARCHAR NOT NULL,
	name VARCHAR NOT NULL,
	PRIMARY KEY (officialId),
	FOREIGN KEY (email)
		REFERENCES UserApp (email)
);

CREATE TABLE Pet (
	petId SERIAL NOT NULL, /* Integer data type to generate a surrogate key */
	name VARCHAR NOT NULL,
	species VARCHAR NOT NULL,
	ownerId INT NOT NULL,
	PRIMARY KEY (petId),
	FOREIGN KEY (ownerId)
		REFERENCES Owner (idNumber)
);