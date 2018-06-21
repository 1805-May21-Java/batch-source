CREATE TABLE employee (
    emp_id NUMBER(5) CONSTRAINT pk_emp PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    reports_to NUMBER(5),
    email VARCHAR(50),
    emp_username VARCHAR(50),
    emp_password VARCHAR(50)
);

CREATE TABLE request (
    req_id NUMBER(5) CONSTRAINT pk_req PRIMARY KEY,
    img VARCHAR(100),
    emp_id NUMBER(5) CONSTRAINT fk_req_emp REFERENCES employee ON DELETE CASCADE,
    manager_id NUMBER(5) CONSTRAINT fk_req_man REFERENCES employee,
    title VARCHAR(100),
    amount DECIMAL(6, 2) NOT NULL,
    comments VARCHAR(256)
);

-- GENERATE PRIMARY KEYS FOR EMPLOYEE AND REQUEST
CREATE SEQUENCE sq_employees_pk
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER tr_insert_employee
BEFORE INSERT ON employee
FOR EACH ROW
BEGIN
    SELECT sq_employees_pk.nextval INTO :NEW.emp_id FROM dual;
END;
/

CREATE SEQUENCE sq_requests_pk
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER tr_insert_request
BEFORE INSERT ON request
FOR EACH ROW
BEGIN
    SELECT sq_requests_pk.nextval INTO :NEW.req_id FROM dual;
END;
/



---- CREATE DUMMY DATA
INSERT INTO employee (first_name, last_name, email, phone, emp_username, emp_password)
VALUES ('Bruce', 'Wayne', 'iamthenight@aol.com', '123-456-7890', 'theboss', 'batman');

INSERT INTO employee (first_name, last_name, reports_to, email, phone, emp_username, emp_password)
VALUES ('Barbara', 'Gordon', 1, 'oracle@gmail.com', '908-765-4321', 'oracle', 'batgirl');
INSERT INTO employee (first_name, last_name, reports_to, email, phone, emp_username, emp_password)
VALUES ('Richard', 'Grayson', 1, 'dick_grayson@gmail.com', '555-555-5555', 'flyinggrayson', 'nightwing');
INSERT INTO employee (first_name, last_name, reports_to, email, phone, emp_username, emp_password)
VALUES ('Duke', 'Thomas', 1, 'dthomas2016@gmail.com', '574-734-8888', 'dthomas', 'thesignal');

INSERT INTO employee (first_name, last_name, reports_to, email, phone, emp_username, emp_password)
VALUES ('Dinah', 'Lance', 2, 'pretty_birb@hotmail.com', '458-444-2364', 'canarycry', 'blackcanary');
INSERT INTO employee (first_name, last_name, reports_to, email, phone, emp_username, emp_password)
VALUES ('Tim', 'Drake', 3, 'techwhiz@gmail.com', '837-288-9567', 'detectiveDrake', 'redrobin');
INSERT INTO employee (first_name, last_name, reports_to, email, phone, emp_username, emp_password)
VALUES ('Helena', 'Bertinelli', 2, 'bertinelli2@aol.com', '334-789-5589', 'matron', 'huntress');
INSERT INTO employee (first_name, last_name, reports_to, email, phone, emp_username, emp_password)
VALUES ('Selena', 'Kyle', 1, 'crazy_cat_lady@gmail.com', '889-764-9898', 'catburgler', 'catwoman');
INSERT INTO employee (first_name, last_name, reports_to, email, phone, emp_username, emp_password)
VALUES ('James', 'Gordon', null, 'commish_jgordon@gcpd.com', '908-765-4321', 'ifoughtthelaw', 'andthelawwon');
INSERT INTO employee (first_name, last_name, reports_to, email, phone, emp_username, emp_password)
VALUES ('Jason', 'Todd', 3, 'internetemail@gmail.com', '222-222-2222', 'outlaw', 'redhood');
INSERT INTO employee (first_name, last_name, reports_to, email, phone, emp_username, emp_password)
VALUES ('Damian', 'Wayne', 3, 'batboy@gmail.com', '123-456-7890', 'dwayne', 'robin');
INSERT INTO employee (first_name, last_name, reports_to, email, phone, emp_username, emp_password)
VALUES ('Alfred', 'Pennyworth', 1, 'apennyworth1@verizon.net', '123-456-7890', 'penny1', 'batbutler');

