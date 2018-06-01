/** 

SQL Lab

Sydney Mercier

**/

--------------------
-- 2. SQL Queries --
--------------------

-- 2.1 SELECT
-- Select all records from the Employee table.
SELECT *
FROM CHINOOK.EMPLOYEE;

-- Select all records from the Employee table where last name is King.
SELECT *
FROM CHINOOK.EMPLOYEE
WHERE LASTNAME='King';

-- Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT *
FROM CHINOOK.EMPLOYEE
WHERE FIRSTNAME='Andrew' AND REPORTSTO IS NULL;


-- 2.2 ORDER BY
-- Select all albums in Album table and sort result set in descending order by title.
SELECT *
FROM CHINOOK.ALBUM
ORDER BY TITLE DESC;

-- Select first name from Customer and sort result set in ascending order by city.
SELECT FIRSTNAME, CITY
FROM CHINOOK.CUSTOMER
ORDER BY CITY;


-- 2.3 INSERT INTO
-- Insert two new records into Genre table
INSERT INTO CHINOOK.GENRE VALUES (26, 'Bebop');
INSERT INTO CHINOOK.GENRE VALUES (27, 'Ska');

-- Insert two new records into Employee table
INSERT INTO CHINOOK.EMPLOYEE VALUES (9, 'Drake', 'Tim','IT Intern', 6, TO_DATE('1994-3-25', 'yyyy-mm-dd'), TO_DATE('2018-6-14', 'yyyy-mm-dd'), '272 Red Robin Rd', 'Gotham', 'NJ', 'United States', '86753', '(123) 456-7890', NULL, 'redrobin03@gmail.com');
INSERT INTO CHINOOK.EMPLOYEE VALUES (10, 'Brown', 'Stephanie','Sales Intern', 3, TO_DATE('1995-7-16', 'yyyy-mm-dd'), TO_DATE('2018-9-12', 'yyyy-mm-dd'), '357 Black Bat Lane', 'Bludhaven', 'NJ', 'United States', '86772', '(123) 908-7654', '(564) 777-8945', 'spoiler001@gmail.com');

-- Insert two new records into Customer table
INSERT INTO CHINOOK.CUSTOMER VALUES (60, 'Kent', 'Clark', 'Daily Planet', '101 Krypton Ave', 'Metropolis', 'DE', 'United States', '83409', '(213) 600-1933', '(825) 777-3333', 'manofsteel13@hotmail.com', 4);
INSERT INTO CHINOOK.CUSTOMER VALUES (61, 'Prince', 'Diana', 'United Nations', '345 Marston Rd', 'London', NULL, 'United Kingdom', 'TH8 KY3', '+44 194 2812 1941', NULL, 'warriorprincess@aol.com', 5);


-- 2.4 UPDATE
-- Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CHINOOK.CUSTOMER
SET FIRSTNAME='Robert', LASTNAME='Walter'
WHERE FIRSTNAME='Aaron' AND LASTNAME='Mitchell';

-- Update name of artist in the Artist table "Creedence Clearwater Revival" to "CCR"
UPDATE CHINOOK.ARTIST
SET NAME='CCR'
WHERE NAME='Creedence Clearwater Revival';


-- 2.5 LIKE
-- Select all invoices with a billing address like "T%"
SELECT *
FROM CHINOOK.INVOICE
WHERE BILLINGADDRESS LIKE 'T%';


-- 2.6 BETWEEN
-- Select all invoices that have a total between 15 and 50
SELECT *
FROM CHINOOK.INVOICE
WHERE TOTAL BETWEEN 15 AND 50;

-- Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT *
FROM CHINOOK.EMPLOYEE
WHERE HIREDATE BETWEEN DATE '2003-06-01' AND DATE '2004-03-01';


-- 2.7 DELETE
-- Delete a record in Customer table where the name is Robert Walter (cascade down)
ALTER TABLE CHINOOK.INVOICE
DROP CONSTRAINT FK_INVOICECUSTOMERID;

ALTER TABLE CHINOOK.INVOICE
ADD CONSTRAINT FK_INVOICECUSTOMERID
FOREIGN KEY (CUSTOMERID) REFERENCES CHINOOK.CUSTOMER(CUSTOMERID) ON DELETE CASCADE;

ALTER TABLE CHINOOK.INVOICELINE
DROP CONSTRAINT FK_INVOICELINEINVOICEID;

ALTER TABLE CHINOOK.INVOICELINE
ADD CONSTRAINT FK_INVOICELINEINVOICEID
FOREIGN KEY (INVOICEID) REFERENCES CHINOOK.INVOICE(INVOICEID) ON DELETE CASCADE;

DELETE FROM CHINOOK.CUSTOMER
WHERE FIRSTNAME='Robert' AND LASTNAME='Walter';



----------------------
-- 3. SQL Functions --
----------------------

-- 3.1 SYSTEM DEFINED FUNCTIONS
-- Create a function that returns the current time

-- Create a function that returns the length of name in MEDIATYPE table


-- 3.2 System Defined Aggregate Functions
-- Create a function that returns the average total of all invoices

-- Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION MOST_EXPENSIVE
RETURN VARCHAR2
IS
BEGIN
    RETURN (SELECT MAX(UNITPRICE) FROM CHINOOK.TRACK;);
END;
/


-- 3.3 User Defined Scalar Functions
-- Create a function that returns the average price of invoiceline items in the invoiceline table


-- 3.4 User Defined Table Valued Functions
-- Create a function that returns all employees who are born after 1968

