SELECT
 *
FROM Pet;


SELECT
  *
FROM Pet
WHERE
  species = 'cat';


SELECT
  petId,
  name
FROM Pet
WHERE
  species = 'dog';


SELECT
	petId,
	name,
	fullName AS owner
FROM Pet p
JOIN Owner o
	ON p.ownerId = o.idNumber
WHERE
  species = 'dog';