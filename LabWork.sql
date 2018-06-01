/**
2.1 SELECT

Task 1-SELECT* grabs all the data from the table EMPLOYEE

Task 2- WHERE is a condition that allows me to return a specified value

Task3- WHERE and AND IS are used to retrieve the data
**/
SELECT*
FROM CHINOOK.EMPLOYEE;

SELECT*
FROM CHINOOK.EMPLOYEE WHERE LASTNAME = 'King';

SELECT*
FROM CHINOOK.EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

/**
2.2 ORDER BY

Task 1- ORBER BY TITLE DESC is what sorts the ablum table by title
in descending order

Task2- needed to SELECT from first name instead of the entire table, and ORDER BY CITY that result

Task3- 
**/
SELECT*
FROM CHINOOK.ALBUM ORDER BY TITLE DESC;

SELECT FIRSTNAME
FROM CHINOOK.CUSTOMER
ORDER BY CITY;

/**
2.3 INSERT INTO
Task1- INSERT INTO was used here along with VALUES to pass in the GENREID and NAME

Task2- INSERT INTO was used again same as last time

Task3- same thing as the previous two
**/
INSERT INTO CHINOOK.GENRE VALUES(26, 'Techno');
INSERT INTO CHINOOK.GENRE VALUES(27, 'Anime');

INSERT INTO CHINOOK.EMPLOYEE VALUES (9, 'Bramhall', 'Stefa', 'Engineer II', 2, '11-NOV-60', '13-OCT-01', '2 Rutledge Parkway', 'Kamsack', 'Saskatchewan', 'Canada', 'R2J', '840-442-5786', '840-209-5467', 'sbramhall0@nytimes.com');
INSERT INTO CHINOOK.EMPLOYEE VALUES(10, 'Aizik', 'Lynelle', 'Nuclear Power Engineer', 4, '22/OCT/1975', '26/APR/2000', '338 Mifflin Place', 'Keswick', 'Ontario', 'Canada', 'L4P', '687-415-5504', '651-923-8947', 'laizik1@t.co');

INSERT INTO CHINOOK.CUSTOMER VALUES (60, 'Erick', 'Santo', 'Help Desk Operator', '015 Upham Avenue', 'Bugko', null, 'Philippines', '6417', '+63 (803) 177-2578', '+62 (688) 461-4123', 'esanto0@usda.gov', 5);
INSERT INTO CHINOOK.CUSTOMER VALUES (61, 'Loree', 'Knowling', 'Senior Cost Accountant', '49 Farmco Street', 'Bahía Honda', null, 'Cuba', null, '+53 (273) 493-4277', '+47 (366) 904-3059', 'lknowling1@wired.com', 3);

/**
2.4 UPDATE
Task1 - used the UPDATE function to pass in the new values and looked it up by customerid setting it with SET

Task2- same as previous task 
**/

UPDATE CHINOOK.CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE CUSTOMERID = 32;

UPDATE CHINOOK.ARTIST
SET NAME = 'CCR'
WHERE ARTISTID = 76;

/**
2.5 LIKE

Task1- the % is the operator wild card operator, in this case we wanted billing addresses that started with a T
**/

SELECT*
FROM CHINOOK.INVOICE
WHERE BILLINGAdDRESS LIKE 'T%';

/**
2.6 BETWEEN

Task1- the between keyword is used to select the entries between the specified values

Task2- same as the first take
**/

SELECT*
FROM CHINOOK.INVOICE
WHERE TOTAL BETWEEN 15 AND 50;

SELECT*
FROM CHINOOK.EMPLOYEE
WHERE HIREDATE BETWEEN '1-JUN-03' AND '1-MAR-04';

/**
2.7 DELETE

Task1- had to alter the invoice table first because it had a foreign key that was pointing at customer id
so I had to drop it
**/

ALTER TABLE CHINOOK.INVOICE DROP CONSTRAINT FK_INVOICECUSTOMERID;
DELETE FROM CHINOOK.CUSTOMER
WHERE CUSTOMERID = 32;

