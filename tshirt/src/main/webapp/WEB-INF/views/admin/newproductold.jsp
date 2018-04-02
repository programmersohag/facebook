<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<form:form commandName="product"
	action="${pageContext.request.contextPath}/admin/addProduct"
	method="post" enctype="multipart/form-data">
	<div class="row">
	<form:hidden path="id" />
	<div class="col-md-6">
		<spring:bind path="name">
				<label for="name">Product name</label>
				<form:input type="text" path="name" class="form-control" id="name"
					placeholder="Product name" />
		</spring:bind>
		</div>
		<div class="col-md-6">
		<spring:bind path="shortDesc">
				<label for="short-desc">Short Description</label>
				<form:input type="text" path="shortDesc" class="form-control"
					id="short-desc" name="short-desc" placeholder="" required="true" />
		</spring:bind>
		</div>
	</div>
	<div class="row">
		<spring:bind path="longDesc">
			<div class="col-md-6 mb-3">
				<label for="long-desc">City</label> <form:input type="text" path="longDesc"
					class="form-control" id="long-desc" name="long-desc"
					placeholder="Long Desc" />
				<div class="invalid-feedback">Please provide a valid city.</div>
			</div>
		</spring:bind>
		<spring:bind path="price">
			<div class="col-md-3 mb-3">
				<label for="price">State</label>
				<form:input type="text" path="price" class="form-control" id="price"
					name="price" placeholder="Price" />
				<div class="invalid-feedback">Please provide a valid state.</div>
			</div>
		</spring:bind>
		<spring:bind path="quantity">
			<div class="col-md-3 mb-3">
				<label for="quantity">State</label>
				<form:input type="text" path="quantity" class="form-control"
					id="quantity" name="quantity" placeholder="Quantity" />
				<div class="invalid-feedback">Please provide a valid state.</div>
			</div>
		</spring:bind>
	</div>
	<div class="row">
		<spring:bind path="thumb">
			<div class="col-md-3 mb-3">
				<label for="thumb">State</label>
				<form:input type="file" path="thumb" class="form-control" id="thumb"
					name="thumb" />
				<div class="invalid-feedback">Please provide a valid state.</div>
			</div>
		</spring:bind>
	</div>
	<input class="btn btn-primary" type="submit" value="Submit"/>
</form:form>