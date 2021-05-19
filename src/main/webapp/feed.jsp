<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import = "controller.postHandler" %>

<title>Blanddit: a page on the internet</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="icon" type="image/png"
	href="https://icons-for-free.com/iconfiles/png/512/reddit+website+icon-1320168605279647340.png" />

<!-- Simple css to align items -->
<style> 
input {
	text-align: center;
}

#text {
	max-width: 75%;
	height: 100px;
}
</style>

<link href="css/product.css" rel="stylesheet">
</head>
<body>

	<header class="site-header sticky-top py-1">
		<!-- Header -->
		<nav
			class="container d-flex flex-column flex-md-row justify-content-between">
			<a class="py-2" href="#" aria-label="Product"> </a> <a
				class="py-2 d-none d-md-inline-block" href="#">Home</a> <a
				class="py-2 d-none d-md-inline-block"
				href="<%=request.getContextPath()%>/logoutNavigator">Log out</a>
		</nav>
	</header>

	<main>
		<!-- Start of main -->
		<div
			class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center text-white bg-dark">
			<!-- Main page field -->
			<div class="col-md-5 p-lg-5 mx-auto my-5">
				<p class="lead fw-normal">Welcome ${userInfo.getUsername()}</p>
				<h1 class="display-4 fw-normal">Blanddit</h1>
				<p class="lead fw-normal">A page on the internet</p>

				<form action="<%=request.getContextPath()%>/postHandler"
					method="post">

					<input type="text" id="title" name="title"
						placeholder="Add a title"><br> <br> <input
						type="text" id="text" name="text"
						placeholder="Your submission here" size="100"><br> <br>
					<input type="text" id="tag" name="tag" placeholder="Add a tag"><br>
					<br> <span>${invalidPost}</span>
					<button class="w-100 btn btn-lg btn-secondary" type="submit">Create
						Post</button>
					<br>
				</form>
			</div>
		</div>

		<c:forEach items="${postList}" var="posts">
			<!-- All posts listed with this forEach -->
			<div class="d-md-flex flex-md-equal w-100 my-md-3 ps-md-3">
				<div
					class="bg-dark me-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center text-white overflow-hidden">
					<div class="my-3 p-3">
						<h2 class="display-5">${posts.getTitle()}</h2>
						<p class="lead">${posts.getText()}</p>
						<p>${posts.getTag()}</p>
					</div>
					<div class="bg-light shadow-sm mx-auto"
						style="width: 80%; height: 30px; border-radius: 21px 21px 0 0;"></div>
				</div>
			</div>
		</c:forEach>
	</main>

	<footer class="container py-5">
		<!-- Footer -->
		<div class="row">
			<div class="col-12 col-md">
				<small class="d-block mb-3 text-muted">2021 - 2021</small>
			</div>
			<div class="col-6 col-md">
				<h5>Features</h5>
				<ul class="list-unstyled text-small">
					<li><a class="link-secondary" href="#">Cool stuff</a></li>
					<li><a class="link-secondary" href="#">Random feature</a></li>
					<li><a class="link-secondary" href="#">Team feature</a></li>
					<li><a class="link-secondary" href="#">Stuff for
							developers</a></li>
					<li><a class="link-secondary" href="#">Another one</a></li>
					<li><a class="link-secondary" href="#">Last time</a></li>
				</ul>
			</div>
			<div class="col-6 col-md">
				<h5>Resources</h5>
				<ul class="list-unstyled text-small">
					<li><a class="link-secondary" href="#">Resource name</a></li>
					<li><a class="link-secondary" href="#">Resource</a></li>
					<li><a class="link-secondary" href="#">Another resource</a></li>
					<li><a class="link-secondary" href="#">Final resource</a></li>
				</ul>
			</div>
			<div class="col-6 col-md">
				<h5>Resources</h5>
				<ul class="list-unstyled text-small">
					<li><a class="link-secondary" href="#">Business</a></li>
					<li><a class="link-secondary" href="#">Education</a></li>
					<li><a class="link-secondary" href="#">Government</a></li>
					<li><a class="link-secondary" href="#">Gaming</a></li>
				</ul>
			</div>
			<div class="col-6 col-md">
				<h5>About</h5>
				<ul class="list-unstyled text-small">
					<li><a class="link-secondary" href="#">Team</a></li>
					<li><a class="link-secondary" href="#">Locations</a></li>
					<li><a class="link-secondary" href="#">Privacy</a></li>
					<li><a class="link-secondary" href="#">Terms</a></li>
				</ul>
			</div>
		</div>
	</footer>

	<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Bootstrap link -->

</body>
</html>
