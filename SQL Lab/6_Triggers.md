6.1a

> ```SQL
> CREATE OR REPLACE TRIGGER TR_Employee_BI
> AFTER INSERT ON EMPLOYEE
> FOR EACH ROW
> BEGIN
>     DBMS_OUTPUT.PUT_LINE('A new employee named ' || :NEW.FIRSTNAME || ' has been inserted into EMPLOYEE.');
> END;
> /
> ```

6.1b

> ```SQL
> CREATE OR REPLACE TRIGGER TR_Album_BI
> AFTER INSERT ON ALBUM
> FOR EACH ROW
> BEGIN
>     DBMS_OUTPUT.PUT_LINE('A new album named ' || :NEW.TITLE || ' has been inserted into EMPLOYEE.');
> END;
> /
> ```

6.1c

> ```SQL
> CREATE OR REPLACE TRIGGER TR_Customer_AD
> AFTER INSERT ON CUSTOMER
> FOR EACH ROW
> BEGIN
>     DBMS_OUTPUT.PUT_LINE('A customer by the name ' || :OLD.FIRSTNAME || ' has been deleted from table.');
> END;
> /
> ```
