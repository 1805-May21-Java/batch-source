CREATE TABLE bankUser (
    user_id INTEGER,
    user_name VARCHAR(20) UNIQUE NOT NULL,
    user_pass VARCHAR(20) NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE bankAccount (
    account_id INTEGER,
    account_type  VARCHAR(10) NOT NULL, 
    account_balance NUMBER(12, 2)DEFAULT 0,
    PRIMARY KEY (account_id),
    CHECK (account_type IN ('Checking', 'Savings'))
);

CREATE TABLE bankUserAccount (
    user_id INTEGER,
    account_id INTEGER,
    FOREIGN KEY (user_id) REFERENCES bankUser(user_id),
    FOREIGN KEY (account_id) REFERENCES bankAccount(account_id)
);

drop table bankaccount;

CREATE SEQUENCE bankuserid_sq
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE bankacctid_sq
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER insert_bank_user_id
BEFORE INSERT ON bankUser
FOR EACH ROW
BEGIN
    SELECT bankuserid_sq.NEXTVAL INTO :NEW.user_id  FROM dual;
END;
/

CREATE OR REPLACE TRIGGER insert_bank_acct_id
BEFORE INSERT ON bankAccount
FOR EACH ROW
BEGIN
    SELECT bankacctid_sq.NEXTVAL INTO :NEW.account_id  FROM dual;
END;
/

-- Dummy Data

insert into bankuser values(1, 'adorasmith', 'password');
insert into bankuser values(2, 'mrmoneybags', 'password');

insert into bankaccount values(1, 'Checking', '213.45');
insert into bankaccount values(2, 'Savings', '3.50');
insert into bankaccount values(3, 'Checking', '4589.89');
insert into bankaccount values(4, 'Savings', 345789.90);

insert into bankuseraccount values (1,1);
insert into bankuseraccount values (1,2);
insert into bankuseraccount values (2,3);
insert into bankuseraccount values (2,4);

select user_name, account_type, account_balance
from bankuser u
join bankuseraccount ua on u.user_id = ua.user_id
join bankaccount a on ua.account_id = a.account_id;

SELECT * FROM bankUser;