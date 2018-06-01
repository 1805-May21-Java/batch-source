-------------------------------2.0 SQL Queries
--2.1 Select
select * from Chinook.employee;
select * from Chinook.employee where Lastname like 'King';
select * from Chinook.employee where firstname like 'Andrew' and reportsto is null;
--2.2 Order By
select * from Chinook.album order by title desc;
select firstname from Chinook.customer order by city asc;
--2.3 Insert Into
insert into Chinook.genre values(26,'KPop');
insert into Chinook.genre values(27,'Bluegrass');
INSERT INTO Chinook.Employee (EmployeeId, LastName, FirstName) VALUES (9, 'Smith', 'John');
insert into Chinook.employee (EmployeeId, LastName, FirstName) values (10,'Farquad', 'Lord');
insert into Chinook.customer (CustomerId, FirstName, LastName, Email) values (60,'Smith','John','smithjohn@gmail.com');
insert into Chinook.customer (CustomerId, FirstName, LastName, Email) values (61,'Tyson','Mike','miketyson@gmail.com');
--2.4 Update
update Chinook.customer set firstname='Robert', lastname='Walter' where firstname='Aaron' and lastname='Mitchell';
update Chinook.artist set name='CCR' where name='Creedence Clearwater Revival';
--2.5 Like
select * from Chinook.invoice where billingaddress like 'T%';
--2.6 Between
select * from Chinook.invoice where total between 15 and 50;
select * from Chinook.employee where hiredate between date '2003-6-1' AND date '2004-3-1'; 
--2.7 Delete
INSERT INTO Chinook.Customer (CustomerId, FirstName, LastName, Address, City, State, Country, PostalCode, Phone, Email, SupportRepId) VALUES (32, 'Aaron', 'Mitchell', '696 Osborne Street', 'Winnipeg', 'MB', 'Canada', 'R3L 2B9', '+1 (204) 452-6452', 'aaronmitchell@yahoo.ca', 4);

alter table Chinook.Invoice drop constraint FK_invoicecustomerid;
ALTER TABLE Chinook.Invoice ADD CONSTRAINT FK_InvoiceCustomerId FOREIGN KEY (CustomerId) REFERENCES Chinook.Customer (CustomerId)  on delete cascade;
ALTER TABLE Chinook.InvoiceLine ADD CONSTRAINT FK_InvoiceLineInvoiceId
    FOREIGN KEY (InvoiceId) REFERENCES Chinook.Invoice (InvoiceId)  ;
delete from Chinook.customer where firstname='Robert' and lastname='Walter';

-----------------------------------------------------3.0 Functions
-- System Functions
create function Chinook.GetTime
return timestamp
is
begin
    return Current_Timestamp;
end;
/
select Chinook.gettime() from dual;

create function Chinook.getMediaLength(name varchar2)
return number
is
begin
    return length(name);
end;
/
select Chinook.getMediaLength(name) from Chinook.Mediatype;

--3.2 System Defined Aggregate Functions
create or replace function Chinook.getAvgInvoice
return number
is
average number(5,2);
begin
    select avg(total) into average from Chinook.Invoice;
    return average;
end;
/
select Chinook.getAvgInvoice() from dual;

create or replace function Chinook.getMaxTrack
return number
is
maximum number;
svar sys_refcursor;
begin
    open svar for
    select name from Chinook.track
    where price = (
        select max(price) from Chinook.track);
    return svar;
end;
/
declare
    s sys_refcursor;
begin
    s := Chinook.getMaxTrack();
    dbms_sql.return_result(s);
end;
/
select Chinook.getMaxTrack() from dual;
--3.3 User defined scalar functions
create or replace function Chinook.getAvgInvoiceLine
return number
is
 total number;
 numLine number;
 average number(5,2);
begin
    select sum(unitprice) into total from Chinook.invoiceline;
    select count(unitprice) into numLine from Chinook.invoiceline;
    average := total/numLine;
    return average;    
end;
/
select Chinook.getAvgInvoiceLine() from dual;
--3.4 User Defined Table Valued Functions

create type Chinook.empl as object(
    EMP_ID NUMBER(5),
    EMP_NAME VARCHAR2(50),
    BIRTHDAY DATE,
    MONTHLY_SALARY NUMBER(7,2),
    DEPT_ID NUMBER(5),
    HIRE_DATE DATE,
    POSITION VARCHAR2(20),
    MANAGER_ID NUMBER(5)
);

create type Chinook.empls as Table of Chinook.empl;

create or replace function Chinook.getOldPeople
return CHinook.empls
is
    results Chinook.empls := Chinook.empls();
