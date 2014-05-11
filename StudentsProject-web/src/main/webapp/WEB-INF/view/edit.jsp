<%@page contentType="text/html; charset=UTF-8" language="java" pageEncoding="utf8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Students List</title>
    </head>
    <body>
        <h2>STUDENTS</h2>
        <a href="main">List of students</a>
        <a href="add">Add student</a>        
        <hr>
        <br><i>Edit student</i>
        <hr>
        <form action="edit" method="post">
            <table>
                <tr><th align="right">FIO:</th><th><input type="text" name="student_fio" value="${student.studentFio}"/><br/></th></tr>
                <tr><th align="right">Group:</th><th><input type="text" name="group_id" value="${student.groupId}"/><br/></th></tr>
                <tr><th align="right">Scholarship:</th><th><input type="text" name="scholarship" value="${student.scholarship}"/><br/></th></tr>
                <tr><th align="right">Date:</th><th><input type="text" name="enrollment_date" value="<fmt:formatDate value="${student.enrollmentDate}" pattern="dd.mm.yyyy"/>"/><br/></th></tr>
            </table>
             <input name="id" type="hidden" value="${student.studentId}"/>
            <input type="submit" value="edit" />
        </form>
    </body>
</html>