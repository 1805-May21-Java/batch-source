SET SERVEROUTPUT ON;
--2.0 SQL Queries, In this section you will be performing various queries against the Oracle Chinook database.
--2.1 SELECT
--Task – Select all records from the Employee table.
SELECT * FROM CHINOOK.EMPLOYEE;

--Task – Select all records from the Employee table where last name is King
SELECT * FROM CHINOOK.EMPLOYEE WHERE LASTNAME='King';

--Task - Select all records from the Employee table where the first name is Andrew and REPORTSTO is NULL
SELECT * FROM CHINOOK.EMPLOYEE WHERE FIRSTNAME='Andrew' AND REPORTSTO IS NULL;

--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM CHINOOK.ALBUM ORDER BY TITLE DESC;

--Task – Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME FROM CHINOOK.CUSTOMER ORDER BY CITY;

--2.3 INSERT INTO
--Task – Insert two new records into Genre table
--SELECT * FROM CHINOOK.GENRE;
INSERT INTO CHINOOK.GENRE VALUES (26, 'Metalcore');
INSERT INTO CHINOOK.GENRE VALUES (27, 'Djent');

--Task – Insert two new records into Employee table
--SELECT * FROM CHINOOK.EMPLOYEE;
INSERT INTO CHINOOK.EMPLOYEE VALUES (9, 'Castro', 'Todd', 'IT Staff', 6,
DATE '1977-03-12', DATE '2016-12-21',
'57 Ave', 'Vegreville', 'AB', 'Canada', 'T9C 1J8',
'+1 (780) 425-1191', '+1 (780) 425-1035', 'todd@chinookcorp.com');
INSERT INTO CHINOOK.EMPLOYEE VALUES (10, 'Ulver', 'Gordie', 'Sales Support Agent', 2,
Date '1976-05-01', DATE '2015-07-07',
'14 St', 'Wainwright', 'AB', 'Canada', 'T9W 1G4',
'+1 (907) 742-1420', '+1 (907) 742-1032', 'gordie@chinookcorp.com');
--also you don't need to include every single field value, just the ID and name

--Task – Insert two new records into Customer table
--SELECT * FROM CHINOOK.CUSTOMER;
INSERT INTO CHINOOK.CUSTOMER VALUES (60, 'Morgan', 'David', NULL,
'23 S Utah Street', 'Pine Bluff', 'AR', 'USA', '71601',
'+1 (870) 642-2163', '+1 (870) 642-2742', 'dmorgan@aol.com', 3);
INSERT INTO CHINOOK.CUSTOMER VALUES (61, 'Vargas', 'Oliver', NULL,
'3179 Hopkins Road', 'Richmond', 'VA', 'USA', '23234',
'+1 (804) 935-1724', '+1 (804) 935-1620', 'ovargas@gmail.com', 5);

--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
--SELECT * FROM CHINOOK.CUSTOMER;
UPDATE CHINOOK.CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE CUSTOMERID = 32;

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
--SELECT * FROM CHINOOK.ARTIST;
UPDATE CHINOOK.ARTIST
SET NAME = 'CCR'
WHERE ARTISTID = 76;

--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
SELECT * FROM CHINOOK.INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM CHINOOK.INVOICE
WHERE TOTAL BETWEEN 15 AND 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM CHINOOK.EMPLOYEE
WHERE HIREDATE BETWEEN DATE '2003-06-01' AND DATE '2004-03-01';

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter
--(There may be constraints that rely on this, find out how to resolve them)
SELECT * FROM CHINOOK.CUSTOMER;
--Constraint exists in Invoice table, with the foreign key FK_INVOICECUSTOMERID
ALTER TABLE CHINOOK.INVOICE DROP CONSTRAINT FK_INVOICECUSTOMERID;
DELETE FROM CHINOOK.CUSTOMER
WHERE CUSTOMERID = 32;

--3. 3. SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION CURRTIME
RETURN TIMESTAMP IS
L_TIMESTAMP TIMESTAMP;
BEGIN
    SELECT CURRENT_TIMESTAMP INTO L_TIMESTAMP FROM DUAL;
    RETURN L_TIMESTAMP;
