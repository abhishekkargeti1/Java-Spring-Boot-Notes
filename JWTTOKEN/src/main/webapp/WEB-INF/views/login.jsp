<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
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
	width: 400px;
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
	grid-template-columns: 1fr;
	gap: 20px;
}

label {
	display: block;
	margin: 8px 0 4px;
	color: #34495e;
	font-size: 14px;
	font-weight: 500;
}

input {
	width: 100%;
	padding: 10px;
	margin-bottom: 12px;
	border: 1px solid #dcdcdc;
	border-radius: 6px;
	box-sizing: border-box;
	font-size: 14px;
	transition: border-color 0.3s, box-shadow 0.3s;
}

input:focus {
	outline: none;
	border-color: #6e8efb;
	box-shadow: 0 0 5px rgba(110, 142, 251, 0.3);
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
	width: 150px;
}

input[type="submit"]:hover, .btn-custom:hover {
	transform: translateY(-2px);
	box-shadow: 0 4px 12px rgba(110, 142, 251, 0.4);
}

input[type="submit"]:active, .btn-custom:active {
	transform: translateY(0);
}

.button-group {
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
	.form-container {
		width: 90%;
		padding: 20px;
	}
	.button-group {
		flex-direction: column;
		gap: 10px;
	}
	input[type="submit"], .btn-custom {
		width: 100%;
	}
}
</style>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<div class="form-container">
		<h1>Login</h1>
		<form action="login" method="get">
			<div class="form-grid">
				<div>
					<label for="email">Email:</label>
					<input type="email" id="email" name="email" placeholder="Enter your email" required>
				</div>
				<div>
					<label for="password">Password:</label>
					<input type="password" id="password" name="password" placeholder="Enter your password" required>
				</div>
				<div class="button-group">
					<input type="submit" value="Login">
					<a href="form" class="btn-custom">Register Here</a>
				</div>
			</div>
		</form>
	</div>
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
</body>
</html>