# 🏦 Bank Management System

A **Java Swing** desktop application for managing basic banking operations such as account creation, login, deposits, withdrawals, transaction history, balance inquiry, and PIN change — backed by a **MySQL** database with **AES-encrypted credentials** for secure connections.

---

## 📌 Features
- **Multi-step Account Registration** – Collects personal, account, and security details in three steps.
- **Secure Login** – Validates user credentials (card number & PIN) using JDBC and AES-decrypted DB credentials.
- **Banking Operations**:
  - Deposit funds
  - Withdraw funds
  - View balance
  - View transaction history
  - Change PIN
- **Transaction Logging** – Each deposit/withdrawal is recorded in the database with date, type, and amount.
- **Swing-based GUI** – User-friendly interface with form validation.

---

## 🛠️ Tech Stack
- **Language:** Java
- **GUI:** Java Swing
- **Database:** MySQL
- **Database Connectivity:** JDBC
- **Encryption:** AES (16-byte key for credential encryption/decryption)
- **IDE:** NetBeans / VS Code

---

## 📂 Project Structure
```plaintext
src/
└── bankmanagementsytem/
    ├── Conn.java          # Database connection with AES decryption
    ├── Signup1.java       # Step 1: Personal details
    ├── Signup2.java       # Step 2: Additional details
    ├── Signup3.java       # Step 3: Account setup
    ├── Login.java         # User authentication
    ├── Deposit.java       # Deposit funds
    ├── Withdrawal.java    # Withdraw funds
    ├── Transactions.java  # View transactions
    ├── Balance.java       # Check balance
    └── Pinchange.java     # Change account PIN
```
## 🗄️ Database Setup

Below is the SQL script to set up the **Bank Management System** database and its required tables.

### 1️⃣ Create Database
```sql
-- Creating database
CREATE DATABASE bankmanagementsystem;
USE bankmanagementsystem;

-- Check databases
SHOW DATABASES;


-- Table: signup (Personal Details)
CREATE TABLE signup (
    formno VARCHAR(20),
    name VARCHAR(20),
    fname VARCHAR(20),
    dob VARCHAR(20),
    gender VARCHAR(20),
    email VARCHAR(50),
    marital VARCHAR(20),
    address VARCHAR(50),
    city VARCHAR(20),
    state VARCHAR(20),
    pincode VARCHAR(20)
);

-- Table: signup2 (Additional Details)
CREATE TABLE signup2 (
    formno VARCHAR(20),
    income VARCHAR(20),
    education VARCHAR(20),
    occupation VARCHAR(20),
    seniorcitizen VARCHAR(20),
    existaccount VARCHAR(20),
    pan VARCHAR(20),
    aadhar VARCHAR(20)
);

-- Table: signup3 (Account Setup)
CREATE TABLE signup3 (
    formno VARCHAR(20),
    accounttype VARCHAR(20),
    cardnumber VARCHAR(20),
    pin VARCHAR(20),
    facility VARCHAR(20)
);

-- Table: login (Login Credentials)
CREATE TABLE login (
    formno VARCHAR(20), 
    cardnumber VARCHAR(20),
    pin VARCHAR(10)
);

-- Table: bank (Transaction Records)
CREATE TABLE bank (
    pin VARCHAR(10),
    date VARCHAR(50),
    type VARCHAR(20),
    amount VARCHAR(20)
);

--viewing the entrys per table
SELECT * FROM signup;
SELECT * FROM signup2;
SELECT * FROM signup3;
SELECT * FROM login;
SELECT * FROM bank;
```

⚙️ Setup & Installation
1. Clone the Repository
```
git clone https://github.com/piyush1and1/Bank-Management-System.git
cd Bank-Management-System
```
## Update DB Credentials

Open Conn.java and update the database username/password and AES secret key:
```java
private static final String SECRET_KEY = "your16charsecret";
```
## Run the Project
Open the project in NetBeans or VS Code.

Compile and run Login.java or the main entry point.
