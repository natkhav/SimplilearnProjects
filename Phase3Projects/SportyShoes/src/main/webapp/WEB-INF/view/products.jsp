
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <link rel="stylesheet" href="/css/style.css">
        <title>Products</title>
    </head>
    <body>
    <div align="left">
        <h1>SPORTY SHOES MARKETPLACE</h1>
        <h2>Admin Portal</h2><br><br>
        <h3>Shoes Inventory</h3>
        <table border="1" cellpadding="5" class="tg" style="margin-right:auto;margin-left:0px">
            <tr>
                <th class="tg-general">Name</th>
                <th class="tg-general">Price</th>  
                <th class="tg-general">Category</th>             
                <th class="tg-general">Actions</th>
            </tr>

            <c:forEach items="${products}" var="product">
                <tr>
                    <td class="tg-general">${product.name}</td>
                    <td class="tg-general">${product.price}</td>
                    <td class="tg-general">${product.category.name}</td>
                    <td class="tg-general">
                        <a href="/product/edit?id=${product.id}" class="">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/product/delete?id=${product.id}" class="">Delete</a>
                    </td>
                </tr>
            </c:forEach>

        </table><br>
        <a href="/admin?id=<%=(Long)session.getAttribute("adminId")%>" class="previous">&laquo; Back to Admin Dashboard</a>
    </div>
    </body>
</html>