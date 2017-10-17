<%-- 
    Document   : ShoppingList
    Created on : Oct 10, 2017, 2:06:56 PM
    Author     : 578291
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html"/>
<h1>Shopping List</h1>
<p>Hello, ${username} <a href="">Log out</a></p>
<h2>List</h2>
<div>
    <form action="shoppinglist" method="POST">
        Add item: <input type="text" name="additem">
        <input type="submit" name="submit" value="Add">
    </form>
</div>

<c:import url="/includes/footer.html"/>