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

SET SERVEROUTPUT ON;

-- 3.1 SYSTEM DEFINED FUNCTIONS
-- Create a function that returns the current time
CREATE OR REPLACE FUNCTION GET_TIME
RETURN VARCHAR2
IS
BEGIN
    RETURN TO_CHAR(LOCALTIMESTAMP, 'HH:MI:SS PM');
END;
/

BEGIN
    DBMS_OUTPUT.PUT_LINE(GET_TIME());
END;
/

-- Create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION GET_LENGTH(X IN NUMBER)
RETURN NUMBER
IS 
NAME_LENGTH NUMBER(4);
BEGIN
    SELECT LENGTH(NAME)
    INTO NAME_LENGTH
    FROM CHINOOK.MEDIATYPE
    WHERE MEDIATYPEID=X;
    RETURN NAME_LENGTH;
END;
/

DECLARE
    N NUMBER := 5;
BEGIN
    DBMS_OUTPUT.PUT_LINE(GET_LENGTH(N));
END;
/


-- 3.2 System Defined Aggregate Functions
-- Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION GET_AVG_INVOICES
RETURN NUMBER
IS 
AVERAGE DECIMAL(5,2);
BEGIN
    SELECT AVG(TOTAL) 
    INTO AVERAGE
    FROM CHINOOK.INVOICE;
    RETURN AVERAGE;
END;
/

BEGIN
    DBMS_OUTPUT.PUT_LINE(GET_AVG_INVOICES);
END;
/

-- Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION MOST_EXPENSIVE
RETURN VARCHAR2
IS
MAX_PRICE DECIMAL(5,2);
MAX_NAME VARCHAR2(50);
BEGIN
    SELECT MAX(UNITPRICE)
    INTO MAX_PRICE
    FROM CHINOOK.TRACK;
    
    SELECT NAME
    INTO MAX_NAME
    FROM CHINOOK.TRACK
    WHERE TRACKID IN (SELECT MIN(TRACKID)
                        FROM CHINOOK.TRACK
                        WHERE UNITPRICE = MAX_PRICE);
    RETURN MAX_NAME;
END;
/

BEGIN
    DBMS_OUTPUT.PUT_LINE(MOST_EXPENSIVE());
END;
/


-- 3.3 User Defined Scalar Functions
-- Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION GET_AVG_PRICE
RETURN NUMBER
IS
AVERAGE DECIMAL(5,2);
BEGIN
    SELECT AVG(UNITPRICE)
    INTO AVERAGE
    FROM CHINOOK.INVOICELINE;
    RETURN AVERAGE;
END;
/

BEGIN
    DBMS_OUTPUT.PUT_LINE(GET_AVG_PRICE());
END;
/


-- 3.4 User Defined Table Valued Functions
-- Create a function that returns all employees who are born after 1968
CREATE OR REPLACE FUNCTION POST_BABYBOOMERS
RETURN SYS_REFCURSOR
IS
BOOMERS SYS_REFCURSOR;
BEGIN
    OPEN BOOMERS FOR 
    SELECT FIRSTNAME, LASTNAME
    FROM CHINOOK.EMPLOYEE
    WHERE BIRTHDATE > '31-DEC-68';
    RETURN BOOMERS;
END;
/

DECLARE
BOOMERS SYS_REFCURSOR;
FIRSTNAME VARCHAR2(20);
LASTNAME VARCHAR2(20);
BEGIN
    BOOMERS := POST_BABYBOOMERS();
    LOOP
        FETCH BOOMERS INTO FIRSTNAME, LASTNAME;
        EXIT WHEN BOOMERS%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(FIRSTNAME || ' ' || LASTNAME);
    END LOOP;
END;
/



--------------------------
-- 4. Stored Procedures --
--------------------------

SET SERVEROUTPUT ON;