/**
3.1 SYSTEM DEFINED FUNCTIONS

Task1- used the built in functions TO_CHAR and SYSDATE to retrieve the time

Task2- used the built in function of length to get the lengths of each name
**/

SELECT TO_CHAR(SYSDATE,'HH24:MI')
FROM DUAL;

SELECT LENGTH(NAME)
FROM CHINOOK.MEDIATYPE;

/**
3.2 SYSTEM DEFINED AGGREGATE FUNCTIONS
Task1- used the aggregate function AVG to calcuate the average of the column total

Task2- used the aggregate function MAX to return the highest unit price
**/

SELECT AVG(TOTAL)
FROM CHINOOK.INVOICE;

SELECT MAX(UNITPRICE)
FROM CHINOOK.TRACK;

/**
3.3 USER DEFINED SCALAR FUNCTIONS

Task1- created a function that calculated the average of the unitprice column and returned it, then called the function
and printed it out to the output
**/
CREATE OR REPLACE FUNCTION CHINOOK.GETPRICE RETURN NUMBER
IS NUM NUMBER;
BEGIN
    SELECT AVG(UNITPRICE)
    INTO NUM 
    FROM CHINOOK.INVOICELINE;
    RETURN NUM;
END GETPRICE;
/
SET SERVEROUTPUT ON;
DECLARE NUM NUMBER;
BEGIN
    NUM := CHINOOK.GETPRICE();
    DBMS_OUTPUT.PUT_LINE(NUM);
END;
/

/**
3.4 USER DEFINED VALUED FUNCTIONS
Task1- used a SYS_REFCURSOR to get the information and then called SELECT on DUAL to retrieve it
**/

CREATE OR REPLACE FUNCTION CHINOOK.GETEMP( EMP IN VARCHAR2 ) RETURN SYS_REFCURSOR
IS
RET SYS_REFCURSOR;
BEGIN
  OPEN RET
   FOR SELECT *
        FROM CHINOOK.EMPLOYEE
        WHERE BIRTHDATE > EMP;
  RETURN RET;
END;
/
SELECT CHINOOK.GETEMP('31-DEC-68') FROM DUAL;

/**
4.1 BASIC STORED PROCEDURE
Task1- created a procedure to put out a cursor wit the information, I then called that procedure and looped it to print out
the result
**/

CREATE OR REPLACE PROCEDURE CHINOOK.GETNAMES(S OUT SYS_REFCURSOR) 
IS
BEGIN
    OPEN S FOR
    SELECT FIRSTNAME, LASTNAME FROM CHINOOK.EMPLOYEE;
END;
/
DECLARE
    SVAR SYS_REFCURSOR;
    FIRST_NAME CHINOOK.EMPLOYEE.FIRSTNAME%TYPE;
    LAST_NAME CHINOOK.EMPLOYEE.LASTNAME%TYPE;

BEGIN
    CHINOOK.GETNAMES(SVAR);
    LOOP
        FETCH SVAR INTO FIRST_NAME, LAST_NAME;
        EXIT WHEN SVAR%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(FIRST_NAME||' IS FIRST NAME, '||LAST_NAME||' IS LAST NAME');
    END LOOP;
    CLOSE SVAR;
END;
/

/**
4.2 STORED PROCEDURE INPUT PARAMETERS
Task1- created a procedure that took the employee ID and new address and then updated the table with that information,
ran the procedure and then used a select to display that the information had changed

Task2- first created a procedure that took in an employee id and return their manager'S id I then
made some variables to store the data in called the procedure and printed out the result
**/

CREATE OR REPLACE PROCEDURE CHINOOK.UPDATE_INFO(EMPID IN NUMBER, ADDRESS_IN IN VARCHAR2)
IS
BEGIN
    UPDATE CHINOOK.EMPLOYEE
    SET ADDRESS = ADDRESS_IN
    WHERE EMPLOYEEID = EMPID;
END;
/

