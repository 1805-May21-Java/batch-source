--SELECT * FROM CHINOOK.EMPLOYEE;
SET SERVEROUTPUT ON;

--SELECT COUNT(*) FROM CHINOOK.PLAYLISTTRACK;

--2.1.1. SELECT * Retrives all rows from the EMPLOYEE TABLE
SELECT * FROM CHINOOK.EMPLOYEE;

--2.1.2. Used a where clause to retrive rows that satisfy the condition that EMPLOYEE.LASTNAME = 'King'
SELECT * FROM CHINOOK.EMPLOYEE 
WHERE CHINOOK.EMPLOYEE.LASTNAME = 'King';

-- 2.1.3. Used AND with WHERE clause to write in additional condition to query.
-- Two conditions, that EMPLOYEE.FIRSTNAME = 'Andrew' and EMPLOYEE.REPORTSTO IS NULL
SELECT * FROM CHINOOK.EMPLOYEE
WHERE CHINOOK.EMPLOYEE.FIRSTNAME = 'Andrew'
AND CHINOOK.EMPLOYEE.REPORTSTO IS NULL;


--2.2.1. ORDER BY
--Used ORDER BY clause with DESC to sort rows in Descending order by TITLE.
SELECT * FROM CHINOOK.ALBUM
ORDER BY TITLE DESC;

--2.2.2. Used ORDER BY clause to sort rows by CITY. No ASC keyword required since
--ORDER BY is sorted in ascending order by default.
SELECT FIRSTNAME FROM CHINOOK.CUSTOMER
ORDER BY CITY;

--2.3.1 INSERT INTO
--Used INSERT INTO to insert two new rows into CHINOOK.GENRE
--SELECT statement is used to check if values are inside CHINOOK.GENRE
INSERT INTO CHINOOK.GENRE VALUES (26, 'Western');
INSERT INTO CHINOOk.GENRE VALUES (27, 'Historic');
SELECT * FROM CHINOOK.GENRE
WHERE GENREID IN (26, 27);

--2.3.2. 
--Used INSERT INTO to insert two new rows into CHINOOK.EMPLOYEE
--SELECT statement is provided to check if additional rows are in CHINOOK.EMPLOYEE
INSERT INTO CHINOOK.EMPLOYEE VALUES(9, 'Williams', 'Gregory', 'Marketing', NULL, DATE '1987-12-26', DATE '2017-04-12', 
'23rd McCormick st.', 'Chicago', 'IL', 'United States', '60623', '+1 (773)466-2484', '+1 (773)466-2456', 'gwill87@gmail.com');
INSERT INTO CHINOOK.EMPLOYEE VALUES(10, 'Ramirez', 'James', 'HR Representative', 1, DATE '1977-03-21', DATE '2008-10-02', 
'55th Point drive', 'New Your', 'NY', 'United States', '60467', '+1 (393)242-7462', '+1 (393)242-5838', 'jramirez02@gmail.com');
SELECT * FROM CHINOOK.EMPLOYEE 
WHERE CHINOOK.EMPLOYEE.EMPLOYEEID IN (9,10);

--2.3.3
--Used INSERT INTO to insert two new rows into CHINOOK.EMPLOYEE
--SELECT statement checks if rows are in CHINOOK.CUSTOMER
INSERT INTO CHINOOK.CUSTOMER VALUES(60, 'Jonathan', 'Banks', NULL, '12th Olgierg st.', 'Las Vegas', 'NV', 'US',
'94432', '+1 (324)495-2405', NULL, 'jBanks55@yahoo.com', NULL);
INSERT INTO CHINOOK.CUSTOMER VALUES(61, 'Bob', 'Odenkirk', NULL, '70 Thor st.', 'Chicago', 'IL', 'US',
'60617', '+1 (773)457-3738', NULL, 'bOden97@yahoo.com', NULL);
SELECT * FROM CHINOOK.CUSTOMER 
WHERE CUSTOMERID IN (60, 61);

