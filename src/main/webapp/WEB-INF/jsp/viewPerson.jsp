
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head></head>
<body>
<jsp:include page="Header.jsp" />
<h1>Person</h1>
<a href="/person/add" >ADD</a>
<table border="1">
	<tr>
		<th>Name</th>
		<th>City</th>
		<th>Address</th>
		<th>Pincode</th>
		<th>Action</th>
	</tr>
	<c:forEach items="${list}" var="ob">
		<tr>
			<td>${ob.person.name}</td>
			<td>${ob.city}</td>
			<td>${ob.address}</td>
			<td>${ob.pincode}</td>
			<td><a href="/person/edit/${ob.id}">EDIT</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>