<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
<div class="row">
	<div class="col-md-4">
	<c:url value="/login" var="login"/>
	<form action="login" method="POST">
	<table class="table table-responsive-sm table-danger">
		<thead>
			<tr>
				<th colspan="2"><h5>Login with Username and Password</h5></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="username" class="form-control" autofocus="autofocus" required="required"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" class="form-control" required="required"/></td>
			</tr>
			<tr>
				<td><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /></td>
				<td><input type="checkbox" name="remember" /> Remember Me</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<button name="submit" type="submit" class="btn btn-outline-info btn-block" style="cursor: pointer;">Submit</button>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><a href="">Forgot Password?</a></td>
			</tr>
			<tr>
				<td></td>
				<td><a href="">Forgot Username?</a></td>
			</tr>
			<tr>
				<td></td>
				<td><a href="">Sign up</a></td>
			</tr>
		</tbody>
	</table>
</form>
</div>
</div>
</div>
