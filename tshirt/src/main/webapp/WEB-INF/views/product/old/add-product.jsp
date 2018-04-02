<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div class="card">
		<c:choose>
			<c:when test="${productInfo['new']}">
				<div class="card-header">Add New Product Information</div>
			</c:when>
			<c:otherwise>
				<div class="card-header">Update Product Information</div>
			</c:otherwise>
		</c:choose>
		<div class="card-body">
			<s:form class="form" method="post" commandName="product"
				action="${pageContext.request.contextPath}/product/docreate"
				enctype="multipart/form-data">
				<div class="row">
					<s:hidden path="id" />
					<div class="col-md-4">
						<spring:bind path="name">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<label for="name" class="col-md-5">Product Name</label>
								<div class="col-sm-7">
									<s:input type="text" path="name" class="form-control"
										name="name" id="name" />
									<s:errors path="name" class="control-label" />
								</div>
							</div>
						</spring:bind>
					</div>
					<div class="col-md-4">
						<spring:bind path="shortDesc">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<label for="short-desc" class="col-md-5">Short Desc</label>
								<div class="col-md-7">
									<s:input type="text" path="shortDesc" class="form-control"
										name="short-desc" id="short-desc" />
								</div>
							</div>
						</spring:bind>
					</div>
					<div class="col-md-4">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<label for="short-desc" class="col-md-5">Short Desc</label>
								<div class="col-md-7">
									<input type="text"  class="form-control"
										name="short-desc" id="short-desc" />
								</div>
							</div>
					</div>
				</div>
				<div class="row">
				<div class="col-md-12">
					<spring:bind path="longDesc">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label for="long-desc" class="col-md-4">Long Desc</label>
							<div class="col-md-12">
								<s:textarea path="longDesc" class="form-control"
									name="long-desc" id="long-desc" />
							</div>
						</div>
					</spring:bind>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<spring:bind path="price">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<label for="price" class="col-md-5">Price</label>
								<div class="col-md-7">
									<s:input type="text" class="form-control" name="price"
										id="price" required="required" path="price" />
								</div>
							</div>
						</spring:bind>
					</div>
					<div class="col-md-4">
						<spring:bind path="quantity">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<label for="quantity" class="col-md-5">Quantity</label>
								<div class="col-md-7">
									<s:input type="text" class="form-control" name="quantity"
										id="quantity" required="required" path="quantity" />
								</div>
							</div>
						</spring:bind>
					</div>
					<div class="col-md-4">
						<spring:bind path="image">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<label for="quantity" class="col-md-5">Select Image</label>
								<div class="col-md-7">
									<s:input type="file" name="image" id="image" path="image" />
								</div>
							</div>
						</spring:bind>
					</div>
				</div>
				<div class="col-md-6 col-md-offset-6">
					<button type="submit" class="btn btn-info">Submit</button>
				</div>
			</s:form>
		</div>

	</div>
</div>