BEGIN
    CHINOOK.UPDATE_INFO(8, '213 Main ST');
END;
/
SELECT ADDRESS FROM CHINOOK.EMPLOYEE WHERE EMPLOYEEID = 8;

CREATE OR REPLACE PROCEDURE CHINOOK.RETURN_MANAGER(EMPID IN NUMBER, MANGID OUT NUMBER)
IS
BEGIN  
    SELECT REPORTSTO
    INTO MANGID
    FROM CHINOOK.EMPLOYEE WHERE EMPLOYEEID = EMPID;
END;
/
SET SERVEROUTPUT ON;
DECLARE
    MANAGER_ID NUMBER;
    MANG_FIRSTNAME VARCHAR2(20);
    MANG_LASTNAME VARCHAR2(20);
BEGIN
    CHINOOK.RETURN_MANAGER(3,MANAGER_ID);
    SELECT FIRSTNAME, LASTNAME 
    INTO MANG_FIRSTNAME, MANG_LASTNAME
    FROM CHINOOK.EMPLOYEE WHERE EMPLOYEEID = MANAGER_ID;
    DBMS_OUTPUT.PUT_LINE(MANG_FIRSTNAME||' '||MANG_LASTNAME);
END;
/

/**
4.3 STORED PROCEDURE OUTPUT PARAMETERS
Task1- this task was similar to the one before. I created a procedure that returned the name and company of a customer
I then called the function and printed out the result;
**/
CREATE OR REPLACE PROCEDURE CHINOOK.GET_CUSTOMER(CUSTID IN NUMBER, FIRST_NAME OUT VARCHAR2, LAST_NAME OUT VARCHAR2, COMPANYIN OUT VARCHAR2)
IS
BEGIN
    SELECT FIRSTNAME, LASTNAME, COMPANY
    INTO FIRST_NAME, LAST_NAME, COMPANYIN
    FROM CHINOOK.CUSTOMER
    WHERE CUSTOMERID = CUSTID;
END;
/

SET SERVEROUTPUT ON;
DECLARE
    CUST_FIRSTNAME VARCHAR2(20);
    CUST_LASTNAME VARCHAR2(20);
    CUST_COMPANY VARCHAR2(30);
BEGIN
    CHINOOK.GET_CUSTOMER(16,CUST_FIRSTNAME, CUST_LASTNAME, CUST_COMPANY);
    DBMS_OUTPUT.PUT_LINE(CUST_FIRSTNAME||' '||CUST_LASTNAME||' '||CUST_COMPANY);
END;
/
/**
5.0 TRANCSACTIONS
Tas1k- altered the table invoiceline removing the constraint that relied on someting from the table invoice
then deleted a invoce table row
Task2– Create a transaction nested within a stored procedure that inserts a new record in the Customer table
**/

ALTER TABLE CHINOOK.INVOICELINE DROP CONSTRAINT FK_INVOICELINEINVOICEID;
DELETE FROM CHINOOK.INVOICE WHERE INVOICEID = 111;

CREATE OR REPLACE PROCEDURE CHINOOK.INSERT_CUST(CUSTID IN NUMBER, FIRSTNAME IN VARCHAR2, LASTNAME IN VARCHAR2, EMAIL IN VARCHAR2)
IS
BEGIN
    INSERT INTO CHINOOK.CUSTOMER VALUES(CUSTID, FIRSTNAME, LASTNAME, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, EMAIL, NULL);
END;
/

BEGIN
    CHINOOK.INSERT_CUST(62, 'JAMES', 'BOND', 'bondjamesbond@gmail.com');
END;
/

/**
6.1 TRIGGER AFTER/FLOOR 
Task1- created a trigger with after insert and just had it print out a simple statement show it fired

Task2- created a trigger with an update to album that fires after an insert occurs

Task3- created a trigger with a simple output that fired after a row was deleted from the table
I had to remove a constraint to alter the table before deleting the row
**/
SET SERVEROUTPUT ON;
CREATE OR REPLACE TRIGGER CHINOOK.TR_AFTER_INSERT
AFTER INSERT ON CHINOOK.EMPLOYEE
BEGIN
    DBMS_OUTPUT.PUT_LINE('Trigger fired after an insert');
