<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Faculty Registration</title>
</head>
<body>
    <h2>Faculty Registration</h2>
    <form action="registerFaculty" method="post">
    <label>Name:</label>
    <input type="text" name="facultyName" required><br>

    <label>Email:</label>
    <input type="email" name="facultyEmail" required><br>

    <label>Password:</label>
    <input type="password" name="password" required><br>

    <label>Mobile Number:</label>
    <input type="text" name="facultyMobileNumber" maxlength="10" required><br>

    <input type="submit" value="Register">
</form>
    
</body>
</html>
