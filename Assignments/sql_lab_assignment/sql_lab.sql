--2.1
--Display all record from employee
SELECT * FROM chinook.employee;

--Display only records which lastname is 'King'
SELECT * FROM chinook.employee
    WHERE lastname = 'King';

--Display all records in employee table which firstname is 'Andrew' and report to is null
SELECT * FROM chinook.employee
    WHERE firstname = 'Andrew' AND reportsto IS NULL;

--2.2
--Display all records in album with employee's title descending order
SELECT * FROM chinook.album
    ORDER BY chinook.album.title DESC;

--display firstname from customer with city asceding order
SELECT chinook.customer.firstname FROM chinook.customer 
    ORDER BY chinook.customer.city ASC;

--2.3
--display all records in employee table
select * from chinook.employee;

--insert a record to genre table with values
INSERT INTO chinook.genre
    VALUES(26,'Asian');


INSERT INTO chinook.genre
    VALUES(27,'Night Rock');

--insert a record to employee table with values
INSERT INTO chinook.employee
    VALUES(9, 'Houth', 'Vannara', 'Prof.', 3, DATE '1900-01-01', DATE '2018-05-21', '189S 298Ave', 'Dophin', 'VA', 'USA', '89382', '900 092-1029', '00 092-1024', 'jackson@gmail.com');

INSERT INTO chinook.employee
    VALUES(10, 'Wonb', 'Yobomo', 'Teacher.', 3, DATE '1900-03-01', DATE '2012-05-21', '102N 298Ave', 'Elephant', 'VA', 'USA', '89432', '900 022-1029', '00 012-1024', 'Justinx@gmail.com');

INSERT INTO chinook.customer
    VALUES(60, 'Momabo', 'Ohshibo', 'Apple', '13S Square Ave', 'Cambridge', 'MA', 'USA', '90391', '893-029-0922', '903-092-3221', 'Saveme@gmail.com', 3);

INSERT INTO chinook.customer
    VALUES(61, 'Bomabo', 'NOhshibo', 'Banana', '93S Bquare Ave', 'Mambridge', 'MA', 'USA', '80391', '393-029-0922', '503-092-3221', 'Gaveme@gmail.com', 1);

--2.4
--update first name and lastname to Robert Waltern in customer table if the first name is 'Aaron' and last name is 'Mitchell'
UPDATE chinook.customer
    SET firstname = 'Robert', lastname='Walter'
    WHERE firstname = 'Aaron' AND lastname = 'Mitchell';

--update artis table to 'CCR' if name ='Creedence Clearwater Revival'
UPDATE chinook.artist
    SET name='CCR'
    WHERE name='Creedence Clearwater Revival';
    
--2.5
--Show all records in invoice table which billing address start with 'T'
SELECT * FROM chinook.invoice
    WHERE billingaddress like 'T%';
    
--2.6
--display all records in invoice table if total between 15 and 50
SELECT * FROM chinook.invoice
    WHERE total BETWEEN 15 AND 50;
 
 --display all records in employee table if the hire date is between  2003-06-01 and 2004-03-01  
SELECT * FROM chinook.employee
    WHERE hiredate BETWEEN DATE '2003-06-01' AND DATE '2004-03-01';

--2.7

--we drop the constrain so that we can add on delete cascade
ALTER TABLE chinook.invoiceline
    DROP CONSTRAINT FK_INVOICELINEINVOICEID;
    
ALTER TABLE chinook.invoice
    DROP CONSTRAINT FK_INVOICECUSTOMERID;
--after drop the constraint we add the constraint back with delete cascade so we can delete a record and its dependency.
ALTER TABLE chinook.invoiceline
    ADD CONSTRAINT FK_INVOICELINEINVOICEID FOREIGN KEY (INVOICEID) REFERENCES chinook.invoice (INVOICEID)
    ON DELETE CASCADE;
    
ALTER TABLE chinook.invoice
    ADD CONSTRAINT FK_INVOICECUSTOMERID FOREIGN KEY (CUSTOMERID) REFERENCES chinook.customer (CUSTOMERID)
    ON DELETE CASCADE;
    
--we delete a record with first name 'Robert' and last name 'Walter'
DELETE FROM chinook.customer
    WHERE firstname ='Robert' AND lastname = 'Walter';



--3.1
--create a function to display time. We call current_timestamp from the system (dual)
CREATE OR REPLACE Function CurrentTime
   RETURN varchar2
IS
    result varchar2(10);
BEGIN
    SELECT to_char(CURRENT_TIMESTAMP, 'hh:mi:ss') INTO result FROM DUAL ;
    

RETURN result;
END;
/

--we display the function return value;
SET serveroutput on;
BEGIN
    DBMS_OUTPUT.PUT_LINE(CurrentTime());
END;


--we create to return that takes string input and return the length of that string 
CREATE OR REPLACE Function NameLength(name VARCHAR2)
   RETURN NUMBER
IS
    result NUMBER(10,2);
