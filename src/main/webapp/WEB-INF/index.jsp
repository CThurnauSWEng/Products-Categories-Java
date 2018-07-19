<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Products Categories</title>
</head>
<body>
	<h1>New Product</h1>
	<h2></h2>
	<form:form method="POST" action="/ProductsCategories/createProduct" modelAttribute="product">
	    <form:label path="name">Name
	    <form:errors path="name"/>
	    <form:input path="name"/></form:label>
	
	    <form:label path="description">Description
	    <form:errors path="description"/>
	    <form:textarea path="description"/></form:label>
	    
	    <form:label path="price">Price
	    <form:errors path="price"/>
	    <form:input path="price"/></form:label>
	    
	    <input type="submit" value="Create"/>
	</form:form>

	<h2>All Products</h2>
    <table>
	    <thead>
	        <tr>
	            <th>Name</th>
	            <th>Description</th>
	            <th>Price</th>
	            <th>Action</th>
	        </tr>
	    </thead>
	    <tbody>
		    <c:forEach var="product" items="${products}" >
		    <tr>
		        <td>${product.name}</td>
		        <td>${product.description}</td>
		        <td>${product.price}</td>
		        <td><a href="/ProductsCategories/newLinkToCategory/${product.id}">Link Category</a></td>
		    </tr>
		    </c:forEach>		
      	</tbody>
	</table>


</body>
</html>