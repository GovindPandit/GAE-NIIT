<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="header.jsp"></jsp:include>
<style>
	.msg
	{
		color:red;
	}
	.myform
	{
		margin:0 auto;
	}
</style>

</head>
<body>
		<div class="container">
		<form action="RegistrationController" method="post" class="col-lg-6 col-md-6 col-sm-12 col-xs-12 myform">
			<div class="form-group">
				<label>Enter Username</label>
				<input type="text" name="username" id="username" class="form-control" placeholder="Enter Username" value="${user.username}"/>
				<span class="msg">${msgusername}</span>
			</div>
			<div class="form-group">
				<label>Enter Email</label>
				<input type="email" name="email" class="form-control" placeholder="Enter Email" value="${user.email}"/>
				<span class="msg">${msgemail}</span>
			</div>
			<div class="form-group">
				<label>Enter Password</label>
				<input type="password" name="password" class="form-control" placeholder="Enter Password" />
				<span class="msg">${msgpassword}</span>
			</div>
			<div class="form-group">
				<input type="submit" value="Register" class="btn btn-primary btn-block"/>
				<input type="reset" value="Reset" class="btn btn-danger btn-block"/>
			</div>
			</form>
		</div>
		
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>