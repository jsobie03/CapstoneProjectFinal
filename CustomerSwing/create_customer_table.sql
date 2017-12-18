USE customerdb;

DROP TABLE IF EXISTS customer;

CREATE TABLE customer
(
	custID   INT          PRIMARY KEY ,
    firstName    VARCHAR(50), 
    lastName     VARCHAR(50), 
    email		 VARCHAR(50)
);

INSERT INTO customer(custID, firstName, lastName, email)VALUES 
(1, 'John', 'Smith', 'johnsmith@hotmail.com'), 
(2, 'Frank', 'Jones', 'frankjones@yahoo.com'), 
(3, 'Cynthia', 'Green', 'seagreen@levi.com'), 
(4, 'Wendy', 'Kowolski', 'wendyk@warners.com');