BEGIN 
  result:=length(name);

RETURN result;
END;
/



--3.2
--we create a function to return the average of the total invoice
CREATE OR REPLACE Function AvgTotalInvoice
RETURN NUMBER
IS
result NUMBER(10,2);
BEGIN
    SELECT AVG(total) INTO result from chinook.invoice;
    RETURN result;
END;
/

--we create a function to return a cursor that contains a list of record if its unit price is max
CREATE OR REPLACE FUNCTION MOSTEXPENSIVETRACK
RETURN SYS_REFCURSOR
IS 
MYCUR SYS_REFCURSOR;
BEGIN
    OPEN MYCUR FOR
    SELECT * FROM CHINOOK.TRACK 
    WHERE UNITPRICE = (SELECT MAX(UNITPRICE) FROM CHINOOK.TRACK);
    RETURN MYCUR;
END;
/

--print line
--print what is in the cursor.
SET serveroutput ON;
DECLARE
MYCUR SYS_REFCURSOR;
BEGIN
    MYCUR := MOSTEXPENSIVETRACK();
    DBMS_SQL.RETURN_RESULT(MYCUR);
END;
/


--3.3
--This function will return the average of the ticket price
CREATE OR REPLACE FUNCTION AVGPRICEINVOICELINE
RETURN NUMBER
IS
RESULT NUMBER(10,2);
BEGIN
    SELECT AVG(UNITPRICE*QUANTITY) INTO RESULT FROM CHINOOK.INVOICELINE;
    RETURN RESULT;
END;
/

SET SERVEROUTPUT ON
BEGIN
    DBMS_OUTPUT.PUT_LINE(AVGPRICEINVOICELINE());
END;
/

--3.4
--This function will return a cursor which stores all of the employees' info which were born after 1968
CREATE OR REPLACE FUNCTION EMPLOYEESAFTER1968
RETURN SYS_REFCURSOR
IS
MYCUR SYS_REFCURSOR;
BEGIN
    OPEN MYCUR FOR
    SELECT * FROM CHINOOK.EMPLOYEE
    WHERE BIRTHDATE > DATE '1968-01-01';
    RETURN MYCUR;
END;
/
SET serveroutput ON;
DECLARE
MYCUR SYS_REFCURSOR;
BEGIN
    MYCUR := EMPLOYEESAFTER1968();
    DBMS_SQL.RETURN_RESULT(MYCUR);
END;
/


--4.1
--The store prodedure will return a cursor which stores all of the employees' first name and last name 
CREATE OR REPLACE PROCEDURE FIRSTLASTNAMES(MYCUR OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN MYCUR FOR
    SELECT FIRSTNAME, LASTNAME FROM CHINOOK.EMPLOYEE;
END;
/

--DECLARE
--    MYCUR SYS_REFCURSOR;
--    TEMP_FIRSTNAME CHINOOK.EMPLOYEE.FIRSTNAME%TYPE;
--    TEMP_LASTNAME CHINOOK.EMPLOYEE.LASTNAME%TYPE;
--BEGIN
--    FIRSTLASTNAMES(MYCUR);
--    LOOP
--        FETCH MYCUR INTO TEMP_FIRSTNAME, TEMP_LASTNAME;
--        EXIT WHEN MYCUR%NOTFOUND;
--        DBMS_OUTPUT.PUT_LINE(TEMP_FIRSTNAME ||' '|| TEMP_LASTNAME);
--    END LOOP;
--    CLOSE MYCUR;
--
--END;

SET serveroutput ON;
DECLARE
MYCUR SYS_REFCURSOR;
BEGIN
    FIRSTLASTNAMES(MYCUR);
    DBMS_SQL.RETURN_RESULT(MYCUR);
END;
/


--4.2
--The store prodecure will take employee id as an input and will update that employee info
CREATE OR REPLACE PROCEDURE CHINOOK.UPDATEINFO(EMPID in NUMBER)
IS 
BEGIN
    UPDATE CHINOOK.EMPLOYEE SET FIRSTNAME ='Vannara', LASTNAME = 'Houth', ADDRESS = '168N The Houth Ave', CITY = 'The Houth Island', State = 'Outerspace', POSTALCODE='H9K 9N9'
    WHERE EMPLOYEEID = EMPID;
END;
/

BEGIN
    CHINOOK.UPDATEINFO(1);
END;
/

SELECT * FROM CHINOOK.CUSTOMER;
/

--The store procedure will take first and last name as inputs and will print out the name of the manager of that employee.
CREATE OR REPLACE PROCEDURE RETURN_MANAGERS(EMPLOYEE_FIRSTNAME IN VARCHAR2, EMPLOYEE_LASTNAME IN VARCHAR2)
IS
MANAGER_ID CHINOOK.EMPLOYEE.REPORTSTO%TYPE;
MANAGER_FIRSTNAME CHINOOK.EMPLOYEE.FIRSTNAME%TYPE;
MANAGER_LASTNAME CHINOOK.EMPLOYEE.LASTNAME%TYPE;

BEGIN
    SELECT REPORTSTO INTO MANAGER_ID FROM CHINOOK.EMPLOYEE WHERE FIRSTNAME=EMPLOYEE_FIRSTNAME AND LASTNAME=EMPLOYEE_LASTNAME;
    SELECT FIRSTNAME, LASTNAME INTO MANAGER_FIRSTNAME, MANAGER_LASTNAME FROM CHINOOK.EMPLOYEE
    WHERE EMPLOYEEID = MANAGER_ID;
    DBMS_OUTPUT.PUT_LINE(MANAGER_FIRSTNAME ||' ' ||MANAGER_LASTNAME);
END;
/

BEGIN
    RETURN_MANAGERS('Jane', 'Peacock');
END;

--4.3
--This store procedure will output cursor and take customer id as an input id to display the output of the name and company
CREATE OR REPLACE PROCEDURE NAMEANDCOMPANY(MYCUR OUT SYS_REFCURSOR, ID IN NUMBER)
IS
BEGIN
    OPEN MYCUR FOR 
    SELECT FIRSTNAME, LASTNAME, COMPANY FROM CHINOOK.CUSTOMER WHERE CUSTOMERID = ID;
END;
/
SET serveroutput ON;
DECLARE
MYCUR SYS_REFCURSOR;
BEGIN
    NAMEANDCOMPANY(MYCUR, 2);
    DBMS_SQL.RETURN_RESULT(MYCUR);
END;
/


--5
SELECT * FROM CHINOOK.INVOICE;

CREATE OR REPLACE PROCEDURE CHINOOK.DELINVOICE(INVOICE_ID IN NUMBER)
IS
BEGIN
    DELETE FROM CHINOOK.INVOICE WHERE INVOICEID = INVOICE_ID;
END;
/

BEGIN
CHINOOK.DELINVOICE(1);
END;


SELECT * FROM CHINOOK.CUSTOMER;

CREATE OR REPLACE PROCEDURE CHINOOK.INSERTCUSTOMER
IS
BEGIN
    INSERT INTO CHINOOK.CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)          
    VALUES( 60, 'Vannara', 'Houth', 'Ralify LLC', '168N Houth Ave', 'Austin', 'TX', 'USA', '87834', '898-309-0983', '898-309-0986', 'evannara@gmail.com', 3) ;