--2.4.1 UPDATE;
--Used UPDATE on CHINOOK.CUSTOMER to change 'Aaron Mitchell' to 'Robert Walker'
-- In the UPDATE statement I specified the columns I wanted to change and 
-- include a WHERE clause to change only columns where name was 'Aaron Mitchell'
--A SELECT statement before the update is provided to show 'Aaron Mitchell' in the table.
--Another SELECT statement after the update is provided to show that 'Aaron Mitchell' has been changed to 
--'Robert Walker' (Note: the CustomerID is the same after the update).
SELECT CUSTOMERID, FIRSTNAME, LASTNAME FROM CHINOOK.CUSTOMER 
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

UPDATE CHINOOK.CUSTOMER SET FIRSTNAME = 'Robert', LASTNAME = 'Walker'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

SELECT CUSTOMERID, FIRSTNAME, LASTNAME FROM CHINOOK.CUSTOMER 
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walker';

--2.4.2
--UPDATE statement is to set NAME to 'CCR' where NAME = 'Creedence Clearwater Revival'
--A SELECT statement is provided before and after to check update(ARTISTID remains the same)
SELECT * FROM CHINOOK.ARTIST WHERE NAME = 'Creedence Clearwater Revival';

UPDATE CHINOOK.ARTIST SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';

SELECT * FROM CHINOOK.ARTIST WHERE NAME = 'CCR';

--2.5 LIKE
--SELECT statement below used LIKE keyword in WHERE clause to check for Billing Adresses that begin with
-- 'T', a wildcard % was added to include all rows that start with 'T'
SELECT * FROM CHINOOK.INVOICE WHERE BILLINGADDRESS LIKE 'T%';

--2.6.1 BETWEEN
--SELECT statement's WHERE clause checks that total is between 15 to 50, using the BETWEEN keyword.
--I added an order by TOTAL clause to chekc that INVOICES have total between 15 to 50
SELECT * FROM CHINOOK.INVOICE WHERE TOTAL BETWEEN 15 AND 50 order by total;

--2.6.2
--SELECT statement's WHERE clause checks that the HIREDATE is between June 1st 2003 and March 1 2004
--using the BETWEEN keyword. The result is ordered by HIREDATE.
SELECT * FROM CHINOOK.EMPLOYEE WHERE HIREDATE BETWEEN DATE '2003-06-01' AND DATE '2004-03-01'
ORDER BY HIREDATE;

--2.7 DELETE
--To DELETE FROM CUSTOMER, FOREIGN KEYS IN BOTH CHINOOK.INVOICE and CHINOOK.INVOIVELINE

--INVOICE(Has a Foreign key referencing CUSTOMERID in CHINOOK.CUSTOMER)
--Foreign Key dropped using ALTER TABLE
ALTER TABLE CHINOOK.INVOICE
DROP CONSTRAINT FK_INVOICECUSTOMERID;

--Foreign Key readded, with condition that any reference that is deleted
--CASCADES foreign key
--This also helps in the Delete trigger in 6.1.3
ALTER TABLE CHINOOK.INVOICE
ADD CONSTRAINT FK_INVOICECUSTOMERID
FOREIGN KEY (CUSTOMERID) REFERENCES CHINOOK.CUSTOMER(CUSTOMERID) ON DELETE CASCADE;

--INVOICELINE(Has Foreign Key that references INVOICEID in CHINOOK.INVOICE)
--CASCADES Foreign key on delete
ALTER TABLE CHINOOK.INVOICELINE
DROP CONSTRAINT FK_INVOICELINEINVOICEID;

ALTER TABLE CHINOOK.INVOICELINE
ADD CONSTRAINT FK_INVOICELINEINVOICEID
FOREIGN KEY (INVOICEID) REFERENCES CHINOOK.INVOICE(INVOICEID) ON DELETE CASCADE;

--Deletes any row where FIRSTNAME = 'Robert' and LASTNAME = 'Walker'
DELETE FROM CHINOOK.CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walker';

-- SELECT with COUNT is used to check that their are not rows containing the name 'Robert Walker'
SELECT COUNT(*) FROM CHINOOK.CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walker';

