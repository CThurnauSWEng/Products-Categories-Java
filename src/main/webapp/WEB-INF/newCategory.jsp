<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>New Category</title>
</head>
<body>
	<h1>New Category</h1>
	<h2></h2>
	<form:form method="POST" action="/ProductsCategories/createCategory" modelAttribute="category">
	    <form:label path="name">Name
	    <form:errors path="name"/>
	    <form:input path="name"/></form:label>
	
	    <input type="submit" value="Create"/>
	</form:form>

	<h2>All Categories</h2>
    <table>
	    <thead>
	        <tr>
	            <th>Name</th>
	            <th>Action</th>
	        </tr>
	    </thead>
	    <tbody>
		    <c:forEach var="category" items="${categories}" >
		    <tr>
		        <td>${category.name}</td>
		        <td><a href="/ProductsCategories/newLinkToProduct/${category.id}">Link Product</a></td>
		    </tr>
		    </c:forEach>		
      	</tbody>
	</table>



</body>
</html>