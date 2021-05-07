
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" href="/css/style.css">
    <title>Purchase Report</title>
</head>
<body>
<div align="left">
        <h1>SPORTY SHOES MARKETPLACE</h1>
        <h2>Admin Portal</h2><br><br>
        <h1>Purchase Report</h1><br>
  
    <form action="/purchase_report">
        <label>Filter By Date:</label>
        <input type="date" id="dateFilter" name="dateFilter">
        <label>and Category:</label>
        <select id="categoryId" name="categoryId">
            <option value="0"></option>
            <c:forEach items="${categories}" var="category">
                <option value="${category.id}">${category.name}</option>
            </c:forEach>
        </select>
        <input type="submit" name="submit" value="Filter">
    </form>
    <c:forEach items="${purchases}" var="purchase">
        <h2>Buyer: ${purchase.user.firstName} ${purchase.user.lastName} - Order ID: ${purchase.id}</h2>
        <h3>Date: ${purchase.date} - Total: $${purchase.total}</h3>

        <table border="1" cellpadding="5" class="tg" style="margin-right:auto;margin-left:0px">
            <tr>
                <th class="tg-general">Product</th>
                <th class="tg-general">Category</th>
                <th class="tg-general">Quantity</th>
                <th class="tg-general">Price Per Unit</th>
            </tr>
            <c:forEach items="${purchase.productPurchases}" var="productPurchase">
                <tr>
                    <td class="tg-general">${productPurchase.product.name}</td>
                    <td class="tg-general">${productPurchase.product.category.name}</td>
                    <td class="tg-general">${productPurchase.quantity}</td>
                    <td class="tg-general">${productPurchase.product.price}</td>
                </tr>
            </c:forEach>

        </table>
    </c:forEach>
    <a href="/admin?id=<%=(Long)session.getAttribute("adminId")%>" class="previous">&laquo; Back to Admin Dashboard</a>
</div>
</body>
</html>