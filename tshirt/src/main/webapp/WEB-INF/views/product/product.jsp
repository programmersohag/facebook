<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
.fileContainer {
	overflow: hidden;
	position: relative;
	background: orange;
	border-radius: .5em;
	padding: .5em;
	margin-left: 10px;
}

.fileContainer [type=file] {
	cursor: pointer;
	display: block;
	font-size: 999px;
	min-height: 100%;
	min-width: 100%;
	opacity: 0;
	position: absolute;
	right: 0;
	top: 0;
}
</style>
<c:if test="${not empty errorMessage }">
	<div class="error-message">${errorMessage}</div>
</c:if>
<c:url value="/product" var="myurl" />
<div class="container">
	<div class="jumbotron">
		<div class="row justify-content-md-center">
			<div class="card-group">
				<div class="card">
					<div class="card-header">Add New Product</div>
					<div class="card-body">
						<form:form modelAttribute="productForm" method="POST" class="form"
							enctype="multipart/form-data" action="${myurl}">
							<div class="form-group">
								<c:if test="${not empty productForm.id}">
									<form:hidden path="id" />${productForm.id}</c:if>
								<c:if test="${empty productForm.id}">
									<form:hidden path="newProduct" />
								</c:if>
								<form:errors path="id" class="error-message" />
							</div>
							<div class="form-group">
								<form:input path="name" class="form-control"
									placeholder="Product Name" required="3"/>
								<form:errors path="name" class="error-message" />
							</div>

							<div class="form-group">
								<form:input path="shortDesc" class="form-control"
									placeholder="Short Description" />
								<form:errors path="shortDesc" class="error-message" />
							</div>
							<div class="form-group">
								<form:input path="longDesc" class="form-control"
									placeholder="Long Description" />
								<form:errors path="longDesc" class="error-message" />
							</div>
							<div class="form-group">
								<form:input path="price" class="form-control"
									placeholder="Price" />
								<form:errors path="price" class="error-message" />
							</div>
							<div class="form-group">
								<form:input path="quantity" class="form-control"
									placeholder="Quantity" />
								<form:errors path="quantity" class="error-message" />
							</div>
							<div class="form-group">
								<img id="image-one" width="80" height="80" /> <img
									id="image-two" width="80" height="80" /> <img id="image-three"
									width="80" height="80" /> <img id="image-four" width="80"
									height="80" />
							</div>
							<div class="form-group">
								<label class="fileContainer"> Upload <form:input
										type="file" path="fileOne"
										onchange="document.getElementById('image-one').src = window.URL.createObjectURL(this.files[0])" />
								</label> <label class="fileContainer"> Upload <form:input
										type="file" path="fileTwo"
										onchange="document.getElementById('image-two').src = window.URL.createObjectURL(this.files[0])" />
								</label> <label class="fileContainer"> Upload <form:input
										type="file" path="fileThree"
										onchange="document.getElementById('image-three').src = window.URL.createObjectURL(this.files[0])" />
								</label> <label class="fileContainer"> Upload <form:input
										type="file" path="fileFour"
										onchange="document.getElementById('image-four').src = window.URL.createObjectURL(this.files[0])" />
								</label>
							</div>
							<div class="form-group">
								<input type="submit" class="btn btn-block btn-info"
									value="Submit" /> <input type="reset"
									class="btn btn-block btn-danger" value="Reset" />
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
