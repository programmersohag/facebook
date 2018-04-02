<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style>
.error {
	color: red;
}
</style>
<div class="container">
	<div class="jumbotron">
		<div class="row justify-content-md-center">
			<div class="card-group">
				<div class="card">
					<div class="card-header">Create an Account</div>
					<div class="card-body">
						<form:form
							action="${pageContext.request.contextPath}/create_account"
							class="form-horizontal" method="post" commandName="userInfo">

							<div class="form-group row">
								<label for="firstName" class="col-sm-4 col-form-label">First
									Name</label>
								<div class="col-sm-8">
									<form:input type="text" class="form-control" id="firstName" 
										path="firstName" placeholder="Your First Name" />
									<form:errors path="firstName" cssClass="error" />
								</div>
							</div>
							<div class="form-group row">
								<label for="lastName" class="col-sm-4 col-form-label">Last
									Name</label>
								<div class="col-sm-8">
									<form:input type="text" class="form-control" id="lastName"
										path="lastName" placeholder="Your Last Name" />
									<form:errors path="lastName" cssClass="error" />
								</div>
							</div>
							<div class="form-group row">
								<label for="userName" class="col-sm-4 col-form-label">Username</label>
								<div class="col-sm-8">
									<form:input type="text" class="form-control" id="userName"
										path="userName" placeholder="Nickname" />
									<form:errors path="userName" cssClass="error" />
								</div>
							</div>
							<div class="form-group row">
								<label for="email" class="col-sm-4 col-form-label">Email</label>
								<div class="col-sm-8">
									<form:input type="email" class="form-control" id="email"
										path="email" placeholder="example@example.com" />
									<form:errors path="email" cssClass="error" />
								</div>
							</div>
							<div class="form-group row">
								<label for="password" class="col-sm-4 col-form-label">Password</label>
								<div class="col-sm-8">
									<form:input type="password" class="form-control" id="password"
										path="password" placeholder="Password" />
									<form:errors path="password" cssClass="error" />
								</div>
							</div>
							<div class="form-group row">
								<label for="conf-password"
									class="col-sm-4 col-form-label col-form-label">Confirm
									Password</label>
								<div class="col-sm-8">
									<input type="password" class="form-control form-control"
										id="conf-password" placeholder="Confirm Password">
								</div>
							</div>
							<div class="form-group row">
								<label for="gender" class="col-sm-4 col-form-label">Gender</label>
								<div class="col-sm-8">
									<div class="form-check">
										<label class="form-check-label"> <form:radiobutton
												class="form-check-input" path="gender" name="gender" id=""
												value="Male" checked="checked" />Male
										</label> <label class="form-check-label"> <form:radiobutton
												class="form-check-input" path="gender" name="gender"
												id="gender" value="Male" />Female
										</label>
									</div>
								</div>

							</div>
							<div class="form-group row">
								<label for="phone" class="col-sm-4 col-form-label">Mobile</label>
								<div class="col-sm-8">
									<form:input type="number" path="phone" class="form-control"
										id="phone" placeholder="01700000000" />
									<form:errors path="phone" cssClass="error" />
								</div>
							</div>
							<div class="form-group">
								<input type="submit" class="btn btn-info btn-block" value="Sign up" />
							</div>
							<div class="form-group">
								<p>
									Already have an account ? <a
										href="${pageContext.request.contextPath}/login"
										class="text-right">Login here</a>
								</p>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	var password1 = document.getElementById('password');
	var password2 = document.getElementById('conf-password');

	var checkPasswordValidity = function() {
		if (password1.value != password2.value) {
			password2.setCustomValidity('Passwords must match.');
		} else {
			password1.setCustomValidity('');
		}
	};

	password1.addEventListener('change', checkPasswordValidity, false);
	password2.addEventListener('change', checkPasswordValidity, false);

	var form = document.getElementById('userInfo');
	form.addEventListener('submit', function() {
		checkPasswordValidity();
		if (!this.checkValidity()) {
			event.preventDefault();
			//Implement you own means of displaying error messages to the user here.
			password2.focus();
		}
	}, false);
</script>