INSERT INTO employee (first_name, last_name, reports_to, email, phone, emp_username, emp_password)
VALUES ('Harvey', 'Bullock', 9, 'det_hbullock@gcpd.com', '875-111-1234', 'hbullock', 'detective');
INSERT INTO employee (first_name, last_name, reports_to, email, phone, emp_username, emp_password)
VALUES ('Maggie', 'Sawyer', 9, 'lt_msawyer@gcpd.com', '999-234-5678', 'msawyer', 'lieutenant');
INSERT INTO employee (first_name, last_name, reports_to, email, phone, emp_username, emp_password)
VALUES ('Stephanie', 'Brown', 8, 'steph_brown3@gmail.com', '717-456-9873', 'steph3', 'spoiler');
INSERT INTO employee (first_name, last_name, reports_to, email, phone, emp_username, emp_password)
VALUES ('Cassandra', 'Cain', 6, 'shakespeare_fan@gmail.com', '717-456-9873', 'blackbat', 'orphan');

INSERT INTO employee (first_name, last_name, reports_to, email, phone, emp_username, emp_password)
VALUES ('Kate', 'Kane', 14, 'katherine_kane@gmail.com', '465-765-9876', 'armypride', 'batwoman');
INSERT INTO employee (first_name, last_name, reports_to, email, phone, emp_username, emp_password)
VALUES ('Crispen', 'Allen', 13, 'det_callen@gcpd.com', '123-123-1234', 'callen', 'thespectre');
INSERT INTO employee (first_name, last_name, reports_to, email, phone, emp_username, emp_password)
VALUES ('Renee', 'Montoya', 13, 'det_rmontoya@gcpd.com', '876-987-9876', 'rmontoya', 'thequestion');

commit;


SELECT DISTINCT e.emp_id, e.first_name, e.last_name, e.reports_to, e.email, e.phone, e.emp_username, e.emp_password
FROM employee e, employee m
WHERE e.emp_id = m.reports_to;

ALTER TABLE request
ADD date_created DATE;

ALTER TABLE request
ADD date_approved DATE;
/

-- create dummy request data
INSERT INTO request (emp_id, title, amount, comments, date_created)
VALUES ( 12, 'Cleaning supplies (various)', 967.60, 'Batcave doesn''t clean itself Master Wayne.', CURRENT_TIMESTAMP);
INSERT INTO request (emp_id, title, amount, comments, date_created)
VALUES ( 12, 'Travel expenses', 5200.55, 'Planes, trains, and automobiles, plus hotel expenses.', CURRENT_TIMESTAMP);
INSERT INTO request (emp_id, title, amount, comments, date_created)
VALUES ( 16, 'Reading body language online course', 85.00, 'The course comes with access codes for up to 10 people. Should be useful.', CURRENT_TIMESTAMP);
INSERT INTO request (emp_id, title, amount, comments, date_created)
VALUES ( 6, 'Work laptop', 2500.00, 'It is a very good laptop.', CURRENT_TIMESTAMP);

ALTER TABLE employee
ADD manager_name VARCHAR(50);

COMMIT;

SELECT *
FROM request
WHERE emp_id=12;

-- number of employees per manager
SELECT COUNT(emp.emp_id) AS EmployeeCount, mng.ManagerName AS ManagerName
FROM employee emp, 
(SELECT DISTINCT e.emp_id AS ManagerId, e.first_name AS ManagerName
FROM employee e, employee m
WHERE e.emp_id = m.reports_to) mng
WHERE emp.reports_to = mng.ManagerId
GROUP BY mng.ManagerId, mng.ManagerName;


SELECT *
FROM employee tier1
WHERE reports_to = 9
OR EXISTS (SELECT *
FROM employee tier2
WHERE emp_id = tier1.reports_to
AND (reports_to = 9
OR EXISTS (SELECT *
FROM employee tier3
WHERE emp_id = tier2.reports_to
AND reports_to = 9)));