cursor c_empls is select * from Chinook.employee where birthdate > date '1969-1-1';
begin
    for rec in c_empls loop
        results.extend;
        results(results.last):=Chinook.empl(rec.EmployeeId ,rec.LastName,
        rec.FirstName ,rec.Title ,rec.ReportsTo, rec.BirthDate, rec.HireDate,
        rec.Address, rec.City, rec.State, rec.Country, rec.PostalCode, rec.Phone,
        rec.fax, rec.email);
    END LOOP;
    return results;
end;
/
select * from table(Chinook.getOldPeople());
------------------------------------4.0 Stored Procedures
--4.1 Basic Stored Procedure
set serveroutput on;
create or replace procedure Chinook.GetAllNames(S out sys_refcursor)
is
begin
    open s for
    select firstname, lastname from Chinook.employee;
end;
/
declare
svar sys_refcursor;
fName Chinook.employee.firstname%type;
lName Chinook.employee.lastname%type;
begin
    Chinook.getallnames(svar);
    loop
        fetch svar into fname, lname;
        exit when svar%notfound;
        dbms_output.put_line(fname||' '||lname);
    end loop;
    close svar;
end;
/
--4.2 Stored Procedure Input paramaters
create or replace procedure Chinook.updateEmp(empid in Chinook.employee.employeeid%type, newtitle in Chinook.employee.title%type)
is
begin
    update Chinook.employee set title =newtitle where employeeid = empid;
end;
/
begin
    Chinook.updateemp(10,'manager');
end;

create or replace procedure Chinook.getmanagers(empid in Chinook.employee.employeeid%type)
is
empname Chinook.employee.firstname%type;
managername Chinook.employee.firstname%type;
begin
    select firstname into empname from Chinook.employee where employeeid = empid;
    select firstname into managername from Chinook.employee where employeeid=(
        select reportsto from Chinook.employee where employeeid=empid);
    dbms_output.put_line('The manager of '||empname||' is '||managername);
end;
/
begin 
    Chinook.getmanagers(7);
end;
--4.3 Stored Procedure Output paramaters
create or replace procedure Chinook.customerInfo(cusID in Chinook.customer.customerid%type, s out sys_refcursor)
is
begin
    open s for
        select firstname, company from Chinook.customer where customerid = cusid;
end;
/
declare
svar sys_refcursor;
cname Chinook.customer.firstname%type;
ccompany Chinook.customer.company%type;
begin
    Chinook.customerinfo(3,svar);
    loop
        fetch svar into cname, ccompany;
        exit when svar%notfound;
        dbms_output.put_line(cname||' works for '||ccompany);
    end loop;
    close svar;
end;
/
-----------------------------5.0 Transactions
create or replace procedure Chinook.deleteinvoice(invid in Chinook.invoice.invoiceid%type)
is
begin
    delete from Chinook.invoice where invoiceid=invid;
    commit;
end;
/
begin
    Chinook.deleteinvoice(1);
end;

create or replace procedure Chinook.newcustomer
is
begin
    insert into Chinook.customer (CustomerId, FirstName, LastName, Email) values (62,'Mouse','Mickey','mickeymouse@gmail.com');
    commit;
end;
/
begin
    Chinook.newcustomer();
end;
------------------------------ 6.0 Triggers
--6.1 After/For
--Apparently, DBMS_OUTPUT does not properly display any outputs during a trigger
create or replace trigger Chinook.T_Insert
after insert on Chinook.employee
begin
  dbms_output.put_line('Employee Inserted');
end;
/
INSERT INTO Chinook.Employee (EmployeeId, LastName, FirstName) VALUES (11, 'Barry', 'Allen');
create or replace trigger Chinook.T_Update
after update on Chinook.Album
begin
    dbms_output.put_line('Album Updated');
end;
/
create or replace trigger Chinook.T_Delete
after delete on Chinook.customer
begin
    dbms_output.put_line('Customer Deleted');
end;
/

-----------------------------------7.0 Joins
--7.1 Inner
select firstname, invoiceid from
    Chinook.customer C join Chinook.invoice I on C.customerid=I.customerid;
    
--7.2 Outer
select C.CustomerId, firstname, lastname, invoiceId, total from
    Chinook.customer C full outer join Chinook.invoice I on C.customerid=I.customerid;
--7.3 Right
select name, title from
    Chinook.Album Al right outer join Chinook.Artist Ar on Ar.artistid=Al.artistid;
    
--7.4 Cross
select * from Chinook.Album Al cross join Chinook.Artist Ar
    where Al.artistid=Ar.artistid
    order by name asc;
--7.5 Self
select * from Chinook.employee E1, Chinook.employee E2
    where E1.employeeid = E2.reportsto;