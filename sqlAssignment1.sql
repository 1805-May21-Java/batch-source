SET SERVEROUTPUT ON;
--2.1

SELECT * 
FROM CHINOOK.EMPLOYEE; 
-- selects everything from employee

SELECT * 
FROM CHINOOK.EMPLOYEE
WHERE LASTNAME LIKE 'King'; 
--case sensitive, where statement allows you to enter a boolean that only returns when true

SELECT *
FROM CHINOOK.EMPLOYEE
WHERE FIRSTNAME LIKE 'Andrew'
AND REPORTSTO is NULL;  
-- And allows you to connect booleans, null is a value by itself so it has to equal null, not be like null

--2.2
SELECT *
FROM CHINOOK.ALBUM
ORDER BY TITLE DESC; 
--order by lets you select how it orders the rows, so this orders by the title.  DESC makes it go in descending order, 
--default is asc

SELECT FIRSTNAME
FROM CHINOOK.CUSTOMER 
ORDER BY CITY;
--can order by different fields than are selected, don't need to say asc because that's the default

--2.3
INSERT INTO CHINOOK.GENRE
VALUES(26,'Punk');

INSERT INTO CHINOOK.GENRE
VALUES(27,'Ska');
--Need to increment id by 1, put values keyword before the new input

INSERT INTO CHINOOK.EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME)
VALUES(9,'Bullington','Brian');

INSERT INTO CHINOOK.EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME)
VALUES(10,'Palmer','Jeremy');

--Specified the employee id and first and last names because those were the not-nullable fields

INSERT INTO CHINOOK.CUSTOMER (CUSTOMERID, LASTNAME, FIRSTNAME,EMAIL)
VALUES(60,'Baker','Stuart','stuartbaker@revature.com');

INSERT INTO CHINOOK.CUSTOMER (CUSTOMERID, LASTNAME, FIRSTNAME,EMAIL)
VALUES(61,'Cahr','Ian','Iancahr@revature.com');

--Now the email field is also not nullable

--2.4
UPDATE CHINOOK.CUSTOMER SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

--Can do multiple updates with commas, selected only Aaron Mitchell by specifying in the where clause

UPDATE CHINOOK.ARTIST SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';

--Similar to previous, set only the name you want by selecting the name

--2.5 
SELECT * FROM CHINOOK.INVOICE WHERE BILLINGADDRESS LIKE 'T%';

--by doing 'like T%' you get every enter that starts with T but can have anything after

--2.6
SELECT * FROM CHINOOK.INVOICE WHERE TOTAL BETWEEN 15 AND 50;
--Between lets you get entries between two values by specifing the lower limit AND upper limit

SELECT * FROM CHINOOK.EMPLOYEE WHERE HIREDATE BETWEEN DATE '2003-6-1' AND DATE '2004-3-1';
--do dates by using DATE then 'year-month-day'

--2.7
ALTER TABLE CHINOOK.INVOICE
DROP CONSTRAINT FK_INVOICECUSTOMERID; 

ALTER TABLE CHINOOK.INVOICE
ADD CONSTRAINT FK_INVOICECUSTOMERID 
FOREIGN KEY (CUSTOMERID) REFERENCES CHINOOK.CUSTOMER
ON DELETE CASCADE;

ALTER TABLE CHINOOK.INVOICELINE
DROP CONSTRAINT FK_INVOICELINEINVOICEID;

ALTER TABLE CHINOOK.INVOICELINE
ADD CONSTRAINT FK_INVOICELINEINVOICEID 
FOREIGN KEY (INVOICEID) REFERENCES CHINOOK.INVOICE 
ON DELETE CASCADE;

DELETE FROM CHINOOK.CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

--Had to drop both constraints and change them to cascading delete before it's safe to delete Robert Walter, or else
--there will be foreign keys that reference rows that don't exist

--3.1

CREATE OR REPLACE FUNCTION CHINOOK.SHOW_DATE_TIME
RETURN VARCHAR2
IS 
BEGIN
    RETURN TO_CHAR(CURRENT_TIMESTAMP, ('HH:MM:SS'));
END;

SELECT CHINOOK.SHOW_DATE_TIME() FROM DUAL;

--Creates a function that returns a varchar2, calls current timestamp which gets the date and time, 
--then formats it to just show the time

CREATE OR REPLACE FUNCTION CHINOOK.LENGTH_NAME(NAME VARCHAR2)
RETURN NUMBER
IS
BEGIN
    RETURN LENGTH(NAME);
END;

