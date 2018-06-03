/**
SQL LAB - CHRISTIAN BUDHI
**/

/**
2.0 SQL QUERIES
In this section you will be performing various queries against the Oracle Chinook database.
**/


-- 2.1 SELECT
-- Select all records from the Employee table.
SELECT *
FROM CHINOOK.EMPLOYEE;

--  Select all records from the Employee table where last name is King.
SELECT *
FROM CHINOOK.EMPLOYEE
WHERE LASTNAME = 'King';
-- 'KING' DOESN'T WORK, THE SEARCH IS CASE SENSITIVE

-- Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * 
FROM CHINOOK.EMPLOYEE
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;


-- 2.2 ORDER BY
-- Select all albums in Album table and sort result set in descending order by title.
SELECT *
FROM CHINOOK.ALBUM
ORDER BY TITLE DESC;

-- Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME, CITY
FROM CHINOOK.CUSTOMER
ORDER BY CITY ASC;
-- ADDED CITY TO SHOW THAT IT IS ORDERED BY CITY


-- 2.3 INSERT INTO
--Insert two new records into Genre 
INSERT INTO CHINOOK.GENRE VALUES(26, 'Bubblegum Pop');
INSERT INTO CHINOOK.GENRE VALUES(27, 'PC Music');

--Insert two new records into Employee table
INSERT INTO CHINOOK.EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME) VALUES (9, 'Smith', 'John');
INSERT INTO CHINOOK.EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME) VALUES (10, 'Budhi', 'Christian');

--Insert two new records into Customer table
INSERT INTO CHINOOK.CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES (60, 'Casper', 'Ghost', 'casperghost@ghosty.com');
INSERT INTO CHINOOK.CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES (61, 'Spider', 'Man', 'sman@mar.u');


-- 2.4 UPDATE
-- Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CHINOOK.CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' and LASTNAME = 'Mitchell'; -- HAVE TO MATCH BOTH NAMES

-- Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE CHINOOK.ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';


-- 2.5 LIKE
-- Select all invoices with a billing address like “T%”
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
-- Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).

-- REMOVE CONSTRAINTS FROM FK_INVOICECUSTOMERID
ALTER TABLE CHINOOK.INVOICE
    DROP CONSTRAINT FK_INVOICECUSTOMERID;
-- ADD IN SAME CONSTRAINT BUT WITH ON DELETE CASCADE
ALTER TABLE CHINOOK.INVOICE
    ADD CONSTRAINT FK_INVOICECUSTOMERID
    FOREIGN KEY (CUSTOMERID) REFERENCES CHINOOK.CUSTOMER ON DELETE CASCADE;
-- REMOVE FK_INVOICELINEINVOICEID
ALTER TABLE CHINOOK.INVOICELINE
    DROP CONSTRAINT FK_INVOICELINEINVOICEID;
-- ADD IN SAME CONSTRAINT BUT WITH ON DELETE CASCADE
ALTER TABLE CHINOOK.INVOICELINE
    ADD CONSTRAINT FK_INVOICELINEINVOICEID
    FOREIGN KEY (INVOICEID) REFERENCES CHINOOK.INVOICE ON DELETE CASCADE;
-- RUN ACTUAL DELETE WITH NO PROBLEMS
DELETE FROM CHINOOK.CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';


/**
3.0 SQL FUNCTIONS
In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
**/


-- 3.1 System Defined Functions
-- Create a function that returns the current time.
CREATE OR REPLACE FUNCTION CHINOOK.GET_LOCAL_TIME
    RETURN VARCHAR2
    IS 
        myTime VARCHAR2(10); --DECALRE TO HOLD TIME
    BEGIN
        SELECT TO_CHAR (LOCALTIMESTAMP, 'HH24:MI:SS') 
        INTO myTime -- PUT TIME INTO OUT DECLARED VARIABLE
        FROM DUAL;
        
        RETURN (myTime);
    END; 
/

--SHOW TIME THROUGH SELECT STATEMENT
SELECT CHINOOK.get_local_time() AS MYTIME
FROM DUAL;

-- Create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION CHINOOK.GET_MEDIATYPE_LENGTH (MEDIATYPE_ID NUMBER)
    RETURN NUMBER
    IS 
    myLength NUMBER(3); --STORE LENGTH, CAN'T BE MORE THAN 999
    BEGIN
        SELECT LENGTH(NAME) 
        INTO myLength --PUT LENGTH INTO VARIABLE
        FROM CHINOOK.MEDIATYPE 
        WHERE  MEDIATYPE_ID = MEDIATYPEID;
        
        RETURN myLength;
    END ;
