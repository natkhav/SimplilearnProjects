<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
    <head>
        <title>Edit Password</title>
    </head>
    <body>
        <div align="left">
            <h2>New Password</h2>
            <form:form action="updatePassword" method="post" modelAttribute="admin">
                <table border="0" cellpadding="5">
                    <tr>
                        <form:hidden path="id"/>

                        <td>Username:</td>
                        <td>${admin.login.username}</td>
                        <form:hidden path="login.username"/>
                    <tr>
                        <td>Old Password:</td>
                        <td>${admin.login.password}</td>
                    </tr>
                    <tr>
                        <td>New Password:</td>
                        <td><form:input path="login.password" /></td>
                    </tr>
                    </tr>
                    <tr align="center">
                        <td colspan="2"><input type="submit" value="Save"/></td>
                    </tr>
                </table>
            </form:form>
        </div>
    </body>
</html>