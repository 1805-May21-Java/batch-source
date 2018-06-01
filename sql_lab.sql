--2.1
SELECT * FROM chinook.employee;

SELECT * FROM chinook.employee
    WHERE lastname = 'King';
    
SELECT * FROM chinook.employee
    WHERE firstname = 'Andrew' AND reportsto IS NULL;

--2.2
SELECT * FROM chinook.album
    ORDER BY chinook.album.title DESC;

SELECT chinook.customer.firstname FROM chinook.customer 
    ORDER BY chinook.customer.city ASC;

--2.3
select * from chinook.employee;

INSERT INTO chinook.genre
    VALUES(26,'Asian');

INSERT INTO chinook.genre
    VALUES(27,'Night Rock');
    
INSERT INTO chinook.employee
    VALUES(9, 'Houth', 'Vannara', 'Prof.', 3, DATE '1900-01-01', DATE '2018-05-21', '189S 298Ave', 'Dophin', 'VA', 'USA', '89382', '900 092-1029', '00 092-1024', 'jackson@gmail.com');

INSERT INTO chinook.employee
    VALUES(10, 'Wonb', 'Yobomo', 'Teacher.', 3, DATE '1900-03-01', DATE '2012-05-21', '102N 298Ave', 'Elephant', 'VA', 'USA', '89432', '900 022-1029', '00 012-1024', 'Justinx@gmail.com');

INSERT INTO chinook.customer
    VALUES(60, 'Momabo', 'Ohshibo', 'Apple', '13S Square Ave', 'Cambridge', 'MA', 'USA', '90391', '893-029-0922', '903-092-3221', 'Saveme@gmail.com', 3);

INSERT INTO chinook.customer
    VALUES(61, 'Bomabo', 'NOhshibo', 'Banana', '93S Bquare Ave', 'Mambridge', 'MA', 'USA', '80391', '393-029-0922', '503-092-3221', 'Gaveme@gmail.com', 1);

--2.4
UPDATE chinook.customer
    SET firstname = 'Robert', lastname='Walter'
    WHERE firstname = 'Aaron' AND lastname = 'Mitchell';
    
UPDATE chinook.artist
    SET name='CCR'
    WHERE name='Creedence Clearwater Revival';
    
--2.5

SELECT * FROM chinook.invoice
    WHERE billingaddress like 'T%';
    
--2.6
SELECT * FROM chinook.invoice
    WHERE total BETWEEN 15 AND 50;
    
SELECT * FROM chinook.employee
    WHERE hiredate BETWEEN DATE '2003-06-01' AND DATE '2004-03-01';

--2.7


ALTER TABLE chinook.invoiceline
    DROP CONSTRAINT FK_INVOICELINEINVOICEID;
    
ALTER TABLE chinook.invoice
    DROP CONSTRAINT FK_INVOICECUSTOMERID;

ALTER TABLE chinook.invoiceline
    ADD CONSTRAINT FK_INVOICELINEINVOICEID FOREIGN KEY (INVOICEID) REFERENCES chinook.invoice (INVOICEID)
    ON DELETE CASCADE;
    
ALTER TABLE chinook.invoice
    ADD CONSTRAINT FK_INVOICECUSTOMERID FOREIGN KEY (CUSTOMERID) REFERENCES chinook.customer (CUSTOMERID)
    ON DELETE CASCADE;
    

DELETE FROM chinook.customer
    WHERE firstname ='Robert' AND lastname = 'Walter';



--3.1
CREATE OR REPLACE Function CurrentTime
   RETURN varchar2
IS
    result varchar2(10);
BEGIN
    SELECT to_char(CURRENT_TIMESTAMP, 'hh:mi:ss') INTO result FROM DUAL ;
    

RETURN result;
END;
/

CREATE OR REPLACE Function Name_Length
    RETURN NUMBER
IS

SET serveroutput on;
BEGIN
    DBMS_OUTPUT.PUT_LINE(CurrentTime());

END;
/

--3.2


--3.4


--4.1

--4.2


--4.3

--5

--6

--7.1

--7.2

--7.3

--7.4

--7.5
