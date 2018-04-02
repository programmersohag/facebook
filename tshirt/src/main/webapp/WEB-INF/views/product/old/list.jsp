<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="container">

	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">×</span>
			</button>
			<strong>${msg}</strong>
		</div>
	</c:if>
	<h1>All Products</h1>
	<table class="table table-reponsive-sm table-hover table-sm">
		<thead class="thead-dark">
			<tr>
				<th>#ID</th>
				<th>Name</th>
				<th>Short Description</th>
				<th>Long Description</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Thumb</th>
			</tr>
		</thead>
		<tbody class="">
			<c:forEach var="product" items="${list}">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.shortDesc}</td>
					<td>${product.longDesc}</td>
					<td>${product.price}</td>
					<td>${product.quantity}</td>
					<td><img src="${product.image2}"/></td>
					
					<%-- <td>  <img src="${pageContext.request.contextPath}/product/productImage?code=${product.id}"  width="50" height="50"/></td> --%>
					
					<td><spring:url value="/product/${product.id}/update"
							var="updateUrl" />
						<button class="btn btn-primary btn-sm"
							onclick="location.href='${updateUrl}'">Update</button>
							</td>
					<td>
					<spring:url value="/product/${product.id}/delete" var="deleteUrl" />
					<form:form method="post" action="${deleteUrl}">
					
						<button type="submit" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete this document?')">Delete</button>
					</form:form>
						

					</td>
				</tr>
			</c:forEach>
			<tr>
			
			</tr>
		</tbody>
	</table>
</div>


<script type="text/javascript">
	$(document).ready(function() {

	});
</script>
