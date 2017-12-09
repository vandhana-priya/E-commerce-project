<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
    <%@ taglib prefix="spring-form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<style>
/* Full-width input fields */
input[type=text],input[type=number], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}
.container {
    padding: 16px;
}
</style>

<body>
<c:set value="${pageContext.request.contextPath }" var="context"></c:set>
<spring-form:form class="form-horizontal" action="${context}/addproduct" method="POST" modelAttribute="product">


<div class="container">
<spring-form:label path="productName"><b>Product Name:</b></spring-form:label>
<spring-form:input type="text"  path="productName" placeholder="Enter product name" name="productName" ></spring-form:input>
<spring-form:errors path="productName" id="message"/><br/>

<spring-form:label path="productDesc"><b>Description:</b></spring-form:label>
<spring-form:input type="text"  path="productDesc" placeholder="Enter productDesc" name="productDesc" ></spring-form:input>
<spring-form:errors path="productDesc" id="message"/><br/>

<spring-form:label path="stock"><b>Stock:</b></spring-form:label>
<spring-form:input type="number"  path="stock" placeholder="Enter stock" name="stock" ></spring-form:input>


<spring-form:label path="price"><b>Price:</b></spring-form:label>
<spring-form:input type="number"  path="price" placeholder="Enter price" name="price" ></spring-form:input>


<div class="clearfix">

<input type= "submit" value="Register"/>
</div>
  </div>
</spring-form:form>
 <table class="table table-hover">
          <tr>
         
          <th>productName</th>
          <th>productDesc</th>
          <th>stock</th>
          <th>price</th>
          
          
          </tr>
          
          <c:forEach items="${products}" var="product">
          <tr>
            
             
             <td>${product.productName}</td>
             <td>${product.productDesc}</td>
             <td>${product.stock}</td>
             <td>${product.price}</td>
             
             
           <td> <a href="<c:url value='/editproduct/${product.productId}'/>">
                   <button type="submit" class="btn btn-basic">edit</button></a></td>
             <td><a href="deleteproduct/${product.productId}">
             <button type="submit" class="btn btn-basic">Delete</button></a>
             </td>
             </tr>
             </c:forEach>
             
          </table>
</body>
</html>  