--3.1.1
--SELECT statement returns the current time by calling SYSDATE FROM the DUAL table
SELECT TO_CHAR(SYSDATE, 'HH24:MI:SS') FROM DUAL;

--3.1.2
--Length of NAME in CHINOOK.MEDIATYPE is returned using the LENGTH() function
--on NAME in each row of CHINOOK.MEDIATYPE
SELECT LENGTH(NAME) FROM CHINOOK.MEDIATYPE;

--3.2.1
--Average of TOTAL from CHINOOK.INVOICE is returned using AVG() function.
SELECT AVG(TOTAL) FROM CHINOOK.INVOICE;

--3.2.2
--To get the most expensive track from CHINOOK.TRACK, the MAX() function was used in
--nested queries in the WHERE clause.  The nested queries returned maximum UNITPRICE and BYTES. 
--Which the main query was able to use to find the most expensive track in CHINOOK.TRACK
SELECT * FROM CHINOOK.TRACK WHERE UNITPRICE = (
SELECT MAX(UNITPRICE) FROM CHINOOK.TRACK) AND BYTES = (
SELECT MAX(BYTES) FROM CHINOOK.TRACK);

--3.3
--Created function that returns avegrage price of INVOICELINE items
--Created function with OUT parameter
CREATE OR REPLACE FUNCTION get_avg(ANS OUT NUMBER)
RETURN NUMBER
IS
BEGIN
    --OUT parameter stores average gotten from a SELECT statement and is returned.
    SELECT AVG(UNITPRICE) INTO ANS FROM CHINOOK.INVOICELINE;
    RETURN ANS;
END;
/

--Anonymous PL/SQL block runs function get_avg.
DECLARE
answer NUMBER;
BEGIN
    DBMS_OUTPUT.PUT_LINE(get_avg(answer));
END;
/

--3.4
--Function returns a string stating all possible employees born after
--1968 have been queried.
--The function takes an OUT parameter which will return the String.
--A cursor that points to the EMPLOYEEID, FIRSTNAME, and LASTNAME of CHINOOK.EMPLOYEE
--has been created, along with variables to store those values during a fetch
CREATE OR REPLACE FUNCTION CHINOOK.employeesPost1968(ANS OUT VARCHAR2)
RETURN VARCHAR2
IS 
CURSOR employees IS SELECT EMPLOYEEID, FIRSTNAME, LASTNAME FROM CHINOOK.EMPLOYEE
WHERE BIRTHDATE > DATE '1968-12-31' ORDER BY BIRTHDATE;
emp_id CHINOOK.EMPLOYEE.EMPLOYEEID%TYPE;
first_name CHINOOK.EMPLOYEE.FIRSTNAME%TYPE;
last_name CHINOOK.EMPLOYEE.LASTNAME%TYPE;
BEGIN
    --Cursor employees is opened.
    OPEN employees;
    --Loop will iterate over each fetch from employees into the variables
    --It will exit when employees reaches a %NOTFOUND.
    LOOP
        FETCH employees INTO emp_id, first_name, last_name;
        EXIT WHEN employees%NOTFOUND;
        --A print statment giving the ID and name of an employee born after 1968
        DBMS_OUTPUT.PUT_LINE('ID: ' || emp_id || ', Name: ' || first_name || ' ' || last_name);
    END LOOP;
    --Cursor is closed.
    CLOSE employees;
    --OUT parameter is given a string to notify user that all possible employees
    --have been found and returns.
    ANS := 'All possible employees born after 1968 have been queried.';
    RETURN ANS;
END;
/
--Anonymous PL/SQL block to test CHINOOK.employeesPost1968
DECLARE
answer VARCHAR2(70);
BEGIN
    DBMS_OUTPUT.PUT_LINE(CHINOOK.employeesPost1968(answer));
END;
/


