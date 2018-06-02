# SQL Sublanguages

## DDL (Data Definition Language)
- __CREATE__
	- `TABLE [TABLE_NAME](`
		- `[COLUMN_NAME] [DATATYPE (VAL)] ,`
		- `[COLUMN_NAME] [DATATYPE (VAL)] );`
	- `INDEX`
	- `VIEW`
- __DROP__ //Removes a table, it's indexes and priveleges without firing DML triggers.
	- `DATABASE [DATABASE_NAME]`
	- `INDEX [INDEX_NAME]` (DB2/Oracle, MySQL)
	- `TABLE [TABLE_NAME]`
- __ALTER__
	- `TABLE [TABLE NAME]`
		- `ADD [COLUMN_NAME] [DATATYPE (VAL)];`
		- `DROP [COLUMN_NAME] [DATATYPE (VAL)];`
- __TRUNCATE__ //Cannot be rolled back. No triggers fire. Deletes faster. Removes ALL rows.
	- `TABLE [TABLE_NAME]` 

## DML (Data Manipulation Language)
- __INSERT__
	- `INTO [TABLE_NAME] (COLUMN_NAME) VALUES (VALUE 1, VALUE 2...);`
- __UPDATE__
	- `[TABLE_NAME]`
		- `SET COLUMN_1=VALUE, COLUMN2=VALUE,...`
		- `WHERE ANY_COLUMN=VALUE;`
- __SELECT__ (See DQL)
- __DELETE__ //Need to COMMIT or ROLLBACK, fires triggers.
	- `FROM [TABLE_NAME] WHERE [COLUMN_NAME]=(VALUE)`
	- `FROM [TABLE_NAME]` //Deletes table.
	- `* FROM [TABLE_NAME]` //Also deletes table.

## DQL (Data Query Language) // SELECT
- __SELECT__
	- `[COLUMN_NAME(S)] FROM [TABLE_NAME]`
	- `* FROM [TABLE_NAME]` //Selects the whole table.
	- `DISTINCT [COLUMN_NAME(S)] FROM [TABLE_NAME]`
	- `TOP [NUMBER/PERCENT] [COLUMN_NAME(S)] FROM [TABLE_NAME]`
- FROM
	- (e.g.) `SELECT EMPLOYEE_NAME __FROM__ EMPLOYEES`
	- Returns a table to the select statement.
- WHERE
	- (e.g.) `SELECT EMPLOYEE_SALARY FROM EMPLOYEES __WHERE EMPLOYEE_NAME=MARK__`
	- Restricts the selection to a specific value.
- ORDER BY
- GROUP BY 
- HAVING

## TCL (Transaction Control Language)
- COMMIT (DML)
- SAVEPOINT
- ROLLBACK

## DCL (Data Control Language)
- GRANT
- REVOKE
