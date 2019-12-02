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
<link href="css/displayproduct.css" rel="stylesheet"/>
<style>
/*Some CSS*/
* {margin: 0; padding: 0;}
.magnify {width: 200px; margin: 50px auto; position: relative;}

/*Lets create the magnifying glass*/
.large {
	width: 175px; height: 175px;
	position: absolute;
	border-radius: 100%;
	
	/*Multiple box shadows to achieve the glass effect*/
	box-shadow: 0 0 0 7px rgba(255, 255, 255, 0.85), 
	0 0 7px 7px rgba(0, 0, 0, 0.25), 
	inset 0 0 40px 2px rgba(0, 0, 0, 0.25);
	
	/*Lets load up the large image first*/
	
	
	/*hide the glass by default*/
	display: none;
}

/*To solve overlap bug at the edges during magnification*/
.small { display: block; }
</style>
 
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
					<div class="col-md-4">
						<div class="magnify">
							<div class="large" style="background: url(ImageServlet?productid=${row.productid}) no-repeat;"></div>
						  	<img class="small" src="ImageServlet?productid=${row.productid}"  />
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
							<a href="AddToCartController?productid=${row.productid}" class="btn btn-primary btn-block" type="button">Add To Cart</a>
							<a href="OrderController?productid=${row.productid}" class="btn btn-warning btn-block" type="button">Buy</a>
							
							<c:if test="${user!=null}">
							<c:if test="${user.role=='admin'}">
								<a href="addproduct.jsp?productid=${row.productid}" class="btn btn-secondary btn-block" type="button">Edit</a>
								<a href="DeleteController?productid=${row.productid}" class="btn btn-danger btn-block" type="button">Delete</a>
							</c:if>
							</c:if>
						</div>
					
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- Lets load up prefixfree to handle CSS3 vendor prefixes -->
	<script src="http://thecodeplayer.com/uploads/js/prefixfree.js" type="text/javascript"></script>
	<!-- You can download it from http://leaverou.github.com/prefixfree/ -->

	<!-- Time for jquery action -->
	<script src="http://thecodeplayer.com/uploads/js/jquery-1.7.1.min.js" type="text/javascript"></script>
	<Script >
	$(document).ready(function(){

		var native_width = 0;
		var native_height = 0;

		//Now the mousemove function
		$(".magnify").mousemove(function(e){
			
			//When the user hovers on the image, the script will first calculate
			//the native dimensions if they don't exist. Only after the native dimensions
			//are available, the script will show the zoomed version.
			if(!native_width && !native_height)
			{
				//This will create a new image object with the same image as that in .small
				//We cannot directly get the dimensions from .small because of the 
				//width specified to 200px in the html. To get the actual dimensions we have
				//created this image object.
				var image_object = new Image();
				image_object.src = $(".small").attr("src");
				
				//This code is wrapped in the .load function which is important.
				//width and height of the object would return 0 if accessed before 
				//the image gets loaded.
				native_width = image_object.width;
				native_height = image_object.height;
			}
			else
			{
				//x/y coordinates of the mouse
				//This is the position of .magnify with respect to the document.
				var magnify_offset = $(this).offset();
				//We will deduct the positions of .magnify from the mouse positions with
				//respect to the document to get the mouse positions with respect to the 
				//container(.magnify)
				var mx = e.pageX - magnify_offset.left;
				var my = e.pageY - magnify_offset.top;
				
				//Finally the code to fade out the glass if the mouse is outside the container
				if(mx < $(this).width() && my < $(this).height() && mx > 0 && my > 0)
				{
					$(".large").fadeIn(100);
				}
				else
				{
					$(".large").fadeOut(100);
				}
				if($(".large").is(":visible"))
				{
					//The background position of .large will be changed according to the position
					//of the mouse over the .small image. So we will get the ratio of the pixel
					//under the mouse pointer with respect to the image and use that to position the 
					//large image inside the magnifying glass
					var rx = Math.round(mx/$(".small").width()*native_width - $(".large").width()/2)*-1;
					var ry = Math.round(my/$(".small").height()*native_height - $(".large").height()/2)*-1;
					var bgp = rx + "px " + ry + "px";
					
					//Time to move the magnifying glass with the mouse
					var px = mx - $(".large").width()/2;
					var py = my - $(".large").height()/2;
					//Now the glass moves with the mouse
					//The logic is to deduct half of the glass's width and height from the 
					//mouse coordinates to place it with its center at the mouse coordinates
					
					//If you hover on the image now, you should see the magnifying glass in action
					$(".large").css({left: px, top: py, backgroundPosition: bgp});
				}
			}
		});
	});
	</Script>
	
</body>
</html>