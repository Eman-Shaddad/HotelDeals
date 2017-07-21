<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>

<body>

	<h3>Failed to process your request due to: <%out.println(session.getAttribute("errorMsg"));%></h3>
	
</body>
</html>