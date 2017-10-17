<%-- 
    Document   : Register
    Created on : Oct 10, 2017, 2:08:45 PM
    Author     : 578291
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html"/>
<h1>Shopping List</h1>
<div>
    <form action="shoppinglist" method="post">
        Username: <input type="text" name="username">
        <input typ="submit" name="submit" value="Register name">
    </form>
</div>
<c:import url="/includes/footer.html"/>