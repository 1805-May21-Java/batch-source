--**********************************************************************************
--MAKE SURE BEFORE RUNNING THE DRIVER TO CREATE THE FOLLOWING TABLE EXACTLY AS IT IS
--**********************************************************************************
CREATE TABLE ACCOUNT (
USR VARCHAR2(25),
USERNAME VARCHAR2(25),
PWORD VARCHAR2(16),
BALANCE FLOAT(8)
)
--since USERNAME is going to be unique, it is our primary key although it isn't specified here
--if you wish, you can DROP TABLE ACCOUNT if you want to start fresh

CREATE OR REPLACE PROCEDURE DELETE_ACCOUNT(D_USERNAME IN VARCHAR2)
IS
BEGIN
    DELETE FROM ACCOUNT WHERE USERNAME = D_USERNAME;
END;
/