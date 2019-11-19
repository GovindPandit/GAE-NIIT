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
 <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">
<link href="displayproduct.css" rel="stylesheet"/>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<sql:setDataSource driver="com.mysql.jdbc.Driver"
							url="jdbc:mysql://34.67.195.30:3306/niitgae"
							user="root"
							password="root"
							var="mydatasource" />
		 
	<sql:query var="data" dataSource="${mydatasource}">
		select * from products where productid=?
		<sql:param>${param.productid}</sql:param>
	</sql:query>
		
	<div class="container">
		<div class="card">
			<div class="container-fliud">
				<div class="wrapper row">
				<c:forEach items="${data.rows}" var="row">
					<div class=" col-md-4">
						
						<div class="preview-pic tab-content">
						  <div class="tab-pane active" id="pic-1"><img src="http://placekitten.com/400/252" class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="height: 300px"/></div>
						 </div>
						
						
					</div>
					<div class=" col-md-4">
						<h3 class="product-title">${row.productname}</h3>
						<!-- 
						<div class="rating">
							<div class="stars">
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star"></span>
								<span class="fa fa-star"></span>
							</div>
							<span class="review-no">41 reviews</span>
						</div>
						 -->
						<p class="product-description">${row.description}</p>
						<h4 class="price">current price: <span>Rs. ${row.price}</span></h4>
						<!-- 
						<p class="vote"><strong>91%</strong> of buyers enjoyed this product! <strong>(87 votes)</strong></p>
						 
						<h5 class="sizes">sizes:
							<span class="size" data-toggle="tooltip" title="small">s</span>
							<span class="size" data-toggle="tooltip" title="medium">m</span>
							<span class="size" data-toggle="tooltip" title="large">l</span>
							<span class="size" data-toggle="tooltip" title="xtra large">xl</span>
						</h5>
						<h5 class="colors">colors:
							<span class="color orange not-available" data-toggle="tooltip" title="Not In store"></span>
							<span class="color green"></span>
							<span class="color blue"></span>
						</h5>
						-->
						</div>	
						<div class="col-md-4">
							<button class="btn btn-primary btn-block" type="button">Add To Cart</button>
							<button class="btn btn-warning btn-block" type="button">Buy</button>
							<a href="addproduct.jsp?productid=${row.productid}" class="btn btn-secondary btn-block" type="button">Edit</a>
							<a href="DeleteController?productid=${row.productid}" class="btn btn-danger btn-block" type="button">Delete</a>
						</div>
					
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>