--takes in a varchar name, then returns the length function which finds the length of a varchar input.

--3.2 
CREATE OR REPLACE FUNCTION CHINOOK.TOTAL_INVOICES
RETURN NUMBER
IS 
TOTAL NUMBER(6,2);
BEGIN
    SELECT AVG(TOTAL) INTO TOTAL FROM CHINOOK.INVOICE;
    RETURN TOTAL;
    
END;

--creates a function that uses the average function to average the totals in invoice and puts it in a variable, then returns it

CREATE OR REPLACE FUNCTION CHINOOK.MOST_EXPENSIVE
RETURN SYS_REFCURSOR
IS 
CUR SYS_REFCURSOR;
TOTAL NUMBER(6,2);
BEGIN
    OPEN CUR FOR
    SELECT NAME 
    FROM CHINOOK.TRACK
    WHERE UNITPRICE =
    (SELECT MAX(UNITPRICE) FROM CHINOOK.TRACK);
    RETURN CUR;
END;

DECLARE
CUR SYS_REFCURSOR;
BEGIN
    CUR := CHINOOK.MOST_EXPENSIVE();
    DBMS_SQL.RETURN_RESULT(CUR);
END;

--returns a cursor of the most expensive tracks, tied

--3.3

CREATE OR REPLACE FUNCTION CHINOOK.AVERAGE_PRICE_INVOICELINE
RETURN NUMBER
IS 
TOTAL NUMBER(6,2);
NUMITEMS NUMBER(5);
AVERAGE NUMBER(6,2);
BEGIN
    SELECT SUM(UNITPRICE) INTO TOTAL FROM CHINOOK.INVOICELINE;
    SELECT COUNT(UNITPRICE) INTO NUMITEMS FROM CHINOOK.INVOICELINE;
    AVERAGE := TOTAL/NUMITEMS;
    RETURN AVERAGE;
END;

SET SERVEROUTPUT ON;

--BEGIN
 --   DBMS_OUTPUT.PUT_LINE(CHINOOK.AVERAGE_PRICE_INVOICELINE());
--END;

--finds the total cost, the total number of items, then puts it in an average variable so it can round.  Returns that number

--3.4
CREATE OR REPLACE FUNCTION CHINOOK.YOUNGER_EMPLOYEES
RETURN SYS_REFCURSOR
IS
CURS SYS_REFCURSOR;
BEGIN 
        OPEN CURS FOR
        SELECT *
        FROM CHINOOK.EMPLOYEE
        WHERE BIRTHDATE > DATE '1969-1-1';
        
        RETURN CURS;
END;

DECLARE
CURS SYS_REFCURSOR;
BEGIN
    CURS := CHINOOK.YOUNGER_EMPLOYEES();
    DBMS_SQL.RETURN_RESULT(CURS);
    CLOSE CURS;
END;

--create a cursor that gets all employees born after a certain date, then prints it
    
--4.1
    
CREATE OR REPLACE PROCEDURE CHINOOK.FIRST_LAST_NAME(S out SYS_REFCURSOR)
IS
BEGIN
    OPEN S FOR
    SELECT FIRSTNAME,LASTNAME FROM CHINOOK.EMPLOYEE;
END;

DECLARE
NAME_CURSOR SYS_REFCURSOR;
FIRSTNAME VARCHAR2(60);
LASTNAME VARCHAR2(60);
BEGIN
    CHINOOK.FIRST_LAST_NAME(NAME_CURSOR);
    LOOP
        FETCH NAME_CURSOR INTO FIRSTNAME, LASTNAME;
        EXIT WHEN NAME_CURSOR%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(FIRSTNAME || ' ' || LASTNAME);
    END LOOP;
    CLOSE NAME_CURSOR;
END;

--procedure creates a cursor with the first and last names, then it can be printed out in a loop
--4.2

CREATE OR REPLACE PROCEDURE CHINOOK.UPDATEINFO
IS
BEGIN
    UPDATE CHINOOK.EMPLOYEE SET CITY = 'Chicago' WHERE FIRSTNAME = 'Brian';
END;

--Updates Brian to be in Chicago

CREATE OR REPLACE PROCEDURE RETURN_MANAGER
IS
MANAGER_ID NUMBER;
BEGIN
    SELECT REPORTSTO INTO MANAGER_ID FROM CHINOOK.EMPLOYEE WHERE FIRSTNAME = 'Nancy';
    DBMS_OUTPUT.PUT_LINE(MANAGER_ID);
END RETURN_MANAGER;

