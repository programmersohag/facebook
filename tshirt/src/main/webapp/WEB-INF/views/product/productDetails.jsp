<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
.thumb-one, .thumb-two, .thumb-three, .thumb-four{
	padding: 5px;
	border-radius: 15px;
	margin-left: 20px;
	border: 1px solid purple;
	cursor: pointer;
}
.thumb-two:hover + #aaa .second{
    display: block;
}

</style>
<div class="container">
	<div class="row">
		<div class="col-md-1">
			<div class="row">
				<img class="thumb-one"
					src="${pageContext.request.contextPath}/image_one?id=${id}"
					width="90" height="100">
			</div>
			<div class="row">
				<img class="thumb-two"
					src="${pageContext.request.contextPath}/image_two?id=${id}"
					width="90" height="100">
			</div>
			<div class="row">
				<img class="thumb-three"
					src="${pageContext.request.contextPath}/image_three?id=${id}"
					width="90" height="100">
			</div>
			<div class="row">
				<img class="thumb-four"
					src="${pageContext.request.contextPath}/image_four?id=${id}"
					width="90" height="100">
			</div>
		</div>
		<div class="col-md-6">
			<img class="aaa"
				src="${pageContext.request.contextPath}/image_one?id=${id}"
				id="first" width="400" height="500">
		</div>
		<div class="col-md-5">
			<h3>
				<input type="hidden"  name="id" value="${id}"/>
				<output name="short-desc"><c:out value="${shortDesc}" /></output>
			</h3>
			<p>
				<output name="long-desc"><c:out value="${longDesc}" /></output>
			</p>
			<p>
				<a href="">By Brand</a>
			</p>
			<hr>
			<a href="">Review</a> <b>Share with</b> <a href="#"><span class="fa-stack fa-lg">
					<i class="fa fa-circle-o fa-stack-2x"></i> <i
					class="fa fa-facebook fa-stack-1x"></i>
			</span></a> <a href="#"><span class="fa-stack fa-lg"> <i
					class="fa fa-square-o fa-stack-2x"></i> <i
					class="fa fa-twitter fa-stack-1x"></i>
			</span></a> <a href="#"><span class="fa-stack fa-lg"> <i
					class="fa fa-square-o fa-stack-2x"></i> <i
					class="fa fa-google-plus fa-stack-1x"></i>
			</span></a>

			<hr>
			<div class="row">
				<div class="col-md-4">
				<output name="price">Price : <c:out value="${price}" /></output>
				</div>
				<div class="col-md-4">
					<label>Size : </label> <select name="size">
						<option value="M">M</option>
						<option value="L">L</option>
						<option value="XL">XL</option>
						<option value="XXL">XXL</option>
						<option value="3XXL">3XXL</option>
					</select>
				</div>
				<div class="col-md-4">
					<label for="qty">Quantity:</label> <input type="number" name="quantity"
						style="width: 80px;" value="<c:out value='${quantity}'/>" />
				</div>
			</div>
			<hr>
			<div class="row">
				<form action="${pageContext.request.contextPath}/addToCart" method="post">
					<button type="submit" class="btn btn-outline-danger">Check
					Out</button>
				</form>
				
				<button type="button" class="btn btn-outline-primary">Save
					For Later</button>

			</div>

		</div>
	</div>
</div>
<script	src="<c:url value='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'/>"></script>
<script>
$( document ).ready(function() {
	$( ".thumb-one" ).click(function() {
		$( ".aaa").attr("src", "${pageContext.request.contextPath}/image_one?id=${id}");
		});
	$( ".thumb-two" ).click(function() {
		$( ".aaa").attr("src", "${pageContext.request.contextPath}/image_two?id=${id}");
		});
	$( ".thumb-three" ).click(function() {
		$( ".aaa").attr("src", "${pageContext.request.contextPath}/image_three?id=${id}");
		});
	$( ".thumb-four" ).click(function() {
		$( ".aaa").attr("src", "${pageContext.request.contextPath}/image_four?id=${id}");
		});
	  
	});

</script>