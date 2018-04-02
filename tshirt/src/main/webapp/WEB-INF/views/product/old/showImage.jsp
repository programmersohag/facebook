 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
 
 <fmt:setLocale value="en_US" scope="session"/>
   <div class="page-title">Product List</div>
       <div class="container">
       <form action="${pageContext.request.contextPath}/product/productImage" method="post">
       		<img class="product-image" width="50" height="50"
                   src="${pageContext.request.contextPath}/product/productImage" />
                   <button type="submit">Show</button>
       </form>
          
             
       </div>
 
   <br/>
  
 
