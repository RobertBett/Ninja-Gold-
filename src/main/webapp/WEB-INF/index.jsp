<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link href="/styles.css" rel="stylesheet"></link>
</head>
<body>
	<h2>Your Gold: <c:out value="${gold}"/></h2>

	<div class="flex">
		<form action="/process/1" method="post">
			<h2>Farm</h2>
			<p>(earns 10-20 gold)</p>
			<input type="submit" value="Find Gold!"></input>
		</form>
	
		<form action="/process/2" method="post">
			<h2>Cave</h2>
			<p>(earns 5-10 gold)</p>
			<input type="submit" value="Find Gold!"></input>
		</form>
		
		<form action="/process/3" method="post">
			<h2>House</h2>
			<p>(earns 2-5 gold)</p>
			<input type="submit" value="Find Gold!"></input>
		</form>
		
		<form action="/process/4" method="post">
			<h2>Casino</h2>
			<p>(earns/takes 0-50 gold)</p>
			<input type="submit" value="Find Gold!"></input>
		</form>
	</div>

	<h2>Activities:</h2>
<c:forEach items="${res}" var="message">
	<tr>
	<td>${message}</td>
	</tr>
</c:forEach>
	${res}
	
</body>
</html>