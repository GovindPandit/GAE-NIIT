<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
 <%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/displayproducts.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<sql:setDataSource driver="com.mysql.jdbc.Driver"
							url="jdbc:mysql://34.67.195.30:3306/niitgae"
							user="root"
							password="root"
							var="mydatasource" />
	
	<c:if test="${param.productname==null}">	
		<sql:query var="data" dataSource="${mydatasource}">
			select * from products
		</sql:query>
	</c:if>
	
	<c:set value="%${param.productname}%" var="p"></c:set>
	<c:if test="${param.productname!=null}">
		<sql:query var="data" dataSource="${mydatasource}">
			select * from products where lower(productname) like ?
			<sql:param>${fn:toLowerCase(p)}</sql:param>
		</sql:query>
	</c:if>
	
	<c:if test="${param.price!=null}">
		<c:if test="${param.price==1}">
			<sql:query var="data" dataSource="${mydatasource}">
				select * from products order by price
			</sql:query>
		</c:if>
		<c:if test="${param.price==0}">
			<sql:query var="data" dataSource="${mydatasource}">
				select * from products order by price desc
			</sql:query>
		</c:if>
	</c:if>
		 	
	<div class="container">
    <h3 class="h3">shopping Demo-1 </h3>
    <div class="row">
    <div class="col-md-3">
    	<div class="form-check">
  			<input type="checkbox" class="form-check-input" id="materialChecked2" value="iphone">
  			<label class="form-check-label" for="materialChecked2">Iphone</label>
		</div>
		<div class="form-check">
  			<input type="checkbox" class="form-check-input" id="materialChecked2" value="samsung">
  			<label class="form-check-label" for="materialChecked2">Samsung</label>
		</div>
    </div>
    <c:forEach items="${data.rows}" var="row">
        <div class="col-md-3 col-sm-6 mydiv">
            <div class="product-grid">
                <div class="product-image">
                    <a href="displayproduct.jsp?productid=${row.productid}">
                        <img  class="pic-1 col-lg-12 col-md-12 col-sm-12 col-xs-12" src="ImageServlet?productid=${row.productid}" class="img-responsive">
                    </a>
                    <ul class="social">
                        <li><a href="" data-tip="Quick View"><i class="fa fa-search"></i></a></li>
                        <li><a href="" data-tip="Add to Wishlist"><i class="fa fa-shopping-bag"></i></a></li>
                        <li><a href="" data-tip="Add to Cart"><i class="fa fa-shopping-cart"></i></a></li>
                    </ul>
                    <span class="product-new-label">${row.productname}</span>
                    <span class="product-discount-label">20%</span>
                </div>
                <ul class="rating">
                    <li class="fa fa-star"></li>
                    <li class="fa fa-star"></li>
                    <li class="fa fa-star"></li>
                    <li class="fa fa-star"></li>
                    <li class="fa fa-star disable"></li>
                </ul>
                <div class="div">
                    <h3 class="title"><a href="#">${row.productname}</a></h3>
                    <h3 class="price">Rs. ${row.price}</h3>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
    
</div>
<hr>
		
	<jsp:include page="footer.jsp"></jsp:include>
	<script>
$(document).ready(function(){
	

	$('#lowtohigh').click(function()
	{
	    var sorted = $('.product-grid').sort(function(a,b)
	    {
	        return (ascending ==
	               (convertToNumber($(a).find('.price').html()) < 
	                convertToNumber($(b).find('.price').html())));
	    });

	    $('.mydiv').html(sorted);
	});

		
	var convertToNumber = function(value){
	     return parseFloat(value.replace('Rs. ',''));
	}
		
		 /*
		$("#hightolow").click(function()
		{
		    var products = $('.product-grid');
		    products.sort(function(a, b){ return $(b).data("price") - $(a).data("price")});
		    $(".mydiv").html(products);

		}); */
		
		 $(".form-check-input").change(function() 
				 {
				$(".mydiv").hide();		
			 var x=new Array(2);
			 	
						x=$('.form-check-input:checkbox:checked');
			 			for(i=0;i<x.length;i++)
			 			{
				      		var filter = x[i].value,
				        	count = 0;
				      		

				      $('.product-grid .product-new-label').each(function() 
				   	{

				        // If the list item does not contain the text phrase fade it out
				        if ($(this).text().search(new RegExp(filter, "i")) >= 0) 
				        {
				          $(this).parent().parent().parent().show();  // MY CHANGE

				          // Show the list item if the phrase matches and increase the count by 1
				        }

				      });
			 			}
			 			
			 			
				    });
		
	 $("#search").keyup(function() 
	 {
	      var filter = $(this).val(),
	        count = 0;

	      $('.product-grid .product-new-label').each(function() {

	        // If the list item does not contain the text phrase fade it out
	        if ($(this).text().search(new RegExp(filter, "i")) < 0) {
	          $(this).parent().parent().parent().hide();  // MY CHANGE

	          // Show the list item if the phrase matches and increase the count by 1
	        } else {
	          $(this).parent().parent().parent().show(); // MY CHANGE
	          count++;
	        }

	      });

	    });
});
</script>
</body>
</html>
