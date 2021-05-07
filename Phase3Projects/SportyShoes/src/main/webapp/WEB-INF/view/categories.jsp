<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <link rel="stylesheet"  href="/css/style.css">
        <title>Categories</title>
    </head>
    <body>
    <div align="left">
        <h1>SPORTY SHOES MARKETPLACE</h1>
        <h2>Admin Portal</h2><br><br>
        <h3>Shoes Categories</h3><br><br>
        <table border="1" cellpadding="5" class="tg" style="margin-right:auto;margin-left:0px">
            <tr>
                <th class="tg-general">Name</th>
                <th class="tg-general">Actions</th>
            </tr>
            <c:forEach items="${categories}" var="category">
                <tr>
                    <td class="tg-general">${category.name}</td>
                    <td class="tg-general">
                        <a href="/category/edit?id=${category.id}">Edit</a>
                    </td>
                </tr>
            </c:forEach>
        </table><br>
        <a href="/admin?id=<%=(Long)session.getAttribute("adminId")%>" class="previous">&laquo; Back to Admin Dashboard</a>
    </div>
    </body>
</html>