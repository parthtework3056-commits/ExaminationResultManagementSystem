CREATE TABLE exam_results (
    roll_no NUMBER PRIMARY KEY,
    name VARCHAR2(50),
    subject1 NUMBER,
    subject2 NUMBER,
    subject3 NUMBER,
    total NUMBER,
    percentage NUMBER(5,2),
    result VARCHAR2(10)
);