END;
/
BEGIN
    INSERT INTO CHINOOK.EMPLOYEE VALUES(13, 'James', 'Bond', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
END;
/

CREATE OR REPLACE TRIGGER CHINOOK.TR_UPDATE
AFTER INSERT ON CHINOOK.ALBUM
BEGIN
    UPDATE CHINOOK.ALBUM
    SET TITLE = 'POP1'
    WHERE ALBUMID = 236;
END;
/

BEGIN
    INSERT INTO CHINOOK.ALBUM VALUES(348, 'Electronic Dance', 275);
END;
/

CREATE OR REPLACE TRIGGER CHINOOK.TR_DELETE
AFTER DELETE ON CHINOOK.EMPLOYEE
BEGIN
    DBMS_OUTPUT.PUT_LINE('The trigger fired after a delete');
END;
/
ALTER TABLE CHINOOK.EMPLOYEE DROP CONSTRAINT FK_EMPLOYEEREPORTSTO;
BEGIN
    DELETE FROM CHINOOK.EMPLOYEE
    WHERE EMPLOYEEID = 9;
END;
/
/** 7.1 INNER JOIN
Task1- selected the first name and last name from customer and the ivoice id and joined them together with
column headers. they both have customer id columns so I used that to match them
**/

SELECT 
    CHINOOK.CUSTOMER.FIRSTNAME AS "First Name",
    CHINOOK.CUSTOMER.LASTNAME AS "Last Name",
    CHINOOK.INVOICE.INVOICEID AS "Invoice ID"
    FROM CHINOOK.CUSTOMER
    INNER JOIN CHINOOK.INVOICE
    ON CHINOOK.CUSTOMER.CUSTOMERID = CHINOOK.INVOICE.CUSTOMERID;
    
/**
7.2 OUTER JOIN
Task1- selected the required fields and joined them with a outer join using the customer and invoice tables
**/

SELECT
    CHINOOK.CUSTOMER.CUSTOMERID AS "Customer ID",
    CHINOOK.CUSTOMER.FIRSTNAME AS "First Name",
    CHINOOK.CUSTOMER.LASTNAME AS "Last Name",
    CHINOOK.INVOICE.INVOICEID AS "Invoice ID",
    CHINOOK.INVOICE.TOTAL AS "Total"
    FROM CHINOOK.CUSTOMER
    FULL OUTER JOIN CHINOOK.INVOICE
    ON CHINOOK.CUSTOMER.CUSTOMERID = CHINOOK.INVOICE.CUSTOMERID;
    
/**
7.3 RIGHT JOIN
Task1- selected the required fields and joined artist and album tables with a right join
**/

SELECT 
    CHINOOK.ARTIST.NAME "Artist Name",
    CHINOOK.ALBUM.TITLE "Title Name"
    FROM CHINOOK.ARTIST
    RIGHT JOIN CHINOOK.ALBUM
    ON CHINOOK.ARTIST.ARTISTID = CHINOOK.ALBUM.ARTISTID;

/**
7.4 CROSS JOIN
Task1- selected the required fields and cross joined artist and album, used an order by artist name to get it to sort by name
ascending
**/

SELECT
CHINOOK.ALBUM.TITLE AS "Album Title",
CHINOOK.ARTIST.NAME AS "Artist Name"
FROM CHINOOK.ALBUM
CROSS JOIN CHINOOK.ARTIST
ORDER BY CHINOOK.ARTIST.NAME ASC;


/**
7.5 SELF JOIN
Task1- a select statment to gather the info into e1 and then joined it by comparing e1's reportsto value to another select's
employee id
**/

SELECT* FROM CHINOOK.EMPLOYEE e1
WHERE e1.REPORTSTO IN (SELECT EMPLOYEEID FROM CHINOOK.EMPLOYEE);
