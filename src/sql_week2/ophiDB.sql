--2.1
SELECT * from CHINOOK.EMPLOYEE;

SELECT * from CHINOOK.EMPLOYEE WHERE LASTNAME = 'King';

SELECT * from CHINOOK.EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

--2.2
SELECT * from CHINOOK.ALBUM ORDER BY TITLE DESC;

SELECT * from CHINOOK.CUSTOMER ORDER BY CITY;

--2.3
INSERT INTO CHINOOK.GENRE VALUES(26, 'Trance');
INSERT INTO CHINOOK.GENRE VALUES (27, 'Electro-House');

INSERT INTO Chinook.Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (9, 'Hill', 'Bob', 'IT Staff', 6, TO_DATE('1994-4-1 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2018-5-25 00:00:00','yyyy-mm-dd hh24:mi:ss'), '923 7 ST NW', 'Lethbridge', 'AB', 'Canada', 'T1H 1Y8', '+1 (403) 467-3352', '+1 (403) 467-8771', 'bob@chinookcorp.com');
INSERT INTO Chinook.Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (10, 'Jensen', 'Thomas', 'IT Staff', 6, TO_DATE('1994-4-1 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2018-5-25 00:00:00','yyyy-mm-dd hh24:mi:ss'), '923 7 ST NW', 'Lethbridge', 'AB', 'Canada', 'T1H 1Y8', '+1 (403) 467-3351', '+1 (403) 467-8770', 'thomas@chinookcorp.com');

INSERT INTO Chinook.Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (60, 'Charles', 'Wright', '3,Raj Bhavan Road', 'Bangalore', 'India', '560001', '+91 080 22289999', 'charles_wright@yahoo.in', 3);
INSERT INTO Chinook.Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) VALUES (61, 'Charles', 'Left', '3,Raj Bhavan Road', 'Bangalore', 'India', '560001', '+91 080 22289999', 'charles_left@yahoo.in', 3);

--2.4
UPDATE Chinook.Customer
Set FirstName = 'Robert', LastName = 'Walter'
Where FirstName = 'Aaron' AND Lastname = 'Mitchell';

Update Chinook.Artist set name = 'CCR' where name = 'Creedence Clearwater Revival';

--2.5
SELECT * from Chinook.Invoice where billingaddress like 'T%';

--2.6
Select * from Chinook.Invoice where total between 1 and 15;
Select * from Chinook.Employee where HIREDATE between TO_DATE('2003-6-1 00:00:00','yyyy-mm-dd hh24:mi:ss') and TO_DATE('2004-3-1 00:00:00','yyyy-mm-dd hh24:mi:ss');

--2.7
ALTER TABLE Chinook.INVOICE
DROP CONSTRAINT FK_INVOICECUSTOMERID;
/
ALTER TABLE Chinook.INVOICE
Add constraint FK_INVOICECUSTOMERID
Foreign key (CUSTOMERID) references Chinook.CUSTOMER(CUSTOMERID) ON DELETE CASCADE;
/
ALTER TABLE Chinook.INVOICELINe
drop constraint FK_INVOICELINEINVOICEID;
/
Alter table CHinook.INVOICELINE
Add constraint FK_INVOICELINEINVOICEID
Foreign Key (INVOICEID) references Chinook.INVOICE(InvoiceID) on delete cascade;
/
Delete from Chinook.Customer where FirstName = 'Robert' and LastName = 'Walter';

--3.1
Create or replace Function THISISTHETIME
return TIMESTAMP 
is
begin
    return Current_timestamp();
end;
/
SET SERVEROUTPUT ON;

BEGIN 
    DBMS_OUTPUT.PUT_LINE(THISISTHETIME());
END;

Create or replace function mediaTypeLength(mediaID in number)
return number
is 
returnNumber number;
begin
    select length(NAME) into returnNumber from chinook.mediatype where Mediatypeid = mediaId;
    return returnNumber;
end;
/
BEGIN 
    DBMS_OUTPUT.PUT_LINE(mediaTypeLength(2));
END;

--3.2
Create or replace function averageInvoiceTotal
return number
is
returnNumber number;
begin
    select avg(total) into returnnumber from Chinook.invoice;
    return returnNumber;
end;
/
BEGIN 
    DBMS_OUTPUT.PUT_LINE(averageInvoiceTotal());
END;
/
create or replace function expensiveTrack
return varchar
is
returnName varChar2(100);
begin
    Select NAME into returnName from (select * from Chinook.Track order by UNITPRICE desc) where ROWNUM <=1 ;
    return returnName;
end;
/
BEGIN 
    DBMS_OUTPUT.PUT_LINE(expensiveTrack());
END;
--3.3
create or replace function avgInvoice(invoice_ID in number)
return number
is
returnNumber number;
begin
    select avg(UNITPRICE) into returnnumber from chinook.invoiceline where invoiceid = invoice_id;
    return returnnumber;
end;
/
BEGIN 
    DBMS_OUTPUT.PUT_LINE(avgInvoice(3));
