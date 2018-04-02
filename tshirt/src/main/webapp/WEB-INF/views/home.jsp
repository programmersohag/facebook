<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style type="text/css">
.prev:hover, .next:hover {
	background-color: rgba(0, 0, 0, 0.8);
}
.col-md-6 {
	position: relative;
}
.caption_text {
	position: absolute;
	textt-align: center;
	padding: 8px 12px;
	font-size: 20px;
	font-weight: bold;
	color: deeppink;
	}
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
<div class="row">
<div class="col-md-9">

	<div id="carousel" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carousel" data-slide-to="0" class="active"></li>
			<li data-target="#carousel" data-slide-to="1"></li>
			<li data-target="#carousel" data-slide-to="2"></li>
		</ol>

		<div class="carousel-inner">
			<div class="carousel-item active">
				<img class="d-block w-100"
					src=" <c:url value='/resources/images/10.jpg'/>" alt="First slide" />
				<div class="carousel-caption d-none d-md-block">
					<h3>First Image Caption</h3>
					<p>The best sell for the year</p>
				</div>
			</div>
			<div class="carousel-item">
				<img class="d-block w-100"
					src=" <c:url value='/resources/images/11.png'/>" alt="Second slide" />
				<div class="carousel-caption d-none d-md-block">
					<h3>First Image Caption</h3>
					<p>The best sell for the year</p>
				</div>
			</div>
			<div class="carousel-item">
				<img class="d-block w-100"
					src=" <c:url value="/resources/images/12.jpg"/>" alt="Third slide">
				<div class="carousel-caption d-none d-md-block">
					<h3>First Image Caption</h3>
					<p>The best sell for the year</p>
				</div>
			</div>
		</div>
<!-- 		<a class="carousel-control-prev" href="#carousel" role="button"
			data-slide="prev"> <span class="carousel-control-prev-icon"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carousel" role="button"
			data-slide="next"> <span class="carousel-control-next-icon"
			aria-hidden="true"></span> <span class="sr-only">Next</span>
		</a> -->
</div>
</div>
<div class="col-md-3">
<div class="card" style="width: 255px;">
	<img class="card-img-top" src="..." alt="Card image cap" width="">
	<div class="card-body">
	<h4 class="card-title">Card title</h4>
	<p class="card-text">Some quick example text to build on the card
				title and make up the bulk of the card's content.</p>
	<a href="#" class="btn btn-primary">Go somewhere</a>
</div>
</div>
</div>
</div>
</div>

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