END;
/
BEGIN
    CHINOOK.INSERTCUSTOMER();
END;
/

--6.1

CREATE OR REPLACE TRIGGER INSERT_EMPLOYEE_TRIGGER
AFTER INSERT ON CHINOOK.EMPLOYEE
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('YOU HAVE INSERTED A RECORD SUCCESSFULLY');
END;
/

CREATE OR REPLACE TRIGGER UPDATE_EMPLOYEE_TRIGGER
AFTER UPDATE ON CHINOOK.EMPLOYEE
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('YOU HAVE UPDATED A RECORD SUCCESSUFLLY');
END;
/

CREATE OR REPLACE TRIGGER DELETE_EMPLOYEE_TRIGGER
AFTER DELETE ON CHINOOK.EMPLOYEE
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('YOU HAVE DELETE A RECORD SUCCESSFULLY');
END;
/
 --   DESCRIBE CHINOOK.EMPLOYEE;
BEGIN

    INSERT INTO CHINOOK.EMPLOYEE VALUES(10, 'Justin', 'Omaga', NULL, NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

END;

BEGIN

    UPDATE CHINOOK.EMPLOYEE SET FIRSTNAME= 'McDont' WHERE EMPLOYEEID=10;

END;

BEGIN

    DELETE FROM CHINOOK.EMPLOYEE WHERE EMPLOYEEID=10;

END;


--7.1
--INNER JOIN
SELECT C.FIRSTNAME, C.LASTNAME, I.INVOICEID 
    FROM CHINOOK.CUSTOMER C 
    INNER JOIN CHINOOK.INVOICE I 
    ON C.CUSTOMERID = I.CUSTOMERID;

--7.2
SELECT C.CUSTOMERID, C.FIRSTNAME, C.LASTNAME, I.INVOICEID, I.TOTAL
    FROM CHINOOK.CUSTOMER C
    FULL JOIN CHINOOK.INVOICE I
    ON C.CUSTOMERID=I.CUSTOMERID;
--7.3

SELECT A.NAME, B.TITLE
    FROM CHINOOK.ALBUM B
    RIGHT JOIN CHINOOK.ARTIST A
    ON B.ARTISTID = A.ARTISTID;

--7.4
SELECT * FROM CHINOOK.ALBUM B
    CROSS JOIN CHINOOK.ARTIST A
    WHERE B.ARTISTID = A.ARTISTID
    ORDER BY A.NAME ASC;

--7.5

SELECT * FROM CHINOOK.EMPLOYEE E1, CHINOOK.EMPLOYEE E2
    WHERE E1.REPORTSTO=E2.REPORTSTO;