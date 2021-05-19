<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Blanddit: a page on the internet</title>
<link rel="icon" type="image/png" href="https://icons-for-free.com/iconfiles/png/512/reddit+website+icon-1320168605279647340.png"/>

<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">
</head>

<body class="text-center">

<main class="form-signin">
<form action="<%= request.getContextPath() %>/loginNavigator" method="post">

<h1 class="h3 mb-3 fw-normal">Please sign in</h1>

<div class="form-floating">
<input type="text" class="form-control" id="floatingInput" placeholder=" " name="username">
<label for="floatingInput">Username</label>
</div>

<div class="form-floating">
<input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password">
<label for="floatingPassword">Password</label>
</div>

<span>${errorMessage}</span>
<button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
<p class="mt-5 mb-3 text-muted">&copy; 2021–2021</p>

</form>
</main>

</body>
</html>