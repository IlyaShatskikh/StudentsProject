<%@page contentType="text/html; charset=UTF-8" language="java" pageEncoding="utf8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Students List</title>
    </head>
    <body>
        <h2>STUDENTS</h2>
        <a href="main">List of students</a>
        <hr>
        <br><i>Add student</i>
        <hr>
        <form action="add" method="post">
            <table>
                <tr><th align="right">FIO:</th><th><input type="text" name="student_fio"/><br/></th></tr>
                <tr><th align="right">Group:</th><th><input type="text" name="group_id"/><br/></th></tr>
                <tr><th align="right">Scholarship:</th><th><input type="text" name="scholarship"/><br/></th></tr>
                <tr><th align="right">Date:</th><th><input type="date" name="enrollment_date"/><br/></th></tr>
            </table>
            <input type="submit" value="add" />
        </form>
    </body>
</html>