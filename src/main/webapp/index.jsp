<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
.mySlides {display:none;}
</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
	<div class="row">
		<div class="col-lg-6">
		<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
		  <div class="carousel-inner">
	    <div class="carousel-item active">
	      <img class="d-block w-100" src="https://s3-ap-southeast-1.amazonaws.com/bsy/iportal/images/handset-offer-banner-new_31F555919982EFE18360075F1D2EC443.png" alt="First slide" style="height:400px">
	    </div>
	    <div class="carousel-item">
	      <img class="d-block w-100" src="https://rukminim1.flixcart.com/flap/480/480/image/6d3cfb20367862be.jpg?q=50" alt="Second slide" style="height:400px">
	    </div>
	    <div class="carousel-item">
	      <img class="d-block w-100" src="https://i.gadgets360cdn.com/large/Realme_3i_cover_ndtv_1563458539417.jpg?downsize=910:*&output-quality=80" alt="Third slide" style="height:400px">
	    </div>
	  </div>
	  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
	    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	    <span class="sr-only">Previous</span>
	  </a>
	  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
	    <span class="carousel-control-next-icon" aria-hidden="true"></span>
	    <span class="sr-only">Next</span>
	  </a>
	</div>
	</div>
	<div class="col-lg-6">
		
	</div>
	</div>
</div>
<script>
var slideIndex = 1;
showDivs(slideIndex);

function plusDivs(n) {
  showDivs(slideIndex += n);
}

function showDivs(n) {
  var i;
  var x = document.getElementsByClassName("mySlides");
  if (n > x.length) {slideIndex = 1}
  if (n < 1) {slideIndex = x.length}
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";  
  }
  x[slideIndex-1].style.display = "block";  
}
</script>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>