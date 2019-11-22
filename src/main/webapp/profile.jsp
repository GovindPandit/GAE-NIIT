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
		<form action="UpdateProfileController" method="post" class="col-lg-6 col-md-6 col-sm-12 col-xs-12 myform">
			<div class="form-group">
				<input type="hidden" name="userid" class="form-control" placeholder="Enter Username" value="${user.userid}"/>
			</div>
			<div class="form-group">
				<label>Enter Username</label>
				<input type="text" name="username" class="form-control" placeholder="Enter Username" value="${user.username}"/>
			</div>
			<div class="form-group">
				<label>Enter Email</label>
				<input type="email" name="email" class="form-control" placeholder="Enter Email" value="${user.email}"/>
			</div>
			<div class="form-group">
				<input type="submit" value="Update Profile" class="btn btn-primary btn-block"/>
				<input type="reset" value="Reset" class="btn btn-danger btn-block"/>
			</div>
			</form>
		</div>
		
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>