END;
--3.4
--create or replace function bornBy1968
--return Chinook.Employee%RowType
--is
--returnRow Chinook.Employee%RowType;
--begin
--    Select * into returnRow from Chinook.Employee where Extract(year from To_date(birthdate, 'DD-MON-RR')) > 1968;
--    return returnRow;
--end;
--/
create or replace function bornBy1968
return SYS_REFCURSOR
is
cursor SYS_REFCURSOR;
begin
    OPEN cursor FOR Select * from Chinook.Employee where Extract(year from To_date(birthdate, 'DD-MON-RR')) > 1968;
    return cursor;
end;
--/
--BEGIN 
--    DBMS_OUTPUT.PUT_LINE(bornBy1968());
--END;
--4.1
create or replace procedure getEmployeeName(cursor out sys_refcursor)
is
begin
    open cursor for select firstName, LastName from Chinook.Employee;
end;

--4.2
create or replace procedure updateEmployee(
employeeID IN Chinook.Employee.employeeID%TYPE,
lastName IN Chinook.Employee.lastName%TYPE,
firstName IN Chinook.Employee.firstName%TYPE,
title IN Chinook.Employee.title%TYPE,
reportsTo IN Chinook.Employee.reportsTo%TYPE,
birthdate IN Chinook.Employee.birthdate%TYPE,
hireDate IN Chinook.Employee.hireDate%TYPE,
address IN Chinook.Employee.address%TYPE,
city IN Chinook.Employee.city%TYPE,
state IN Chinook.Employee.state%TYPE,
country IN Chinook.Employee.country%TYPE,
postalCode IN Chinook.Employee.postalCode%TYPE,
phone IN Chinook.Employee.phone%TYPE,
fax IN Chinook.Employee.fax%TYPE,
email IN Chinook.Employee.email%TYPE)
is
begin
    update Chinook.Employee set
    lastName = lastName, firstName = firstName, title = title,
    reportsTo = reportsTo, birthdate = birthdate, hireDate = hireDate,
    address = address, city = city, state = state, country = country, postalCode = postalCode,
    phone = phone, fax = fax, email = email
    where employeeID = employeeID;
END;
/
create or replace procedure getManager(managerName out varChar, employeeID in number)
is
managerName varChar2(50);
reportsToTemp number;
begin
    select reportsTo into reportsToTemp from Chinook.Employee where employeeId = employeeID;
    select firstName into managerName from Chinook.employee where employeeId = reportsToTemp;
end;

--4.3
create or replace procedure getCustomerInfo(customerID in number, customerName out varchar, customerCompany out varchar)
is

begin
    select firstname, company into customerName, customerCompany from Chinook.Customer where customerId = customerId;
end;

--5.0
--ALTER TABLE Chinook.INVOICELINe
--drop constraint FK_INVOICELINEINVOICEID;
--/
--Alter table CHinook.INVOICELINE
--Add constraint FK_INVOICELINEINVOICEID
--Foreign Key (INVOICEID) references Chinook.INVOICE(InvoiceID) on delete cascade;
--/
start transaction
    delete from Chinook.Invoice where invoiceId = invoiceId;
commit;

create or replace procedure addCustomer(customerFirstName in varchar, customerLastName in varchar, customerId in number, customerEmail in varchar)
is
begin
    insert into Chinook.Customer (firstName, lastName, customerID, email) values (customerFirstName, customerLastName, customerId, customerEmail);
    commit;
end;

--6.1
create or replace trigger afterEmployeeInsert
after insert on Chinook.Employee for each row
begin
    Select :NEW.FirstName from dual;
end;
/
create or replace trigger afterAlbumInsert
after insert on Chinook.Album for each row
begin
    Select :NEW.Title from dual;
end;
/
create or replace trigger afterCustomerDelete
after delete on Chinook.Customer for each row
begin
    Select :NEW.FirstName from dual;
end;

--7.1
Select invoiceID, firstName, lastName from Chinook.Customer join Chinook.invoice on Chinook.Customer.CustomerID = chinook.Invoice.CustomerID;

--7.2
select Chinook.Customer.CustomerID, firstname, lastname, invoiceId, total from Chinook.Customer full join Chinook.invoice on Chinook.Customer.CustomerID = Chinook.Invoice.CustomerID;

--7.3
select name, title from Chinook.album right join Chinook.artist on Chinook.album.artistId = chinook.Artist.artistId;

--7.4
select * from Chinook.Album cross join Chinook.artist order by Chinook.artist.name asc;

--7.5
select * from Chinook.Employee t1, Chinook.Employee t2 where t1.reportsTo = t2.EmployeeID;

CREATE OR REPLACE PROCEDURE INTEREST(ACCOUNTID IN NUMBER, VAL IN NUMBER)
IS
BEGIN
    UPDATE ACCOUNT
    SET BALANCE = BALANCE + VAL
    WHERE ACCOUNTID = ACCOUNTID;

END;