END;
/
BEGIN
    DBMS_OUTPUT.PUT_LINE(CURRTIME());
END;

--Task – create a function that returns the length of name in MEDIATYPE table
SELECT LENGTH(NAME) "MEDIATYPE_NAME_LENGTH" FROM CHINOOK.MEDIATYPE;
CREATE OR REPLACE FUNCTION MEDIATYPE_NAME_LENGTH (M_ID NUMBER)
RETURN NUMBER IS
L_LENGTH NUMBER;
BEGIN
    SELECT LENGTH(NAME) INTO L_LENGTH FROM CHINOOK.MEDIATYPE
    WHERE CHINOOK.MEDIATYPE.MEDIATYPEID = M_ID;
    RETURN L_LENGTH;
END;
/
BEGIN
    DBMS_OUTPUT.PUT_LINE('Length of first name in MEDIATYPE: '||MEDIATYPE_NAME_LENGTH(1));
END;
--for this one, change the number in MEDIATYPE_NAME_LENGTH(x) to whichever

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices 
CREATE OR REPLACE FUNCTION INVOICE_AVERAGE_TOTAL
RETURN NUMBER IS
L_AVGTOTAL NUMBER;
BEGIN
    SELECT AVG(TOTAL) INTO L_AVGTOTAL FROM CHINOOK.INVOICE;
    RETURN ROUND(L_AVGTOTAL, 2);
END;
/
BEGIN
    DBMS_OUTPUT.PUT_LINE('Average total: $' || INVOICE_AVERAGE_TOTAL());
END;

--Task – Create a function that returns the most expensive track
SELECT MAX(UNITPRICE) "MOST_EXPENSIVE_TRACK" FROM CHINOOK.TRACK;
SELECT NAME FROM CHINOOK.TRACK WHERE UNITPRICE = (SELECT MAX(UNITPRICE) FROM CHINOOK.TRACK);
CREATE OR REPLACE FUNCTION MOST_EXPENSIVE_TRACK
RETURN VARCHAR2 IS
L_EXPTRACK VARCHAR2(200);
BEGIN
    SELECT NAME INTO L_EXPTRACK FROM CHINOOK.TRACK WHERE UNITPRICE = (SELECT MAX(UNITPRICE) FROM CHINOOK.TRACK) AND ROWNUM <= 1;
    RETURN L_EXPTRACK;
END;
/
BEGIN
    DBMS_OUTPUT.PUT_LINE('Most expensive track: '||MOST_EXPENSIVE_TRACK());
END;

--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
SELECT ROUND(AVG(UNITPRICE), 2) "AVERAGE_PRICE" FROM CHINOOK.INVOICELINE;
CREATE OR REPLACE FUNCTION AVG_PRICELINE
RETURN NUMBER IS
L_TOTAL NUMBER(6,2);
L_ITEMS NUMBER(5);
L_AVGPRICE NUMBER(6,2);
BEGIN
    --simple calculation for average, sum total from invoiceline then divide by amount of items
    --may be better to use AVG instead
    SELECT SUM(UNITPRICE) INTO L_TOTAL FROM CHINOOK.INVOICELINE;
    SELECT COUNT(UNITPRICE) INTO L_ITEMS FROM CHINOOK.INVOICELINE;
    L_AVGPRICE := L_TOTAL/L_ITEMS;
    RETURN L_AVGPRICE;
END;
/
BEGIN
    DBMS_OUTPUT.PUT_LINE('Average price of invoiceline: $'||AVG_PRICELINE);
END;

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
SELECT * FROM CHINOOK.EMPLOYEE WHERE EXTRACT(YEAR FROM TO_DATE(BIRTHDATE, 'DD-MON-RR')) > 1968;
CREATE OR REPLACE FUNCTION CHINOOK.PAST1968
RETURN SYS_REFCURSOR IS
SVAR SYS_REFCURSOR;
BEGIN
    OPEN SVAR FOR
    SELECT * FROM CHINOOK.EMPLOYEE WHERE BIRTHDATE > DATE '1969-1-1';
    RETURN SVAR;
