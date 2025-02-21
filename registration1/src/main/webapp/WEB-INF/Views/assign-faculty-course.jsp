<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Assign Faculty to Course</title>
</head>
<body>
    <h2>Assign Faculty to a Course</h2>
    <form action="/assignments/assign" method="post">
        <label>Faculty:</label>
        <select name="facultyId">
            <c:forEach var="faculty" items="${faculties}">
                <option value="${faculty.facultyId}">${faculty.facultyName}</option>
            </c:forEach>
        </select>
        <br>
        <label>Course:</label>
        <select name="courseId">
            <c:forEach var="course" items="${courses}">
                <option value="${course.courseId}">${course.courseName}</option>
            </c:forEach>
        </select>
        <br>
        <input type="submit" value="Assign">
    </form>
</body>
</html>
