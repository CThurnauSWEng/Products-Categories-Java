<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Add Link</title>
</head>
<body>
	<h1>Add Category to ${thisProduct.name }</h1>
	<h2></h2>
	<h1>The product ${thisProduct.name } is already in these categories:</h1>
	<p></p>
	<c:forEach var="this_cat" items="${thisProdsCats}">
		<h3>${this_cat.name}</h3>
	</c:forEach>
	<h2>Add Category</h2>
    <form method="POST" action="/ProductsCategories/newLinkToCategory">
    
    		<select name="this_category">
    			<c:forEach var="this_category" items="${allCategories}">
    				<option label="${this_category.name }" value="${this_category.id }"></option>
    			</c:forEach>
    		</select><p></p>
        <h1></h1>
                
       	<input type="hidden" name="thisProduct" value="${thisProduct.id}">
        <input type="submit" value="Create"/>
    </form>
    	
</body>
</html>