--4.1
--To get the names of employees from CHINOOK.EMPLOYEES in a stored procedure
--A procedure names 'employee_name is created(added a replace so it can be improved upon)
CREATE OR REPLACE PROCEDURE CHINOOK.employee_names AS
--Variables first_name and last_name have the same type as FIRSTNAME and LASTNAME in CHINOOK.EMPLOYEE
--using the %TYPE to match the variables to the same type as the columns in CHINOOK.EMPLOYEE.
--A cursor rowFetch is created to retrieve values of FIRSTNAME and LASTNAME, acting as a pointer for each row in CHINOOK.EMPLOYEE.
first_name VARCHAR(20);
last_name VARCHAR(20);
CURSOR rowFetch is SELECT FIRSTNAME, LASTNAME FROM CHINOOK.EMPLOYEE;
--Beginning of procedure body
BEGIN
    --rowFetch is opened, now allowed to fetch information from query.
    OPEN rowFetch;
    -- LOOP is created make sure rowFetch retrieves information row for row
    -- and includes output for employee names
    LOOP
        -- FETCH allows rowFetch to put row values into first_name and last_name
        --and moves on to the next row.
        FETCH rowFetch INTO first_name, last_name;
        --LOOP will exit when there are no more rows to fetch from
        --Using %NOTFOUND on rowFetch.
        EXIT WHEN rowFetch%NOTFOUND;
        --Employee names are printed in the Dbms Output(Connect to Dbms Output prior to running procedure)
        DBMS_OUTPUT.PUT_LINE(first_name || ' ' || last_name);
    END LOOP;
    --rowFetch is closed to remove reference to CHINOOK.EMPLOYEE.
    CLOSE rowFetch;
    --END means end of Procedure body
END;
/

--Anonymous PL/SQL block used to run procedure employee_names 
BEGIN
    CHINOOK.employee_names();
END;
/


--4.2.1
--Procedure UPDATE_EMPLOYEE_ADRESS updates ADRESS of CHINOOK.EMPLOYEE TABLE WHERE EMPLOYEEID = eid
--Procedure takes in two parameters, eid for EMPLOYEEID, and adress_change for ADDRESS.
CREATE OR REPLACE PROCEDURE CHINOOK.UPDATE_EMPLOYEE_ADDRESS(eid NUMBER, address_change VARCHAR2)
IS
--Variable to retrieve name of employee
first_name CHINOOK.EMPLOYEE.FIRSTNAME%TYPE;
last_name CHINOOK.EMPLOYEE.LASTNAME%TYPE;
BEGIN
    --Variable store FIRSTNAME and LASTNAME
    SELECT FIRSTNAME, LASTNAME INTO first_name, last_name FROM CHINOOK.EMPLOYEE
    WHERE EMPLOYEEID = eid;
    --UPDATE changes address of Employee with ID of eid's address to adress_change
    UPDATE CHINOOK.EMPLOYEE SET ADDRESS = address_change WHERE EMPLOYEEID = eid;
    --Print statment notifying of change
    DBMS_OUTPUT.PUT_LINE('Address of ' || first_name || ' ' || last_name || ' has been updated.');
END;
/
--Anonymous PL/SQL block to test CHINOOK.UPDATE_EMPLOYEE_ADDRESS
BEGIN
    CHINOOK.UPDATE_EMPLOYEE_ADDRESS(10, '55 Orchard road.');
END;
/


--4.2.2
--Create a procedure that returns the name of the manage of a employee
-- Procedure takes in a single parameter eid, which takes an argument of type EMPLOYEEID
--from the CHINOOK.EMPLOYEE table.
CREATE OR REPLACE PROCEDURE CHINOOK.get_manager(eid CHINOOK.EMPLOYEE.EMPLOYEEID%TYPE) AS
--Variables will store manager ID, as well as first and last name
--variable types have been set to match those of the columns in CHINOOK.EMPLOYEE.
employee_first  EMPLOYEE.FIRSTNAME%TYPE;
employee_last   EMPLOYEE.LASTNAME%TYPE;
manager_Id CHINOOK.EMPLOYEE.REPORTSTO%TYPE;
manager_FirstName CHINOOK.EMPLOYEE.FIRSTNAME%TYPE;
manager_LastName CHINOOK.EMPLOYEE.LASTNAME%TYPE;
BEGIN
    --SELECT statement gets Employee's firstname, lastname, and manangerID
    SELECT FIRSTNAME, LASTNAME, REPORTSTO INTO employee_first, employee_last,
    manager_Id FROM CHINOOK.EMPLOYEE WHERE EMPLOYEEID = eid;
    --IF-ELSE statement used to check if manager_Id is null, meaning that employee has no manager.
    --Else a SELECT statement on CHINOOK.EMPLOYEE using manager_ID as the EMPLOYEEID retrieves the
    --First and last names of the manager.
    IF manager_Id IS NULL THEN
        DBMS_OUTPUT.PUT_LINE('Employee ' || employee_first || ' ' || employee_last || ' has no manager');
    ELSE
        SELECT FIRSTNAME, LASTNAME INTO manager_FirstName, manager_LastName FROM 
        CHINOOK.EMPLOYEE WHERE EMPLOYEEID = manager_Id;
        --Print statment showing the name of the employee, as well as the manager.
        DBMS_OUTPUT.PUT_LINE('The manager of ' ||employee_first || ' ' || employee_last || ' is: ' 
        || manager_FirstName || ' ' || manager_LastName);
    END IF;
