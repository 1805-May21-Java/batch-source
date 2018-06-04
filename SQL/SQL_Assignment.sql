-- 2.1 SELECT
-- SELECT ALL EMPLOYEES
SELECT * FROM chinook.EMPLOYEE;

-- Select all records from the Employee table where last name is King.
SELECT * FROM chinook.EMPLOYEE WHERE LASTNAME='King';

-- Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL
SELECT * FROM chinook.EMPLOYEE WHERE FIRSTNAME='Andrew' AND REPORTSTO IS NULL;



-- 2.2 ORDER BY
-- Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM chinook.ALBUM ORDER BY(TITLE) DESC;

-- Select first name from Customer and sort result set in ascending order by citY
SELECT FIRSTNAME FROM chinook.CUSTOMER ORDER BY(CITY);




-- 2.3 INSERT INTO
-- Insert two new records into Genre table
INSERT Into chinook.GENRE Values(26,'Yoddling');

-- Insert two new records into Employee table
INSERT INTO chinook.EMPLOYEE VALUES(9,'Stubbs','Nicholas','CEO',null,'21-APR-1996', '21-APR-2015','205 South Main Street', 'Okolona', 'AR', 'United States', '71962','+1 (870) 406-1448',null,'nickdstubss@gmail.com');
INSERT INTO chinook.EMPLOYEE VALUES(10,'Tubbs','Nichademus','SEO',9,'20-APR-1995', '20-APR-2016','207 North Main Street', 'Toad Suck', 'AR', 'United States', '72016','+1 (870) 406-1449',null,'nickadtubss@gmail.com');

-- Insert two new records into Customer table
INSERT INTO chinook.CUSTOMER VALUES(60,'Picard','Jean-Luc','United Federation of Planets','115 2nd Street','Paris','Île-de-France','France','75000','+33 (03) 867-5309',null,'tea_earl-gray_hot@gmail.com.fr',5);
INSERT INTO chinook.CUSTOMER VALUES(61,'Bicard','John-Luke','Romulan Empire','117 3rd Street','Paris','Île-de-France','France','75001','+33 (03) 867-5308',null,'romulansRule@gmail.com.fr',3);

-- 2.4 Update
-- Update Aaron Mitchell in Customer table to Robert Walter
UPDATE chinook.CUSTOMER SET FIRSTNAME='Robert', LASTNAME='Walter' WHERE FIRSTNAME='Aaron' AND LASTNAME='Mitchell';

--Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE chinook.ARTIST SET NAME='CCR' WHERE NAME='Creedence Clearwater Revival';

-- 2.5 LIKE
-- Select all invoices with a billing address like “T%”
SELECT * FROM chinook.INVOICE WHERE BILLINGADDRESS LIKE 'T%';

--2.6 BETWEEN
-- Select all invoices that have a total between 15 and 50
SELECT * FROM chinook.INVOICE WHERE TOTAL BETWEEN 15 AND 50;

-- Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM chinook.EMPLOYEE;
SELECT * FROM chinook.EMPLOYEE WHERE HIREDATE BETWEEN TO_DATE('06/01/2003', 'MM/DD/YYYY') AND TO_DATE('03/01/2004', 'MM/DD/YYYY');

--2.7 DELETE
-- Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE chinook.INVOICE DROP CONSTRAINT FK_INVOICECUSTOMERID;

ALTER TABLE chinook.INVOICE ADD CONSTRAINT FK_INVOICECUSTOMERID
FOREIGN KEY(CUSTOMERID) REFERENCES chinook.CUSTOMER(CUSTOMERID) ON DELETE CASCADE;

ALTER TABLE chinook.INVOICELINE DROP CONSTRAINT FK_INVOICELINEINVOICEID;

ALTER TABLE chinook.INVOICELINE ADD CONSTRAINT FK_INVOICELINEINVOICEID
FOREIGN KEY(INVOICEID) REFERENCES chinook.INVOICE(INVOICEID) ON DELETE CASCADE;

DELETE FROM chinook.CUSTOMER WHERE FIRSTNAME='Robert' AND LASTNAME='Walter';

-- 3.1 System Defined Functions
-- Create a function that returns the current time.
set serveroutput on;

CREATE OR REPLACE FUNCTION GET_TIME
RETURN TIMESTAMP
IS
BEGIN
    RETURN(CURRENT_TIMESTAMP());
END;
-- RUN FUNCTION
BEGIN
    DBMS_OUTPUT.put_line(GET_TIME);
END;

-- create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION NAME_LENGTH(NAMEID IN NUMBER)
RETURN NUMBER
IS THE_LENGTH NUMBER;
BEGIN
    SELECT LENGTH(NAME) INTO THE_LENGTH FROM 
    chinook.MEDIATYPE WHERE MEDIATYPEID=NAMEID;
    RETURN(THE_LENGTH);
END;
-- RUN FUNCTION
BEGIN
    DBMS_OUTPUT.put_line(NAME_LENGTH(1));
END;

-- 3.2 System Defined Aggregate Functions
