<%@page import="org.springframework.validation.FieldError"%>
<%@page import="org.springframework.validation.BindingResult"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<%
BindingResult message = (BindingResult)request.getAttribute("error");
	
System.out.println("Message is "+message);
String className= "form-control";
String className2= "form-control";
if (message != null && message.getFieldErrors("username") != null) {
	className +=" is-invalid";	
}
if (message != null && message.getFieldError("email") != null) {
	className2 +=" is-invalid";
}
%>
<body>
	<div class="container">
		<div class="row mt-5">
			<div class="col-md-6 offset-md-3">
				<form action="submit" method="post">
					<h1 class="text-center">Register Here</h1>
					<div class="form-group">
					
						<label for="exampleInputEmail1">User Name</label> <input
							type="text" class="<%=className%>" id="exampleInputEmail1"
							aria-describedby="emailHelp" placeholder="Enter Your Username"
							name="username">
						<%
   				 if (message != null && message.getFieldErrors("username") != null) {
   					for(FieldError er: message.getFieldErrors("username")){
   						
   						System.out.println("ERROR is "+er.getDefaultMessage());
							%>
						<small style="color: red"><%=er.getDefaultMessage() %><br></small>
						<%
   					}
					} %>
					</div>
					
					<div class="form-group">
						<label for="exampleInputPassword1">User Email</label> <input
							type="email" class="<%=className2 %>" id="exampleInputPassword1"
							placeholder="Enter Your Email" name="email">
							<%
							 if (message != null && message.getFieldError("email") != null) {
							%>
						<small style="color: red"><%=message.getFieldError("email").getDefaultMessage() %></small>
						<%
						
					} %>
					</div>
					<div class="form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1">
						<label class="form-check-label" for="exampleCheck1">Check
							me out</label>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</html>