END;
/

--Anonymous PL/SQL block to test code
BEGIN
    CHINOOK.get_manager(2);
    CHINOOK.get_manager(1);
END;
/

--4.3
--Created procedure that takes in a CUSTOMERID from CHINOOK.CUSTOMER.
CREATE OR REPLACE PROCEDURE CHINOOK.customerName_and_Company(cid CHINOOK.CUSTOMER.CUSTOMERID%TYPE) AS
--All variables have matching types as the specified columns below.
c_FirstName CHINOOK.CUSTOMER.FIRSTNAME%TYPE;
c_LastName CHINOOK.CUSTOMER.LASTNAME%TYPE;
c_Company CHINOOK.CUSTOMER.COMPANY%TYPE;
BEGIN
    --SELECT statement retrieves the FIRSTNAME, LASTNAME, and COMPANY FROM CHINOOK.CUSTOMER WHERE
    -- THe Customer ID matches input cid.
    SELECT FIRSTNAME, LASTNAME, COMPANY INTO c_FirstName, c_LastName, c_Company FROM CHINOOK.CUSTOMER
    WHERE CUSTOMERID = cid;
    --IF statement checks if COMPANY name is null, giving a different output depending if it is null or not null.
    IF c_COMPANY IS NULL THEN
        DBMS_OUTPUT.PUT_LINE(c_FirstName || ' ' || c_LastName || ' has no company.');
    ELSE
        DBMS_OUTPUT.PUT_LINE(c_FirstName || ' ' || c_LastName || ' has company named ' || c_Company);
    END IF;
END;
/

--Anonymous PL/SQL block to test customerName_and_Company.
BEGIN
    CHINOOK.customerName_and_Company(1);
    CHINOOK.customerName_and_Company(2);
END;
/

--5.1
--Creating a Transaction to delete INVOICE LINE using an INVOICEID
--Check if this row exist in CHINOOK.INVOICE(Should be 1 prior to transaction)
SELECT COUNT(*) FROM CHINOOK.INVOICE WHERE INVOICEID = 324;

--Anonymouse PL/SQL block that acts as transaction,
--deletes from CHINOOK.INVOICE WHERE INVOICEID = 324
BEGIN
    DELETE FROM CHINOOK.INVOICE WHERE INVOICEID = 324;
    COMMIT;
END;
/
--ROLLBACK added to go back to previous commit
ROLLBACK;

--Check if row still exist in INVOICEID(Should be 0)
SELECT COUNT(*) FROM CHINOOK.INVOICE WHERE INVOICEID = 324;

