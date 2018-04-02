<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
.card:hover{-webkit-box-shadow: -2px -1px 23px 3px rgba(201,4,132,0.72);
-moz-box-shadow: -2px -1px 23px 3px rgba(201,4,132,0.72);
box-shadow: -2px -1px 23px 3px rgba(201,4,132,0.72);}
/* .card{padding: 10px;margin: 10px;} */
@media (min-width: 576px) {
    .card-columns {
        column-count: 2;
    }
}

@media (min-width: 768px) {
    .card-columns {
        column-count: 5;
    }
}

@media (min-width: 992px) {
    .card-columns {
        column-count: 4;
    }
}

@media (min-width: 1200px) {
    .card-columns {
        column-count: 5;
    }
}
</style>


<div class="container">
	<div class="card-columns">
		<c:forEach items="${paginationProducts.list}" var="prodInfo">
			<div class="card">
				<a
					href="${pageContext.request.contextPath}/product_details?id=${prodInfo.id}"
					title="Click heare to view this product details"> <img
					class="card-img-top rounded"
					src="${pageContext.request.contextPath}/image_one?id=${prodInfo.id}"
					alt="Tshirt image cap" width="100" height="200" />
				</a>
				<div class="card-body">
					<div class="card-title">
						<strong class="card-title"><c:out
								value="${prodInfo.name}" /></strong> <label class="float-right">Tk.
							<c:out value="${prodInfo.price}" />
						</label>
					</div>
					<p class="card-text">
						<c:out value="${prodInfo.shortDesc}" />
					</p>
					<p>
						<button class="btn btn-primary" type="submit">Cart</button>
						<button class="btn btn-success" type="submit">Save</button>
					</p>
				</div>
			</div>
		</c:forEach>
	</div>
</div>

<br>
