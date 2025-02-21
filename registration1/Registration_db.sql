	mysql> CREATE DATABASE register_db;
Query OK, 1 row affected (0.02 sec)

mysql> use register_db;
Database changed
mysql> CREATE TABLE faculty (faculty_id BIGINT AUTO_INCREMENT PRIMARY KEY, faculty_name VARCHAR(100) NOT NULL, faculty_email VARCHAR(100) UNIQUE NOT NULL, password VARCHAR(255) NOT NULL, faculty_mobile_number VARCHAR(10) NOT NULL);
Query OK, 0 rows affected (0.04 sec)

mysql> CREATE TABLE course (course_id BIGINT AUTO_INCREMENT PRIMARY KEY, course_name VARCHAR(100) NOT NULL, course_duration INT NOT NULL);
Query OK, 0 rows affected (0.01 sec)

mysql> drop table faculty;
Query OK, 0 rows affected (0.01 sec)

mysql> drop table course;
Query OK, 0 rows affected (0.01 sec)

mysql> CREATE TABLE faculty (facultyId BIGINT AUTO_INCREMENT PRIMARY KEY, facultyName VARCHAR(100) NOT NULL, facultyEmail VARCHAR(100) UNIQUE NOT NULL, password VARCHAR(255) NOT NULL, facultyMobileNumber VARCHAR(10) NOT NULL);
Query OK, 0 rows affected (0.04 sec)

mysql> CREATE TABLE course (courseId BIGINT AUTO_INCREMENT PRIMARY KEY, courseName VARCHAR(100) NOT NULL, courseDuration INT NOT NULL);
Query OK, 0 rows affected (0.01 sec)

mysql> CREATE TABLE faculty_course (id BIGINT AUTO_INCREMENT PRIMARY KEY, facultyId BIGINT NOT NULL, courseId BIGINT NOT NULL, FOREIGN KEY (facultyId) REFERENCES faculty(facultyId) ON DELETE CASCADE,FOREIGN KEY (courseId) REFERENCES course(courseId) ON DELETE CASCADE);
Query OK, 0 rows affected (0.05 sec)

mysql> INSERT INTO faculty (facultyName, facultyEmail, password, facultyMobileNumber) VALUES ('Faculty1', 'faculty1@gmail.com', 'root
1', '0987654321'),('Faculty2', 'faculty2@gmail.com', 'root', '1234567890');
Query OK, 2 rows affected (0.02 sec)
Records: 2  Duplicates: 0  Warnings: 0

mysql> INSERT INTO faculty_course (facultyId, courseId) VALUES (1, 1), (1, 3), (2, 2);
ERROR 1452 (23000): Cannot add or update a child row: a foreign key constraint fails (`register_db`.`faculty_course`, CONSTRAINT `faculty_course_ibfk_2` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`) ON DELETE CASCADE)
mysql> INSERT INTO course (courseName, courseDuration) VALUES ('Mathematics', 4),('Physics', 3),('Computer Science', 4);
Query OK, 3 rows affected (0.01 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> INSERT INTO faculty_course (facultyId, courseId) VALUES (1, 1), (1, 3), (2, 2);
Query OK, 3 rows affected (0.01 sec)
Records: 3  Duplicates: 0  Warnings: 0