--5.2
--The procedure CHINOOK.TRANSACTION_INSERT takes in all arguments needed to 
--insert a row into CHINOOK.CUSTOMER
CREATE OR REPLACE PROCEDURE CHINOOK.transaction_insert(cid CHINOOK.CUSTOMER.CUSTOMERID%TYPE, 
first_name CHINOOK.CUSTOMER.FIRSTNAME%TYPE, last_name CHINOOK.CUSTOMER.LASTNAME%TYPE, c_Company CHINOOK.CUSTOMER.COMPANY%TYPE,
c_address CHINOOK.CUSTOMER.ADDRESS%TYPE, c_city CHINOOK.CUSTOMER.CITY%TYPE, c_state CHINOOK.CUSTOMER.STATE%TYPE,
c_country CHINOOK.CUSTOMER.COUNTRY%TYPE, c_postalcode CHINOOK.CUSTOMER.POSTALCODE%TYPE,
c_phone CHINOOK.CUSTOMER.PHONE%TYPE, c_fax CHINOOK.CUSTOMER.FAX%TYPE,
c_email CHINOOK.CUSTOMER.EMAIL%TYPE, c_support_repid CHINOOK.CUSTOMER.SUPPORTREPID%TYPE)
IS
customer_exists NUMBER;
BEGIN
    --SELECT checks if customer is already in CHINOOK.CUSTOMER using COUNT().
    SELECT COUNT(*) INTO customer_exists FROM CHINOOK.CUSTOMER WHERE CUSTOMERID = cid;
    --If customer exist then a print statement saying customer already in table is given
    IF(customer_exists = 1) THEN
        DBMS_OUTPUT.PUT_LINE('Transaction Failed. Customer already exist in the table');
    --If customer does not exist, then transaction occurs.
    ELSE
         --Parameter values are INSERTED INTO CHINOOK.CUSTOMER. Afterwards a COMMIT is done to signify the transaction.
        INSERT INTO CHINOOK.CUSTOMER VALUES(cid, first_name, last_name, c_Company, c_address, c_city, c_state,
        c_country, c_postalcode, c_phone, c_fax, c_email, c_support_repid);
        COMMIT;
        --Print statment to signify end of transaction.
        DBMS_OUTPUT.PUT_LINE('Transaction Complete. New Customer has been added to the CHINOOK.CUSTOMER table.');
    END IF;
END;
/

--Anonymous PL/SQL bloc to test CHINOOK.TRANSACTION_INSERT
BEGIN
    CHINOOK.transaction_insert(70, 'Rick', 'Jones', NULL, '35th Community Blvd.', 'New York', 'NY', 'United States', '59362',
    '+1 (241)425-9256', '+1 (241)425-8204', 'rJones44', 3);
        CHINOOK.transaction_insert(71, 'Ted', 'Jones', NULL, '35th Community Blvd.', 'New York', 'NY', 'United States', '59362',
    '+1 (241)425-9256', '+1 (241)425-8204', 'tJones48', 3);
        CHINOOK.transaction_insert(71, 'Ted', 'Jones', NULL, '35th Community Blvd.', 'New York', 'NY', 'United States', '59362',
    '+1 (241)425-9256', '+1 (241)425-8204', 'tJones48', 3);
END;
/

--6.1.1
--Created a trigger that will print a COUNT(*) of CHINOOK.EMPLOYEE after
--every INSERT.
CREATE OR REPLACE TRIGGER CHINOOK.TR_INSERT_EMPLOYEE
AFTER INSERT ON CHINOOK.EMPLOYEE
DECLARE
--Variable will store count of CHINOOK.EMPLOYEE
new_count NUMBER;
BEGIN
    --SELECT statement stores COUNT(*) into new_count
    --and prints it in the print statement below.
    SELECT COUNT(*) INTO new_count FROM CHINOOK.EMPLOYEE;
    DBMS_OUTPUT.PUT_LINE('CHINOOK.EMPLOYEE table count has increased to ' || TO_CHAR(new_count));
END;
/
--Anonymous PL/SQL block test CHINOOK.TR_INSERT_EMPLOYEE
BEGIN
    INSERT INTO CHINOOK.EMPLOYEE VALUES(11, 'Jackson', 'John', 'Salesman', NULL, DATE '1990-04-14', DATE '2018-01-28',
    '743rd Party ST','Reston', 'VA', 'United States', '50526', '+1 (241)517-9314', '+1 (241)517-9256', 'jacksonCity90@yahoo.com');
END;
/


