<style>
#search:focus{width : 400px;}
#search{width: 100px; -webkit-transition: width 0.5s ease-in-out; transition: width 0.5s ease-in-out;}
</style>
<div class="container-fluid">
	<nav class="navbar navbar-expand-sm navbar-light bg-light">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#myNavBar"
			aria-controls="myNavBar" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="myNavBar">
			<a class="navbar-brand" href="#"> <img src=".svg" width="30"
				height="30" alt="" />
			</a>
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link" href="#">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Male</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Female</a></li>
			</ul>
			
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="text" placeholder="Search" id="search"
					aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
			
			<ul class="navbar-nav justify-content-end">
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/create_account">SignUp <span
						class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/contact_us">Contact
						Us</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Cart <i class="fa fa-shopping-cart fa-lg"></i></a></li>
			</ul>
		</div>
	</nav>
</div>