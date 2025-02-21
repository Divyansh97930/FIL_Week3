<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Course Registration</title>
</head>
<body>
    <h2>Course Registration</h2>
    <form action="/courses/register" method="post">
        Course Name: <input type="text" name="courseName" required /><br>
        Course Duration: <input type="text" name="courseDuration" required /><br>
        <input type="submit" value="Register">
    </form>
</body>
</html>
