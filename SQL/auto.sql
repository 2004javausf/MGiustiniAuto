CREATE TABLE CUSTOMER (
CUSTOMER_ID INTEGER PRIMARY KEY,
F_NAME VARCHAR2 (20),
L_NAME VARCHAR2 (20),
USERNAME VARCHAR2 (20),
PASSWORD VARCHAR2 (20)
);

CREATE TABLE EMPLOYEE (
EMPLOYEE_ID INTEGER PRIMARY KEY,
F_NAME VARCHAR2 (20),
L_NAME VARCHAR2 (20),
USERNAME VARCHAR2 (20),
PASSWORD VARCHAR2 (20)
);

CREATE TABLE CAR (
CAR_ID INTEGER PRIMARY KEY,
CAR_MAKE VARCHAR2 (20),
CAR_MODEL VARCHAR2 (20),
CAR_YEAR VARCHAR2 (4),
CAR_COLOR VARCHAR2 (20),
CAR_PRICE INTEGER,
OWNED VARCHAR2 (3),
OWNER_ID INTEGER
);

CREATE TABLE PAYMENT_PLANS (
PLAN_ID INTEGER PRIMARY KEY,
PAYEE_ID INTEGER,
PLAN_LENGTH_MONTHS INTEGER,
PAYMENT_AMT INTEGER,
AMOUNT_PAID INTEGER,
REMAINING_PAYMENTS INTEGER
);

CREATE TABLE CUSTOMER_CARS (
CUSTOMER_ID INTEGER,
CAR_ID INTEGER,
CAR_MAKE VARCHAR2 (20),
CAR_MODEL VARCHAR2 (20),
ASKING_PRICE INTEGER,
PAYMENT_PLAN_ID INTEGER,
PLAN_LENGTH_MONTHS INTEGER,
PAYMENT_AMT INTEGER,
REMAINING_PAYMENTS INTEGER
);

--TABLE MODIFICATION
ALTER TABLE CUSTOMER_CARS
ADD CONSTRAINT PK_CUSTOMER_CARS
PRIMARY KEY (CUSTOMER_ID,CAR_ID);

--CONSTRAINTS
ALTER TABLE CAR
ADD CONSTRAINT FK_OWNER_ID
FOREIGN KEY (OWNER_ID) REFERENCES CUSTOMER(CUSTOMER_ID);

ALTER TABLE PAYMENT_PLANS
ADD CONSTRAINT FK_PAYEE_ID
FOREIGN KEY (PAYEE_ID) REFERENCES CUSTOMER(CUSTOMER_ID);

ALTER TABLE CUSTOMER_CARS
ADD CONSTRAINT FK_CUSTOMER_ID
FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER(CUSTOMER_ID);

ALTER TABLE CUSTOMER_CARS
ADD CONSTRAINT FK_CAR_ID
FOREIGN KEY (CAR_ID) REFERENCES CAR(CAR_ID);

ALTER TABLE CUSTOMER_CARS
ADD CONSTRAINT FK_PAYMENT_PLAN_ID
FOREIGN KEY (PAYMENT_PLAN_ID) REFERENCES PAYMENT_PLANS(PLAN_ID);