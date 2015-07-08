<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kickstarter: Donate</title>
</head>
<body>
	<h1>Donate:</h1>
	<h2>
		Project:
		<c:out value="${project.name}" />
	</h2>

	<form method="POST"
		action="/kickstarter/donate?project=${project.id}&category=${project.category.id}">
		<c:forEach var="paymentVariant" items="${project.paymentVariants}">
			<p>
				<input type="radio" name="paymentVariant"
					value="${paymentVariant.id}">
				<c:out
					value="${paymentVariant.amount} - ${paymentVariant.description}" />
			</p>
		</c:forEach>
		<p>
			<input type="radio" name="paymentVariant" value="other">
			<c:out value="other:" />
			<input type="text" name="amount">
		</p>
		<p>
			<input type="submit" value="Donate">
		</p>
	</form>

	<br />
	<br />
	<h3>
		<a
			href="/kickstarter/project?project=${project.id}&category=${project.category.id}">
			<c:out value="<- back to project" />
		</a>
	</h3>
</body>
</html>