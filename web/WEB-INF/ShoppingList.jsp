<%-- 
    Document   : ShoppingList
    Created on : Oct 10, 2017, 2:06:56 PM
    Author     : 578291
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html"/>
<h1>Shopping List</h1>
<p>Hello, ${username} <a href="shoppinglist?action=logout">Log out</a></p>
<h2>List</h2>
<div>
    <form action="shoppinglist?action=add" method="POST">
        Add item: <input type="text" name="additem">
        <input type="submit" name="submit" value="Add">
    </form>
</div>
</br>
<div>
    <c:if test="${items.size() > 0}">
        <form action="shoppinglist?action=delete" method="POST">
            <c:forEach var="item" items="${items}">
                <input type="radio" name="itemlist" value="${item}">${item}
                </br>
            </c:forEach>
            
            <input type="submit" value="Delete">
        </form>
        
    </c:if>
</div>

<c:import url="/includes/footer.html"/>