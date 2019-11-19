<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
 <%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	.myform
	{
		margin:0 auto;
	}
</style>
</head>
<body>
	<sql:setDataSource driver="com.mysql.jdbc.Driver"
							url="jdbc:mysql://34.67.195.30:3306/niitgae"
							user="root"
							password="root"
							var="mydatasource" />
		 
	<sql:query var="data" dataSource="${mydatasource}">
		select * from products where productid=?
		<sql:param>${param.productid}</sql:param>
	</sql:query>
	
	<jsp:include page="header.jsp"></jsp:include>
		
		<div class="container">
		
		<c:if test="${param.productid!=null}">
			<c:forEach items="${data.rows}" var="row">
			<form action="UpdateProductController" method="post" class="col-lg-6 col-md-6 col-sm-12 col-xs-12 myform">
			<div class="form-group">
				<label>Enter Product Id</label>
				<input type="text" name="productid" class="form-control" placeholder="Enter Productid" value="${row.productid}"/>
			</div>
			<div class="form-group">
				<label>Enter Product Name</label>
				<input type="text" name="productname" class="form-control" placeholder="Enter Productname" value="${row.productname}"/>
			</div>
			<div class="form-group">
				<label>Enter Price</label>
				<input type="text" name="price" class="form-control" placeholder="Enter Price" value="${row.price}"/>
			</div>
			<div class="form-group">
				<label>Enter Quantity</label>
				<input type="text" name="quantity" class="form-control" placeholder="Enter Quantity" value="${row.quantity}"/>
			</div>
			<div class="form-group">
				<label>Enter Description</label>
				<input type="text" name="description" class="form-control" placeholder="Enter description" value="${row.description}"/>
			</div>
			<div class="form-group">
				<input type="submit" value="Update Product" class="btn btn-primary btn-block"/>
				<input type="reset" value="Reset" class="btn btn-danger btn-block"/>
			</div>
			</form>
			</c:forEach>
		</c:if>
		
		<c:if test="${param.productid==null}">
			<form action="AddProductController" method="post" class="col-lg-6 col-md-6 col-sm-12 col-xs-12 myform">
			<div class="form-group">
				<label>Enter Product Name</label>
				<input type="text" name="productname" class="form-control" placeholder="Enter Productname" />
			</div>
			<div class="form-group">
				<label>Enter Price</label>
				<input type="text" name="price" class="form-control" placeholder="Enter Price" />
			</div>
			<div class="form-group">
				<label>Enter Quantity</label>
				<input type="text" name="quantity" class="form-control" placeholder="Enter Quantity"/>
			</div>
			<div class="form-group">
				<label>Enter Description</label>
				<input type="text" name="description" class="form-control" placeholder="Enter description" />
			</div>
			<div class="form-group">
				<input type="submit" value="Add Product" class="btn btn-primary btn-block"/>
				<input type="reset" value="Reset" class="btn btn-danger btn-block"/>
			</div>
			</form>
		</c:if>
		
			
	
		
		</div>
		
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>