CREATE TABLE bankUser (
    user_id INTEGER,
    user_name VARCHAR(20) UNIQUE NOT NULL,
    user_pass VARCHAR(20) NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE bankAccount (
    account_id INTEGER,
    account_type  VARCHAR2(10) NOT NULL, 
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
/

CREATE OR REPLACE PROCEDURE insert_into_user(userId OUT INTEGER, username IN VARCHAR2, userpass IN VARCHAR2)
AS
BEGIN
    select user_id_seq.nextval into userid from dual;
    insert into bankuser values(userid, username, userpass);
END;
/

CREATE OR REPLACE PROCEDURE add_new_account(userid IN INTEGER, account_type IN VARCHAR2, account_balance IN NUMBER)
AS
BEGIN

    insert into bankaccount values (acct_id_seq.nextval, account_type, account_balance);
    insert into bankuseraccount values(userid, acct_id_seq.currentval);
END;

/

CREATE OR REPLACE PROCEDURE insert_new_user_account(username IN VARCHAR2, userpass IN VARCHAR2)
AS
BEGIN
    -- insert user and get id
    insert into bankuser values((user_id_seq.nextval), username, userpass);
    
    --insert account and get id
    insert into bankaccount values ( (acct_id_seq.nextval ), 'Checking', 0);

    insert into bankuseraccount values(user_id_seq.currval, acct_id_seq.currval);
END;
/

CREATE SEQUENCE USER_ID_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE SEQUENCE ACCT_ID_SEQ
START WITH 1
INCREMENT BY 1;


/
insert into bankuser values(null, 'adora', 'test');