/
    
SELECT NAME, CHINOOK.GET_MEDIATYPE_LENGTH(MEDIA.MEDIATYPEID) NAME_LENGTH
FROM CHINOOK.MEDIATYPE MEDIA;

-- 3.2 System Defined Aggregate Functions
-- Create a function that returns the average total of all invoices 
CREATE OR REPLACE FUNCTION CHINOOK.AVERAGE_TOTAL_INVOICES
    RETURN NUMBER
    IS 
    AVERAGE_TOTAL NUMBER(10,2); --hold number
    BEGIN 
        SELECT AVG(TOTAL) INTO AVERAGE_TOTAL --put into average total
        FROM CHINOOK.INVOICE;
        RETURN AVERAGE_TOTAL;
    END;
/
    
SELECT CHINOOK.AVERAGE_TOTAL_INVOICES() FROM DUAL;

-- Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION CHINOOK.MOST_EXPENSIVE_TRACK
    -- since there are more than one track that ties for most expensive, I've decided to return the result as a cursor
    RETURN SYS_REFCURSOR
    IS 
    MAXIMUM NUMBER(10,2);
    Q SYS_REFCURSOR;
    BEGIN
        -- get max price
        SELECT MAX(UNITPRICE) INTO MAXIMUM FROM CHINOOK.TRACK;
        -- store tracks into the cursor
        OPEN Q FOR
        SELECT NAME FROM CHINOOK.TRACK WHERE UNITPRICE = MAXIMUM;
        
        RETURN Q;
    END;
/

DECLARE
    Q SYS_REFCURSOR;
BEGIN
    Q := CHINOOK.MOST_EXPENSIVE_TRACK();
    DBMS_SQL.RETURN_RESULT(Q);
END;
SELECT NAME, UNITPRICE FROM CHINOOK.TRACK
WHERE UNITPRICE = (  SELECT MAX(UNITPRICE) FROM CHINOOK.TRACK);


-- 3.3 User Defined Scalar Functions
-- Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION CHINOOK.AVERAGE_PRICE_INVOICELINE
    RETURN NUMBER
    IS TOTAL_PRICE NUMBER(10,2);
    NUMBER_ITEMS NUMBER(10, 2);
    AVERAGE NUMBER(10, 2);
    BEGIN
        -- store sum and total
        SELECT SUM(UNITPRICE) INTO TOTAL_PRICE FROM CHINOOK.INVOICELINE;
        SELECT COUNT(*) INTO NUMBER_ITEMS FROM CHINOOK.INVOICELINE;
        -- compute average
        AVERAGE := TOTAL_PRICE/NUMBER_ITEMS;
        RETURN AVERAGE;
    END;

SELECT CHINOOK.AVERAGE_PRICE_INVOICELINE() FROM DUAL;


-- 3.4 User Defined Table Valued Functions
-- Create a function that returns all employees who are born after 1968
CREATE OR REPLACE FUNCTION CHINOOK.EMPLOYEES_YOUNGER
    -- this is the first function where I figured out how to use the cursor
    RETURN SYS_REFCURSOR
    IS Q SYS_REFCURSOR;
    BEGIN    
        -- store any body born after the date
        OPEN Q FOR 
        SELECT * FROM EMPLOYEE WHERE BIRTHDATE > DATE '1969-01-01';
        
        RETURN Q;
    END;
 
DECLARE
    Q SYS_REFCURSOR;
BEGIN 
    Q := CHINOOK.EMPLOYEES_YOUNGER();
    DBMS_SQL.RETURN_RESULT(Q);
END;




/**
4.0 Stored Procedures
In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
**/

-- 4.1 Basic Stored Procedure
-- Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE CHINOOK.FIRST_LAST_EMPLOYEE_NAMES (Q OUT SYS_REFCURSOR)
IS 
BEGIN
    OPEN Q FOR
    SELECT FIRSTNAME, LASTNAME 
    FROM CHINOOK.EMPLOYEE;
    
    DBMS_SQL.RETURN_RESULT(Q);
END;

DECLARE
    Q SYS_REFCURSOR;
BEGIN 
    CHINOOK.FIRST_LAST_EMPLOYEE_NAMES(Q);
END;


