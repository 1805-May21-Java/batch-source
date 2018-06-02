/*************************/
/**** 2.0 SQL QUERIES ****/
/*************************/

/* 2.1 SELECT */
-- Select all records from the Employee table.
SELECT * 
    FROM Chinook.employee;

-- Select all records from the Employee table where last name is King.
SELECT *
    FROM Chinook.employee
    WHERE lastname = 'King';

--  Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT *
    FROM Chinook.employee
    WHERE firstname = 'Andrew'
    AND reportsto IS NOT NULL;


/* 2.2 ORDER BY */
-- Select all albums in Album table and sort result set in descending order by title.
SELECT * 
    FROM Chinook.album
    ORDER BY title DESC;

-- Select first name from Customer and sort result set in ascending order by city
SELECT firstname
    FROM Chinook.customer
    ORDER BY city;


/*2.3 INSERT INTO */
-- Insert two new records into Genre table
INSERT INTO chinook.genre VALUES (26, 'J-Rock');
INSERT INTO chinook.genre VALUES (27, 'Rap');

-- Insert two new records into Employee table
INSERT INTO chinook.employee VALUES(9, 'Smith', 'Darren', 'Database Administrator', 6, '16-NOV-91', '08-MAY-18', '123 Sesame St NW', 'Lethbridge','AB','Canada', null, null, null, 'darren@chinookcorp.com');
INSERT INTO chinook.employee VALUES(10, 'Garland', 'Gary', 'Coffee Boy', 2, null, null, null, null, null, null, null, null, null, null);

-- Insert two new records into Customer table
INSERT INTO chinook.customer VALUES(60, 'Dustice', 'Willie', null, null, null, null, null, null, null, null, 'dillie@mail.com', 3);
INSERT INTO chinook.customer VALUES(61, 'Person', 'Namington', null, null, null, null, null, null, null, null, 'fakemeail@company.com', null);


/*2.4 UPDATE */
-- Update Aaron Mitchell in Customer table to Robert Walter
UPDATE chinook.customer
    SET firstname = 'Robert', lastname='Walter'
    WHERE firstname='Aaron' AND  lastname='Mitchell';

-- Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE chinook.artist
    SET name= 'CCR'
    WHERE name = 'Creedence Clearwater Revival';


/*2.5 Like*/
-- Select all invoices with a billing address like “T%”
SELECT * 
    FROM chinook.invoice 
    WHERE billingaddress LIKE 'T%';


/*2.6 BETWEEN*/

-- Select all invoices that have a total between 15 and 50
SELECT *
    FROM chinook.invoice
    WHERE total BETWEEN 15 AND 50;

-- Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT *
    FROM chinook.employee
    WHERE hiredate BETWEEN '1-JUN-03' AND '1-MAR-04';

/*2.7 DELETE */
-- Delete a record in Customer table where the name is Robert Walter

ALTER TABLE chinook.invoiceline DROP 
    CONSTRAINT fk_invoicelineinvoiceid;

ALTER TABLE chinook.invoiceline ADD 
    CONSTRAINT fk_invoicelineinvoiceid
    FOREIGN KEY (invoiceid) 
    REFERENCES chinook.invoice(invoiceid) 
    ON DELETE CASCADE;

ALTER TABLE chinook.invoice DROP 
    CONSTRAINT fk_invoicecustomerid;
    
ALTER TABLE chinook.invoice ADD
    CONSTRAINT fk_invoicecustomerid
    FOREIGN KEY (customerid)
    REFERENCES chinook.customer(customerid)
    ON DELETE CASCADE;



DELETE FROM chinook.customer
    WHERE firstname='Robert' and lastname='Walter'
    

/***************************/
/**** 3.0 SQL FUNCTIONS ****/
/***************************/

/* 3.1 System Defined Functions */
-- Create a function that returns the current time.
create or replace function get_time
return  varchar2
is 
v_time varchar2(8);
begin
     select to_char(localtimestamp, 'hh:mm:ss') into v_time from dual;
     return v_time;
end;
/


-- Create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION get_mediatype_name_length(n IN NUMBER)
RETURN  NUMBER
IS
media_name NUMBER(4);
BEGIN
    SELECT LENGTH(name) 
    INTO media_name
    FROM chinook.mediatype 
    WHERE mediatypeid = n;
    RETURN media_name;
END;
/

/* 3.2 ystem Defined Aggregate Functions */
-- Create a function that returns the average total of all invoices 
CREATE OR REPLACE FUNCTION  avg_all_invoices
RETURN NUMBER
IS 
    average NUMBER(10,2);
BEGIN
    SELECT AVG(total)
    INTO average
    FROM chinook.invoice;
    RETURN average;
END;
/
-- Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION most_expensive_track
RETURN VARCHAR2
IS
    exp_price NUMBER(10,2);
    exp_tracks SYS_REFCURSOR;
    exp_track chinook.track.name%type;
BEGIN
    SELECT MAX(unitprice)
    INTO exp_price
    FROM chinook.track;
    
    OPEN exp_tracks FOR
    SELECT name
    FROM chinook.track
    WHERE unitprice = exp_price;
    
    FETCH exp_tracks into  exp_track;
    
    CLOSE 
    RETURN exp_track;
END;
/


/* 3.3 User Defined Scalar Functions */
-- Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION avg_invoiceline_price
RETURN NUMBER
IS
    avg_price NUMBER(10,2);
BEGIN
    SELECT AVG(unitprice)
    INTO avg_price
    FROM chinook.invoiceline;
    RETURN avg_price;
END;
/

/* 3.4 User Defined Table Valued Functions */
-- Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION old_employees
RETURN SYS_REFCURSOR
IS
    curs SYS_REFCURSOR;       
