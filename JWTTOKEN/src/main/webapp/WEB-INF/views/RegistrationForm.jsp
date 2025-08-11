<%@page import="com.springBoot.helper.Message"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
<style>
body {
	font-family: 'Poppins', sans-serif;
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
	margin: 0;
	background: linear-gradient(135deg, #6e8efb, #a777e3);
	overflow: hidden;
}

.form-container {
	background-color: rgba(255, 255, 255, 0.95);
	padding: 30px;
	border-radius: 12px;
	box-shadow: 0 8px 32px rgba(0, 0, 0, 0.15);
	width: 600px;
	max-width: 90%;
	animation: fadeIn 0.5s ease-in-out;
}

@keyframes fadeIn {
	from { opacity: 0; transform: translateY(-20px); }
	to { opacity: 1; transform: translateY(0); }
}

h1 {
	text-align: center;
	color: #2c3e50;
	font-size: 24px;
	margin-bottom: 20px;
}

.form-grid {
	display: grid;
	grid-template-columns: 1fr 1fr;
	gap: 20px;
}

label {
	display: block;
	margin: 8px 0 4px;
	color: #34495e;
	font-size: 14px;
	font-weight: 500;
}

input, select, textarea {
	width: 100%;
	padding: 10px;
	margin-bottom: 12px;
	border: 1px solid #dcdcdc;
	border-radius: 6px;
	box-sizing: border-box;
	font-size: 14px;
	transition: border-color 0.3s, box-shadow 0.3s;
}

input:focus, select:focus, textarea:focus {
	outline: none;
	border-color: #6e8efb;
	box-shadow: 0 0 5px rgba(110, 142, 251, 0.3);
}

textarea {
	height: 100px;
	resize: vertical;
	grid-column: span 2;
}

select {
	appearance: none;
	background: url("data:image/svg+xml;charset=UTF-8,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 24 24' fill='none' stroke='currentColor' stroke-width='2' stroke-linecap='round' stroke-linejoin='round'%3e%3cpolyline points='6 9 12 15 18 9'%3e%3c/polyline%3e%3c/svg%3e") no-repeat right 10px center;
	background-size: 16px;
}

input[type="submit"], .btn-custom {
	background: linear-gradient(90deg, #6e8efb, #a777e3);
	color: white;
	border: none;
	cursor: pointer;
	padding: 12px;
	font-size: 16px;
	font-weight: 600;
	border-radius: 6px;
	transition: transform 0.2s, box-shadow 0.2s;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	width: 150px; /* Fixed width for both buttons */
}

input[type="submit"]:hover, .btn-custom:hover {
	transform: translateY(-2px);
	box-shadow: 0 4px 12px rgba(110, 142, 251, 0.4);
}

input[type="submit"]:active, .btn-custom:active {
	transform: translateY(0);
}

.button-group {
	grid-column: span 2;
	display: flex;
	justify-content: center;
	gap: 20px;
	margin-top: 10px;
}

::placeholder {
	color: #bdc3c7;
	font-size: 14px;
}

@media (max-width: 600px) {
	.form-grid {
		grid-template-columns: 1fr;
	}
	.form-container {
		width: 90%;
		padding: 20px;
	}
	textarea, .button-group {
		grid-column: span 1;
	}
	.button-group {
		flex-direction: column;
		gap: 10px;
	}
	input[type="submit"], .btn-custom {
		width: 100%; /* Full width on mobile */
	}
}
</style>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap"
	rel="stylesheet">
</head>
<body>
	<div class="form-container">
		<h1>Register</h1>

		<%
		Message message = (Message) session.getAttribute("message");
		if (message != null) {
		%>
		<div class="alert <%=message.getCssClass()%>" role="alert">
			<%=message.getContent()%>
		</div>
		<%
		session.removeAttribute("message");
		}
		%>
		<form action="register" method="post">
			<div class="form-grid">
				<div>
					<label for="firstName">First Name:</label>
					<input type="text" id="firstName" name="firstName" placeholder="Enter your first name">
				</div>
				<div>
					<label for="lastName">Last Name:</label>
					<input type="text" id="lastName" name="lastName" placeholder="Enter your last name">
				</div>
				<div>
					<label for="email">Email:</label>
					<input type="email" id="email" name="email" placeholder="Enter your email">
				</div>
				<div>
					<label for="phone">Phone Number:</label>
					<input type="tel" id="phone" name="phoneNumber" pattern="[0-9]{10}" placeholder="1234567890">
				</div>
				<div>
					<label for="gender">Gender:</label>
					<select id="gender" name="gender">
						<option value="" disabled selected>Select Gender</option>
						<option value="male">Male</option>
						<option value="female">Female</option>
						<option value="other">Other</option>
					</select>
				</div>
				<div>
					<label for="description">Description:</label>
					<textarea id="description" name="description" placeholder="Tell us about yourself"></textarea>
				</div>
				<div class="button-group">
					<input type="submit" value="Register">
					<a href="login" class="btn-custom">Login Here</a>
				</div>
			</div>
		</form>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</html>