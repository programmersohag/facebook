<style>
#search:focus{width : 400px;}
#search{width: 100px; -webkit-transition: width 0.5s ease-in-out; transition: width 0.5s ease-in-out;}
</style>
<div class="container-fluid">
	<nav class="navbar navbar-expand-sm navbar-inverse bg-light">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#adminNavBar"
			aria-controls="myNavBar" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="adminNavBar">
			<a class="navbar-brand" href="#"> <img src=".svg" width="30"
				height="30" alt="" />
			</a>
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link" href="#">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
			</ul>
			
			<!-- <form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="text" placeholder="Search" id="search"
					aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form> -->
			
			<ul class="navbar-nav justify-content-end">
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/create_account">Profile <span
						class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/">Logout
						Us</a></li>
			</ul>
		</div>
	</nav>
</div>