--6.1.2
--Created a trigger that will print a statment that CHINOOK.EMPLOYEE has been updated
--after every UPDATE.
CREATE OR REPLACE TRIGGER CHINOOK.TR_UPDATE_EMPLOYEE
AFTER UPDATE ON CHINOOK.EMPLOYEE
BEGIN
    --Print statment notifying the user of the UPDATE call
     DBMS_OUTPUT.PUT_LINE('CHINOOK.EMPLOYEE table has been updated');
END;
/
--Anonymous PL/SQL block to test CHINOOK.TR_UPDATE_EMPLOYEE
BEGIN
    UPDATE CHINOOK.EMPLOYEE SET REPORTSTO = 2 WHERE EMPLOYEEID = 11;
END;
/

--6.1.3
--Created a trigger that will print a COUNT(*) of CHINOOK.EMPLOYEE
--after every DELETE call.
CREATE OR REPLACE TRIGGER TR_DELETE_EMPLOYEE
AFTER DELETE ON CHINOOK.EMPLOYEE
DECLARE
--Variable to COUNT(*) of CHINOOK.EMPLOYEE
new_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO new_count FROM CHINOOK.EMPLOYEE;
    DBMS_OUTPUT.PUT_LINE('CHINOOK.EMPLOYEE table count reduced to ' || new_count);
END;
/
--Anonymous PL/SQL Block to test CHINOOK.TR_DELETE_EMPLOYEE
BEGIN
    DELETE FROM CHINOOK.EMPLOYEE WHERE EMPLOYEEID = 11;
END;
/

--7.1 INNER JOIN
--Use INNER JOIN with the ON clause match CHINOOK.CUSTOMER and CHINOOK.INVOICE
--by the CUSTOMERID
SELECT FIRSTNAME, LASTNAME, INVOICEID FROM CHINOOK.CUSTOMER c
INNER JOIN CHINOOK.INVOICE i ON c.CUSTOMERID = i.CUSTOMERID;

--7.2 OUTER JOIN
--Used FULL OUTER JOIN to join ON CUSTOMERID of both CHINOOK.CUSTOMER c and CHINOOK.INVOICE i.
--Query is ORDERED BY c.CUSTOMERID
SELECT c.CUSTOMERID, c.FIRSTNAME, c.LASTNAME, i.INVOICEID, i.TOTAL FROM CHINOOK.CUSTOMER c
FULL OUTER JOIN CHINOOK.INVOICE i ON c.CUSTOMERID = i.CUSTOMERID ORDER BY c.CUSTOMERID;

--7.3 RIGHT JOIN
--Used RIGHT JOIN to join ON ARTISTID in both CHINOOK.ARTIST and CHINOOK.alb
--Ordered by artist name
SELECT NAME, TITLE FROM CHINOOK.ARTIST art RIGHT JOIN 
CHINOOK.ALBUM alb ON art.ARTISTID = alb.ARTISTID ORDER BY art.NAME;

--7.4 CROSS JOIN
-- Used CROSS JOIN with WHERE clause to return a query of ARTISTID, NAME, TITLE FROM
--CHINOOK.ARTIST art and CHINOOK.ALBUM alb ORDERED by art.NAME.
--WHERE clause is needed, else duplicates of rows are generated in the query.
SELECT art.ARTISTID, art.NAME, alb.TITLE FROM CHINOOK.ARTIST art CROSS JOIN CHINOOK.ALBUM alb
WHERE art.ARTISTID = alb.ARTISTID ORDER BY art.NAME;

--7.5 SELF JOIN
--Uses SELECT statent 
SELECT e1.EMPLOYEEID, e1.FIRSTNAME, e1.LASTNAME, e2.EMPLOYEEID Manager, e2.FIRSTNAME ManagerName, e2.LASTNAME ManagerName 
FROM CHINOOK.EMPLOYEE e1 LEFT OUTER JOIN CHINOOK.EMPLOYEE e2 ON e1.REPORTSTO = e2.EMPLOYEEID ORDER BY e1.EMPLOYEEID;
--WHERE e1.REPORTSTO IN (SELECT EMPLOYEEID FROM CHINOOK.EMPLOYEE e2);
