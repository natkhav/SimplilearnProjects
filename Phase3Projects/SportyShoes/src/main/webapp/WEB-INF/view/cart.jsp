<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" href="/css/style.css">
    <title>Shop</title>
</head>
<body>
<div align="left">
    <h2>Available Products</h2>
    <form action="/purchase" method="post">
    <table border="1" cellpadding="5" class="tg">
        <tr>
            <th class="tg-general">Product</th>
            <th class="tg-general">Price</th>
            <th class="tg-general">Category</th>
            <th class="tg-general">Quantity</th>
        </tr>

        <c:forEach items="${products}" var="product">
            <tr>
                <input type="hidden" id="productId" name="productId" value="${product.id}">
                <td class="tg-general">${product.name}</td>
                <td class="tg-general">${product.price}</td>
                <td class="tg-general">${product.category.name}</td>
                <td class="tg-general">
                    <input type="number" id="quantity" name="quantity" min="0" max="100" value="0">
                </td>
            </tr>
        </c:forEach>
    </table>
        <input type="submit" name="purchase" value="Purchase" class="previous">
    </form>
</div>
</body>
</html>