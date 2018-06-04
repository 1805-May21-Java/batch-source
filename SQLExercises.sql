
-- 2.1 SELECT
-- Task � Select all records from the Employee table.
SELECT *
FROM CHINOOK.EMPLOYEE;

-- Task � Select all records from the Employee table where last name is King.
SELECT * 
FROM CHINOOK.EMPLOYEE
WHERE LASTNAME = 'King';

-- Task � Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.// 
SELECT *
FROM CHINOOK.EMPLOYEE
WHERE FIRSTNAME = 'Andrew'
AND REPORTSTO IS NULL;

-- 2.2 ORDER BY
-- Task � Select all albums in Album table and sort result set in descending order by title.
SELECT * 
FROM CHINOOK.ALBUM
ORDER BY TITLE DESC;

-- Task � Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME 
FROM CHINOOK.CUSTOMER
ORDER BY CITY;

-- 2.3 INSERT INTO
-- Task � Insert two new records into Genre table 
INSERT INTO CHINOOK.GENRE (GenreId, Name) VALUES (26, 'Indie Rock');
INSERT INTO CHINOOK.GENRE (GenreId, Name) VALUES (27, 'Polka');

-- Task � Insert two new records into Employee table
INSERT INTO CHINOOK.EMPLOYEE (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (9, 'Beeson', 'Stephon', 'IT Staff', TO_DATE('1969-5-22 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2018-3-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '123 Oak St', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', '+1 (790) 488-6482', '+1 (780) 428-3457', 'stephon@chinookcorp.com');
INSERT INTO CHINOOK.EMPLOYEE (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (10, 'Reynolds', 'Stacy', 'IT Staff', TO_DATE('1967-6-19 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2018-4-11 00:00:00','yyyy-mm-dd hh24:mi:ss'), '11120 Jasper Ave NW', 'Calgary', 'AB', 'Canada', 'T5G 2N4', '+1 (720) 421-5482', '+1 (780) 428-3457', 'stacy@chinookcorp.com');

-- Task � Insert two new records into Customer table
INSERT INTO CHINOOK.CUSTOMER (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) VALUES (60, 'Sam', 'Stone', 'NASA', '123 The Moon St', 'Cape Canaveral', 'FL', 'USA', '69420-000', '+1 (999) 765-4321', '+1 (100) 789-4567', 'spaceman@space.com', 3);
INSERT INTO CHINOOK.CUSTOMER (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) VALUES (61, 'Sarah', 'Smith', 'Microsoft', '45 Jones St', 'San Diego', 'CA', 'USA', '42069-000', '+1 (123) 423-5555', '+1 (112) 923-5566', 'ssmith@micro.soft', 4);

-- 2.4 UPDATE
-- Task � Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CHINOOK.CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE CHINOOK.CUSTOMER.CUSTOMERID = 32;

-- Task � Update name of artist in the Artist table �Creedence Clearwater Revival� to �CCR�
UPDATE CHINOOK.ARTIST
SET NAME = 'CCR'
WHERE CHINOOK.ARTIST.ARTISTID = 76;

-- 2.5 LIKE
-- Task � Select all invoices with a billing address like �T%�
SELECT *
FROM CHINOOK.INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

-- 2.6 BETWEEN
--Task � Select all invoices that have a total between 15 and 50
SELECT *
FROM CHINOOK.INVOICE
WHERE TOTAL BETWEEN 15 AND 50;

-- Task � Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT *
FROM CHINOOK.EMPLOYEE
WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04'; 

-- 2.7 DELETE
-- Task � Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE CHINOOK.INVOICE
DROP CONSTRAINT FK_INVOICECUSTOMERID;

DELETE FROM CHINOOK.CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

-- SQL Functions
-- In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
-- 3.1 System Defined Functions
-- Task � Create a function that returns the current time.
CREATE OR REPLACE FUNCTION WHAT_TIME_IS_IT
RETURN TIMESTAMP
IS 
    TIME_NOW TIMESTAMP;
BEGIN
    SELECT LOCALTIMESTAMP INTO TIME_NOW
    FROM DUAL;

    RETURN TIME_NOW;
END;
/
BEGIN
    DBMS_OUTPUT.PUT_LINE(WHAT_TIME_IS_IT);
END;

-- Task � create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION MEDIANAMELENGTH (X CHINOOK.MEDIATYPE.MEDIATYPEID%TYPE) -- DEFINES X AS AN INPUT VARIABLE OF SAME TYPE AS MEDIATYPE ID
RETURN NUMBER -- SETS FUNCTION RETURN TYPE TO NUMBER
IS
    -- DECLARE VARIABLES NEEDED FOR EXECUTION
    Y NUMBER;
    NAME CHINOOK.MEDIATYPE.NAME%TYPE;
BEGIN
    -- EXECUTABLE BLOCK
    -- SELECT STATEMENT THAT USES INPUT X TO GET THE NAME FROM OUR TABLE THAT CORRESPONDS TO THE MEDIATYPE ID
    SELECT CHINOOK.MEDIATYPE.NAME INTO NAME -- SELECTS NAME COLUMN FROM MEDIATYPE TABLE TO BE SAVED INTO FUNCTION-SCOPED VARIABLE NAME
    FROM CHINOOK.MEDIATYPE -- DEFINES FROM WHICH TABLE TO FIND THAT COLUMN
    WHERE CHINOOK.MEDIATYPE.MEDIATYPEID = X; -- INCLUDES THE CONDITION TO SELECT ONLY FROM ROWS WHERE THE MEDIATYPE ID EQUALS OUR INPUT VARIABLE X
    
    Y := LENGTH(NAME); -- PASSES THE STRING SAVED TO NAME VARIABLE THROUGH THE LENGTH FUNCTION, AND SAVES THAT NUMBER VALUE TO Y
    RETURN Y;  -- RETURNS NUMBER Y
END;
/
-- CALLS FUNCTION ON MEDIATYPE ID 1
BEGIN
    DBMS_OUTPUT.PUT_LINE(MEDIANAMELENGTH(1));
END;

-- 3.2 System Defined Aggregate Functions
-- Task � Create a function that returns the average total of all invoices 
CREATE OR REPLACE FUNCTION AVG_INVOICE_TOTAL
RETURN NUMBER
IS
    TOTAL_AVG NUMBER;
BEGIN
    SELECT AVG(CHINOOK.INVOICE.TOTAL) INTO TOTAL_AVG
    FROM CHINOOK.INVOICE;
    
    RETURN TOTAL_AVG;

END;
/
BEGIN
    DBMS_OUTPUT.PUT_LINE(AVG_INVOICE_TOTAL);
END;

-- Task � Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION MOST_EXPENSIVE_TRACK
RETURN NUMBER
IS
    TOP_TRACK_PRICE NUMBER;
BEGIN
    -- SELECT STATEMENT TO RETURN THE UNITPRICE OF THE MOST EXPENISVE TRACK
    SELECT MAX(CHINOOK.TRACK.UNITPRICE) INTO TOP_TRACK_PRICE
    FROM CHINOOK.TRACK;
    
    RETURN TOP_TRACK_PRICE;
END;

/
BEGIN
    DBMS_OUTPUT.PUT_LINE(MOST_EXPENSIVE_TRACK);
END;

-- 3.3 User Defined Scalar Functions
-- Task � Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION AVG_INVOICE_LINE_ITEM
RETURN NUMBER
IS
    FINAL_AVG NUMBER;
BEGIN
    SELECT AVG(CHINOOK.INVOICELINE.UNITPRICE) INTO FINAL_AVG
    FROM CHINOOK.INVOICELINE;
    
    RETURN FINAL_AVG;
END;
/
BEGIN
    DBMS_OUTPUT.PUT_LINE(AVG_INVOICE_LINE_ITEM);
END;

-- 3.4 User Defined Table Valued Functions
-- Task � Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION OVER_FIFTY
RETURN SYS_REFCURSOR
IS
    S SYS_REFCURSOR;
BEGIN    
    OPEN S FOR 
    SELECT *
    FROM CHINOOK.EMPLOYEE
    WHERE BIRTHDATE > DATE '1968-12-31';
    
    RETURN S;
END;
/   
DECLARE
    SVAR SYS_REFCURSOR;
    TEMP_FIRSTNAME CHINOOK.EMPLOYEE.FIRSTNAME%TYPE;
    TEMP_LASTNAME CHINOOK.EMPLOYEE.LASTNAME%TYPE;
    TEMP_EMPLOYEEID CHINOOK.EMPLOYEE.EMPLOYEEID%TYPE;
    TEMP_TITLE CHINOOK.EMPLOYEE.TITLE%TYPE;
BEGIN
    OVER_FIFTY(SVAR);
    LOOP
        FETCH SVAR INTO TEMP_FIRSTNAME, TEMP_LASTNAME, TEMP_EMPLOYEEID, TEMP_TITLE;
        EXIT WHEN SVAR%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(TEMP_EMPLOYEEID||' '||TEMP_FIRSTNAME||' '||TEMP_LASTNAME||' ' ||TEMP_TITLE||' ');
    END LOOP;
    CLOSE SVAR;
END;


-- 4.0 Stored Procedures
 -- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that 
 -- take input and output parameters.
-- 4.1 Basic Stored Procedure
-- Task � Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE FULL_EMP_NAMES (S OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN S FOR
    SELECT CHINOOK.EMPLOYEE.FIRSTNAME, CHINOOK.EMPLOYEE.LASTNAME 
    FROM CHINOOK.EMPLOYEE;
END;

DECLARE
    SVAR SYS_REFCURSOR;
    TEMP_FN CHINOOK.EMPLOYEE.FIRSTNAME%TYPE;
    TEMP_LN CHINOOK.EMPLOYEE.LASTNAME%TYPE;
BEGIN
    FULL_EMP_NAMES(SVAR);
    LOOP
        FETCH SVAR INTO TEMP_FN, TEMP_LN;
        EXIT WHEN SVAR%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(TEMP_FN ||' '||TEMP_LN||' ');
    END LOOP;
    CLOSE SVAR;
END;
    
-- 4.2 Stored Procedure Input Parameters
-- Task � Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE CHINOOK.UPDATE_EMPLOYEE(
    EMP_ID CHINOOK.EMPLOYEE.EMPLOYEEID%TYPE, VAL IN NUMBER,
    N_FIRSTNAME IN CHINOOK.EMPLOYEE.FIRSTNAME%TYPE,
    N_LASTNAME IN CHINOOK.EMPLOYEE.LASTNAME%TYPE,
    N_BIRTHDATE IN CHINOOK.EMPLOYEE.BIRTHDATE%TYPE,
    N_ADDRESS IN CHINOOK.EMPLOYEE.ADDRESS%TYPE,
    N_CITY IN CHINOOK.EMPLOYEE.CITY%TYPE,
    N_STATE IN CHINOOK.EMPLOYEE.STATE%TYPE,
    N_COUNTRY IN CHINOOK.EMPLOYEE.COUNTRY%TYPE,
    N_POSTAL_CODE IN CHINOOK.EMPLOYEE.POSTALCODE%TYPE)
IS
BEGIN
    UPDATE CHINOOK.EMPLOYEE
    SET
    LASTNAME = N_LASTNAME, FIRSTNAME = N_FIRSTNAME,
    BIRTHDATE = N_BIRTHDATE, ADDRESS = N_ADDRESS,
    CITY = N_CITY, STATE = N_STATE,
    COUNTRY = N_COUNTRY, POSTALCODE = N_POSTAL_CODE
    WHERE CHINOOK.EMPLOYEE.EMPLOYEEID = EMP_ID;
    COMMIT;
END;

BEGIN
    CHINOOK.UPDATE_EMPLOYEE(11, 'JAMES', 'JONES', '01-MAR-98', '543 GREEN ST', 'JOHNSON', 'FLORIDA', 'USA', 10000);
END;
-- Task � Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE SEE_MANAGER(
    EMP_ID IN CHINOOK.EMPLOYEE.EMPLOYEEID%TYPE,
    MANAGER_NAME OUT VARCHAR2
    )
IS
    TEMP_NUM CHINOOK.EMPLOYEE.EMPLOYEEID%TYPE;
    TEMP_FN CHINOOK.EMPLOYEE.FIRSTNAME%TYPE;
    TEMP_LN CHINOOK.EMPLOYEE.LASTNAME%TYPE;
BEGIN
    SELECT CHINOOK.EMPLOYEE.REPORTSTO INTO TEMP_NUM 
    FROM CHINOOK.EMPLOYEE
    WHERE CHINOOK.EMPLOYEE.EMPLOYEEID = EMP_ID;
    SELECT CHINOOK.EMPLOYEE.FIRSTNAME, CHINOOK.EMPLOYEE.LASTNAME INTO TEMP_FN, TEMP_LN 
    FROM CHINOOK.EMPLOYEE
    WHERE CHINOOK.EMPLOYEE.EMPLOYEEID = TEMP_NUM;
    MANAGER_NAME := (TEMP_FN||' '||TEMP_LN);
    DBMS_OUTPUT.PUT_LINE(MANAGER_NAME);
END;
/
DECLARE
    MANAGER_NAME CHINOOK.EMPLOYEE.FIRSTNAME%TYPE;
BEGIN
    SEE_MANAGER(2, MANAGER_NAME);
END;

-- 4.3 Stored Procedure Output Parameters
-- Task � Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE CUSTOMER_AND_COMPANY(CUST_ID IN CHINOOK.CUSTOMER.CUSTOMERID%TYPE, CUST_NAME OUT VARCHAR, 
CUST_COMPANY OUT CHINOOK.CUSTOMER.COMPANY%TYPE)
IS
    TEMP_FN CHINOOK.CUSTOMER.FIRSTNAME%TYPE;
    TEMP_LN CHINOOK.CUSTOMER.LASTNAME%TYPE;
BEGIN
    SELECT CHINOOK.CUSTOMER.FIRSTNAME, CHINOOK.CUSTOMER.LASTNAME, CHINOOK.CUSTOMER.COMPANY INTO TEMP_FN, TEMP_LN, CUST_COMPANY
    FROM CHINOOK.CUSTOMER 
    WHERE CHINOOK.CUSTOMER.CUSTOMERID = CUST_ID;
    CUST_NAME := (TEMP_FN|| ' ' ||TEMP_LN);
    DBMS_OUTPUT.PUT_LINE(CUST_NAME|| ' ' ||CUST_COMPANY);
END;
/
DECLARE
CUST_NAME CHINOOK.CUSTOMER.FIRSTNAME%TYPE;
CUST_COMPANY CHINOOK.CUSTOMER.COMPANY%TYPE;
BEGIN
    CUSTOMER_AND_COMPANY(1, CUST_NAME, CUST_COMPANY);
END;

-- 5.0 Transactions
-- In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
-- Task � Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE CHINOOK.DELETE_INVOICE(INPUT_INVOICE_ID IN NUMBER)
IS
BEGIN
    DELETE FROM CHINOOK.INVOICE 
    WHERE INPUT_INVOICE_ID = INVOICEID;
    COMMIT;    
END;

-- Task � Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE INSERT_CUSTOMER(
    EMPLOYEEID CHINOOK.CUSTOMER.CUSTOMERID%TYPE,
    FIRSTNAME CHINOOK.CUSTOMER.FIRSTNAME%TYPE,
    LASTNAME CHINOOK.CUSTOMER.LASTNAME%TYPE,
    COMPANY CHINOOK.CUSTOMER.COMPANY%TYPE,
    ADDRESS CHINOOK.CUSTOMER.ADDRESS%TYPE,
    CITY CHINOOK.CUSTOMER.CITY%TYPE,
    STATE CHINOOK.CUSTOMER.STATE%TYPE,
    COUNTRY CHINOOK.CUSTOMER.COUNTRY%TYPE,
    POSTALCODE CHINOOK.CUSTOMER.POSTALCODE%TYPE,
    PHONENUMBER CHINOOK.CUSTOMER.PHONE%TYPE,
    FAXNUMBER CHINOOK.CUSTOMER.FAX%TYPE,
    EMAIL CHINOOK.CUSTOMER.EMAIL%TYPE,
    SUPPORTID CHINOOK.CUSTOMER.SUPPORTREPID%TYPE)
IS
BEGIN
   INSERT INTO CHINOOK.CUSTOMER VALUES(EMPLOYEEID, FIRSTNAME,
   LASTNAME, COMPANY, ADDRESS, CITY, STATE,
   COUNTRY, POSTALCODE, PHONENUMBER, FAXNUMBER,
   EMAIL, SUPPORTID);
   COMMIT;
END;

-- 6.0 Triggers
-- In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
-- 6.1 AFTER/FOR
-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER NEW_EMPLOYEE
AFTER INSERT ON CHINOOK.EMPLOYEE
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('NEW EMPLOYEE ADDED SUCCESSFULLY');
END;

INSERT INTO CHINOOK.Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (11, 'GRUBER', 'STRUBER', 'IT Staff', 6, TO_DATE('1968-1-9 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2004-3-4 00:00:00','yyyy-mm-dd hh24:mi:ss'), '913 7 ST NW', 'Lethbridge', 'AB', 'Canada', 'T1H 1Y8', '+1 (403) 367-3351', '+1 (403) 467-8742', 'GOOBER@chinookcorp.com');

-- Task � Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER UPDATE_ALBUM
AFTER UPDATE ON CHINOOK.ALBUM
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('ALBUM UPDATED SUCCESSFULLY');
END;
-- Task � Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER DELETE_CUSTOMER
AFTER DELETE ON CHINOOK.EMPLOYEE
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('CUSTOMER DELETED SUCCESSFULLY');
END;

-- 7.0 JOINS
-- In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
-- 7.1 INNER
-- Task � Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT 
    CHINOOK.CUSTOMER.FIRSTNAME AS FIRST_NAME,
    CHINOOK.CUSTOMER.LASTNAME AS LAST_NAME,
    CHINOOK.INVOICE.INVOICEID AS INVOICE_ID
FROM CHINOOK.CUSTOMER
INNER JOIN CHINOOK.INVOICE
ON CHINOOK.CUSTOMER.CUSTOMERID = CHINOOK.INVOICE.CUSTOMERID;

-- 7.2 OUTER
-- Task � Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT
    CHINOOK.CUSTOMER.CUSTOMERID AS CUSTOMER_ID,
    CHINOOK.CUSTOMER.FIRSTNAME AS FIRST_NAME,
    CHINOOK.CUSTOMER.LASTNAME AS LAST_NAME,
    CHINOOK.INVOICE.INVOICEID AS INVOICE_ID,
    CHINOOK.INVOICE.TOTAL AS TOTAL
FROM CHINOOK.CUSTOMER
RIGHT OUTER JOIN CHINOOK.INVOICE
ON CHINOOK.CUSTOMER.CUSTOMERID = CHINOOK.INVOICE.CUSTOMERID;

-- 7.3 RIGHT
-- Task � Create a right join that joins album and artist specifying artist name and title.
SELECT
    CHINOOK.ARTIST.NAME AS ARTIST,
    CHINOOK.ALBUM.TITLE AS ALBUM_TITLE
FROM CHINOOK.ALBUM
RIGHT OUTER JOIN CHINOOK.ARTIST
ON CHINOOK.ARTIST.ARTISTID = CHINOOK.ALBUM.ARTISTID;

-- 7.4 CROSS
-- Task � Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT
    CHINOOK.ARTIST.NAME AS ARTIST,
    CHINOOK.ALBUM.TITLE AS ALBUM_TITLE
FROM CHINOOK.ALBUM
CROSS JOIN CHINOOK.ARTIST
ORDER BY CHINOOK.ARTIST.NAME;

-- 7.5 SELF
-- Task � Perform a self-join on the employee table, joining on the reportsto column.
SELECT
   CONCAT(E.FIRSTNAME, E.LASTNAME) AS EMPLOYEE,
   CONCAT(B.FIRSTNAME, B.LASTNAME) AS MANAGER
FROM 
    CHINOOK.EMPLOYEE E
INNER JOIN 
    CHINOOK.EMPLOYEE B ON B.EMPLOYEEID = E.REPORTSTO;
