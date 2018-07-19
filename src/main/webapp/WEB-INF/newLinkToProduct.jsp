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
	<h1>Products in ${thisCategory.name }</h1>
	<h2></h2>
	<c:forEach var="this_product" items="${thisCatsProducts}">
		<h3>${this_product.name}</h3>
	</c:forEach>
	<h2>Add Product</h2>
    <form method="POST" action="/ProductsCategories/newLinkToProduct">
    
    		<select name="this_product">
    			<c:forEach var="this_product" items="${allProducts}">
    				<option label="${this_product.name }" value="${this_product.id }"></option>
    			</c:forEach>
    		</select><p></p>
        <h1></h1>
                
       	<input type="hidden" name="thisCategory" value="${thisCategory.id}">
        <input type="submit" value="Create"/>
    </form>
    	
</body>
</html>