# Examination Result Management System

## Project Overview
A Java JDBC application that stores student examination results in an Oracle database and generates pass/fail reports.

## Technologies Used
- Java
- JDBC
- Oracle Database 21c XE
- Oracle SQL Developer
- Visual Studio Code

## Features
- Enter student roll number, name, and marks in three subjects
- Calculate total marks and percentage
- Determine PASS or FAIL based on minimum marks of 40 in each subject
- Store student records in Oracle Database
- Retrieve and display examination reports

## Database
Table: `exam_results`

The table definition is available in `schema.sql`.

## How to Run
1. Install Java JDK and Oracle Database.
2. Create the table using `schema.sql` in Oracle SQL Developer.
3. Download a compatible Oracle JDBC driver.
4. Configure the Oracle database connection in `Main.java`.
5. Set the `ORACLE_DB_PASSWORD` environment variable.
6. Compile and run the Java program with the JDBC driver on the classpath.

### Commands (Windows)

```powershell
javac -cp ".;ojdbc17.jar" Main.java
java -cp ".;ojdbc17.jar" Main
```

## Result
The application calculates examination results, saves student records, and generates pass/fail reports using Java JDBC and Oracle Database.