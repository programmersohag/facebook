<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form action="${pageContext.request.contextPath}/admin/update">
<table class="table table-sm">
	<thead>
		<tr>
			<th>SL</th>
			<th scope="col">First</th>
			<th scope="col">Last</th>
			<th scope="col">Username</th>
			<th scope="col">Email</th>
			<th scope="col">Phone</th>
			<th scope="col">Enable</th>
			<th scope="col">Reg. Date</th>
			<th scope="col">Action</th>

		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="list">
		
			<tr>
			
				<td>${list.userId}</td>
				<td>${list.firstName}</td>
				<td>${list.lastName}</td>
				<td>${list.userName}</td>
				<td>${list.email}</td>
				<td>${list.phone}</td>
				<td>${list.active}</td>
				<td>${list.insDate}</td>
				<td>
				
				
				<button type="button" class="sohag" data-toggle="modal"
					data-target="#exampleModal">Update</button> <a href="">Delete</a></td>
					
			</tr>
			
		</c:forEach>
	</tbody>
</table>
</form>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<form action="${pageContext.request.contextPath}/create_account"
				class="form-horizontal" method="post">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Update User
						Details</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="form-group row">
						<label for="firstName" class="col-sm-4 col-form-label">First
							Name</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="firstName"
								placeholder="Your First Name" />
						</div>
					</div>
					<div class="form-group row">
						<label for="lastName" class="col-sm-4 col-form-label">Last
							Name</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="lastName"
								placeholder="Your Last Name" />
						</div>
					</div>
					<div class="form-group row">
						<label for="userName" class="col-sm-4 col-form-label">Username</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="userName"
								placeholder="Nickname" />
						</div>
					</div>
					<div class="form-group row">
						<label for="email" class="col-sm-4 col-form-label">Email</label>
						<div class="col-sm-8">
							<input type="email" class="form-control" id="email"
								placeholder="example@example.com" />
						</div>
					</div>
					<div class="form-group row">
						<label for="password" class="col-sm-4 col-form-label">Password</label>
						<div class="col-sm-8">
							<input type="password" class="form-control" id="password"
								placeholder="Password" />
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
								<label class="form-check-label"> <input type="radio"
									class="form-check-input" name="gender" id="" value="Male"
									checked="checked" />Male
								</label> <label class="form-check-label"> <input type="radio"
									class="form-check-input" name="gender" id="gender" value="Male" />Female
								</label>
							</div>
						</div>

					</div>
					<div class="form-group row">
						<label for="phone" class="col-sm-4 col-form-label">Mobile</label>
						<div class="col-sm-8">
							<input type="number" class="form-control" id="phone"
								placeholder="01700000000" />
						</div>
					</div>

				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
function doAjaxPost() {


$.ajax({
    type: "POST",
    url: "/GettingJsonDataJQuery/AddUser.htm",
    data: "name=" + name + "&education=" + education,
    success: function(response){
        // we have the response
        if(response.status == "SUCCESS"){
            $('#info').html("User has been added to the list successfully.<br>"+
            "The User Details are as follws : <br> Name : "
            + response.result.name + " <br> Education : " + response.result.education);
            $('#name').val('');
            $('#education').val('');
        }else{
            $('#info').html("Sorry, there is some thing wrong with the data provided.");
        }
    },
    error: function(e){
        alert('Error: ' + e);
    }
});
}
</script>