--Returns the manager of Nancy Edwards

--4.3
CREATE OR REPLACE PROCEDURE CHINOOK.GET_CUSTOMER_INFO(INPUT_CUSTORMERID IN NUMBER,
    CUST_FIRST_NAME OUT VARCHAR2, CUST_LAST_NAME OUT VARCHAR2, CUST_COMPANY OUT VARCHAR2)
IS
BEGIN
    SELECT FIRSTNAME, LASTNAME, COMPANY
    INTO CUST_FIRST_NAME, CUST_LAST_NAME, CUST_COMPANY
    FROM CHINOOK.CUSTOMER 
    WHERE INPUT_CUSTORMERID = CUSTOMERID;
END;

--matches the customer id to existing id, then selects those columns into the appropriate output variables

--5.0
--from 2.7 already replaced the FK constraint in invoice to on delete cascade, so deleting an invoice will not cause a problem
--in invoiceline
CREATE OR REPLACE PROCEDURE CHINOOK.DELETE_TRANSACTION(INPUT_INVOICE_ID IN NUMBER)
IS
BEGIN
    DELETE FROM CHINOOK.INVOICE 
    WHERE INPUT_INVOICE_ID = INVOICEID;
    COMMIT;    
END;

--deletes record matching the inputted invoice id

CREATE OR REPLACE PROCEDURE CHINOOK.INSERT_NEW_RECORD
IS
BEGIN
    INSERT INTO CHINOOK.CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES(62,'Phil','Coulson','.@rev');
    COMMIT;
END;

--6.0

--First, create a table to log these events
CREATE TABLE CHINOOK.LOG(MESSAGE VARCHAR2(60));


CREATE OR REPLACE TRIGGER CHINOOK.SAY_HI_TO_NEW_EMPLOYEE
AFTER INSERT ON CHINOOK.EMPLOYEE
FOR EACH ROW
BEGIN
    INSERT INTO CHINOOK.LOG VALUES('Hi, '||:NEW.FIRSTNAME);
END;

--whenever a new employee is entered, a welcome message is logged

CREATE OR REPLACE TRIGGER CHINOOK.NEW_ALBUM
AFTER UPDATE ON CHINOOK.ALBUM
FOR EACH ROW
BEGIN
    INSERT INTO CHINOOK.LOG VALUES('Artist changed their mind, the album is now called: '||:NEW.TITLE);
END;

--Whenever there's a new album released it logs the new name

CREATE OR REPLACE TRIGGER CHINOOK.GOODBYE
AFTER DELETE ON CHINOOK.CUSTOMER
BEGIN
    INSERT INTO CHINOOK.LOG VALUES('Goodbye!');
END;

--logs goodbye when record deleted

--7.1
SELECT C.FIRSTNAME "FIRST NAME", C.LASTNAME "LAST NAME", I.INVOICEID INVOICE
FROM CHINOOK.CUSTOMER C
JOIN CHINOOK.INVOICE I
ON C.CUSTOMERID = I.CUSTOMERID;

--inner joined on where the customer and invoice have the same ID, returning only rows where they are the same and 
--combining the tables when that happens

--7.2
SELECT C.CUSTOMERID "CUSTOMER ID", C.FIRSTNAME "FIRST NAME", C.LASTNAME "LAST NAME", I.INVOICEID INVOICE, I.TOTAL
FROM CHINOOK.CUSTOMER C
FULL JOIN CHINOOK.INVOICE I
ON C.CUSTOMERID = I.CUSTOMERID;

--outer joins on where the customer and invoices, returning all rows from both tables and combining the rows when they share
--a customerid

--7.3
SELECT ARTIST.NAME "ARTIST NAME", ALBUM.TITLE TITLE
FROM CHINOOK.ARTIST
RIGHT JOIN CHINOOK.ALBUM
ON ARTIST.ARTISTID = ALBUM.ARTISTID;

--right join on artist and album, returning all albums and adding the artist name when the artist id's match

--7.4
SELECT *
FROM CHINOOK.ARTIST
CROSS JOIN CHINOOK.ALBUM
WHERE ARTIST.ARTISTID = ALBUM.ARTISTID
ORDER BY ARTIST.NAME;

--returns every combination of album and artist when the artist id's match.  Identitical to an inner join

--7.5
SELECT * 
FROM CHINOOK.EMPLOYEE E1, CHINOOK.EMPLOYEE E2
WHERE E1.REPORTSTO = E2.REPORTSTO;

--combines every record where they report to the same person

--