-- 4.1 Basic Stored Procedure
-- Create a stored procedure that selects the first and last names of all the employees
CREATE OR REPLACE PROCEDURE FULL_NAMES (EMPLOYEE_NAMES OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN EMPLOYEE_NAMES FOR
    SELECT FIRSTNAME, LASTNAME
    FROM CHINOOK.EMPLOYEE;
END;
/

DECLARE
    EMPLOYEE_NAMES SYS_REFCURSOR;
    FIRSTNAME CHINOOK.EMPLOYEE.FIRSTNAME%TYPE;
    LASTNAME CHINOOK.EMPLOYEE.LASTNAME%TYPE;
BEGIN
    FULL_NAMES(EMPLOYEE_NAMES);
    LOOP
        FETCH EMPLOYEE_NAMES INTO FIRSTNAME, LASTNAME;
        EXIT WHEN EMPLOYEE_NAMES%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(FIRSTNAME || ' ' || LASTNAME);
    END LOOP;
    CLOSE EMPLOYEE_NAMES;
END;
/


-- 4.2 Stored Procedure Input Parameters
-- Create a stored procedure that updates the personal information of an employee
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE (EMPID IN NUMBER, LNAME IN VARCHAR2, FNAME IN VARCHAR2,
      TITLE IN VARCHAR, REPORTSTO IN NUMBER, DOB IN DATE, DATEHIRED IN DATE, EMPADDRESS IN VARCHAR2,
      EMPCITY IN VARCHAR2, EMPSTATE IN VARCHAR2, EMPCOUNTRY IN VARCHAR2, EMPZIP IN VARCHAR2,
      EMPPHONE IN VARCHAR2, EMPFAX IN VARCHAR2, EMPEMAIL IN VARCHAR2)
IS
BEGIN
    UPDATE CHINOOK.EMPLOYEE
    SET EMPLOYEEID = EMPID, LASTNAME = LNAME, FIRSTNAME = FNAME, TITLE = TITLE, REPORTSTO = REPORTSTO,
        BIRTHDATE = DOB, HIREDATE = DATEHIRED, ADDRESS = EMPADDRESS, CITY = EMPCITY, STATE = EMPSTATE,
        COUNTRY = EMPCOUNTRY, POSTALCODE = EMPZIP, PHONE = EMPPHONE, FAX = EMPFAX, EMAIL = EMPEMAIL
    WHERE EMPLOYEEID = EMPID;
END;
/

BEGIN
    UPDATE_EMPLOYEE(8, 'Callahan', 'Laura', 'IT Manager', 1, '09-JAN-68', '04-MAR-04', '923 7 ST NW	Lethbridge',
        'AB', 'Canada', 'T1H 1Y8', '+1 (403) 467-3351', '+1 (403) 467-8772', 'laura@chinookcorp.com');
END;
/

-- Create a stored procedure that returns the managers of an employee
CREATE OR REPLACE PROCEDURE GET_MANAGER(EMPID IN NUMBER)
IS
FNAME VARCHAR2(20);
LNAME VARCHAR2(20);
BEGIN
    SELECT FIRSTNAME, LASTNAME
    INTO FNAME, LNAME
    FROM CHINOOK.EMPLOYEE
    WHERE EMPLOYEEID = (SELECT REPORTSTO
                        FROM CHINOOK.EMPLOYEE
                        WHERE EMPLOYEEID = EMPID);
    DBMS_OUTPUT.PUT_LINE(FNAME || ' ' || LNAME);
END;
/

BEGIN
    GET_MANAGER(5);
END;
/


-- 4.3 Stored Procedure Output Parameters
-- Create a stored procedure that returns the name and company of a customer
CREATE OR REPLACE PROCEDURE GET_CUSTOMER(CUSID IN NUMBER, CUSTOMER_FNAME OUT CHINOOK.CUSTOMER.FIRSTNAME%TYPE,
    CUSTOMER_LNAME OUT CHINOOK.CUSTOMER.LASTNAME%TYPE, CUSTOMER_COMPANY OUT CHINOOK.CUSTOMER.COMPANY%TYPE)
IS
BEGIN
    SELECT FIRSTNAME, LASTNAME, COMPANY
    INTO CUSTOMER_FNAME, CUSTOMER_LNAME, CUSTOMER_COMPANY
    FROM CHINOOK.CUSTOMER
    WHERE CUSTOMERID = CUSID;
END;
/

DECLARE
FNAME CHINOOK.CUSTOMER.FIRSTNAME%TYPE;
LNAME CHINOOK.CUSTOMER.LASTNAME%TYPE;
COMPANY CHINOOK.CUSTOMER.COMPANY%TYPE;
BEGIN
    GET_CUSTOMER(10, FNAME, LNAME, COMPANY);
    DBMS_OUTPUT.PUT_LINE(FNAME || ' ' || LNAME || ' - ' || COMPANY);
END;
/



---------------------
-- 5. Transactions --
---------------------

-- Create a transaction that given an invoiceid will delete that invoice
-- (see 2.7 for how invoices are deleted on cascade)
SET TRANSACTION NAME 'DELETE_INVOICE';
DECLARE
    INVOICE NUMBER(5) := 6;
BEGIN
    --INVOICE := 6;
    DELETE FROM CHINOOK.INVOICE
    WHERE INVOICEID = INVOICE;
    COMMIT;
END;
/

-- Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE INSERT_RECORD(CUSID IN CHINOOK.CUSTOMER.CUSTOMERID%TYPE, 
    CUSTOMER_FNAME IN CHINOOK.CUSTOMER.FIRSTNAME%TYPE, CUSTOMER_LNAME IN CHINOOK.CUSTOMER.LASTNAME%TYPE, 
    CUSTOMER_COMPANY IN CHINOOK.CUSTOMER.COMPANY%TYPE, CUSTOMER_EMAIL IN CHINOOK.CUSTOMER.EMAIL%TYPE)
IS
BEGIN
    INSERT INTO CHINOOK.CUSTOMER(CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, EMAIL)
    VALUES (CUSID, CUSTOMER_FNAME, CUSTOMER_LNAME, CUSTOMER_COMPANY, CUSTOMER_EMAIL);
    COMMIT;
END;
/



-----------------
-- 6. Triggers --
-----------------

-- 6.1 AFTER/FOR
-- Create an after insert trigger on the emplyee table fired after a new record is inserted into the table
CREATE OR REPLACE TRIGGER CHINOOK.TR_INSERT_EMPLOYEE
AFTER INSERT ON CHINOOK.EMPLOYEE
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('INSERT COMPLETE');
END;
/

-- Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER CHINOOK.TR_UPDATE_ALBUM
AFTER UPDATE ON CHINOOK.ALBUM
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('NEW ENTRY IN ALBUM');
END;
/

-- Create an after delete trigger on the customer table that fires after a row is deleted from the table
CREATE OR REPLACE TRIGGER CHINOOK.TR_DELETE_CUSTOMER
AFTER DELETE ON CHINOOK.CUSTOMER
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('CUSTOMER DELETED! BUH-BYE!');
END;
/


--------------
-- 7. Joins --
--------------

-- 7.1 INNER
-- Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceid


-- 7.2 OUTER
-- Create an outer join that joins the customer and invoice table, specifying the customerid, firstname, lastname, and total


-- 7.3 RIGHT
-- Create a right join that joins album and artist specifying artist name and title


-- 7.4 CROSS
-- Create a cross join that joins album and artist and sorts by artist name in ascending order


-- 7.5 SELF
-- Perform a self-join on the employee table, joining on the reportsto column