END;
/
DECLARE
SVAR SYS_REFCURSOR;
BEGIN
    SVAR := CHINOOK.PAST1968();
    DBMS_SQL.RETURN_RESULT(SVAR);
    CLOSE SVAR;
END;
--4.0 Stored Procedures
--In this section you will be creating and executing stored procedures.
--You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
--SELECT FIRSTNAME, LASTNAME FROM CHINOOK.EMPLOYEE;
CREATE OR REPLACE PROCEDURE EMPLOYEE_NAMES (S OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN S FOR
    SELECT FIRSTNAME, LASTNAME FROM CHINOOK.EMPLOYEE;
END;
/
DECLARE
    SVAR SYS_REFCURSOR;
    TEMP_FNAME CHINOOK.EMPLOYEE.FIRSTNAME%TYPE;
    TEMP_LNAME CHINOOK.EMPLOYEE.LASTNAME%TYPE;
BEGIN
    EMPLOYEE_NAMES(SVAR);
    LOOP
        FETCH SVAR INTO TEMP_FNAME, TEMP_LNAME;
        EXIT WHEN SVAR%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(TEMP_FNAME||' '||TEMP_LNAME);
    END LOOP;
    CLOSE SVAR;
END;
--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE CHINOOK.UPDATE_INFO(
    p_id IN CHINOOK.EMPLOYEE.EMPLOYEEID%TYPE,
    p_address IN CHINOOK.EMPLOYEE.ADDRESS%TYPE)
IS
BEGIN
    UPDATE CHINOOK.EMPLOYEE SET CHINOOK.EMPLOYEE.ADDRESS = p_address WHERE CHINOOK.EMPLOYEE.EMPLOYEEID = p_id;
    COMMIT;
END;
/
BEGIN
    CHINOOK.UPDATE_INFO(9, '47 Ave');
END;
--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE EMPLOYEE_MGR(EMP_ID IN NUMBER)
IS
TEMP VARCHAR2(20);
TEMP2 VARCHAR2(20);
TEMP3 VARCHAR2(20);
TEMP4 VARCHAR2(20);
BEGIN
    SELECT MGR.FIRSTNAME, MGR.LASTNAME,
           EMP.FIRSTNAME, EMP.LASTNAME
           INTO TEMP, TEMP2, TEMP3, TEMP4
    FROM CHINOOK.EMPLOYEE EMP
    INNER JOIN CHINOOK.EMPLOYEE MGR
    ON MGR.EMPLOYEEID = EMP.REPORTSTO
    WHERE EMP.EMPLOYEEID = EMP_ID;
    DBMS_OUTPUT.PUT_LINE(TEMP||' ' ||TEMP2||' is the manager of '||TEMP3||' '||TEMP4);
END;
/
BEGIN
    EMPLOYEE_MGR(6);
END;
--NOTE: EMPLOYEE_MGR(1) does not work because of the null value in REPORTSTO

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE NAME_COMPANY (S OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN S FOR
    SELECT FIRSTNAME, LASTNAME, COMPANY FROM CHINOOK.CUSTOMER;
END;
/
DECLARE
    SVAR SYS_REFCURSOR;
    TEMP_FNAME CHINOOK.CUSTOMER.FIRSTNAME%TYPE;
    TEMP_LNAME CHINOOK.CUSTOMER.LASTNAME%TYPE;
    TEMP_COMP CHINOOK.CUSTOMER.COMPANY%TYPE;
BEGIN
    NAME_COMPANY(SVAR);
    LOOP
        FETCH SVAR INTO TEMP_FNAME, TEMP_LNAME, TEMP_COMP;
        EXIT WHEN SVAR%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Customer name: '||TEMP_FNAME||' '||TEMP_LNAME||' Company: '||TEMP_COMP);
    END LOOP;
    CLOSE SVAR;
END;

--5.0 Transactions
--In this section you will be working with transactions.
--Transactions are usually nested within a stored procedure.
--Task – Create a transaction that given a invoiceId will delete that invoice
--(There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE CHINOOK.DELETE_INVOICE (INID NUMBER)
--FK constraint had already been removed prior to this
IS
BEGIN
    DELETE FROM CHINOOK.INVOICE WHERE INID = INVOICEID;
    COMMIT;
END;
BEGIN
    CHINOOK.DELETE_INVOICE(413);
END;

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE CHINOOK.INSERT_CUSTOMER IS
BEGIN
    INSERT INTO CHINOOK.CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY) VALUES (62, 'Y', 'Thassus', 'First Company');
    COMMIT;
END;
/
--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE TABLE CHINOOK.LOG(MESSAGE VARCHAR2(60));
-- log table may be necessary
CREATE OR REPLACE TRIGGER CHINOOK.EMP_PK_TRIGGER
AFTER INSERT ON CHINOOK.EMPLOYEE FOR EACH ROW
DECLARE
v_user VARCHAR2(20);
BEGIN
    SELECT USER INTO v_user FROM DUAL;
    --DBMS_OUTPUT.PUT_LINE(v_user||' inserted a record into the employee table.');
    INSERT INTO CHINOOK.LOG VALUES(v_user||' inserted a record');
END;
/
INSERT INTO CHINOOK.EMPLOYEE (EMPLOYEEID, FIRSTNAME, LASTNAME) VALUES (11, 'Scott', 'Taylor');

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER CHINOOK.ALB_PK_TRIGGER
AFTER UPDATE ON CHINOOK.ALBUM FOR EACH ROW
DECLARE
v_user VARCHAR2(20);
BEGIN
    SELECT USER INTO v_user FROM DUAL;
    --DBMS_OUTPUT.PUT_LINE(v_user||' updated a record from the album table.');
    INSERT INTO CHINOOK.LOG VALUES(v_user||' updated a record');
END;
/
UPDATE CHINOOK.ALBUM SET TITLE = 'Revelations' WHERE ALBUMID = 11;
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER CHINOOK.CUS_PK_TRIGGER
AFTER DELETE ON CHINOOK.CUSTOMER FOR EACH ROW
DECLARE
v_user VARCHAR2(20);
BEGIN
    SELECT USER INTO v_user FROM DUAL;
    --DBMS_OUTPUT.PUT_LINE(v_user||' deleted a record from the customer table.');
    INSERT INTO CHINOOK.LOG VALUES(v_user||' deleted a record');
END;
/
DELETE FROM CHINOOK.CUSTOMER WHERE CUSTOMERID=32;

--7.0 JOINS
--In this section you will be working with combining various tables through the use of joins.
--You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT CHINOOK.CUSTOMER.FIRSTNAME, CHINOOK.CUSTOMER.LASTNAME, CHINOOK.INVOICE.INVOICEID
FROM CHINOOK.CUSTOMER
INNER JOIN CHINOOK.INVOICE ON CHINOOK.CUSTOMER.CUSTOMERID = CHINOOK.INVOICE.CUSTOMERID;
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table,
--specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT CHINOOK.CUSTOMER.CUSTOMERID, CHINOOK.CUSTOMER.FIRSTNAME, CHINOOK.CUSTOMER.LASTNAME,
CHINOOK.INVOICE.INVOICEID, CHINOOK.INVOICE.TOTAL
FROM CHINOOK.CUSTOMER
FULL OUTER JOIN CHINOOK.INVOICE ON CHINOOK.CUSTOMER.CUSTOMERID = CHINOOK.INVOICE.CUSTOMERID;
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT CHINOOK.ALBUM.TITLE, CHINOOK.ARTIST.NAME
FROM CHINOOK.ALBUM
RIGHT JOIN CHINOOK.ARTIST ON CHINOOK.ALBUM.ARTISTID = CHINOOK.ARTIST.ARTISTID;
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT *
FROM CHINOOK.ALBUM
CROSS JOIN CHINOOK.ARTIST
ORDER BY CHINOOK.ARTIST.NAME ASC;
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT *
FROM CHINOOK.EMPLOYEE E1, CHINOOK.EMPLOYEE E2
WHERE E1.REPORTSTO = E2.REPORTSTO;