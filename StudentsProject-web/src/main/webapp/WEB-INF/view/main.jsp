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
        <a href="add">Add student</a>
        <hr>
        <br><i>Search for students</i>
        <hr>
        <form action="main" method="post">
            <table>
                <tr><th align="right">Enter text:</th><th><input type="text" name="student_text"/><br/></th></tr>
            </table>
            <input type="submit" value="search" />
        </form>
        <br><i>List of students</i>
        <hr>
        <table border="1">
            <tr>
                <th>FIO</th>
                <th>Group</th>
                <th>Scholarship</th>
                <th>Date</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:if test="${!empty student}">
                <c:forEach items="${student}" var="st">
                    <tr>
                        <td>${st.studentFio}</td>
                        <td>${st.groupId}</td>
                        <td>${st.scholarship}</td>
                        <td><fmt:formatDate value="${st.enrollmentDate}" pattern="dd.mm.yyyy"/></td>
                        <td><a href="edit?id=${st.studentId}">X</a></td>
                        <td><a href="delete?id=${st.studentId}">X</a></td>
                    </tr>   
                </c:forEach>
            </c:if>
        </table>
    </body>
</html>