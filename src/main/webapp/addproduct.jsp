<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<jsp:include page="header.jsp"></jsp:include>
		
		<div class="container">
		<form action="AddProductController" method="post" class="col-lg-6 col-md-6 col-sm-12 col-xs-12 myform">
			<div class="form-group">
				<label>Enter Product Name</label>
				<input type="text" name="productname" class="form-control" placeholder="Enter Productname"/>
			</div>
			<div class="form-group">
				<label>Enter Price</label>
				<input type="text" name="price" class="form-control" placeholder="Enter Price"/>
			</div>
			<div class="form-group">
				<label>Enter Quantity</label>
				<input type="text" name="quantity" class="form-control" placeholder="Enter Quantity"/>
			</div>
			<div class="form-group">
				<label>Enter Description</label>
				<input type="text" name="description" class="form-control" placeholder="Enter description"/>
			</div>
			<div class="form-group">
				<input type="submit" value="Add Product" class="btn btn-primary btn-block"/>
				<input type="reset" value="Reset" class="btn btn-danger btn-block"/>
			</div>
			</form>
		</div>
		
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>