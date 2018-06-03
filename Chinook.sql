/*
PROGRAMMER NAME: KEANDRE PALMER
DATE: 05/30/2018
BATCH: JAVA
*/

--2.1 SELECT QUERIES
--Task – Select all records from the Employee table.
SELECT * FROM CHINOOK.EMPLOYEE;
--Task – Select all records from the Employee table where last name is King.
SELECT * FROM CHINOOK.EMPLOYEE WHERE CHINOOK.EMPLOYEE.LASTNAME = 'King';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.// 
SELECT * FROM CHINOOK.EMPLOYEE WHERE CHINOOK.EMPLOYEE.FIRSTNAME = 'Andrew' AND CHINOOK.EMPLOYEE.REPORTSTO IS NULL;

--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM CHINOOK.ALBUM ORDER BY CHINOOK.ALBUM.TITLE DESC;

--Task – Select first name from Customer and sort result set in ascending order by city
SELECT CHINOOK.CUSTOMER.FIRSTNAME FROM CHINOOK.CUSTOMER ORDER BY CHINOOK.CUSTOMER.CITY ASC;

--2.3 INSERT INTO
--Task – Insert two new records into Genre table one named Korean Pop and Alternative Pop
INSERT INTO CHINOOK.GENRE VALUES (26,'Korean Pop');
INSERT INTO CHINOOK.GENRE VALUES (27,'Alternative Pop');

--Task – Insert two new records into Employee table
INSERT INTO CHINOOK.EMPLOYEE VALUES (16,'Spere','Evelyn','Rev',5,DATE '1993-11-21',DATE '2018-05-09','501 Fordem Drive','Sacramento','California','United States','94257','916-148-4069','509-281-1475','espere1@ocn.ne.jp');
INSERT INTO CHINOOK.EMPLOYEE VALUES (17,'Nicklen','Marcille','Mrs',3,DATE '1994-04-06',DATE '2018-04-26','6268 Morningstar Place','Washington','District of Columbia','United States','20436','202-852-8530','646-707-5455','mnicklen0@sciencedaily.com');

--Task – Insert two new records into Customer table
INSERT INTO CHINOOK.CUSTOMER VALUES (60,'Emilia','Deddum','Dazzlesphere','9 Pond Terrace','Palm Bay','Florida','United States','32909','321-324-8042','941-622-4290','ededdum0@zdnet.com',2);
INSERT INTO CHINOOK.CUSTOMER VALUES (61,'Kirbie','Nuton','Quatz','9 Blue Bill Park Trail','Savannah','Georgia','United States','31405','912-858-3171','937-280-7236','knuton1@noaa.gov',3);

--2.4 UPDATE

--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CHINOOK.CUSTOMER SET CHINOOK.CUSTOMER.FIRSTNAME = 'Robert', CHINOOK.CUSTOMER.LASTNAME = 'Walter' WHERE CHINOOK.CUSTOMER.FIRSTNAME ='Aaron' AND CHINOOK.CUSTOMER.LASTNAME = 'Mitchell';
UPDATE CHINOOK.ARTIST SET CHINOOK.ARTIST.NAME = 'CCR' WHERE CHINOOK.ARTIST.NAME ='Creedence Clearwater Revival';

--2.5 LIKE

--Task – Select all invoices with a billing address like “T%”
SELECT * FROM CHINOOK.INVOICE WHERE CHINOOK.INVOICE.BILLINGADDRESS LIKE 'T%';

--2.6 BETWEEN

--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM CHINOOK.INVOICE WHERE CHINOOK.INVOICE.TOTAL BETWEEN 15 AND 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM CHINOOK.EMPLOYEE WHERE CHINOOK.EMPLOYEE.HIREDATE BETWEEN DATE '2003-06-01' AND DATE '2004-03-01';

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
--DELETE All Invoice lines that were created in relation to the invoice
DELETE CHINOOK.INVOICELINE WHERE CHINOOK.INVOICELINE.INVOICEID =342;
DELETE CHINOOK.INVOICELINE WHERE CHINOOK.INVOICELINE.INVOICEID =50;
DELETE CHINOOK.INVOICELINE WHERE CHINOOK.INVOICELINE.INVOICEID =61;
DELETE CHINOOK.INVOICELINE WHERE CHINOOK.INVOICELINE.INVOICEID =116;
DELETE CHINOOK.INVOICELINE WHERE CHINOOK.INVOICELINE.INVOICEID =245;
DELETE CHINOOK.INVOICELINE WHERE CHINOOK.INVOICELINE.INVOICEID =268;
DELETE CHINOOK.INVOICELINE WHERE CHINOOK.INVOICELINE.INVOICEID =290;
--DELETE invoice where the custromerid is Robert Walter's Customer ID
DELETE CHINOOK.INVOICE WHERE CHINOOK.INVOICE.CUSTOMERID = 32;
--Finally DELETE Robert Walter
DELETE CHINOOK.CUSTOMER WHERE CHINOOK.CUSTOMER.FIRSTNAME = 'Robert' AND CHINOOK.CUSTOMER.LASTNAME ='Walter';

--3 FUNCTIONS
SET SERVEROUTPUT ON;
--3.1 SYSTEM DEFINED FUNCTIONS
--Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION GETTIME
RETURN TIMESTAMP
IS
BEGIN
    RETURN CURRENT_TIMESTAMP;
END;

BEGIN 
    DBMS_OUTPUT.PUT_LINE(GETTIME());
END;

--Task – create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION GETLENGTH(MEDIAID CHINOOK.MEDIATYPE.MEDIATYPEID%TYPE)
RETURN NUMBER
IS
MEDIANAME CHINOOK.MEDIATYPE.NAME%TYPE;
X NUMBER;
BEGIN
    SELECT NAME INTO MEDIANAME
    FROM MEDIATYPE
    WHERE MEDIAID =
        (SELECT MEDIATYPEID
        FROM MEDIATYPE
        WHERE MEDIATYPEID = MEDIAID);
    X := LENGTH(MEDIANAME);
    RETURN X;
END;

BEGIN 
    DBMS_OUTPUT.PUT_LINE(GETLENGTH(CHINOOK.MEDIATYPE.NAME()));
END;

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices

--Task – Create a function that returns the most expensive track
