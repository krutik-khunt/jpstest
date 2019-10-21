<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head></head>
<body>
<jsp:include page="Header.jsp" />
<h1>Add Person</h1>
<form action="/person/save" method="post"> 
	<input type="hidden" name="id" value="${data.id!=null ? data.id : '0' }" />
	Name : <input type="text" name="name" value="${data.name}" />
	<br>
	
	  
	<c:forEach var="obb" items="${details}"> 
		<input type="hidden" name="detailid" value="${obb.id}" />
		city:<input type="text" name="city" value="${obb.city}" />
		address:<input type="text" name="address" value="${obb.address}" />
		pincode<input type="text" name="pincode" value="${obb.pincode}" /> <br>
	</c:forEach>
	
	<c:if test="${details==null}">
		<input type="hidden" name="detailid" value="0" />
		city:<input type="text" name="city" value="" />
		address:<input type="text" name="address" value="" />
		pincode<input type="text" name="pincode" value="" /> <br>
		<input type="hidden" name="detailid" value="0" />
		city:<input type="text" name="city" value="" />
		address:<input type="text" name="address" value="" />
		pincode<input type="text" name="pincode" value="" /> <br>
	</c:if>
	<input type="submit" value="Add">
</form>
</body>
</html>