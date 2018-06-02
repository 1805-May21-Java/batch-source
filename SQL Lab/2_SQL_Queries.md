2.1a

> ```SQL
> SELECT * 
> FROM EMPLOYEE;
> ```

2.1b

> ```SQL
> SELECT * 
> FROM EMPLOYEE 
> WHERE LASTNAME='King';`
> ```
2.1c

> ```SQL
> SELECT * 
> FROM EMPLOYEE 
> WHERE FIRSTNAME='Andrew' 
> 	AND REPORTSTO is NULL;`
> ```

2.2a

> ```SQL 
> SELECT * 
> FROM ALBUM 
> ORDER BY TITLE DESC;`
> ```

2.2b

> ```SQL 
> SELECT * 
> FROM CUSTOMER 
> ORDER BY CITY desc;`
> ```

2.3a

> ``` SQL 
> INSERT INTO GENRE 
> 	VALUES (26,'Spoken Word');
> INSERT INTO GENRE 
> 	VALUES (27,'Regular Poetry');
> INSERT INTO GENRE 
> 	VALUES (28,'Slam Poetry');
> ```

2.3b

> ```SQL 
> INSERT INTO EMPLOYEE 
> 	VALUES (9, 'Post','Austin','Entertainment',1,'1995-7-4','2007-1-6 00:00:00','627 7W St','Albright','AB','Canada','T18 S72');
> INSERT INTO EMPLOYEE 
> 	VALUES (10, 'Malone','Post','Entertainment',1,'1995-7-4','2007-1-6 00:00:00','627 7W St','Albright','AB','Canada','T18 S72');
> ```

2.3c

> ```SQL 
> INSERT INTO CUSTOMER (CUSTOMERID,CITY,FIRSTNAME,LASTNAME,COMPANY,EMAIL) 
> 	VALUES ('60','New Orleans','Jen','Janson','Revature','jj@revature.com');
> INSERT INTO CUSTOMER (CUSTOMERID,COUNTRY,STATE,FIRSTNAME,LASTNAME,COMPANY,EMAIL) 
> 	VALUES ('61','France','PV','Pierre','Montaigne','Revature FR','Montpierre@revature.co.fr');
> ```

2.4a

> ```SQL
> UPDATE CUSTOMER 
> SET FIRSTNAME='Robert', LASTNAME='Walter' 
> WHERE FIRSTNAME='Aaron' AND LASTNAME='Mitchell';
> ```

2.4b

> ```SQL 
> UPDATE ARTIST 
> SET ARTIST.NAME='CCR' 
> WHERE ARTIST.NAME='Creedence Clearwater Revival';
> ```

2.5

> ```SQL
> SELECT * 
> FROM CUSTOMER 
> WHERE ADDRESS LIKE 'T%';
> ```

2.6a

> ```SQL
> SELECT * 
> FROM INVOICE 
> WHERE TOTAL BETWEEN 
> '15' AND '50';
> ```

2.6b

> ```SQL 
> SELECT *
> FROM EMPLOYEE
> WHERE HIREDATE BETWEEN 
> 	TO_DATE('2003/06/01','YYYY/MM/DD') 
> 	AND 
> 	TO_DATE('2004/03/01','YYYY/MM/DD');
> ```

2.7

> ```SQL 
> DELETE 
> FROM CUSTOMER
> WHERE EXISTS(
> 		SELECT * 
> 		FROM CUSTOMER 
> 		WHERE FIRSTNAME='ROBERT' 
> 		AND LASTNAME='WALTER');
> ```