-- 4.2 Stored Procedure Input Parameters
-- Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE CHINOOK.UPDATE_EMPLOYEE(
    EMPID IN NUMBER, 
    EMPLAST IN VARCHAR2,
    EMPFIRST IN VARCHAR2,
    EMPTITLE IN VARCHAR2,
    EMPMANAGER IN NUMBER,
    EMPBIRTHDATE IN DATE,
    EMPHIREDATE IN DATE,
    EMPADDRESS IN VARCHAR2,
    EMPCITY IN VARCHAR2,
    EMPSTATE IN VARCHAR,
    EMPCOUNTRY IN VARCHAR2,
    EMPPOSTALCODE IN VARCHAR2,
    EMPPHONE IN VARCHAR2,
    EMPFAX IN VARCHAR2,
    EMPEMAIL IN VARCHAR2   )
IS
BEGIN
    UPDATE CHINOOK.EMPLOYEE
    SET
        LASTNAME = EMPLAST, 
        FIRSTNAME = EMPFIRST,
        TITLE = EMPTITLE,
        REPORTSTO = EMPMANAGER,
        BIRTHDATE = EMPBIRTHDATE,
        HIREDATE = EMPHIREDATE,
        ADDRESS = EMPADDRESS,
        CITY = EMPCITY,
        STATE = EMPSTATE,
        COUNTRY = EMPCOUNTRY,
        POSTALCODE = EMPPOSTALCODE,
        PHONE = EMPPHONE,
        FAX = EMPFAX,
        EMAIL = EMPEMAIL
    WHERE EMPLOYEEID = EMPID;
END;

SELECT * FROM CHINOOK.EMPLOYEE ORDER BY EMPLOYEEID ASC;
BEGIN
    CHINOOK.UPDATE_EMPLOYEE(1, 'Budhi', 'Christian', 'IT Staff', 1, DATE '1995-12-05', DATE '2018-05-21', '84 Stobe Ave', 'Staten Island', 'NY', 'United States', '10306', '+1 (646) 247-0955', null, 'cjbudhi95@gmail.com');
END;
SELECT * FROM CHINOOK.EMPLOYEE ORDER BY EMPLOYEEID ASC;
-- Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE CHINOOK.GET_MANAGER (EMPID IN NUMBER, Q OUT SYS_REFCURSOR)
IS
BEGIN   
    -- using a cursor so I can reference all of the manger's data without having to create too many out parameters
    OPEN Q FOR
    SELECT * 
    FROM CHINOOK.EMPLOYEE
    WHERE EMPLOYEEID = ( -- subquery to get managers EMPLOYEEID
        SELECT REPORTSTO
        FROM CHINOOK.EMPLOYEE
        WHERE EMPLOYEEID = EMPID);
END;

DECLARE
    Q SYS_REFCURSOR;
    EMPID NUMBER := 3;
BEGIN
    CHINOOK.GET_MANAGER(EMPID,Q);
    DBMS_SQL.RETURN_RESULT(Q);
END;
    

-- 4.3 Stored Procedure Output Parameters
-- Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE CHINOOK.GET_CUSTOMER_NAME_COMPANY (CUSTID IN NUMBER, CUSTNAME OUT VARCHAR2, CUSTCOMPANY OUT VARCHAR2)
IS FIRSTNM VARCHAR2(20);
LASTNM VARCHAR2(20);
BEGIN
    -- Store first and last name
    SELECT FIRSTNAME INTO FIRSTNM
    FROM CHINOOK.CUSTOMER
    WHERE CUSTOMERID = CUSTID;
    
    SELECT LASTNAME INTO LASTNM
    FROM CHINOOK.CUSTOMER
    WHERE CUSTOMERID = CUSTID;
    
    -- concatinate names so that there are fewer out paramters
    CUSTNAME := (FIRSTNM || ' ' || LASTNM);
    
    SELECT COMPANY INTO CUSTCOMPANY
    FROM CHINOOK.CUSTOMER
    WHERE CUSTOMERID = CUSTID;
END;

SET SERVEROUTPUT ON;

DECLARE 
    CUSTID NUMBER := 1;
    CUSTNAME VARCHAR2(40);
    CUSTCOMPANY VARCHAR2(100);
BEGIN
    CHINOOK.GET_CUSTOMER_NAME_COMPANY(CUSTID, CUSTNAME, CUSTCOMPANY);
    DBMS_OUTPUT.PUT_LINE('NAME: ' || CUSTNAME || ' COMPANY: ' || CUSTCOMPANY);   
END;


/**
5.0 Transactions
In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
**/

-- Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE CHINOOK.REMOVE_INVOICE (INVID IN NUMBER) 
IS 
BEGIN
    -- CONSTRAINTS HANDLED IN THE DELETE SECTION OF PART 2
    -- IF NOT WE WOULD HAVE DROPPED THE FOREIGN KEY AND THEN RE ADDED IS, BUT WITH ON CASCADE DELETE
    DELETE FROM CHINOOK.INVOICE WHERE INVOICEID = INVID;
    COMMIT; -- commit to save changes
