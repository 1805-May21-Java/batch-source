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

-- 3.2 System Defined Aggregate Functions
-- Create a function that returns the average total of all invoices 

CREATE OR REPLACE FUNCTION INVOICE_AVE
RETURN NUMBER
IS
NUM NUMBER;
BEGIN
    SELECT AVG(TOTAL) INTO NUM FROM chinook.INVOICE;
    RETURN NUM;
END;
   
-- Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION MOST_EXPENSIVE_TRACK
RETURN VARCHAR2
IS
NAME VARCHAR2;
BEGIN
    SELECT NAME INTO NAME FROM chinook.TRACK WHERE UNITPRICE=(SELECT MAX(UNITPRICE) FROM chinook.TRACK);
    RETURN NAME;
END;

--3.3 User Defined Scalar Functions
-- Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION AVG_INVOICELINE
RETURN NUMBER
IS
NUM NUMBER;
BEGIN
    SELECT AVG(UNITPRICE) INTO NUM FROM chinook.INVOICELINE;
    RETURN(NUM);
END;

-- 3.4 User Defined Table Valued Functions
-- Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION EMPLOYEES_BEFORE(NUM NUMBER)
RETURN CURSOR
IS
CURSOR CUR
IS
SELECT * FROM chinook.EMPLOYEE WHERE BIRTHDATE>TO_DATE(TO_CHAR(NUM)+'/12/31', 'YYYY/MM/DD');
BEGIN
    RETURN CUR;
END;


-- 4.0 Stored Procedures
-- 4.1 Basic Stored Procedure
-- Create a stored procedure that selects the first and last names of all the employees.

-- 4.2 Stored Procedure Input Parameters
-- Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE(ID NUMBER, LNAME VARCHAR, FNAME VARCHAR, E_TITLE VARCHAR, REPORTTO NUMBER, BIRTHDAY DATE, HIREDAT DATE, ADDR VARCHAR,
                                            CIT VARCHAR, STAT VARCHAR, COUNTR VARCHAR, PCODE VARCHAR, PHON VARCHAR, FX VARCHAR, EMAI VARCHAR)
IS

BEGIN
    UPDATE chinook.EMPLOYEE SET LASTNAME=LNAME, FIRSTNAME=FNAME, 
    TITLE=E_TITLE, REPORTSTO=REPORTTO, BIRTHDATE=BIRTHDAY, HIREDATE=HIREDAT, 
    ADDRESS=ADDR, CITY=CIT, STATE=STAT, COUNTRY=COUNTR, POSTALCODE=PCODE, PHONE=PHON, FAX=FX, EMAIL=EMAI WHERE EMPLOYEEID=ID;
END;

-- 4.3 Stored Procedure Output Parameters
-- Create a stored procedure that returns the name and company of a customer.

-- 5.0 Transactions
-- Transactions
-- Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
DELETE FROM chinook.INVOICE WHERE INVOICEID=1;
COMMIT;
-- Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE NEW_CUSTOMER(FIRST VARCHAR2, LAST VARCHAR2, COMP VARCHAR2, ADDR VARCHAR2, CIT VARCHAR2, STAT VARCHAR2, COUN VARCHAR2, 
PCODE VARCHAR2, PHON VARCHAR2, FX VARCHAR2, EMAI VARCHAR2, SRID NUMBER)
IS
BEGIN
    INSERT INTO CUSTOMER(FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID) 
    VALUES(FIRST, LAST, COMP, ADDR, CIT, STAT, COUN, PCODE, PHON, FX, EMAI, SRID);
END;


-- 6.0 Triggers
--6.1 AFTER/FOR
-- Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER TR_AFTER_INSERT_EMPLOYEE
AFTER INSERT ON chinook.EMPLOYEE
BEGIN
    --DO SOMETHING
END;
-- Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER TR_AFTER_UPDATE_EMPLOYEE
AFTER UPDATE ON chinook.ALBUM
BEGIN
    --DO SOMETHING
END;

-- Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER TR_AFTER_DELETE_CUSTOMER
AFTER DELETE ON chinook.CUSTOMER
BEGIN
    --DO SOMETHING
END;

-- 7.0 JOINS

-- 7.1 INNER
-- Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT CUSTOMER.FIRSTNAME,CUSTOMER.LASTNAME, INVOICE.INVOICEID FROM chinook.CUSTOMER JOIN chinook.INVOICE ON chinook.CUSTOMER.CUSTOMERID=chinook.INVOICE.CUSTOMERID;
-- 7.2 OUTER
-- Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME,CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL FROM chinook.CUSTOMER OUTER JOIN chinook.INVOICE ON chinook.CUSTOMER.CUSTOMERID=chinook.INVOICE.CUSTOMERID;
-- 7.3 RIGHT
-- Create a right join that joins album and artist specifying artist name and title.
SELECT ARTIST.NAME, ALBUM.TITLE FROM chinook.ARTIST RIGHT JOIN chinook.ALBUM ON ARTIST.ARTISTID=ALBUM.ARTISTID;
-- 7.4 CROSS
-- Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT ARTIST.NAME, ALBUM.TITLE FROM chinook.ARTIST CROSS JOIN chinook.ALBUM WHERE ARTIST.ARTISTID=ALBUM.ARTISTID ORDER BY ARTIST.NAME ASC;
-- 7.5 SELF
-- Perform a self-join on the employee table, joining on the reportsto column.
SELECT A.FIRSTNAME, A.LASTNAME, B.FIRSTNAME, B.LASTNAME, A.REPORTSTO FROM chinook.EMPLOYEE A, chinook.EMPLOYEE B WHERE A.REPORTSTO=B.REPORTSTO;