BEGIN
    OPEN curs FOR
    SELECT *
    FROM chinook.employee
    WHERE birthdate > '31-DEC-1968';
    RETURN curs;
END;
/

/*******************************/
/**** 4.0 STORED PROCEDURES ****/
/*******************************/

/* 4.1 Basic Stored Procedure */
-- Create a stored procedure that selects the first and last names of all the employees.

CREATE OR REPLACE PROCEDURE get_employee_names(curs OUT SYS_REFCURSOR) 
IS
BEGIN
    OPEN curs FOR
    SELECT firstname, lastname
    FROM chinook.employee;
END;
/

/* 4.2  Stored Procedure Input  */
-- Create a stored procedure that updates the personal information of an employee
CREATE OR REPLACE PROCEDURE chinook.update_employee
    (empId IN CHINOOK.EMPLOYEE.EMPLOYEEID%TYPE, lname IN CHINOOK.EMPLOYEE.LASTNAME%TYPE, fname IN CHINOOK.EMPLOYEE.FIRSTNAME%TYPE,
    empTitle IN CHINOOK.EMPLOYEE.TITLE%TYPE, supervisor IN CHINOOK.EMPLOYEE.REPORTSTO%TYPE, empBirthdate IN DATE, empHiredate IN DATE,
    empAddress IN CHINOOK.EMPLOYEE.ADDRESS%TYPE, empCity IN CHINOOK.EMPLOYEE.CITY%TYPE, empState IN CHINOOK.EMPLOYEE.STATE%TYPE,
    empCountry IN CHINOOK.EMPLOYEE.COUNTRY%TYPE,  empPostal IN CHINOOK.EMPLOYEE.POSTALCODE%TYPE, empPhone IN CHINOOK.EMPLOYEE.PHONE%TYPE,
    empFax IN CHINOOK.EMPLOYEE.FAX%TYPE, empEmail IN CHINOOK.EMPLOYEE.EMAIL%TYPE)
IS
BEGIN
    UPDATE chinook.employee
    SET employeeid = empId,  lastname = lname, firstname = fname, title = empTitle, reportsto = supervisor, birthdate = empBirthdate,
        hiredate = empHiredate, address = empAddress, city = empCity, state = empState, country = empCountry, postalcode = empPostal,
        phone = empPhone, fax = empFax, email = empFax
    WHERE employeeid = empId;
END;
/

-- Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE get_managers (empId IN CHINOOK.EMPLOYEE.EMPLOYEEID%TYPE, managerID OUT CHINOOK.EMPLOYEE.REPORTSTO%TYPE)
IS
BEGIN
  SELECT reportsto
  INTO managerID
  FROM chinook.employee
  WHERE employeeid = empId;
END;
/
  
/* 4.3 Stored Procedure Output Parameters */
-- Create a stored procedure that returns the name and company of a customer. 
CREATE OR REPLACE PROCEDURE get_customer_name_and_company
    (custId IN CHINOOK.CUSTOMER.CUSTOMERID%TYPE, customerName OUT VARCHAR2, customerCompany OUT CHINOOK.CUSTOMER.COMPANY%TYPE)
IS
BEGIN
    SELECT firstname || ' ' || lastname, company
    INTO customerName, customerCompany
    FROM chinook.customer
    WHERE customerid = custId;
END;
/

/**************************/
/**** 5.0 TRANSACTIONS ****/
/**************************/

-- Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
/** note : the constraints were altered in previous query **/


SET TRANSACTION NAME 'remove_invoice';

DECLARE
    invoice_Id NUMBER(5) := 1; 
BEGIN
    DELETE FROM chinook.invoice
    WHERE invoiceid = invoice_id;
END;

COMMIT;
/


-- Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE chinook.new_customer 
    (custid chinook.customer.customerid%type, fname chinook.customer.firstname%type, lname chinook.customer.lastname %type,
     email_addr chinook.customer.email%type)
IS
BEGIN
    INSERT INTO chinook.customer (customerid, firstname, lastname, email)
        VALUES  (custid, fname, lname, email_addr);
        
    COMMIT;
END;
/

/**********************/
/**** 6.0 TRIGGERS ****/
/**********************/

/* 6.1 AFTER/FOR */
-- Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER  new_employee_trigger
AFTER INSERT ON chinook.employee
FOR EACH ROW
BEGIN
     -- do some stuff;
END;
/

-- Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER update_album_trigger
AFTER UPDATE ON chinook.album
FOR EACH ROW
BEGIN
    -- do some stuff;
END;
/

-- Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER delete_customer_trigger
AFTER DELETE ON chinook.customer
FOR EACH ROW
BEGIN
    -- do some stuff;
END;
/


/*******************/
/**** 7.0 JOINS ****/
/*******************/

/* 7.1 INNER */
-- Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.

SELECT  firstname || ' ' || lastname AS name, invoiceid
    FROM chinook.customer c 
    JOIN chinook.invoice i 
    ON  c.customerid = i.customerid;
    
/* 7.2 OUTER */
--Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT c.customerid, firstname, lastname, invoiceid, total
    FROM chinook.customer c
    FULL JOIN chinook.invoice i
    ON c.customerid = i.customerid;
    
/* 7.3 RIGHT */
-- Create a right join that joins album and artist specifying artist name and title.
SELECT name, title
    FROM chinook.album al
    RIGHT JOIN chinook.artist ar
    ON al.artistid = ar.artistid;
    
/* 7.4 CROSS */
-- Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT *
    FROM chinook.album, chinook.artist
    ORDER BY name;

/* 7.5 SELF */
-- Perform a self-join on the employee table, joining on the reportsto column.
SELECT *
    FROM chinook.employee e1
    JOIN chinook.employee e2
    ON e1.reportsto = e2.employeeid;

    