END;

DECLARE
    INVID NUMBER := 250;    
BEGIN
    CHINOOK.REMOVE_INVOICE(INVID);
END;

-- Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE CHINOOK.INSERT_CUSTOMER (CUSTID IN NUMBER, FNAME IN VARCHAR, LNAME IN VARCHAR, CUSTEMAIL IN VARCHAR)
IS 
BEGIN
    INSERT INTO CHINOOK.CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES (CUSTID, FNAME, LNAME, CUSTEMAIL);
    COMMIT; --commit to save changes
END;

BEGIN
    CHINOOK.INSERT_CUSTOMER(62, 'Robert', 'Rams', 'RRams@email.com');
END;


/**
6.0 Triggers
In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
**/

-- USE THIS TABLE TO INDICATE THAT THE TRIGGER WAS CALLED
-- this was the best way I could come up with to prove that the triggers were being called
CREATE TABLE CHINOOK.OUTPUT(
    QUESTION NUMBER(2,1),
    STATUS VARCHAR2(20)
);
    
-- 6.1 AFTER/FOR
-- Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER CHINOOK.TR_EMPLOYEE_PK
AFTER INSERT ON CHINOOK.EMPLOYEE
BEGIN 
    INSERT INTO CHINOOK.OUTPUT VALUES(6.1, 'SUCCESS'); --when trigger fires, just add to the table
END;

INSERT INTO CHINOOK.EMPLOYEE (EMPLOYEEID, FIRSTNAME, LASTNAME) VALUES (11, 'Devin', 'Dougherty');


-- Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER CHINOOK.TR_ALBUM
AFTER UPDATE ON CHINOOK.ALBUM
BEGIN
    INSERT INTO CHINOOK.OUTPUT VALUES(6.2, 'SUCCESS');
END;
UPDATE CHINOOK.ALBUM
SET TITLE = 'Original Soundtracks 1, but where is 2'
WHERE ALBUMID = 176;


-- Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER CHINOOK.TR_CUSTOMER_DELETE
AFTER DELETE ON CHINOOK.CUSTOMER
BEGIN
    INSERT INTO CHINOOK.OUTPUT VALUES(6.3, 'SUCCESS');
END;
DELETE FROM CHINOOK.CUSTOMER WHERE CUSTOMERID = 61;


-- DISPLAY TRIGGER LOG
SELECT * FROM CHINOOK.OUTPUT;

/**
7.0 JOINS
In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
**/

-- 7.1 INNER
-- Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
-- displays everytning in common
SELECT C.FIRSTNAME, C.LASTNAME, I.INVOICEID
FROM CHINOOK.CUSTOMER C
INNER JOIN CHINOOK.INVOICE I
ON C.CUSTOMERID = I.CUSTOMERID
ORDER BY C.CUSTOMERID;

-- 7.2 OUTER
-- Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
-- displays everything from both tables
SELECT C.CUSTOMERID, C.FIRSTNAME, C.FIRSTNAME, I.INVOICEID, I.TOTAL
FROM CHINOOK.CUSTOMER C
FULL JOIN CHINOOK.INVOICE I
ON C.CUSTOMERID = I.CUSTOMERID
ORDER BY C.CUSTOMERID;

-- 7.3 RIGHT
-- Create a right join that joins album and artist specifying artist name and title.
-- displays all of the artists and any in common with album
SELECT AL.TITLE, AR.NAME
FROM CHINOOK.ALBUM AL
RIGHT JOIN CHINOOK.ARTIST AR
ON AL.ARTISTID = AR.ARTISTID
ORDER BY AR.ARTISTID;


-- 7.4 CROSS
-- Create a cross join that joins album and artist and sorts by artist name in ascending order.
-- matched artist with album
SELECT *
FROM CHINOOK.ALBUM AL
CROSS JOIN CHINOOK.ARTIST AR
WHERE AL.ARTISTID = AR.ARTISTID
ORDER BY AR.NAME ASC;

-- 7.5 SELF
-- Perform a self-join on the employee table, joining on the reportsto column.
-- the solution to an earlier problem where we wanted to return managers
-- this matches the table with itself
SELECT *
FROM CHINOOK.EMPLOYEE EMP1, CHINOOK.EMPLOYEE EMP2
WHERE EMP1.REPORTSTO = EMP2.EMPLOYEEID;









